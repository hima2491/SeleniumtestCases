package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase23TodaysLeads {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		leads();
		Leadsdrpdwn();
		GoBtn();
		driver.close();
		System.out.println("TestCase23 is success");
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
	static void leads() throws InterruptedException {
		WebElement Leadslink=driver.findElement(By.id("Lead_Tab"));
		Leadslink.click();
		Thread.sleep(2000);	
	   }
	static void Leadsdrpdwn() throws InterruptedException {
		WebElement Leaddrpdwnbtn=driver.findElement(By.xpath("//select[@id='fcf']"));
		Select TodaysLeads=new Select (Leaddrpdwnbtn);
		TodaysLeads.selectByVisibleText("Today's Leads");
	}
	static void GoBtn() {
		WebElement Go= driver.findElement(By.xpath("//input[@title='Go!']"));
		Go.click();
	}            
}
