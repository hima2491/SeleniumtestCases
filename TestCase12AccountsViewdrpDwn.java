package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase12AccountsViewdrpDwn {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		AccountsTab();	
		viewDrpdwn();
		System.out.println("TestCase-12 is Success");	
		//driver.close();
	}
	static void LoginApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://login.salesforce.com");
		driver.manage().window().maximize();
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("hima@abb.com");		
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("chindu@7022");
		Thread.sleep(2000);
		WebElement Login=driver.findElement(By.id("Login"));
		Login.click();
		
	}
	static void AccountsTab() {
		driver.findElement(By.id("Account_Tab")).click();
	}
	static void viewDrpdwn() throws InterruptedException {
		WebElement Viewdrpdwn =driver.findElement(By.id("fcf"));
		Select viewname =new Select(Viewdrpdwn);
		viewname.selectByVisibleText("Chindu");
		WebElement EditLink=driver.findElement(By.xpath("//a[text()='Edit']"));
		EditLink.click();
		WebElement ViewName=driver.findElement(By.id("fname"));
		ViewName.clear();
		ViewName.sendKeys("ChinduMuthyala");
		WebElement field=driver.findElement(By.id("fcol1"));
		Select AccountName= new Select(field);
		AccountName.selectByVisibleText("Account Name");
		WebElement Operator=driver.findElement(By.id("fop1"));
		Select Eqa = new Select(Operator);
		Eqa.selectByVisibleText("equals");
		WebElement ValueField=driver.findElement(By.id("fval1"));
		ValueField.sendKeys("a");	
		WebElement AvailableFields=driver.findElement(By.id("colselector_select_0"));
		Select LastActivity= new Select(AvailableFields);
		LastActivity.selectByVisibleText("Last Activity");
		WebElement AddBtn=driver.findElement(By.xpath("//img[@title='Add']"));
		AddBtn.click();
		Thread.sleep(2000);
		WebElement SaveBtn=driver.findElement(By.xpath("//input[@data-uidsfdc='4']"));
		SaveBtn.click();
	}
}
