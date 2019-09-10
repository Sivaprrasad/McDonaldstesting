import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myMcdTests {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//Added Selenium + webdriver
		
		System.setProperty("webdriver.chrome.driver","/Users/sivaprrasad/Desktop/chromedriver");
		driver = new ChromeDriver();
		
		//Given target website
		driver.get("https://www.mcdonalds.com/ca/en-ca.html");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void testTitleSubscription() {
		
		
		//Getting the Title of McD Subscription
		WebElement title = driver.findElement(By.className("click-before-outline"));
		String actualTitle = title.getText();
		
		//checking Actual = Expected
		assertEquals("Subscribe to My McD’s®", actualTitle);
		
	}
	
	@Test
	public void testEmailSignupHappyPath() {
		//getting fistname textfield id and inserting 
		WebElement firstNameInput = driver.findElement(By.id("firstname2"));
		firstNameInput.sendKeys("SivaPrasad");
		String fname = firstNameInput.getText();
		
		//getting email textfield id and inserting
		WebElement emailInput = driver.findElement(By.id("email2"));
		emailInput.sendKeys("usivaprasad95@gmail.com");
		String email = emailInput.getText();
		
		//getting postal code id and inserting.
		WebElement postalCodeInput = driver.findElement(By.id("postalcode2"));
		postalCodeInput.sendKeys("  m1h");
		String pcode = postalCodeInput.getText();
		
		//getting subscribe button id and clicking
		WebElement subscribeButton = driver.findElement(By.id("g-recaptcha-btn-2"));
		subscribeButton.click();
		
// <div class="verify-button-holder"><button class="rc-button-default goog-inline-block" title="" 
//		value="" 
//		id="recaptcha-verify-button" tabindex="0">Verify</button></div>
		
		// Trying for auto click Verify captcha button
//		//Getting Verify Captcha Button and Clicking
//		WebElement verifyCaptchaButton = driver.findElement(By.className("rc-button-default goog-inline-block"));
//		verifyCaptchaButton.click();
	}
	
	@Test
	public void testEmailSignupNegativePath() {
		
		WebElement firstNameInput = driver.findElement(By.id("firstname2"));
		firstNameInput.sendKeys("");
		String fname = firstNameInput.getText();
		
		WebElement emailInput = driver.findElement(By.id("email2"));
		emailInput.sendKeys("");
		String email = emailInput.getText();
		
		//Inserting WRONG INPUT in postal code input..
		WebElement postalCodeInput = driver.findElement(By.id("postalcode2"));
		postalCodeInput.sendKeys("");
		String pcode = postalCodeInput.getText();
		
		//getting subscribe button id and clicking
		WebElement subscribeButton = driver.findElement(By.id("g-recaptcha-btn-2"));
		subscribeButton.click();
		
		// Trying for auto click Verify captcha button
//		//Getting Verify Captcha Button and Clicking
//		WebElement verifyCaptchaButton = driver.findElement(By.cssSelector("rc-button-default.goog-inline-block"));
//				//("rc-button-default goog-inline-block"));
//				//recaptcha-verify-button
//		verifyCaptchaButton.click();
		
	}

}
