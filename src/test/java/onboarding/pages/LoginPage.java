package onboarding.pages;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.Constants;
import onboarding.dataobjects.LoginData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class LoginPage extends BasePage {
	private String currentScreenName;

	public LoginPage() {
		currentScreenName = getClassName(this.getClass());
	}

	// controls

	public WebElement we_optumIDoremailAddress() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "OptumIDoremailaddress")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_passWord() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Password")), mediumSync(),
				SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_signIn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SignIn")), mediumSync(),
				SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_appUnavailable() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ApplicationNotAvailable")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_errortext() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ErrorText")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	// methods
	/**
	 * @param {LoginData
	 *            data} holds data members of Login page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to Login to Onboarding application
	 * @name loginToOnboarding
	 */
	public boolean loginToOnboarding(LoginData data) {
		// skip login if local
		if (AutomationBase.getRegion().equals("local")) {
			return true;
		}
		SeleniumHelper.waitForPageLoad(highSync());
		if (!SeleniumHelper.enterText(we_optumIDoremailAddress(), data.getOptumIDorEmailAddress())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_passWord(), data.getPassWord())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_signIn())) {
			return false;
		}
		//commented out as we got new URL
		/*// to be deleted once https logic is implemented
		if (!SeleniumHelper.getTitle().equals(Constants.app_Title)
				&& SeleniumHelper.isElementDisplayed(we_appUnavailable())) {
			String url = SeleniumHelper.getURL();
			url = url.replace("https", "http");
			System.out.println("Updated URL.." + url);
			SeleniumHelper.navigateToURL(url);
		}*/

		return true;
	}

	/**
	 * @param {String
	 *            text} that holds error text on login page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to validate error message on login
	 *              page with invalid credentials
	 * @name validateErrorMessage
	 */
	public boolean validateErrorMessage(String text) {
		if (!SeleniumHelper.getText(we_errortext()).equals(text)) {
			return false;
		}
		return true;
	}
}
