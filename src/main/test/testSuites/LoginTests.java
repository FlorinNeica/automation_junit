package testSuites;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import driverManagement.BaseClass;
import pageObject.ForgotPasswordPage;
import pageObject.LoginPage;

public class LoginTests extends BaseClass {

	@Before
	public void navigate() {
		navigateTo("http://siit.epizy.com/index.php?route=account/login");
	}

	@Test
	public void testLogin() {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("home@acasa.com", "12345");
		ForgotPasswordPage forgetPage = loginPage.navigateToForgottenPassword(driver);
		forgetPage.resetPassword();
	}
}
