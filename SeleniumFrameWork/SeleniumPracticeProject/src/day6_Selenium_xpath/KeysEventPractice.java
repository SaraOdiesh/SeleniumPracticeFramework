package day6_Selenium_xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEventPractice {

	public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", 
			        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
			
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait for the page to be loaded
			driver.manage().window().maximize();
			//driver.get("https://www.google.com");
			driver.navigate().to("https://google.com");
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Coffee Mug" + Keys.ENTER);// this opens a new page
			
			Thread.sleep(5000);
			driver.findElement(By.name("q")).clear();
			Thread.sleep(5000);
			driver.findElement(By.name("q")).sendKeys("Selenium Webdriver " + Keys.ENTER);
			
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();
			Thread.sleep(5000);
			driver.navigate().refresh();
			
			driver.quit();
			
	}

}
