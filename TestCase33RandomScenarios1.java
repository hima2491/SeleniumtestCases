package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase33RandomScenarios1 {
	static WebDriver driver;
	static Actions actions;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Hometab();
		Thread.sleep(2000);
//		driver.close();
		System.out.println("Test case- 33 is success");
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
	static void  Hometab() throws InterruptedException {
		WebElement Home=driver.findElement(By.id("home_Tab"));
		Home.click();
//		WebElement firstlastname=driver.findElement(By.xpath("//div[@class='content']/span[2]"));
//		Actions actions=new Actions(driver);
//		actions.moveToElement(firstlastname).build().perform();
//		Thread.sleep(4000);
//		firstlastname.click();
		WebElement firstAndLastName=driver.findElement(By.xpath("//div[@class='mruItem']//a[@class='userMru']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(firstAndLastName).build().perform();
		Thread.sleep(2000);
		firstAndLastName.click();
	}
}
