package day6_Selenium_xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_HW {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
		Xpath_HW hm =new Xpath_HW();
		hm.TestCase1();
		
		
		

	}
	
	public void TestCase1() throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Wait for the page to be loaded
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		Thread.sleep(5000);
		    WebElement element = driver.findElement(By.xpath("(//button[@class='accordion-button collapsed'])[1]"));
		    element.click();
			Thread.sleep(5000);
            // Find all the checkboxes on the page
		    List<WebElement> checkBoxesPage = driver.findElements(By.xpath("//button[@class='accordion-button']"));
		
		    // Find all the radioButton on the page
		    List<WebElement> radioButtonPage = driver.findElements(By.xpath("(//button[@class='btn btn-secondary'])[1]"));
		    // Find all the buttons on the page
		    List<WebElement> buttonsPage = driver.findElements(By.cssSelector("#buttons"));
		    // Find all the links on the page
		    List<WebElement> linksPage = driver.findElements(By.cssSelector("#links"));
		    // Print the number of checkboxes found on the page
		    System.out.println("Number of checkboxes found: " + checkBoxesPage.size());
		    System.out.println("Number of radio buttons found: " + radioButtonPage.size());
		    System.out.println("Number of buttons found: " + buttonsPage.size());
		    System.out.println("Number of links found: " + linksPage.size());
		   
		    
		    // Close the browser
		    driver.quit();
		  }


	}

