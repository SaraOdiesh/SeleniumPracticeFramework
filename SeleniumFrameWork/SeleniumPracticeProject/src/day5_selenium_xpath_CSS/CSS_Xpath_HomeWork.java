package day5_selenium_xpath_CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSS_Xpath_HomeWork {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
		        "/Users/sammerodiesh/Documents/SeleniumTools/chromeDriver/chromedriver/chromedriver");
		CSS_Xpath_HomeWork hm = new CSS_Xpath_HomeWork();
		//hm.Testcase1();
		hm.webTabel();
			
	}
	public void Testcase1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		//Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		Thread.sleep(5000);
		//Find first name, last name, email, password, address fields, and type relevant information.
		//(Create variables for those information and pass the variable to the sendkey() method).
				String firstName = "Sara";
				String lastName ="Odiesh";
				String email= "odi@gmail.com";
				String password = "Test1235";
				String address = "123 Main St, CA, 92882";
		WebElement firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstNameField.sendKeys(firstName);
		WebElement lastNameField =driver.findElement(By.xpath("//input[@id='lastName']"));
		lastNameField.sendKeys(lastName);
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		emailField.sendKeys(email);
		WebElement passwordField =driver.findElement(By.xpath("//input[@id='password']"));
		passwordField.sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Enable')]")).click();
		WebElement addressField = driver.findElement(By.xpath("//textarea[@id='address']"));

		addressField.sendKeys(address);
		//Then click on submit button. (your inputs displays under user info section).
		WebElement submitField =driver.findElement(By.xpath("//button[@type='submit']"));
		submitField.click();
		Thread.sleep(5000);
		//Find your inputs and get text of each and store them into variables.
	
        WebElement userInfoSection = driver.findElement(By.xpath("//h3[contains(text(),'User Info:')]"));
        String displayedFirstName = userInfoSection.findElement(By.xpath("//div[contains(text(),'"+firstName+"')]"))
                        .getText().split(": ")[0];
        System.out.println("Actual first name is: " + firstName);
        String displayedLastName = userInfoSection.findElement(By.xpath("//div[contains(text(),'"+lastName+"')]"))
                        .getText().split(": ")[0];
        System.out.println("Actual last name is: " + lastName);
        String displayedEmail = userInfoSection.findElement(By.xpath("//div[contains(text(),'"+email+"')]"))
                        .getText().split(": ")[0];
        System.out.println("Actual email name is: " + email);
        String displayedPassword = userInfoSection.findElement(By.xpath("//div[contains(text(),'"+password+"')]"))
                        .getText().split(": ")[0];
        System.out.println("Actual passowrd is: " + password);
        String displayedAddress = userInfoSection.findElement(By.xpath("//div[contains(text(),'"+address+"')]"))
                        .getText().split(": ")[0];
        System.out.println("Actual address: " + address);

		//driver.findElement(null)
		//Then compare your input with the displayed user information if they match.
        if(displayedFirstName.equals(firstName) && displayedLastName.equals(lastName)
        		&& displayedEmail.equals(email) && displayedPassword.equals(password) 
        		&& displayedAddress.equals(address)){
        	System.out.println("Test Case1 Pass Input values match display user input");
        }
        else {
        	System.out.println("Test Case1 Fail Input values don't match display user input");
        }
        driver.quit();
	}
	
	//Testcase 2: 
	    public static void webTabel() throws InterruptedException {
	      WebDriver driver = new ChromeDriver();
		//1. Go to http://practice.primetech-apps.com/practice/web-tables
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		//2. Verify that you see Web Table's text
		String webtabelHeaderText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();
		if (webtabelHeaderText.equals("Web Tables")) {
			System.out.println(" We are on the Web Table Page.");
		}else {
			System.out.println("We are not on the Web table Page.");
		}
		//3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
		int id = 123;
		String firstname = "Sara";
		String lastname = "Odiesh";
	    int salary = 120000;
	    double salary2 = 13000.00;
		
	    driver.findElement(By.cssSelector("input[id=Id]")).sendKeys(String.valueOf(id));
	    driver.findElement(By.cssSelector("input[id='First Name']")).sendKeys(firstname);
	    driver.findElement(By.cssSelector("input[id='Last Name']")).sendKeys(lastname);
	    driver.findElement(By.cssSelector("input[id='Salary']")).sendKeys(String.valueOf(salary));
	  //4. Click on Add button
	    driver.findElement(By.xpath("//button[text()='Add']")).click();
	    Thread.sleep(1000);
	    
	    
		//5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
		String actualId = driver.findElement(By.xpath("//td[text()='" + id + "']")).getText();
		System.out.println(actualId);
		String actualFirstname = driver.findElement(By.xpath("//td[text()='" + firstname + "']")).getText();
		System.out.println(actualFirstname);
		String actualLastname = driver.findElement(By.xpath("//td[text()='" + lastname + "']")).getText();
		System.out.println(actualLastname);
		String actualSalary = driver.findElement(By.xpath("//td[text()='" + salary + "']")).getText();
		System.out.println(actualSalary);
	    //6. Verify your input under the table match the input you added. 
		
		
		if (Integer.parseInt(actualId) == id) {
			System.out.println("ID is good, Test Pass!");
		} else {
			System.out.println("ID is not good.");
		}
		if (actualFirstname.equals(firstname)) {
			System.out.println("Firstname is good, Test Pass!");
		} else {
			System.out.println("Firstname is not good.");
		}
		if (actualLastname.equals(lastname)) {
			System.out.println("Lastname is good, Test Pass!");
		} else {
			System.out.println("Lastname is not good.");
		}
		if (Integer.parseInt(actualSalary) == salary) {
			System.out.println("Salary is good, Test Pass!");
		} else {
			System.out.println("Salary is not good.");
		}
	}
}
