package day3_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day2_seleniumFunctions.FacebookActivities;

public class EtsySignIn {

	public static void main(String[] args) throws InterruptedException {
		
        // Create a new ChromeDriver
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
		EtsySignIn esty = new EtsySignIn();
		esty.testCase();

	}

	
	public void testCase() throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
	       // Navigate to Etsy.com
		driver.get("https://etsy.com");
        // Find and click on the Sign In button
		driver.findElement(By.className("select-signin")).click();
		Thread.sleep(1000);
	    // Find the email and password fields and enter the credentials
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("automation");
		   // Find and click on the Sign In button
		driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--primary wt-width-full']")).click();
		
		//wait for 5 seconds and close the browser 
		   //Thread.sleep(5000);
		   driver.quit();
	}

}
