package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase16NewOppurtunity {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		OppurtunitiesTab();
		NewBtn();
		createNewopp();
		System.out.println("Testcase-16 is success");
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
	static void OppurtunitiesTab() throws InterruptedException {
		WebElement Oppurtunity=driver.findElement(By.xpath("//a[@title='Opportunities Tab']"));
		Thread.sleep(3000);
		Oppurtunity.click();
	}
	static void NewBtn() {
		driver.findElement(By.xpath("//input[@value=' New ']")).click();
	}
	static void createNewopp() throws InterruptedException {
		WebElement OppName=driver.findElement(By.id("opp3"));
		OppName.sendKeys("Oppurtunity2");
		WebElement AccName=driver.findElement(By.id("opp4"));
		AccName.sendKeys("Saketh");
		WebElement CloseDate=driver.findElement(By.id("opp9"));
		CloseDate.sendKeys("3/25/2024");
		WebElement LeadSource=driver.findElement(By.id("opp6"));
		Select leadsrc=new Select(LeadSource);
		leadsrc.selectByVisibleText("Web");
		WebElement Stagedrpdwn=driver.findElement(By.id("opp11"));
		Select stage=new Select(Stagedrpdwn);
		stage.selectByVisibleText("Qualification");
		WebElement Probability=driver.findElement(By.id("opp12"));
		Probability.sendKeys("0.25%");
		WebElement TypeDrpdwn=driver.findElement(By.id("opp5"));
		Select type=new Select(TypeDrpdwn);
		type.selectByVisibleText("Existing Customer - Upgrade");
		Thread.sleep(2000);
		WebElement Savebtn=driver.findElement(By.xpath("//input[@tabindex='18']"));
		Thread.sleep(2000);
		Savebtn.click();	
	}
}
