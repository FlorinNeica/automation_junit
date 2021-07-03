package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(how = How.ID, using = "input-email")
	private WebElement txtEmailAddress;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement txtPassword;

	// //a[.='Forgotten Password']
	// //div[@id='content']//a[.='Forgotten Password']
	// //a[.='Forgotten Password' and not(@class='list-group-item')]

	@FindBy(how = How.LINK_TEXT, using = "Forgotten Password")
	private WebElement btnForgottenPassword;

	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	private WebElement btnLogin;

	public void login(String emailAddress, String password) {
		txtEmailAddress.sendKeys(emailAddress);
		txtPassword.sendKeys(password);
		btnLogin.click();
	}

	public ForgotPasswordPage navigateToforgottenPassword(WebDriver driver) {

		btnForgottenPassword.click();

		return PageFactory.initElements(driver, ForgotPasswordPage.class);
	}
}
