package driverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebBrowser {
	public static WebDriver getDriver(Browser browserName) {
	WebDriver driver = null;
	
		switch(browserName) {
	
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
			
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default :
			throw new IllegalArgumentException("Unknown browser: " + browserName);
		}
		return driver;
	}	
	
}
