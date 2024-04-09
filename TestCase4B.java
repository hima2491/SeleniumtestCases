package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase4B {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(" https://login.salesforce.com");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("123");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("22131");
		Thread.sleep(2000);
		WebElement Login=driver.findElement(By.id("Login"));
		Login.click();
		Thread.sleep(4000);
		driver.close();
		System.out.println("TestCase is success");
	}

}
