package onboarding.pages;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.AddProviderData;
import onboarding.dataobjects.Constants;
import onboarding.dataobjects.DashBoardData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class LicensesPage extends BasePage {
	private String currentScreenName;

	public LicensesPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_License_Heading() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-ICON")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_License() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-BTN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	/**
	 * @return {boolean} returns true or
	 *         false
	 * @function
	 * @description This function is
	 *              used to verify all
	 *              the Licenses Page
	 *              header elements
	 * @name verifyLicensesHeaderElements
	 */
	public boolean verifyLicensesHeaderElements() {

		if (!SeleniumHelper.isElementDisplayed(we_License_Heading())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Add_Icon())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Add_License())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or
	 *         false
	 * @function
	 * @description This function is
	 *              used to click Add
	 *              License
	 * @name clickAddLicense
	 */
	public boolean clickAddLicense() {
		if (!SeleniumHelper.clickElement(we_Add_License())) {
			return false;
		}
		return true;
	}
}
