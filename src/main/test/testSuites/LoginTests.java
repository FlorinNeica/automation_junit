package testSuites;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import driverManagement.BaseClass;
import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;

public class LoginTests extends BaseClass {

	// @Before
	public void navigate() {
		navigateTo("http://siit.epizy.com/index.php?route=account/login");
	}

	// @Test
	public void testLogin() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("home@acasa.com", "12345");
		ForgotPasswordPage forgetPage = loginPage.navigateToForgottenPassword(driver);
		forgetPage.resetPassword();
	}

	// @Test
	public void displayCookies() {
		navigateTo("https://google.com");
		Set<Cookie> setOfCookies = driver.manage()
				.getCookies();
		System.out.println("Found " + setOfCookies.size() + " cookies");
		for (Cookie c : setOfCookies) {
			System.out.println("Cookie name: " + c.getName());
			System.out.println("Cookie value: " + c.getValue());
		}
	}

	// @Test
	public void takeScreenShot() throws IOException {
		navigateTo("https://google.com");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File finalFile = new File("D:\\scoala informala it\\testing\\automation\\screenshot\\screenshot.png");
		FileUtils.copyFile(screenshotFile, finalFile);
	}

	// @Test
	public void actionsOnPage() throws IOException {
		navigateTo("http://siit.epizy.com/");
		WebElement btnComponents = driver.findElement(By.linkText("Components"));
		Actions actions = new Actions(driver);
		actions.moveToElement(btnComponents)
				.build()
				.perform();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File finalFile = new File("D:\\scoala informala it\\testing\\automation\\screenshot\\screenshot.png");
		FileUtils.copyFile(screenshotFile, finalFile);
	}

	// @Test
	public void openNewTab() {
		navigateTo("http://siit.epizy.com/");

		WebElement btnSoftware = driver.findElement(By.linkText("Software"));
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL)
				.click(btnSoftware)
				.build()
				.perform();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			if (driver.switchTo()
					.window(handle)
					.getTitle()
					.equals("Software")) {
				System.out.println(handle);
				break;
			}

			System.out.println(handle);

		}
	}

	@Test
	public void staleElementSolution() {
		navigateTo("http://siit.epizy.com/");

		By btnLocator = By.xpath("//div[@id='search']/span/button");
		WebElement button = driver.findElement(btnLocator);

		button.click();

		for (int i = 0; i <= 10; i++) {
			// Locate the element again before the action we need to perform (click)
			button = driver.findElement(btnLocator);
			button.click();
		}
	}
}
