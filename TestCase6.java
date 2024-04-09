package SeleniumTestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase6 {
	static WebDriver driver;	
	static Actions action;
	public static void main(String[] args) throws InterruptedException {
		LoginApplication();
		EditLink();
		AboutinEditnxttoContact();
		lastname();	
		PostLink();
		driver.switchTo().defaultContent();
		UploadPhoto();
	}
		static void LoginApplication() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		driver.get(" https://login.salesforce.com");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("hima@abb.com");		
		Thread.sleep(2000);
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("chindu@7022");
		Thread.sleep(2000);
		WebElement Login=driver.findElement(By.id("Login"));
		Login.click();
		WebElement UsermenuDropdown=driver.findElement(By.id("userNavButton"));
		UsermenuDropdown.click();
		WebElement Myprofile=driver.findElement(By.xpath("//a[@title='My Profile']"));
		Myprofile.click();
	}
		static void EditLink() {
			WebElement Editbutton=driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
			Editbutton.click();
		}
		static void AboutinEditnxttoContact() throws InterruptedException {
		Thread.sleep(2000);
		WebElement frame=driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame(frame);
		Thread.sleep(1000);
		WebElement Abouttab=driver.findElement(By.id("aboutTab"));
		Abouttab.click();
		//driver.close();
	}
		static void lastname() throws InterruptedException {
			WebElement LastName=driver.findElement(By.xpath("//input[@class='lastName zen-inputFull zen-input']"));
			LastName.clear();
			LastName.sendKeys("Muthyala");
			WebElement saveAll=driver.findElement(By.xpath("//input[@value='Save All']"));
			saveAll.click();
			Thread.sleep(4000);
		}
		static void PostLink() throws InterruptedException {
			driver.switchTo().defaultContent();
//			Thread.sleep(4000);
			WebElement PostLink=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
			Thread.sleep(4000);
			PostLink.click();
			WebElement Frame=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
			driver.switchTo().frame(Frame);
			WebElement TextArea=driver.findElement(By.xpath("/html/body"));
			TextArea.click();
			Thread.sleep(2000);
			TextArea.sendKeys("Hello Team");
			driver.switchTo().defaultContent();
			WebElement Share=driver.findElement(By.xpath("//span[@class='publisherShareButtonPlaceholder']"));
			Thread.sleep(2000);
			Share.click();
			WebElement FileLink=driver.findElement(By.xpath("//span[text()='File']"));
			Thread.sleep(2000);
			FileLink.click();
			WebElement uploadfilefromcomputer=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
			uploadfilefromcomputer.click();
			WebElement choosefile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
			Thread.sleep(2000);
			choosefile.sendKeys("C:\\Java\\Files\\fileuploadintestestcase6.txt");
			WebElement sharefile=driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
			sharefile.click();
		}
		static void UploadPhoto() throws InterruptedException {
     		 action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='photoSection']"))).build().perform();
			
//	     	WebElement Deletephoto=driver.findElement(By.xpath("//a[@id='deletePhoto']"));
//			Deletephoto.click();
//			WebElement ok= driver.findElement(By.xpath("//input[@id='simpleDialog0button0']"));
//			ok.click();
			WebElement Addphoto=driver.findElement(By.xpath("//a[contains(text(),'Add Photo')]"));
			Addphoto.click();
			Thread.sleep(2000);
			WebElement photoframe=driver.findElement(By.id("uploadPhotoContentId"));
			driver.switchTo().frame(photoframe);
			WebElement fileinput=driver.findElement(By.className("fileInput"));
			Thread.sleep(2000);
			fileinput.sendKeys("C:\\Users\\himabindhu\\OneDrive\\Desktop\\bunny.png");
			WebElement SaveBtn=driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
			Thread.sleep(2000);
			SaveBtn.click();
			Thread.sleep(3000);
			WebElement SaveBtn2=driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']"));
			SaveBtn2.click();
			
		}
		}


