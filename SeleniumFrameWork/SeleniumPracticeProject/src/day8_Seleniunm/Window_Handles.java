package day8_Seleniunm;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Window_Handles {

	    public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", 
			        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
	    	//testCase();
	    	
	    }
	    
	    
	    public static void testCase() {
	    	 WebDriver driver = new ChromeDriver();
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, 5);
	        // Create a new instance of the ChromeDriver
	    	String firstName = "John";
	    	String lastName = "Smith";
	    	String address = "123 Main St";
	    	String city = "Anaheim";
	    	String state = "CA";
	    	String zipCode ="92882";
	      

	        // Navigate to the page
	        driver.get("http://practice.primetech-apps.com/practice/frames");

	     
	        // Verify that there is a page header text as "Frames"
	        WebElement pageHeader = driver.findElement(By.xpath("//h3[text(),'Frames']"));
	        String pageHeaderText = pageHeader.getText();
	        if (pageHeaderText.equals("Frames")) {
	            System.out.println("Page header verified successfully.");
	        } else {
	            System.out.println("Page header verification failed.");
	        }

	        // Find the iFrame element and switch into it
	        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
	        driver.switchTo().frame(iframeElement);

	        // Find firstname, lastname, address, city, state, and zipcode, and type relative information
	        driver.findElement(By.id("firstName")).sendKeys(firstName);
	        driver.findElement(By.id("lastName")).sendKeys(lastName);
            driver.findElement(By.id("address")).sendKeys(address);
	        driver.findElement(By.id("city")).sendKeys(city);
	        driver.findElement(By.id("state")).sendKeys(state);
	        driver.findElement(By.id("zipCode")).sendKeys(zipCode);
           
//	        // Click on submit button
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	      //  wait.until(ExpectedConditions.visibilityOf(submitBTN)).click();
//	        // Verify you see "You have submitted below information:" message
        WebElement confirmationMessage = driver.findElement(By.xpath("//h3[contains(text(),'You have submited below information')]"));
        String confirmationMessageText = confirmationMessage.getText();
        if (confirmationMessageText.equals("You have submited below information:")) {
            System.out.println("Confirmation message verified successfully.");
	        } else {
            System.out.println("Confirmation message verification failed.");
	        }

//	        // Switch back to main frame
	        driver.switchTo().defaultContent();

//	        // Verify that there is a page header text as "Frames"
	        pageHeader = driver.findElement(By.xpath("//h3[@class='mb-5']"));
        pageHeaderText = pageHeader.getText();
        if (pageHeaderText.equals("Frames")) {
	            System.out.println("Page header verified successfully.");
	        } else {
            System.out.println("Page header verification failed.");
        }

	        // Quit the driver
	        driver.quit();
	    }
	
}

