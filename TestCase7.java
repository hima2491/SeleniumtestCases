package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase7 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		UserMenuBtn();
		Mysettings();
		Personol();
		DispalyandLayout();
		Email();
		CalendersandRemainders();
		System.out.println("Testcase is Success");
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
	 static void UserMenuBtn() {
		 WebElement UsermenuDropdown=driver.findElement(By.id("userNavButton"));
		 UsermenuDropdown.click();
	 }
	 static void Mysettings() throws InterruptedException {
		WebElement MySettings=driver.findElement(By.xpath("//a[@title='My Settings']"));
		MySettings.click();
	}
	static void Personol() throws InterruptedException {
		WebElement personol=driver.findElement(By.id("PersonalInfo_font"));
		personol.click();
		Thread.sleep(2000);
		WebElement LoginHistory=driver.findElement(By.id("LoginHistory_font"));
		LoginHistory.click();
		Thread.sleep(2000);
		WebElement DownloadHis=driver.findElement(By.xpath("//div[@class='pShowMore']"));
		DownloadHis.click();
     	Thread.sleep(2000);
	}
		static void DispalyandLayout() throws InterruptedException {
		WebElement DisandLayout=driver.findElement(By.id("DisplayAndLayout_font"));
		DisandLayout.click();
		WebElement CustomizeMytabs=driver.findElement(By.id("CustomizeTabs_font"));
		CustomizeMytabs.click();
     	WebElement customApp=driver.findElement(By.id("p4"));
		Select saleschatter= new Select(customApp);
		saleschatter.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(2000);
		WebElement Report=driver.findElement(By.xpath("//option[@value='report']"));
		Report.click();
		WebElement Addbutton=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		Addbutton.click();
		WebElement save=driver.findElement(By.name("save"));
		save.click();
		Thread.sleep(2000);
		WebElement contentbuttonArrow=driver.findElement(By.id("tsid-arrow"));
		contentbuttonArrow.click();
		Thread.sleep(2000);
		WebElement salesforcechatter=driver.findElement(By.xpath("//a[contains(text(),'Salesforce Chatter')]"));
		salesforcechatter.click();
		Thread.sleep(2000);
		WebElement contentbuttonArrow1=driver.findElement(By.id("tsid-arrow"));
		contentbuttonArrow1.click();
  	    WebElement content=driver.findElement(By.xpath("//a[contains(text(),'Content')]"));
        content.click();
	    Thread.sleep(2000);
	  }
	     static void Email() throws InterruptedException {
	     Mysettings();
		WebElement Emaillink=driver.findElement(By.xpath("//div[@id='EmailSetup']"));
		Emaillink.click();
		WebElement MyEmailSettings=driver.findElement(By.id("EmailSettings_font"));
		MyEmailSettings.click();
		WebElement AutomaticBcc=driver.findElement(By.name("auto_bcc"));
		if(!AutomaticBcc.isSelected()) {
		AutomaticBcc.click();
		}
		WebElement SaveBtn=driver.findElement(By.xpath("//input[@class='btn primary']"));
		SaveBtn.click();
     	}
		
		static void CalendersandRemainders() throws InterruptedException{
		WebElement CalandRem=driver.findElement(By.id("CalendarAndReminders_font"));
		CalandRem.click();
		Thread.sleep(1000);
		WebElement ActivityRemainders=driver.findElement(By.id("Reminders_font"));
		ActivityRemainders.click();
		WebElement OpenTestRemainders=driver.findElement(By.xpath("//input[@value='Open a Test Reminder']"));
		OpenTestRemainders.click();
		}	
	}	


