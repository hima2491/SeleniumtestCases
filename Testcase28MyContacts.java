package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase28MyContacts {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		viewDrpdwn();
		Thread.sleep(2000);
		driver.close();
		System.out.println("TestCASE28 is success");
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
	static void viewDrpdwn() throws InterruptedException {
		WebElement Viewdrpdwn =driver.findElement(By.id("fcf"));
		Select MyContacts =new Select(Viewdrpdwn);
		MyContacts.selectByVisibleText("My Contacts");
		WebElement goBtn=driver.findElement(By.xpath("//input[@value=' Go! ']"));
		goBtn.click();
}
}


