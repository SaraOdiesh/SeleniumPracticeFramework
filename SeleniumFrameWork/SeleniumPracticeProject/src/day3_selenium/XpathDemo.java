package day3_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		XpathDemo xpath = new XpathDemo();
		xpath.xpathDemo();

	}

	
	public void xpathDemo() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://etsy.com");
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Jon");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
