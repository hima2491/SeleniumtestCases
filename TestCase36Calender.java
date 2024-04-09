package SeleniumTestCases;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase36Calender {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Hometab() ;
		Thread.sleep(2000);
		CalenderLink();
		EightPMLink();
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
}

static void CalenderLink() throws InterruptedException {
	WebElement Dateanddaylink=driver.findElement(By.xpath("//span[@class='pageDescription']/a"));
	Thread.sleep(2000);
	Dateanddaylink.click();
	  }
static void EightPMLink() throws InterruptedException {
	WebElement EightPmBtn= driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']"));
	EightPmBtn.click();
	WebElement SubCombo=driver.findElement(By.xpath("//a[@tabindex='2']"));
	SubCombo.click();
	String ParentWindow=driver.getWindowHandle();
	System.out.println("Parent window handle" +ParentWindow);
	Set<String> listofHandles=driver.getWindowHandles();
	System.out.println("total windows opened currently"+ listofHandles.size());
	for(String Handle:listofHandles) 
	{
		System.out.println("Current window Handle" +Handle);
		if(!Handle.equals(ParentWindow)) {
			driver.switchTo().window(Handle);
			Thread.sleep(2000);
			WebElement other=driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']"));
			Thread.sleep(2000);
			other.click();
//			if(other.isSelected()) {
//				Thread.sleep(2000);
//				System.out.println("Other Button is clicked");
//			}else {
//				System.out.println("Other Button is not clicked");
//			}
		}
	}
	driver.switchTo().window(ParentWindow);
	Thread.sleep(2000);
	WebElement EndTime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
	EndTime.clear();
	EndTime.sendKeys("9:00PM");
	WebElement SaveBtn=driver.findElement(By.xpath("(//input[@title='Save'])[1]"));
	Thread.sleep(3000);
	SaveBtn.click();
}
}


