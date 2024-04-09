package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase18StuckOPP {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		OppurtunitiesTab();
		StuckOPP();
		System.out.println("TestCase-18 is success");
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
	static  void StuckOPP() throws InterruptedException {
		WebElement StuckOppurtunity=driver.findElement(By.xpath("//a[text()='Stuck Opportunities']"));
		Thread.sleep(2000);
		StuckOppurtunity.click();
	}
}
