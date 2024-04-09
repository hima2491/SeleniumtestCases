package SeleniumTestCases;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase25Contact {
	static WebDriver driver;
	static Actions actions;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Contact();
		NewBtn() ;
		NewAccountCreation();
		Thread.sleep(3000);
		driver.close();
		System.out.println("TestCase-25 is Success");
		
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
	static void NewAccountCreation() throws InterruptedException {
		WebElement LastName=driver.findElement(By.id("name_lastcon2"));
		LastName.sendKeys("Muthyala");
		WebElement AccountlookupIcon=driver.findElement(By.xpath("//a[@title='Account Name Lookup (New Window)']"));
		AccountlookupIcon.click();
				String ParentWindow=driver.getWindowHandle();
				  System.out.println("Parent window handle" +ParentWindow);
					Set<String>listofHandles=driver.getWindowHandles();
					System.out.println("total windows opened currently"+ listofHandles.size());
					for(String Handle:listofHandles)
					{
						System.out.println("Current window Handle" +Handle);
						if(!Handle.equals(ParentWindow)) {
							driver.switchTo().window(Handle);//switching to new window
							Thread.sleep(3000);
							WebElement LookUPFrame=driver.findElement(By.id("searchFrame"));
							driver.switchTo().frame(LookUPFrame);
							Thread.sleep(2000);
							WebElement searchinlookup=driver.findElement(By.xpath("//form[@id='theForm']//input[@id='lksrch']"));
							searchinlookup.sendKeys("Account123");
							driver.switchTo().defaultContent();
							WebElement GOBtn=driver.findElement(By.xpath("//form[@id='theForm']//input[@class=' Go! ']"));
							 actions=new Actions(driver);
							 actions.moveToElement(GOBtn).build().perform();
							GOBtn.click();
			
//							driver.close();
							break;
						}
					}
		WebElement  AccountName=driver.findElement(By.id("con4"));
		AccountName.sendKeys("Saketh");
		WebElement Savebtn=driver.findElement(By.xpath("//input[@value=' Save ']"));
		Savebtn.click();
	}
}
