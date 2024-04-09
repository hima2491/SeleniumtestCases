package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase17OppPipeLine {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		OppurtunitiesTab();
		OppPipeline();
		System.out.println("Testcase-17 is Success");
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
	static void OppurtunitiesTab() throws InterruptedException {
		WebElement Oppurtunity=driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Thread.sleep(3000);
		Oppurtunity.click();
	}
	static  void OppPipeline() throws InterruptedException {
		WebElement oppPipeLine=driver.findElement(By.xpath("//a[text()='Opportunity Pipeline']"));
		Thread.sleep(2000);
		oppPipeLine.click();
	}
}
