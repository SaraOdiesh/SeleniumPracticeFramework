package day3_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedHomeWork {

	public static void main(String[] args) throws InterruptedException {
		/*1. go to indeed.com
		2. get the current URL and store it in a variable called homeURL.
		3. get the website title and store it in a variable homeTitle.
		4. find the input field for WHAT and type SDET
		5. find the Search button and click on it.
		6. get the current URL and store it a variable searchURL.
		7. get the website title and store it in a variable searchTitle.
		8. verify that searchURL does not equal to homeURL and contains the search criteria.
		9. verify that searchTitle does not equal to homeTitle and has the search criteria.
		10. Get Text of the JobsInLocation field, store it in a variable, then verify if it's equals to your search criteria. 
		*/
		
        // Create a new ChromeDriver
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
		IndeedHomeWork indeed = new IndeedHomeWork();
        indeed.testCase();
	}
 
	
	    public void testCase() throws InterruptedException {
		//go to indeed.com
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.indeed.com");
		 Thread.sleep(1000);
	   // Get the current URL and website title
		String homeURL = driver.getCurrentUrl();
		String homeTitle = driver.getTitle();
		// Find the input field for WHAT and enter "SDET"
		driver.findElement(By.name("q")).sendKeys("SDET");
		
	    // Find and click on the Search button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Get the current URL and website title after the search
		String searchURL = driver.getCurrentUrl();
		String searchTitle = driver.getTitle();
        // Verify that the search URL is not equal to the home URL and contains the search criteria
		if(!searchURL.equals(homeURL) && searchURL.contains("SDET")) {
		System.out.println("Search URL doesn't match and contains the search criteria");
		} else {
			System.out.println("Search URL matchs or doesn't contains the search criteria");
		}
		  // Verify that the search title is not equal to the home title and has the search criteria
		if(!searchTitle.equals(homeTitle) && searchTitle.contains("SDET")) {
			System.out.println("Search Title doesn't match and contains the search criteria");
			
		} else {
			System.out.println("Search Title  matchs or doesn't contains the search criteria");
		}
		
			     // Get the text of the "Jobs in Location" field and verify that it equals to "SDET"
		//WebElement jobsInLocationField =driver.findElement(By.name("l"));
		String jobsInLocationText = driver.findElement(By.className("jobsearch-SerpTitle")).getText();
		System.out.println("Jobs in the location text: " + jobsInLocationText);
		
		if(jobsInLocationText.contains("SDET")){
				System.out.println("Job in Location Text Contains the Search Criteria. Test Pass!");
	   } else {
		System.out.println("Job in Location Text does not Contains the Search Criteria. Test Fail!");
		
	    
	  }
		//wait for 5 seconds and close the browser 
	    Thread.sleep(5000);
        driver.quit();
	  }
}
