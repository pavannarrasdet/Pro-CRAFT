package onboarding.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.AddLocationData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class AddLocationPage extends BasePage {

	private String currentScreenName;

	public AddLocationPage() {
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

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify add location window
	 *              functionality
	 * @name verifyAddLocationDlg
	 */
	public boolean verifyAddLocationDlg(RFPData data) {
		if (data.getLicenseType().equals("Billing")) {
			if (SeleniumHelper.isElementEnabled(we_BLNG_CHK()) && !SeleniumHelper.isElementSelected(we_BLNG_CHK())) {
				return false;
			}

			if (!SeleniumHelper.isElementEnabled(we_PLSV_CHK()) && SeleniumHelper.isElementSelected(we_PLSV_CHK())) {
				return false;
			}
			if (!SeleniumHelper.isElementEnabled(we_CRED_CHK()) && SeleniumHelper.isElementSelected(we_CRED_CHK())) {
				return false;
			}
		} else if (data.getLicenseType().equals("Place of Service")) {
			if (SeleniumHelper.isElementEnabled(we_PLSV_CHK()) && !SeleniumHelper.isElementSelected(we_PLSV_CHK())) {
				return false;
			}

			if (!SeleniumHelper.isElementEnabled(we_BLNG_CHK()) && SeleniumHelper.isElementSelected(we_BLNG_CHK())) {
				return false;
			}
			if (!SeleniumHelper.isElementEnabled(we_CRED_CHK()) && SeleniumHelper.isElementSelected(we_CRED_CHK())) {
				return false;
			}
		} else if (data.getLicenseType().equals("Credentialing")) {
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

		if (!SeleniumHelper.isElementDisplayed(we_STATE_DDN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_STRT_ADDRS_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CITY_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_ZIP_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PHONE_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_FAX_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_ADD_BTN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CANCEL_BTN())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return {boolean}
	 * @function
	 * @description This function is used to cancel location window
	 * @name cancelLocationWindow
	 */
	public boolean cancelLocationWindow() {
		if (!SeleniumHelper.clickElement(we_CANCEL_BTN())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return {boolean}
	 * @function
	 * @description This function is used to close location window
	 * @name cancelLocationWindow
	 */
	public boolean closeLocationWindow() {
		if (!SeleniumHelper.clickElement(we_CLOSE_BTN())) {
			return false;
		}
		return true;
	}

	public boolean addLocation(AddLocationData data) {
		String[] types = data.getLocationType().split(",");
		for (String type : types) {
			switch (type) {
			case "Billing":
				if(SeleniumHelper.isElementSelected(we_BLNG_CHK()))
				{
					break;
				}
				if (!SeleniumHelper.clickElement(we_BLNG_CHK())) {
					return false;
				}
				break;
			case "Place Of Service":
				if(SeleniumHelper.isElementSelected(we_PLSV_CHK()))
				{
					break;
				}
				if (!SeleniumHelper.clickElement(we_PLSV_CHK())) {
					return false;
				}
				break;
			case "Credentialing":
				if(SeleniumHelper.isElementSelected(we_CRED_CHK()))
				{
					break;
				}
				if (!SeleniumHelper.clickElement(we_CRED_CHK())) {
					return false;
				}
				break;
			}
		}
		if (!SeleniumHelper.enterText(we_STRT_ADDRS_TXT(), data.getStreetAddress())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_CITY_TXT(), data.getCity())) {
			return false;
		}
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
		if (!SeleniumHelper.enterText(we_ZIP_TXT(), data.getZipCode())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_PHONE_TXT(), data.getPhone())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_FAX_TXT(), data.getFax())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_ADD_BTN())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return {boolean}
	 * @function
	 * @description This function is used to add location information
	 * @name addLocationInfo
	 */
	public boolean addLocationInfo(AddLocationData data) {
		
		if (!SeleniumHelper.enterText(we_STRT_ADDRS_TXT(), data.getStreetAddress())) {
			return false;
		}
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
		if (!SeleniumHelper.enterText(we_ZIP_TXT(), data.getZipCode())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_PHONE_TXT(), data.getPhone())) {
			return false;
		}
		if (!SeleniumHelper.enterText(we_FAX_TXT(), data.getFax())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_ADD_BTN())) {
			return false;
		}
		return true;
	}
	
}
