package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase34 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Hometab();
		Thread.sleep(2000);
		EditProfile();
		iframeEditProfile() ;
		AboutTabinIframe();
		driver.switchTo().defaultContent();
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
		WebElement firstAndLastName=driver.findElement(By.xpath("//div[@id='mru005ak000002GqmI']"));
		Thread.sleep(2000);
		firstAndLastName.click();
	}
	static void EditProfile() {
		WebElement EditLink=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		EditLink.click();
	}
	static void iframeEditProfile() {
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='contactInfoContentId']"));
		driver.switchTo().frame(iframe);
	}
	static void AboutTabinIframe() {
		WebElement Abouttab=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		Abouttab.click();
		WebElement Lastname=driver.findElement(By.xpath("//input[@id='lastName']"));
		Lastname.clear();
		Lastname.sendKeys("Abcd");
		WebElement SaveAll=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		SaveAll.click();
	}
	
}
