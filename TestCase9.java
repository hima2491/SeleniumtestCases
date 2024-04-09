package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase9 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		UserMenuBtn();
		LogOut();
		System.out.println("Testcase-9 is Success");
		driver.close();
		
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
	static void UserMenuBtn() {
		 WebElement UsermenuDropdown=driver.findElement(By.id("userNavButton"));
		 UsermenuDropdown.click();
	 }
	static void LogOut() throws InterruptedException {
		WebElement LogOut=driver.findElement(By.xpath("//a[@title='Logout']"));
		LogOut.click();
	}

}
