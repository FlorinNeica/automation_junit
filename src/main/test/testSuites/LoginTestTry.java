package testSuites;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestTry {

	private WebDriver driver;

	@Before
	public void beforeTest() {

		WebDriverManager.chromedriver()
				.setup();
		// System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("http://siit.epizy.com/index.php?route=account/login");
	}

	@Test
	public void loginInvalidCredentialsTest() {

		WebElement txtEmailAddress = driver.findElement(By.id("input-email"));

		txtEmailAddress.sendKeys("acasa1@home.com");

		WebElement txtPassword = driver.findElement(By.id("input-password"));

		txtPassword.sendKeys("acasa1");

		WebElement btnLogin = driver.findElement(By.xpath("//input[@value='Login']"));

		btnLogin.click();

		WebElement lblValidationError = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

		String actualErrorMsg = lblValidationError.getText();

		String expectedErrorMsg = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertEquals("The validation error is incorrect", expectedErrorMsg, actualErrorMsg);
	}

	@After
	public void afterTest() {
		driver.quit();
	}
}
