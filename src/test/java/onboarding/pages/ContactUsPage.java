package onboarding.pages;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.CredentialingDecisionData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class ContactUsPage extends BasePage{
	
	private String currentScreenName;

	public ContactUsPage() {
		currentScreenName = getClassName(this.getClass());
	}
	
	//Controls
	
	public WebElement we_ContactUs_Content_Section() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CONTACT-US-CONTENT-SECTION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_Contact_Us_Dlg() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-CONTACT-US-DLG")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_CRED_Not_Allowed_Error_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-NOT-ALLOWED-ERR-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_CRED_Not_Allowed_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-NOT-ALLOWED-INFO-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_CRED_Not_Allowed_Call_Us_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-NOT-ALLOWED-CALL-US-INFO-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_CRED_Not_Allowed_Phone_Num() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-NOT-ALLOWED-PHONE-NUM")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_CRED_Not_Allowed_Phone_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-NOT-ALLOWED-PHONE-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Click_Close_Button() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CLOSE-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}
	
	//Methods
	
	/**
	 * @return {boolean}
	 * 
	 * @function
	 * 
	 * @description This function is used to verify dash board content section
	 * presence
	 * 
	 * @name verifyContactUsContent
	 */
	public boolean verifyContactUsContent() {
		int num = 0;
		while (we_ContactUs_Content_Section() == null && num <= 50) {
			SeleniumHelper.sleep(1000);
			num++;
		}
		return SeleniumHelper.isElementDisplayed(we_ContactUs_Content_Section());
	}
	
	/**
	 * @param {AddProviderData
	 *            data} to hold Add
	 *            Provider Data page
	 *            data members
	 * @return {boolean} returns True or
	 *         false
	 * @function
	 * @description The below function
	 *              is used to display
	 *              Contact Us message
	 * @name displayContactUsMessage
	 */
	public boolean displayContactUsMessage(CredentialingDecisionData data) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(2600);
		}
		if (!SeleniumHelper.isElementDisplayed(we_CRED_Not_Allowed_Error_Icon())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_CRED_Not_Allowed_Message()).contains(data.getCREDNotAllowedMessage())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_CRED_Not_Allowed_Call_Us_Message()).contains(data.getCREDNotAllowedCallUsMessage())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CRED_Not_Allowed_Phone_Icon())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_CRED_Not_Allowed_Phone_Num()).contains(data.getCREDNotAllowedPhoneNum())) {
			return false;
		}	
		return true;
		
	}
	
	/**
	 * @return {boolean} returns True or
	 *         false
	 * @function
	 * @description The below function
	 *              is used to click the
	 *              close button on the
	 *              Contact Us page
	 * @name clickCloseButton
	 */
	public boolean clickCloseButton() {
		if (!SeleniumHelper.clickElement(we_Click_Close_Button())) {
			return false;
		}
		return true;
	}
}
