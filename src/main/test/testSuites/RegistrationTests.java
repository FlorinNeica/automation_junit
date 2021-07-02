package testSuites;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegistrationTests {

	private static WebDriver driver;

	/**
	 * 1. Open the browser (Chrome) <br>
	 * 2. Navigate to http://siit.epizy.com/ <br>
	 * 3. Click on My Account button <br>
	 * 4. Click on Register button <br>
	 */
	@BeforeClass
	public static void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://siit.epizy.com/");

		WebElement btnMyAccount = driver.findElement(By.xpath("//a[@title='My Account']//span[1]"));
		
		btnMyAccount.click();

		WebElement btnRegister = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		btnRegister.click();
	}

	/**
	 * On the Register page <br>
	 * 1. Click on Continue button <br>
	 * 2. Verify that the message "Warning: You must agree to the Privacy Policy!" is displayed <br>
	 */
	@Test
	public void noDataRegisterTest() {
		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		
		btnContinue.click();

		WebElement lblPrivacyError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		String actualPrivacyErrorMsg = lblPrivacyError.getText();
		String expectedPrivacyErrorMsg = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(expectedPrivacyErrorMsg, actualPrivacyErrorMsg);
	}

	/**
	 * On the Register page <br>
	 * 1. Enter "asd" in the First Name field <br>
	 * 2. Enter "asd" in the Last Name field <br>
	 * 3. Click on Continue button <br>
	 * 4. Verify that the message "Warning: You must agree to the Privacy Policy!" is displayed <br>
	 */
	@Test
	public void invalidFirstAndLastNameDataTest() {
		WebElement fieldFirstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		
		fieldFirstName.sendKeys("asd");

		WebElement fieldLastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
		
		fieldLastName.sendKeys("asd");

		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		
		btnContinue.click();

		WebElement lblPrivacyError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		String actualPrivacyErrorMsg = lblPrivacyError.getText();
		String expectedPrivacyErrorMsg = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(expectedPrivacyErrorMsg, actualPrivacyErrorMsg);
	}

	/**
	 * On the Register page <br>
	 * 1. Enter "asd@home.com" in the Email Address field <br>
	 * 2. Click on Continue button <br>
	 * 3. Verify that the message "Warning: You must agree to the Privacy Policy!" is displayed <br>
	 */
	@Test
	public void invalidEmailDataTest() {
		WebElement fieldEmailAddress = driver.findElement(By.xpath("//input[@name='email']"));
		
		fieldEmailAddress.sendKeys("asd@home.com");
		
		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		
		btnContinue.click();

		WebElement lblPrivacyError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		String actualPrivacyErrorMsg = lblPrivacyError.getText();
		String expectedPrivacyErrorMsg = "Warning: You must agree to the Privacy Policy!";
		
		Assert.assertEquals(expectedPrivacyErrorMsg, actualPrivacyErrorMsg);
	}

	/**
	 * On the Register page <br>
	 * 1. Enter "asd" in the Telephone field <br>
	 * 2. Click on Continue button <br>
	 * 3. Verify that the message "Warning: You must agree to the Privacy Policy!" is displayed <br>
	 */
	@Test
	public void invalidTelephoneDataTest() {
		WebElement fieldTelephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
		
		fieldTelephone.sendKeys("asd");
		
		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		
		btnContinue.click();

		WebElement lblPrivacyError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		String actualPrivacyErrorMsg = lblPrivacyError.getText();
		String expectedPrivacyErrorMsg = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(expectedPrivacyErrorMsg, actualPrivacyErrorMsg);
	}
	
	/**
	 * On the Register page <br>
	 * 1. Enter "asdasd" in the Password field <br>
	 * 2. Enter "asdasd" in the Confirm Password field <br> 
	 * 3. Click on Continue button <br>
	 * 4. Verify that the message "Warning: You must agree to the Privacy Policy!" is displayed <br>
	 */
	@Test
	public void invalidPasswordDataTest() {
		WebElement fieldPassword = driver.findElement(By.xpath("//input[@id='input-password']"));
		
		fieldPassword.sendKeys("asdasd");
		
		WebElement fieldConfirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
		
		fieldConfirmPassword.sendKeys("asdasd");
		
		WebElement btnContinue = driver.findElement(By.xpath("//input[@value='Continue']"));
		
		btnContinue.click();
		
		WebElement lblPrivacyError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		
		String actualPrivacyErrorMsg = lblPrivacyError.getText();
		String expectedPrivacyErrorMsg = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(expectedPrivacyErrorMsg, actualPrivacyErrorMsg);
	}

	/**
	Close the browser (Chrome) <br>
	 */
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}

}
