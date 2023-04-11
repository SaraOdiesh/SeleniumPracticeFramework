package day4_selenium_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookXpath {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
		
		FaceBookXpath fb= new FaceBookXpath();
		fb.xpathFace();
		fb.xpathFaceCreate();
		
	}

	
	public void xpathFace() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		// go to facebook.com
		
		driver.get("https://facebook.com");
		Thread.sleep(1000);
	    // find the Email or phone number field and type Automation
		driver.findElement(By.xpath( "//input[@id='email']")).sendKeys("automation");
	    // find the Password field and type Automation
		driver.findElement(By.xpath(" //input[@id='pass']")).sendKeys("automation");
	    // find the Login button and click on it.
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	//Test case 2 - (Use only Xpath)
	public void xpathFaceCreate() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	    // go to facebook.com
		driver.get("https://facebook.com");
		Thread.sleep(1000);
	    // find the Create New Account button and click on it
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		Thread.sleep(1000);
	    // find the FirstName,  LastName, Email and Password fields and type Automation
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("automation@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("automation");
	    // find the Sign Up button and click on it.
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		driver.quit();
	}
}
