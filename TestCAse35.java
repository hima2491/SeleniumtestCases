package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCAse35 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		Alltabs();
		Customizetab();
		SelectedTab() ;
		Thread.sleep(4000);
		savebtn();
		Thread.sleep(2000);
		Logout();
		LoginApplication();
		driver.close();
		System.out.println("TestCase-35 is success");	
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
 static void Alltabs() {
	 WebElement AllTabsbtn=driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
	 AllTabsbtn.click();
 }
 static void Customizetab() {
	 WebElement Customizetabbtn=driver.findElement(By.xpath("//input[@class='btnImportant']"));
	 Customizetabbtn.click();
 }
 static void SelectedTab() throws InterruptedException {
		WebElement selectedtabdrpdwn=driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		Select libraries=new Select(selectedtabdrpdwn);
		libraries.selectByVisibleText("Libraries");
		WebElement Removebtn=driver.findElement(By.xpath("//img[@class='leftArrowIcon']"));
		Thread.sleep(2000);
		Removebtn.click();
	}
 static void savebtn() {
	 WebElement Savebtn=driver.findElement(By.xpath("//input[@class='btn primary']"));
	 Savebtn.click();
 }
 static void Logout() {
	WebElement UsermenuDropdown=driver.findElement(By.id("userNavButton"));
	UsermenuDropdown.click();
	WebElement logout=driver.findElement(By.xpath("//a[@title='Logout']"));
	logout.click();
  }
}