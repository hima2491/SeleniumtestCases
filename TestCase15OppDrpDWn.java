package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase15OppDrpDWn {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		OppurtunitiesTab();
		OppDrpDwnbtn();
		Thread.sleep(2000);
		System.out.println("Test Case-15 is success");
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
	static void OppDrpDwnbtn() throws InterruptedException {
		WebElement oppdrpdwn=driver.findElement(By.id("fcf"));
		oppdrpdwn.click();
		Thread.sleep(3000);
		String Oppdrpdwnmenu=oppdrpdwn.getText();
		if(oppdrpdwn.isDisplayed())
		{
			System.out.println("OppurtunityDropDown is present" +Oppdrpdwnmenu);
		}
		else
		{
			System.out.println("OppurtunityDropDown is not presnt");
		}
	}
}
