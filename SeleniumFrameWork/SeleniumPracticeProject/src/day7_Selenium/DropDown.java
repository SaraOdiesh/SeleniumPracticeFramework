package day7_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		//amazonDropDown();
		//amazonHomepage();
		//alertTest1();
		//alertTest2();
		//alertTest3();
		alertTest4();
	}
public static void amazonDropDown() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
   // go to amazon.com 
	driver.get("http://amazon.com");
   // get all the options in the departments select dropdown
	WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
	Select choose = new Select(selectElement);
	List<WebElement> allOptions = choose.getOptions();
	System.out.println(allOptions.size());
	for (WebElement element : allOptions) {
		System.out.println(element.getText());
 
		
	}
	driver.quit();
} 

   public static void amazonHomepage() throws InterruptedException {
	   
	   WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   // go to amazon.com 
		driver.get("http://amazon.com");
		WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
		Select choose = new Select(selectElement);
		//verify that you are on the amazon home page. (verify with title). 
		assert driver.getTitle().equals("title");
		Thread.sleep(1000);
	    
		 // Verify that the default dropdown value is "All Departments"
        Select departmentsDropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
        assert departmentsDropdown.getFirstSelectedOption().getAttribute("value").equals("search-alias=aps");

        // Select department "Home & Kitchen" and search for "coffee mug"
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("coffee mug");
        departmentsDropdown.selectByVisibleText("Home & Kitchen");
        driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  
        // Verify that you are on the coffee mug search results page by checking the title
        assert driver.getTitle().equals("Amazon.com: coffee mug - Home & Kitchen");
         System.out.println("You are on the the coffee mug search page ");
        // Verify that you are in the Home & Kitchen department.
        assert driver.findElement(By.id("s-refinements")).getText().contains("Home & Kitchen");
         System.out.println("You are on the Home & Kitchen department");
	 
   }

   
   public static void alertTest1() {
	   

       // Create a new instance of ChromeDriver
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       // Navigate to the URL
       driver.get("http://practice.primetech-apps.com/practice/alerts");
       
       // Find the 'Alert' button by ID and click on it
       driver.findElement(By.id("alert_button")).click();
       
       // Switch the driver focus to the alert
       Alert alert = driver.switchTo().alert();
       
       // Accept the alert
       alert.accept();
       
       // Close the browser
       driver.quit();
   }
	   
	   
   
   
  public static void alertTest2() throws InterruptedException {
	  // Create a new instance of ChromeDriver
      WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().window().maximize();
   // Navigate to the URL
      driver.get("http://practice.primetech-apps.com/practice/alerts");
      Thread.sleep(1000);

      // Click on the 'Confirm Alert' button
      driver.findElement(By.cssSelector("#confirm")).click();
	   // wait for the alert to appear
      Alert alert = driver.switchTo().alert();
      String alerttext = alert.getText();
      // Verify if the text equals to "Do you wish to continue or cancel?"
      if (alerttext.equals("Do you wish to continue or cancel?")) {
    	  System.out.println("Do you wish to continue or cancel");
		alert.accept();
		
	} else {
		//cancel the alert 
		alert.dismiss();
	}
   }
  public static void alertTest3() throws InterruptedException {
	  
	  WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      WebDriverWait wait = new WebDriverWait(driver, 5);
	      //go to http://practice.primetech-apps.com/practice/alerts 
      driver.get("http://practice.primetech-apps.com/practice/alerts");
      Thread.sleep(1000);
		//  Click on the 'Prompt Alert' button and type PrimeTech
 	    driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);

		System.out.println(alert.getText());
		alert.sendKeys("Prime Tech ");
		alert.accept();
		
		String greetingMessage = driver.findElement(By.id("demo")).getText();


        // Verify that the greeting message displays as "Hello <your input>! How are you today?"
        if (greetingMessage.equals("Hello PrimeTech! How are you today?")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        // Close the browser
        driver.quit();
		
	
		//String greetingMessage = driver.findElement(By.id("prompt_demo")).getText();
	   
  }
  public static void alertTest4() {
	  
	// Create an instance of the ChromeDriver
      WebDriver driver = new ChromeDriver();
  
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      // Navigate to the website
      driver.get("http://practice.primetech-apps.com/practice/alerts");

      // Click on the 'Prompt Alert' button
      driver.findElement(By.id("prompt")).click();

      // Wait for the alert to appear
      Alert alert = driver.switchTo().alert();

      // Type the input in the alert
      alert.sendKeys("PrimeTech");

      // accept the alert
      alert.accept();

      // Wait for the message to appear
      String message = driver.findElement(By.id("demo")).getText();

      // Verify that the message displays as "User cancelled the prompt."
      if (message.equals("User cancelled the prompt.")) {
          System.out.println("Test passed");
      } else {
          System.out.println("Test failed");
      }

      // Close the browser
      driver.quit();
  }


  }
