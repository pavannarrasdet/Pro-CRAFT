package onboarding.pages;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.Constants;
import onboarding.dataobjects.DashBoardData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class AcknowledgementAndSubmitPage extends BasePage {

	private String currentScreenName;
	private static String crNumber = "";

	public AcknowledgementAndSubmitPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_Text_Message(String text) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "Message_Text");
		properties[1] = properties[1].replace("$value", text);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Provider_Name(String text) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "Provider_Name_Text");
		properties[1] = properties[1].replace("$value", text);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_chk_HereBy() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HereBy_ChkBox")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Txt_AttestorName() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "AttestorName_TxtBox")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Btn_Cancel() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Cancel_Btn")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Btn_Add() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Add_Btn")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CR_Number() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "REF_NUM_TXT")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify controls on acknowledge and
	 *              modal window
	 * @name navigateToAddaLocationScreen
	 */
	public boolean verifyAckSubmitModalControls(RFPData rfpDt) {
		if (!SeleniumHelper.isElementDisplayed(we_Txt_AttestorName())) {
			return false;
		}
		if (we_chk_HereBy() == null) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Text_Message(rfpDt.getInfoAtstMsg()))) {
			return false;
		}

		/*
		 * if (!SeleniumHelper.isElementDisplayed(we_Text_Message(rfpDt.
		 * getUserCnfrmAtstMsg()))) { return false; }
		 */
		if (!SeleniumHelper.isElementDisplayed(we_Provider_Name(rfpDt.getProviderName()))) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_Txt_AttestorName(), "value").equals(DashBoardData.optumUserName)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Btn_Add())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Btn_Cancel())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_chk_HereBy())) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_Btn_Add())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param {RFPData}
	 * @param {RFPPage}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify attestor's name text box and
	 *              cancel button functionality
	 * @name validateAttstrNameAndCancelBtn
	 */
	public boolean validateAttstrNameAndCancelBtn(RFPData data, RFPPage rfpPage) {

		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getAttestorNameCharLen(), "AB");

		if (!SeleniumHelper.enterText(we_Txt_AttestorName(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_Txt_AttestorName());

		if (SeleniumHelper.getAttribute(we_Txt_AttestorName(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry
		value = AutomationBase.generateRandomString(data.getAttestorNameCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_Txt_AttestorName(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_Txt_AttestorName());

		if (SeleniumHelper.getAttribute(we_Txt_AttestorName(), "value").equals(value)) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getAttestorNameCharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_Txt_AttestorName(), Constants.spl_Char + value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_Txt_AttestorName());

		if (SeleniumHelper.getAttribute(we_Txt_AttestorName(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}
		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getAttestorNameCharLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_Txt_AttestorName(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_Txt_AttestorName());

		if (SeleniumHelper.getAttribute(we_Txt_AttestorName(), "value").length() != data.getAttestorNameCharLen()) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_Btn_Cancel())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(rfpPage.we_ContractInfo_TIN())) {
			return false;
		}

		return true;

	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to cancel attest window
	 * @name cancelWindow
	 */
	public boolean cancelWindow() {
		if (!SeleniumHelper.clickElement(we_Btn_Cancel())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to submit attest window
	 * @name submitWindow
	 */
	public boolean submitWindow() {
		if (!SeleniumHelper.clickElement(we_Btn_Add())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @param {RFPData}
	 * @function
	 * @description This function is used to attest RFP
	 * @name attestRFP
	 */
	public boolean attestRFP(RFPData data) {
		if (!SeleniumHelper.clickElement(we_chk_HereBy())) {
			return false;
		}
		if (!data.getAttestorName().equalsIgnoreCase("AUTO")) {
			if (!SeleniumHelper.enterText(we_Txt_AttestorName(), data.getAttestorName())) {
				return false;
			}
		}
		if (!SeleniumHelper.clickElement(we_Btn_Add())) {
			return false;
		}
		return true;
	}

	public boolean validateSuccessMsgAndCaptureCR(RFPData data) {
		if (!SeleniumHelper.isElementDisplayed(we_Text_Message(data.getAttestSucsMsg()))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Provider_Name(data.getProviderName()))) {
			return false;
		}
		captureCRNumber();
		if (getCrNumber().equals("")) {
			return false;
		}

		return true;
	}

	public void captureCRNumber() {
		String text = SeleniumHelper.getText(we_CR_Number());
		if (text.contains("Reference Number: ")) {
			String[] texts = text.split(":");
			crNumber = texts[1];
		} else {
			crNumber = "";
		}
	}

	public static String getCrNumber() {
		return crNumber.trim();
	}

}
