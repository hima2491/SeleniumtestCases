package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase29SelectRecentContact {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		RecentContact();
		Thread.sleep(2000);
//		driver.close();
		System.out.println("TestCASE29 is success");
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
	static void RecentContact() throws InterruptedException {
//		WebElement RecCon=driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]//th[@scope='row']"));
		WebElement rec=driver.findElement(By.xpath("//tr[@class='dataRow even first']/th[1]/a[@href='/003ak000001Rlv7']"));
//		WebElement RecentContact=driver.findElement(By.xpath("//tr[@class='dataRow even first']/th[@class=' dataCell  ']"));
//		Thread.sleep(4000);
//		RecentContact.click();
		Thread.sleep(4000);
		rec.click();
	}
	
}
