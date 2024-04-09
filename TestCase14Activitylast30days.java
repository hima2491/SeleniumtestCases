  package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase14Activitylast30days {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		AccountsTab();
		ActwitLast30days();
		datefield();
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
	static void ActwitLast30days() {
		WebElement Activity=driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
		Activity.click();
	}
	static void datefield() throws InterruptedException {
		WebElement Datefield=driver.findElement(By.xpath("//input[@id='ext-gen20']"));
		Datefield.click();
//		Select CreatedDate=new Select(Datefield);
//		CreatedDate.selectByVisibleText("Created Date");
		WebElement CreatedDate=driver.findElement(By.xpath("//div[text()='Created Date']"));
		CreatedDate.click();
//		WebElement Fromdt=driver.findElement(By.xpath("//button[@id='ext-gen276']"));
//		Fromdt.click();
		WebElement FromDate=driver.findElement(By.xpath("//input[@name='startDate']"));
		FromDate.sendKeys("3/23/2024");
		WebElement ToDate=driver.findElement(By.xpath("//input[@name='endDate']"));
		ToDate.clear();
//		WebElement ToDate1=driver.findElement(By.xpath("//button[@id='ext-gen295']"));
//		ToDate1.click();
		ToDate.sendKeys("4/4/2024");
		WebElement SaveBTn=driver.findElement(By.id("ext-gen49"));
		SaveBTn.click();
		WebElement ReportName=driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		ReportName.sendKeys("Saketh");	
		WebElement RepUniName=driver.findElement(By.xpath("//input[@id='saveReportDlg_DeveloperName']"));
		RepUniName.sendKeys("SakethMuthyala22");
		WebElement SaveandRun=driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']/tbody/tr[2]/td[2]"));
		Thread.sleep(2000);
		SaveandRun.click();		
	} 
}
