package driverManagement;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	protected static WebDriver driver;

	@BeforeClass
	public static void initDriver() {
		driver = WebBrowser.getDriver(Browser.CHROME);

	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
