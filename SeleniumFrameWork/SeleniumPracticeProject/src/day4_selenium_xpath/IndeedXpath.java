package day4_selenium_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import day3_selenium.IndeedHomeWork;

public class IndeedXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
		IndeedHomeWork indeed = new IndeedHomeWork();
        indeed.testCase();
	}
 
	
	    public void testCase() throws InterruptedException {
		//go to indeed.com
		WebDriver driver = new ChromeDriver();
		String searchCriteria = "SDET";
		driver.get("https://indeed.com");
		 Thread.sleep(1000);
	   // Get the current URL and website title
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		// Find the input field for WHAT and enter "SDET"
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys(searchCriteria);
		//find the input field for where, clear the field first and type washington DC
		WebElement whereField = driver.findElement(By.xpath("//input[@name='l']"));
	
		whereField.sendKeys(Keys.COMMAND + "a");
		
		whereField.sendKeys(Keys.DELETE);
		String locationText= whereField.getAttribute("value");
		for (int i = 0; i < locationText.length(); i++) {
			whereField.sendKeys(Keys.BACK_SPACE);
		}
		whereField.sendKeys("Washington DC");
		
		 Thread.sleep(5000);
	    // Find and click on the Search button
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 Thread.sleep(5000);
		// Get the current URL and website title after the search
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
        // Verify that the search URL is not equal to the home URL and contains the search criteria
		if(!searchURL.equals(homeURL) && searchURL.contains(searchCriteria)) {
		System.out.println("Search URL doesn't match and contains the search criteria");
		} else {
			System.out.println("Search URL matchs or contains the search criteria");
		}
		  // Verify that the search title is not equal to the home title and has the search criteria
		if(!searchTitle.equals(homeTitle) && searchTitle.contains(searchCriteria)) {
			System.out.println("Search Title doesn't match and contains the search criteria");
			
		} else {
			System.out.println("Search Title  matchs or doesn't contains the search criteria");
		}
		
		
	     // Get the text of the "Jobs in Location" field and verify that it equals to "SDET"
		//WebElement jobsInLocationField =driver.findElement(By.name("l"));
		 String jobsInLocationText = driver.findElement(By.xpath("//div[contains(text(),'Location')]")).getText();
	        System.out.println("Jobs in the Location text: " + jobsInLocationText);
	        
	        if (jobsInLocationText.contains("Washington DC")) {
				System.out.println("Jobs in Location Text Contains the Search Criteria. Test Pass!");
			} else {
				System.out.println("Jobs in Location Text Does not Contain the Search Criteria. Test Fail!");
			}
	        
	        String searchCriteriaSubText = jobsInLocationText.substring(0, searchCriteria.length());
	        
	        System.out.println(searchCriteriaSubText + " " + searchCriteria.length());
	        
	        if (searchCriteriaSubText.equals(searchCriteria)) {
				System.out.println("Jobs in Location Text Equals the Search Criteria. Test Pass!");
			} else {
				System.out.println("Jobs in Location Text Does not Contain the Search Criteria. Test Fail!");
			}
	    }
}

