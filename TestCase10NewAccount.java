package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase10NewAccount {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		AccountsTab();
		NewBtn();
		NewAccountCreation();
		System.out.println("TestCase10 is Success");
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
	static void NewBtn() {
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
	}
	static void NewAccountCreation() {
		WebElement AccountName= driver.findElement(By.id("acc2"));
		AccountName.sendKeys("Saketh");
		WebElement typedrpdwn=driver.findElement(By.id("acc6"));
		Select type=new Select(typedrpdwn);
		type.selectByVisibleText("Technology Partner");
		WebElement cutpridrpdwn=driver.findElement(By.id("00Nak0000011npK"));
		Select priority=new Select(cutpridrpdwn);
		priority.selectByVisibleText("High");
		WebElement Savebtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
		Savebtn.click();
	}
}
