package SeleniumTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1EnterYourPW {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get(" https://login.salesforce.com");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("hima@abb.com");		
		Thread.sleep(2000);
		WebElement Login=driver.findElement(By.id("Login"));
		Login.click();
		WebElement Error=driver.findElement(By.xpath("//div[@id='error']"));
		String Errormsg=Error.getText();
		if(Errormsg.isEmpty()) {
			System.out.println("Error Msg is not diplayed");
		}else
		{
			System.out.println("Eroor Msg is diplayed: "  + Errormsg);
	
	    }
		driver.close();
		System.out.println("TestCase-1 is success");
	}
	
}
