package day9_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDropHW {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		 DragAndDropHWTest();
	}
public static void DragAndDropHWTest() throws InterruptedException {
	
	 WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		Actions letsDo = new Actions(driver);
		// Navigate to the website
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		// Verify Drag And Drop text displays
		WebElement dragAndDropText= driver.findElement(By.xpath("//h3[contains(text(),'Drag And Drop')]"));
		if (dragAndDropText.getText().equals("Drag And Drop")) {
			System.out.println("Drag and drop text is displayed!");
		} else {
			System.out.println("Drag and drop text is not displayed!");
		}
		  // Locate the target window
		WebElement targetWindow = driver.findElement(By.id("dropzone"));
				// drag the Text element to target window
		 WebElement textElement =driver.findElement(By.xpath("//p[@class='drag ui-draggable ui-draggable-handle']"));
		 letsDo.dragAndDrop(textElement, targetWindow).build().perform();
		// drag the Textarea element to target window
		 WebElement textareaElement =driver.findElement(By.xpath("(//p[@class='drag ui-draggable ui-draggable-handle'])[2]"));
		 letsDo.dragAndDrop(textareaElement, targetWindow).build().perform();
		// drag the Number element to target window
		 WebElement numberElement =driver.findElement(By.xpath("(//p[@class='drag ui-draggable ui-draggable-handle'])[3]"));
		 letsDo.dragAndDrop(numberElement, targetWindow).build().perform();
		Thread.sleep(5000);
				// delete all those dragged items from target window
		 targetWindow.findElement(By.xpath("(//i[@class='bi bi-trash'])[1]")).click();
		 targetWindow.findElement(By.xpath("(//i[@class='bi bi-trash'])[2]")).click();
		 targetWindow.findElement(By.xpath("//i[@class='bi bi-trash']")).click();
		 
	    
	
}
}
