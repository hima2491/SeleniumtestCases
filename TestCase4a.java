package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4a {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(" https://login.salesforce.com");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("hima@abb.com");	
		WebElement forgotpw=driver.findElement(By.id("forgot_password_link"));
		forgotpw.click();
		WebElement forgotpwusername=driver.findElement(By.id("un"));
		forgotpwusername.sendKeys("hima@abb.com");
		WebElement submit=driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		System.out.println("Testcase is success");
	}

}
