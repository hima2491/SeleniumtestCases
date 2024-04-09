package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase27RecentlyCreated {
	static WebDriver driver;
	static Actions actions;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		RecentlyCreated() ;
		Thread.sleep(2000);
		driver.close();
		System.out.println("TestCase-27 is success");
		
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
	static void  RecentlyCreated() throws InterruptedException {
		
		WebElement Recentlyframe1=driver.findElement(By.xpath("//form[@id='hotlist']/table/tbody/tr[1]//select[@id='hotlist_mode']"));
		actions=new Actions(driver);
		actions.moveToElement(Recentlyframe1).build().perform();
//		WebElement Recentlyframe=driver.findElement(By.xpath("//form[@id='hotlist']//select[@id='hotlist_mode']"));
		Thread.sleep(4000);
		Select Recentlycreated = new Select(Recentlyframe1);
		Recentlycreated.selectByVisibleText("Recently Created");
		
	}
}
