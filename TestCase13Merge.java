package SeleniumTestCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase13Merge {
	static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			LoginApplication();
			AccountsTab();
			MergeAccounts();
			System.out.println("Test case-13 is success");
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
		static void MergeAccounts() throws InterruptedException {
			WebElement Merge=driver.findElement(By.xpath("//a[@ href='/merge/accmergewizard.jsp?retURL=%2F001%2Fo']"));
			Merge.click();
			WebElement inputdata=driver.findElement(By.id("srch"));
			 inputdata.sendKeys("Saketh");
			 WebElement FindAccounts=driver.findElement(By.xpath("//input[@value='Find Accounts']"));
			 FindAccounts.click();
			 WebElement NextBtn=driver.findElement(By.xpath("//input[@name='goNext']"));
			 NextBtn.click();
			 WebElement Merge2=driver.findElement(By.xpath("(//input[@name='save'])[2]"));
			 Thread.sleep(3000);
			 Merge2.click();
			 Alert alertOb=driver.switchTo().alert();
			 Thread.sleep(2000);
			 alertOb.accept(); 
		}
}
