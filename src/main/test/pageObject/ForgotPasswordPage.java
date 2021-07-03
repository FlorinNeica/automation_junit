package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

	@FindBy(how = How.ID, using = "input-email")
	private WebElement txtEmailAddress;

	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	private WebElement btnContinue;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Back']")
	private WebElement btnBack;

	public void resetPassword() {

	}
}
