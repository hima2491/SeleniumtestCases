package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase30CreatreNewVIew {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		createnewview();
		driver.close();
		System.out.println("TestCase 30 Error Message is success");
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
	static void Contact() throws InterruptedException {
		 WebElement contactlink=driver.findElement(By.id("Contact_Tab"));
		 Thread.sleep(4000);
		 contactlink.click();
	} 
	static void createnewview() throws InterruptedException {
		WebElement createnew=driver.findElement(By.xpath("//a[text()='Create New View']"));
		createnew.click();
		WebElement UniViewName=driver.findElement(By.id("devname"));
		UniViewName.clear();
		UniViewName.sendKeys("EFGH");
		Thread.sleep(2000);
		WebElement Savebtn=driver.findElement(By.xpath("//input[@data-uidsfdc= '4']" ));
		Thread.sleep(2000);
		Savebtn.click();
		WebElement ErrorMsg=driver.findElement(By.xpath("//div[@class='errorMsg']"));
		String Message=ErrorMsg.getText();
		System.out.println("Error Msg:" +Message);
	}
}
