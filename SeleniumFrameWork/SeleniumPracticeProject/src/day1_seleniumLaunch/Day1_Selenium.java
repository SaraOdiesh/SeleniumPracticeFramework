package day1_seleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1_Selenium {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        driver.get("https://amazon.com");
         Thread.sleep(1000);
         
         //System.out.println("Home page title is: " + driver.getTitle());
        //driver.findElement(By.name("username")).sendKeys("saraodiesh");
       // driver.findElement(By.name("password")).sendKeys("test1234"); 
       // Thread.sleep(3000);
        
        //driver.findElement(By.xpath(null));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug");
        driver.findElement(By.id("nav-search-submit-button")).click();
        
        driver.findElement(By.linkText("Customer Service")).click();
        
	} 

}
