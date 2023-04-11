package day6_Selenium_xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {

    public static void main(String[] args) {
        // Set up the WebDriver instance and navigate to the URL
    	System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		
    	
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Declare an implicit wait for 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.indeed.com/");

        // Check if the search fields are enabled and displayed
        WebElement whatField = driver.findElement(By.name("q"));
        WebElement whereField = driver.findElement(By.name("l"));
        System.out.println("What field is enabled and displayed? " + whatField.isEnabled() + ", " + whatField.isDisplayed());
        System.out.println("Where field is enabled and displayed? " + whereField.isEnabled() + ", " + whereField.isDisplayed());

        // Close the browser
        driver.quit();
    }
}