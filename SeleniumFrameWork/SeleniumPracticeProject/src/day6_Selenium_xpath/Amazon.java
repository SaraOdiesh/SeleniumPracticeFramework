package day6_Selenium_xpath;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		listElement();
		
	}

        public static void listElement() {
		        WebDriver driver = new ChromeDriver();
		        driver.manage().window().maximize();

		        // Declare an implicit wait for 5 seconds
		        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		        // Navigate to amazon.com
		        driver.get("https://www.amazon.com");

		        // Search for "coffee mug"
		        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		        searchBox.sendKeys("coffee mug");
		        searchBox.submit();

		        // Navigate back
		        driver.navigate().back();

		        // Search for "pretty coffee mug"
		        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		        searchBox.sendKeys("pretty coffee mug");
		        searchBox.submit();

		        // Navigate back and then forward
		        driver.navigate().back();
		        driver.navigate().forward();

		        // Refresh the page
		        driver.navigate().refresh();

		        // Close the browser
		        driver.quit();
		        
        }
}