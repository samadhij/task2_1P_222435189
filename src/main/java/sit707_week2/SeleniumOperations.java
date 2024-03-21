package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement fName = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + fName);
		// Send first name
		fName.sendKeys("Samadhi");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement LName = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + LName);
		// Send last name
		LName.sendKeys("Jayasinghe");
		
		WebElement pNumber = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + pNumber);
		// Send phone number
		pNumber.sendKeys("0424548014");
		
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Found element: " + email);
		// Send email
		email.sendKeys("samadhi0727@gmail.com");
		
		WebElement pword = driver.findElement(By.id("password"));
		System.out.println("Found element: " + pword);
		// Send password
		pword.sendKeys("samadhi");
		
		WebElement pwordConf = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + pwordConf);
		// Send password confirmation
		pwordConf.sendKeys("samadhi");
		
		 //Identify button 'Create account' and click to submit using Selenium API.
		
		WebElement createAccountButton = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
        createAccountButton.click();
		
		//Take screenshot using selenium API.
		
        if (driver.getCurrentUrl().equals(url)) {
        	saveScreenshotOfficeworks(driver);
        }
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void saveScreenshotOfficeworks(WebDriver driver) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:/Users/User/Documents/SIT 707 - Software Quality And Testing/Task 2.1P/screenshot.png"));
			System.out.println("Screenshot from Officework's registration page saved successfully");
		}catch(IOException e) {
			System.out.println("Failed to save screenshot from Officework's registration page");
			e.printStackTrace();
		}
	}
	
	public static void bunnings_registration_page(String url2) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver2 = new ChromeDriver();
		
		System.out.println("Driver info: " + driver2);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver2.get(url2);
		
		
		// Wait for the element to be clickable with a timeout of 5 seconds
		WebDriverWait wait = new WebDriverWait(driver2, 5);
		
		WebElement email2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("uid")));
		System.out.println("Found element: " + email2);
		// Send email
		email2.sendKeys("samadhi0727@gmail.com");
		
		WebElement pword2 = driver2.findElement(By.id("password"));
		System.out.println("Found element: " + pword2);
		// Send password
		pword2.sendKeys("samadhi");
		
		WebElement fName2 = driver2.findElement(By.id("firstName"));
		System.out.println("Found element: " + fName2);
		// Send first name
		fName2.sendKeys("Samadhi");
		
		WebElement LName2 = driver2.findElement(By.id("lastName"));
		System.out.println("Found element: " + LName2);
		// Send last name
		LName2.sendKeys("Jayasinghe");
	
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement createAccountButton2 = driver2.findElement(By.cssSelector("button[data-locator='input_CreateAccount']"));
        createAccountButton2.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
        if (driver2.getCurrentUrl().equals(url2)) {
        	saveScreenshotBunnings(driver2);
        }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver2.close();	
	}
	
	public static void saveScreenshotBunnings(WebDriver driver2) {
		
		File scrFile2 = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile2, new File("C:/Users/User/Documents/SIT 707 - Software Quality And Testing/Task 2.1P/screenshotBunnings.png"));
			System.out.println("Screenshot from Bunnings's registration page saved successfully");
		}catch(IOException e) {
			System.out.println("Failed to save screenshot from Bunnings's registration page");
			e.printStackTrace();
		}
	}
	
	
}
