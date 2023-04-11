package day9_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Class {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		actionTest();
	}
public static void actionTest() throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Actions letsDo = new Actions(driver);
		driver.get("http://etsy.com");
		//Hover Over on Jewelry & Accessories
		WebElement jewelaryTab = driver.findElement(By.xpath("//span[contains(text(), 'Jewelry & Accessories')]"));
		letsDo.moveToElement(jewelaryTab).build().perform();
		Thread.sleep(5000);
		//Mouseover on Bags & Purses
		WebElement bagsPurses = 
				driver.findElement(By.xpath("(//span[contains(text(), 'Bags & Purses')])[1]"));
		Thread.sleep(5000);
		letsDo.moveToElement(bagsPurses).build().perform();
		WebElement ShoulderBags = 
				driver.findElement(By.xpath("//a[contains(text(), 'Shoulder Bags')]"));
		Thread.sleep(5000);
		letsDo.moveToElement(ShoulderBags).build().perform();
		//Click on the shoulder bags
		ShoulderBags.click();
		//Verify you are on the Shoulder bags page
		if (driver.findElement(By.xpath("//span[contains(text(), 'Shoulder Bags')]")).isDisplayed()) {
			System.out.println("We are on the Bag page.");
		} else {
			System.out.println("We are not on the Bag page.");
		}
}
}
