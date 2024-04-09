package SeleniumTestCases;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase8DeveloperConsole {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		UserMenuDropdown();
		DeveloperConsole();
		driver.quit();
		System.out.println("TestCase-8 is success");
	}
		static void LoginApplication() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(" https://login.salesforce.com");
			WebElement username=driver.findElement(By.id("username"));
			username.sendKeys("hima@abb.com");		
			Thread.sleep(2000);
			WebElement password=driver.findElement(By.id("password"));
			password.sendKeys("chindu@7022");
			Thread.sleep(2000);
			WebElement Login=driver.findElement(By.id("Login"));
			Login.click();
	}
		static void UserMenuDropdown() throws InterruptedException {
			WebElement UsermenuDropdown=driver.findElement(By.id("userNavButton"));
			UsermenuDropdown.click();
			Thread.sleep(2000);
		}
		static void DeveloperConsole() throws InterruptedException{
			WebElement DevCon=driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
			Thread.sleep(2000);
			DevCon.click();//New window is opened
			String ParentWindow=driver.getWindowHandle();//to get to current window handle
			System.out.println("Parent window handle" +ParentWindow);
			Set<String>listofHandles=driver.getWindowHandles();
			System.out.println("total windows opened currently"+ listofHandles.size());
			for(String Handle:listofHandles)
			{
				System.out.println("Current window Handle" +Handle);
				if(!Handle.equals(ParentWindow)) {
					driver.switchTo().window(Handle);//switching to new window
					Thread.sleep(3000);
					driver.close();
					break;
				}
			}
			driver.switchTo().window(ParentWindow);
		}
  }
