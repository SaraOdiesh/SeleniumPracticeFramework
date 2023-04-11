package day9_Selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Handle {

	public static void main(String[] args) throws InterruptedException {
	

		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		windowHandlesTest();
	}

	
	 public static void windowHandlesTest() throws InterruptedException {
		        WebDriver driver = new ChromeDriver();
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, 5);
		       // go to http://demo.guru99.com/popup.php
			    driver.get("http://demo.guru99.com/popup.php");
		       // Get title and store it in a variable.
			  String windowTitle  = driver.getTitle();
			  String mainPageWindowId = driver.getWindowHandle();
		       // Click on "Click Here" button,
			driver.findElement(By.linkText("Click Here")).click();
			
			Thread.sleep(5000);
			
			  // switch over to next window,  
		      Set<String> windowHandles = driver.getWindowHandles();
		      for(String handle:windowHandles) {
		    	  driver.switchTo().window(handle);
		    	  if(!handle.equals(mainPageWindowId)) {
		    		 driver.switchTo().window(handle);
		    		 
		    	  }
		    	  
		      }
		  
   
               //provide an email click Submit.
	            WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
	            emailInput.sendKeys("test1234@gmail.com");
		        driver.findElement(By.name("btnLogin")).click();
		        Thread.sleep(5000);
		        WebElement userId = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td"));
		        WebElement password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td"));
		        System.out.println("User id" + userId.getText());
		        System.out.println("Password " + password.getText());
		        WebElement accessText = driver.findElement(By.xpath("//h3[text()='This access is valid only for 20 days.']"));
		        String accessTextValue = accessText.getText();
		        if (accessTextValue.equals("This access is valid only for 20 days.")) {
		            System.out.println("Access text verification passed");
		        } else {
		            System.out.println("Access text verification failed");
		        }
		        driver.close();
	        driver.switchTo().window(mainPageWindowId);
	        String mainTitle = driver.getTitle();
	        if (windowTitle.equals(mainTitle)) {
		            System.out.println("Main title verification passed");
		        } else {
		            System.out.println("Main title verification failed");
		        }

	 }
}
		

		 
		 
		 
	 

