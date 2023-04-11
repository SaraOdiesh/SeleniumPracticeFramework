package day9_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		dragAndDemoTest();
	}

	
	public static void dragAndDemoTest() {
		 WebDriver driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			
			
			Actions letsDo = new Actions(driver);
			// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
		   driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		//  drag the Text element to next window
		   WebElement sourceElement = driver.findElement(By.id("text"));
		  WebElement targetElement = driver.findElement(By.id("dropzone"));
		  letsDo.dragAndDrop(sourceElement, targetElement).build().perform();
		   
		
		
	}
	
	
}
