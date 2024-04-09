package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase11AccountsCreateNewView {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		AccountsTab();	
		createnewview() ;
		System.out.println("TestCase-11 is Success");
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
	static void AccountsTab() {
		driver.findElement(By.id("Account_Tab")).click();
	}
	static void createnewview() throws InterruptedException {
		WebElement createnew=driver.findElement(By.xpath("//a[text()='Create New View']"));
		createnew.click();
		WebElement ViewName=driver.findElement(By.id("fname"));
		ViewName.clear();
		ViewName.sendKeys("Chindu");
		WebElement UniViewName=driver.findElement(By.id("devname"));
		UniViewName.clear();
		UniViewName.sendKeys("Muthyala");
		Thread.sleep(2000);
		WebElement Savebtn=driver.findElement(By.xpath("//input[@data-uidsfdc= '4']" ));
		Thread.sleep(2000);
		Savebtn.click();
		
	}

}
