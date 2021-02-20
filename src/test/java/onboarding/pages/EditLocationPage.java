package onboarding.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.EditLocationData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class EditLocationPage extends BasePage {
	private String currentScreenName;

	public EditLocationPage() {
		currentScreenName = getClassName(this.getClass());
	}	
	
	public WebElement we_BLNG_CHK() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "BILLING-CHKBOX")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PLSV_CHK() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PLSV-CHKBOX")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CRED_CHK() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CRED-CHKBOX")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_STRT_ADDRS_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "STRT-ADRS-Txt")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CITY_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CITY-Txt")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_STATE_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "STATE-DDN")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_STATE_DDN_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LOCATION-STATE-DDN-LIST")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_ZIP_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ZIP-TXT")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PHONE_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PHONE-TXT")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_FAX_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FAX-TXT")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_ADD_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-BTN")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CANCEL_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CANCEL-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CLOSE_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CLOSE-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_SAVE_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SAVE-BTN")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	//methods
	
	/**
	 * 
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify existing location information
	 * @name verifyExistingAddress
	 */
	public boolean verifyExistingAddress(EditLocationData data) {
		if (data.getLocationType().equals("Billing")) {
			if (SeleniumHelper.isElementEnabled(we_BLNG_CHK()) && !SeleniumHelper.isElementSelected(we_BLNG_CHK())) {
				return false;
			}

			if (!SeleniumHelper.isElementEnabled(we_PLSV_CHK()) && SeleniumHelper.isElementSelected(we_PLSV_CHK())) {
				return false;
			}
			if (!SeleniumHelper.isElementEnabled(we_CRED_CHK()) && SeleniumHelper.isElementSelected(we_CRED_CHK())) {
				return false;
			}
		} else if (data.getLocationType().equals("Place of Service")) {
			if (SeleniumHelper.isElementEnabled(we_PLSV_CHK()) && !SeleniumHelper.isElementSelected(we_PLSV_CHK())) {
				return false;
			}

			if (!SeleniumHelper.isElementEnabled(we_BLNG_CHK()) && SeleniumHelper.isElementSelected(we_BLNG_CHK())) {
				return false;
			}
			if (!SeleniumHelper.isElementEnabled(we_CRED_CHK()) && SeleniumHelper.isElementSelected(we_CRED_CHK())) {
				return false;
			}
		} else if (data.getLocationType().equals("Credentialing")) {
			if (SeleniumHelper.isElementEnabled(we_CRED_CHK()) && !SeleniumHelper.isElementSelected(we_CRED_CHK())) {
				return false;
			}

			if (!SeleniumHelper.isElementEnabled(we_PLSV_CHK()) && SeleniumHelper.isElementSelected(we_PLSV_CHK())) {
				return false;
			}
			if (!SeleniumHelper.isElementEnabled(we_BLNG_CHK()) && SeleniumHelper.isElementSelected(we_BLNG_CHK())) {
				return false;
			}
		}
		if(!SeleniumHelper.getAttribute(we_STRT_ADDRS_TXT(), "value").equals(data.getStreetAddress()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_CITY_TXT(), "value").equals(data.getCity()))
		{
			return false;
		}
		if(!SeleniumHelper.getText(we_STATE_DDN()).equals(data.getState()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_ZIP_TXT(), "value").equals(data.getZipCode()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_PHONE_TXT(), "value").equals(data.getPhone()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_FAX_TXT(), "value").equals(data.getFax()))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return {boolean}
	 * @function
	 * @description This function is used to edit location information
	 * @name editLocationInfo
	 */
	public boolean editLocationInfo(EditLocationData data) {
		
//		we_STRT_ADDRS_TXT().sendKeys(Keys.SHIFT, Keys.END, Keys.BACK_SPACE);
		SeleniumHelper.clickElement(we_STRT_ADDRS_TXT());
		SeleniumHelper.js_clearInput(we_STRT_ADDRS_TXT());
		if (!SeleniumHelper.enterText(we_STRT_ADDRS_TXT(), data.getStreetAddress())) {
			return false;
		}
		SeleniumHelper.clickElement(we_CITY_TXT());
		SeleniumHelper.js_clearInput(we_CITY_TXT());
		if (!SeleniumHelper.enterText(we_CITY_TXT(), data.getCity())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_STATE_DDN())) {
			return false;
		} else {
			if (!SeleniumHelper.selectOption(we_STATE_DDN_List(), data.getState())) {
				return false;
			}
		}
		SeleniumHelper.clickElement(we_ZIP_TXT());
		SeleniumHelper.js_clearInput(we_ZIP_TXT());
		if (!SeleniumHelper.enterText(we_ZIP_TXT(), data.getZipCode())) {
			return false;
		}
		SeleniumHelper.clickElement(we_PHONE_TXT());
		SeleniumHelper.js_clearInput(we_PHONE_TXT());
		if (!SeleniumHelper.enterText(we_PHONE_TXT(), data.getPhone())) {
			return false;
		}
		SeleniumHelper.clickElement(we_FAX_TXT());
		SeleniumHelper.js_clearInput(we_FAX_TXT());
		if (!SeleniumHelper.enterText(we_FAX_TXT(), data.getFax())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_SAVE_BTN())) {
			return false;
		}
		return true;
	}
}
