package onboarding.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import onboarding.dataobjects.Constants;
import onboarding.dataobjects.CredentialingDecisionData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class CredentialingDecisionPage extends BasePage {
	private String currentScreenName;

	public CredentialingDecisionPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_CRED_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CRED-MESSAGE-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CRED_Message_1() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CRED-MESSAGE-DISPLAY_1")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CAQH-MESSAGE-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CRED_Decision_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CRED-DECISION-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_Green_Tick_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-GREEN-TICK")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_Image() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CAQH-LOGO")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Display_Name() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-NAME-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Click_X_Button() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-X-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Click_Cancel_Button() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CANCEL-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_CONTINUE_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-CONTINUE-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}
	
	public WebElement we_Red_Exclamation_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-RED-EXCLAMATION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_Behavior_Health_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-BEHAVIORAL-HEALTH-RESULT-MESSAGE1")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_Behavior_Health_Result_Contact() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-BEHAVIORAL-HEALTH-RESULT-CONTACT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_Behavior_Health_Result_ContactUs_Link() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-BEHAVIORAL-HEALTH-RESULT-CONTACTUS-LINK")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_Physical_Health_Result_ContactUs_Link() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CRED-DECISION-PHYSICAL-HEALTH-RESULT-CONTACTUS-LINK")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
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
	 *              CRED/NOT CRED
	 *              required message
	 * @name displayMessage
	 */
	public boolean displayMessage(CredentialingDecisionData data) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(2600);
		}

		if (!SeleniumHelper.getText(we_CRED_Message()).contains(data.getCREDMessage())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_CAQH_Message()).contains(data.getCAQHMessage())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Green_Tick_Icon())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CAQH_Image())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Display_Name())
				.contains(Constants.prefix + data.getFirstName() + data.getMiddleName() + data.getLastName())) {
			return false;
		}
		if(!SeleniumHelper.isElementEnabled(we_CONTINUE_BTN())) {
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
	 *              x button on the
	 *              credentialing
	 *              decision page
	 * @name clickXButton
	 */
	public boolean clickXButton() {
		if (!SeleniumHelper.clickElement(we_Click_X_Button())) {
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
	 *              cancel button on the
	 *              credentialing
	 *              decision page
	 * @name clickCancelButton
	 */
	public boolean clickCancelButton() {
		if (!SeleniumHelper.clickElement(we_Click_Cancel_Button())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to click
	 *              continue button on
	 *              the credentialing
	 *              decision page
	 * @name clickContinue
	 */

	public boolean clickContinue() {
		//SeleniumHelper.sleep(4000);
		if (!SeleniumHelper.isElementDisplayed(we_CRED_Message())) {
			SeleniumHelper.sleep(1000);
		}

		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(3000);
		}
		if (!SeleniumHelper.clickElement(we_CONTINUE_BTN())) {
			return false;
		}
		return true;
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
	 *              BehavioralHealth
	 *              message
	 * @name displayBehavioralHealthMessage
	 */
	public boolean displayBehavioralHealthMessage(CredentialingDecisionData data) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(2600);
		}
		
		if (!SeleniumHelper.isElementDisplayed(we_Red_Exclamation_Icon())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Behavior_Health_Message()).contains(data.getBehavioralHealthMessage())) {
			return false;
		}

		if (!SeleniumHelper.getText(we_Behavior_Health_Result_Contact()).contains(data.getContactMessageLink())) {
			return false;
		}	
		if (!SeleniumHelper.getText(we_Behavior_Health_Result_Contact()).contains(data.getContactMessageNumber())) {
			return false;
		}	
		return true;
		
	}
	
	public boolean verifyContactMessageLink(CredentialingDecisionData data) {
		if (!SeleniumHelper.getText(we_Behavior_Health_Result_Contact()).contains(data.getContactMessageLink())) {
			return false;
		}
		return true;
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
	 *              Cred not allowed
	 *              message
	 * @name displayCredNotAllowedMessage
	 */
	public boolean displayCredNotAllowedMessage(CredentialingDecisionData data) {
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
	 *              credentialing
	 *              decision page
	 * @name clickCloseButton
	 */
	public boolean clickCloseButton() {
		if (!SeleniumHelper.clickElement(we_Click_Close_Button())) {
			return false;
		}
		return true;
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
	 *              PhysicalHealth
	 *              message
	 * @name displayPhysicalHealthMessage
	 */
	public boolean displayPhysicalHealthMessage(CredentialingDecisionData data) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(2600);
		}
		
		if (!SeleniumHelper.isElementDisplayed(we_Red_Exclamation_Icon())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Behavior_Health_Message()).contains(data.getPhysicalHealthMessage())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Behavior_Health_Result_Contact()).contains(data.getContactMessageLink())) {
			return false;
		}	
		if (!SeleniumHelper.getText(we_Behavior_Health_Result_Contact()).contains(data.getContactMessageNumber())) {
			return false;
		}	
		return true;	
	}
	
	public boolean verifyOptumBehavioralHealthLink() {
		SeleniumHelper.clickElement(we_Behavior_Health_Result_ContactUs_Link());
		ArrayList<String> windows = SeleniumHelper.getWindows();
		if (windows.size() != 2) {
			return false;
		}
		SeleniumHelper.switchToWindowAndClose(windows.get(1));
		SeleniumHelper.switchToWindow(windows.get(0));
		return true;
	}
	
	public boolean verifyOptumPhysicalHealthLink() {
		SeleniumHelper.clickElement(we_Physical_Health_Result_ContactUs_Link());
		ArrayList<String> windows = SeleniumHelper.getWindows();
		if (windows.size() != 2) {
			return false;
		}
		SeleniumHelper.switchToWindowAndClose(windows.get(1));
		SeleniumHelper.switchToWindow(windows.get(0));
		return true;
	}
	
}
