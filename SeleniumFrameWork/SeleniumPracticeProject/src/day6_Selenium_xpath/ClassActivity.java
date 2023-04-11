package day6_Selenium_xpath;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassActivity {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		newTabDemo();
		
	}
	
	public static void newTabDemo() {
		 WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      WebDriverWait wait = new WebDriverWait(driver, 5);
	   // Navigate to the URL
	      driver.get("http://practice.primetech-apps.com/practice/browser-windows");

	      // Step 1: Get the main window ID and store it in a String called mainWindowId
	      String mainWindowId = driver.getWindowHandle();

	      // Step 2: Click on the ‘New Tab’ button
	      driver.findElement(By.id("newTab")).click();

	      // Step 3: Get window IDs and store it into a Set
	      Set<String> windowIds = driver.getWindowHandles();
            for(String windowId : windowIds){
            	System.out.println("Window Id is: "+ windowId);
            }
	      // Step 4: Get the first window ID from the Set and Verify it matches with the main window id in step 1.
	      windowIds.remove(mainWindowId);
	      
	      String newWindowId = windowIds.iterator().next();
	      assert newWindowId.equals(mainWindowId);

	      // Step 5: Then get the second window id and store it in variable called secondWindowId.
	      windowIds.remove(newWindowId);
	      String secondWindowId = windowIds.iterator().next();

	      // Step 6: Switch to the second window
	      driver.switchTo().window(secondWindowId);

	      // Step 7: Verify that there is a button called ‘New Tab’
	      assert driver.findElement(By.id("newTab")).isDisplayed();

	      // Close the window
	      driver.close();

	      // Switch back to the main window
	      driver.switchTo().window(mainWindowId);

	      // Verify you are on the main window
	      assert driver.getTitle().equals("Browser Windows Practice");
	      
	      // Close the main window and quit the driver
	      driver.close();
	      driver.quit();
	    }
	  
	}


