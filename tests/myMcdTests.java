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

}
