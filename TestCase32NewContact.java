package SeleniumTestCases;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase32NewContact {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		NewBtn();
		NewcontactCreation();
		SaveAndNew();
	    Thread.sleep(2000);
//		driver.close();
		System.out.println("TestCase 32 Error Message is success");
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
	static void NewBtn() {
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
	}
	static void NewcontactCreation() throws InterruptedException {
		WebElement LastName=driver.findElement(By.id("name_lastcon2"));
		LastName.sendKeys("Indian");
		WebElement AccountlookupIcon=driver.findElement(By.xpath("//a[@title='Account Name Lookup (New Window)']"));
		AccountlookupIcon.click();
		String ParentWindow=driver.getWindowHandle();//to get to current window handle
		System.out.println("Parent window handle" +ParentWindow);
		Set<String>listofHandles=driver.getWindowHandles();
		System.out.println("total windows opened currently"+ listofHandles.size());
		for(String Handle:listofHandles)
		{
			System.out.println("Current window Handle" +Handle);
			if(!Handle.equals(ParentWindow)) {
				driver.switchTo().window(Handle);//switching to new window
				Thread.sleep(2000);
				WebElement LookUPFrame=driver.findElement(By.id("searchFrame"));
				driver.switchTo().frame(LookUPFrame);
				Thread.sleep(2000);

				WebElement search=driver.findElement(By.xpath("//input[@id='lksrch']"));
				search.sendKeys("GlobalMedia");
				driver.switchTo().defaultContent();
				WebElement GOBtn=driver.findElement(By.xpath("//form[@id='theForm']//input[@class=' Go! ']"));
				GOBtn.click();
				Thread.sleep(2000);
			
			}
			}
		}
	
	static void SaveAndNew() throws InterruptedException {
		WebElement SaveandNew=driver.findElement(By.xpath("(//input[@value='Save & New'])[1]"));
		Thread.sleep(2000);
		SaveandNew.click();
		System.out.println("New Contact is creatred");
	}
}


