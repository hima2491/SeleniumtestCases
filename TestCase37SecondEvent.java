package SeleniumTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase37SecondEvent {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Hometab() ;
		CalenderLink();
		FourPMLink();
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
  }static void FourPMLink() throws InterruptedException {
		WebElement FourPmBtn= driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:20:j_id64']"));
		FourPmBtn.click();
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
				Thread.sleep(4000);
				other.click();
				
//				if(other.isSelected()) {
//					Thread.sleep(2000);
//					System.out.println("Other Button is clicked");
//				}else {
//					System.out.println("Other Button is not clicked");
//				}
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(ParentWindow);
		WebElement EndTime=driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		EndTime.clear();
		EndTime.sendKeys("7:00PM");
		Thread.sleep(2000);
		WebElement Recurrence= driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		if(!Recurrence.isSelected()) {
			Recurrence.click();
			System.out.println("Recurrence is checked");
		}
		WebElement WeeklyRoudnup=driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		if(!WeeklyRoudnup.isSelected()) {
			WeeklyRoudnup.click();
			System.out.println("WeeklyRoudnup is checked");
		}
		WebElement RecEndDate=driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		RecEndDate.sendKeys("4/17/2024");
		WebElement SaveBtn=driver.findElement(By.xpath("(//input[@title='Save'])[1]"));
		Thread.sleep(3000);
		SaveBtn.click();
		WebElement Monthview=driver.findElement(By.xpath("//img[@class='monthViewIcon']"));
		Monthview.click();
  }
}
