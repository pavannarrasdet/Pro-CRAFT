package onboarding.pages;

import java.util.List;
import org.openqa.selenium.WebElement;

import onboarding.dataobjects.AddAffiliatedHospitalData;
import onboarding.dataobjects.EditLicenseData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class EditLicensesPage extends BasePage {
	private String currentScreenName;

	public EditLicensesPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_Add_License_Header() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_All_Fields_Required() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ALL-FIELDS-REQUIRED-TXT")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_Type() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-TYPE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_Number_Header() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-NUMBER-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Cancel_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-CANCEL-BTN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Add_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-ADD-BTN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Close_X_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-X-BTN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_State_Header() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-STATE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Issue_Date_Header() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ISSUE-DATE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Expiration_Date_Header() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "EXPIRATION-DATE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_Type_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-TYPE-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public List<WebElement> we_select_License_Type_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-TYPE-DDN-LIST")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_License_Number_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-NUMBER-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Issue_Date_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-ISSUE-DATE-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Expiration_Date_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-EXPIRATION-DATE-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_License_State_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-STATE-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public List<WebElement> we_select_License_State_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-STATE-DDN-LIST")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to populates license data on Edit
	 *              License window
	 * @param It
	 *            accepts the Edit License data object as a parameter
	 * @name populateLicenseData
	 */
	public boolean populateLicenseData(EditLicenseData data) {
		if (!data.getLicenseType().isEmpty()) {
			if (!SeleniumHelper.clickElement(we_License_Type_DDN())) {
				return false;
			}
			if (!SeleniumHelper.selectOption(we_select_License_Type_List(), data.getLicenseType())) {
				return false;
			}
		}

		if (!data.getLicenseNumber().isEmpty()) {
			if (!SeleniumHelper.enterText(we_License_Number_TXT(), data.getLicenseNumber())) {
				return false;
			}
		}
		if (!data.getIssueDate().isEmpty()) {
			if (!SeleniumHelper.enterText(we_Issue_Date_TXT(), data.getIssueDate())) {
				return false;
			}
		}
		if (!data.getExpirationDate().isEmpty()) {
			if (!SeleniumHelper.enterText(we_Expiration_Date_TXT(), data.getExpirationDate())) {
				return false;
			}
		}
		if (!data.getState().isEmpty()) {
			if (!SeleniumHelper.clickElement(we_License_State_DDN())) {
				return false;
			}
			if (!SeleniumHelper.selectOption(we_select_License_State_List(), data.getState())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description The below function is used to do not submit 'Add License
	 *              Modal' window
	 * @name DonNotsubmitForm
	 */
	public boolean DonNotsubmitForm() {
		if (!SeleniumHelper.clickElement(we_Cancel_Btn())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description The below function is used to submit 'Add License Modal'
	 *              window
	 * @name submitForm
	 */
	public boolean submitForm() {
		if (!SeleniumHelper.clickElement(we_Add_Btn())) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param {EditAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to verify previous saved data on 'Edit License Modal' window
	 * @name validatePreviousSavedInfo
	 */
	public boolean validatePreviousSavedInfo(EditLicenseData data) {
		
		if(!SeleniumHelper.getAttribute(we_License_Number_TXT(), "value").equals(data.getLicenseNumber()))
		{
			return false;
		}
		if(!SeleniumHelper.getText(we_License_Type_DDN()).equals(data.getLicenseType()))
		{
			return false;
		}
		if (!data.getIssueDate().isEmpty()) {
			if (!SeleniumHelper.getAttribute(we_Issue_Date_TXT(),"value").equals(data.getIssueDate())) {
				return false;
			}
		}
		if (!data.getExpirationDate().isEmpty()) {
			if (!SeleniumHelper.getAttribute(we_Expiration_Date_TXT(),"value").equals(data.getExpirationDate())) {
				return false;
			}
		}
		if (!data.getState().isEmpty()) {
			if(!SeleniumHelper.getText(we_License_State_DDN()).equals(data.getState()))
			{
				return false;
			}
		}
		return true;
	}
	
}
