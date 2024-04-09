package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase20Leads {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		leads();
		System.out.println("TestCase20 is success");
		
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
	static void leads() throws InterruptedException {
		WebElement Leadslink=driver.findElement(By.id("Lead_Tab"));
		Leadslink.click();
		Thread.sleep(2000);
		driver.close();
	   }
}
