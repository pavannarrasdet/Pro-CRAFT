package onboarding.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import onboarding.dataobjects.AddProviderData;
import onboarding.dataobjects.Constants;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class AddProviderPage extends BasePage {

	private String currentScreenName;
	private String currentValueToSet = "";

	public AddProviderPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_LNAME_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-LNAME-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_FNAME_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-FNAME-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_MNAME_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-MNAME-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQHID_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQHID-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_NPI_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-NPI-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SPECIALTY_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SPECIALTY-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SPECIALTY_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SPECIALTY-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACTICE_SETTING_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRACTICE-SETTING-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACTICE_SETTING_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRACTICE-SETTING-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DEGREE_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-DEGREE-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACTICE_ZIP_CODE_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName,
						"ADD-PROVIDER-PRIMARY-PRACTICE-ZIP-CODE-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACTICE_STATE_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRIMARY-PRACTICE-STATE-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRE_CRED_CHK_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRE-CRED-CHK-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_IMPORTED_CAQH_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-IMPORTED_CAQH-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_NEEDS_ATTN_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-NEEDS-ATTN-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_CHK_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQH-CHK-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_TOOL_TIP_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-TOOL-TIP-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CHK_MARK_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CHK_MARK-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_WARNING_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-WARNING-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CANCEL_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CANCEL-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CONTINUE_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CONTINUE-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CHK_PROVIDER_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CHK_PROVIDER-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CLOSE_ICON_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CLOSE-ICON-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_TOOL_TIP_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQH-TOOL-TIP-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACT_SETNG_TOOL_TIP_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRAC-SETNG-TOOL-TIP-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_getSpecialty_DefaultValue() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SPECIALTY-DEFAULT-VALUE")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public List<WebElement> we_select_Specialty_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SPECIALTY-DDN-LIST")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public List<WebElement> we_select_Practice_Setting_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRAC-SETNG-DDN-LIST")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_getPS_DefaultValue() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-PRAC-SETNG-DEFAULT-VALUE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_CAQH_ID_ErrMsg() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQHID-ERR-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_NPI_ErrMsg() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-NPI-ERR-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_Continue_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CONTINUE-BTN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);

	}

	public WebElement we_CRED_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CRED-MESSAGE-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQH-MESSAGE-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CRED_Decision_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CRED-DECISION-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_Green_Tick_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-GREEN-TICK")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_Image() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQH-LOGO")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Display_Name() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-NAME-DISPLAY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRACTICE_ZIP_CODE_ERR_MSG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName,
						"ADD-PROVIDER-PRIMARY-PRACTICE-ZIP-CODE-ERR-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_CAQH_INPUT_ERR_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CAQH-Err-Icon")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_Err_Box() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "Add-PROVIDER-CAQH-API-Err-MsgBox")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_CAQH_ERR_MSG(String errMsg) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "Add-PROVIDER-CAQH-API-Err-Msg");
		properties[1] = properties[1].replace("$value", errMsg);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);

	}
	
	public WebElement we_CAQH_ERR_MSG_BODY() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "Add-PROVIDER-CAQH-API-Err-Msg-Body")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_CAQH_GOTO_LNK() {

		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-GOTO-CAQH-LNK")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_Chk_Prv_Btn() {

		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-CHK-PRV-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	/**
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to verify add provider modal
	 *              window fields
	 * @name verifyAddProviderModalControls
	 */

	public boolean verifyAddProviderModalControls() {
		if (!SeleniumHelper.isElementDisplayed(we_FNAME_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_LNAME_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_MNAME_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CAQHID_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_NPI_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SPECIALTY_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PRACTICE_SETTING_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PRACTICE_STATE_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_DEGREE_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CANCEL_BTN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CONTINUE_BTN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PRE_CRED_CHK_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CAQH_CHK_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_TOOL_TIP_ICON())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CHK_MARK_ICON())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_WARNING_ICON())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_CHK_PROVIDER_BTN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_IMPORTED_CAQH_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_NEEDS_ATTN_TXT())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to verify if only CAQH ID field
	 *              is active
	 * @name verifyOnlyCAQHIDActive
	 */

	public boolean verifyOnlyCAQHIDActive() {
		if (SeleniumHelper.isElementEnabled(we_FNAME_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_LNAME_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_MNAME_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_CAQHID_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_NPI_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_SPECIALTY_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_PRACTICE_SETTING_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_PRACTICE_STATE_TXT())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_DEGREE_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_CANCEL_BTN())) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_CONTINUE_BTN())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            text parameter takes the default specialty value as per the
	 *            AC}
	 * @return {Boolean}
	 * @function
	 * @description The below function is to verify the default value of
	 *              specialties
	 * @name verifyDefaultSpecialtyValue
	 */
	public Boolean verifyDefaultSpecialtyValue(String text) {

		if (!SeleniumHelper.getText(we_getSpecialty_DefaultValue()).equals(text)) {
			return false;
		}

		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} Takes AddProvider data object containing the datatable
	 *            with the values passed from the feature file
	 * @return {Boolean}
	 * @function
	 * @description The below function is to select the specialty from the drop
	 *              down
	 * @name selectSpecialty
	 */
	public Boolean selectSpecialty(AddProviderData data) {
		String text = "";
		if (data.getSpecialty().trim().toLowerCase().contains("random")) {
			text = SeleniumHelper.selectOption(we_select_Specialty_List(), data.getSpecialtyInd());
			data.setSpecialty(text);
			if (!text.equals(data.getSpecialty())) {
				return false;
			}
		} else {
			if (!SeleniumHelper.selectOption(we_select_Specialty_List(), data.getSpecialty())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} Takes AddProvider data object containing the datatable
	 *            with the values passed from the feature file
	 * @return {Boolean}
	 * @function
	 * @description The below function is to verify the count of specialties
	 *              drop down
	 * @name verifyCount
	 */
	public Boolean verifyCount(AddProviderData data) {
		if (!SeleniumHelper.clickElement(we_SPECIALTY_DDN())) {
			return false;
		}
		if (!(SeleniumHelper.getElementsCount(we_select_Specialty_List()) == data.getSpecialtyCount())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} Takes AddProvider data object
	 * @return {Boolean}
	 * @function
	 * @description The below function is to verify if the Practice setting drop
	 *              down order is as provided in the data object in the feature
	 *              file
	 * @name verifyPSDropDown
	 */
	public boolean verifyPSDropDown(AddProviderData data) {
		Boolean getOrder = true;
		ArrayList<String> expectedDropDownItems = new ArrayList<String>();
		ArrayList<String> actualDropDownItems = new ArrayList<String>();
		// split code that splits items
		// into dynamically
		// for
		String[] getValues = data.getpracticeSettingValues().split(",");
		for (String val : getValues) {
			expectedDropDownItems.add(val);
		}

		if (!SeleniumHelper.clickElement(we_PRACTICE_SETTING_DDN())) {
			return false;
		}
		for (int i = 1; i < we_select_Practice_Setting_List().size(); i++) {
			WebElement value = we_select_Practice_Setting_List().get(i);
			actualDropDownItems.add(value.getText());
		}
		for (int i = 1; i < actualDropDownItems.size(); i++) {
			if (!expectedDropDownItems.get(i).equals(actualDropDownItems.get(i))) {
				getOrder = false;
			}

		}
		if (getOrder == true) {
			return true;
		} else
			return false;

	}

	/**
	 * @param {AddProviderData
	 *            data} Takes the AddProviderData object which takes values from
	 *            feature file
	 * @return {Boolean}
	 * @function
	 * @description The below function is to select a practice setting value
	 *              from the drop down and verify that the placeholder text
	 *              matches to the selected value.
	 * @name {selectPSValue}
	 */
	public Boolean selectPSValue(AddProviderData data) {

		String text = "";
		if (data.getPracticeSetting().trim().toLowerCase().equals("random")) {
			text = SeleniumHelper.selectOption(we_select_Practice_Setting_List(), data.getPracticeSettingInd());
			data.setPracticeSetting(text);
			if (!text.equals(data.getPracticeSetting())) {
				return false;
			}
		} else {

			if (!SeleniumHelper.selectOption(we_select_Specialty_List(), data.getPracticeSetting())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param {String
	 *            text} Takes default Practice setting value
	 * @return {Boolean}
	 * @function
	 * @description The below function is to verify the Practice setting default
	 *              value
	 * @name verifyDefaultPSValue
	 */
	public Boolean verifyDefaultPSValue(String text) {

		if (!SeleniumHelper.getText(we_getPS_DefaultValue()).equals(text)) {
			return false;
		}

		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to perform CAQH ID text filed
	 *              error validations
	 * @name verifyCAQHFieldErrorPrones
	 */
	public boolean verifyCAQHFieldErrorPrones(AddProviderData data) {
		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getcaqhIdCharLen(), "AB");
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (!SeleniumHelper.getAttribute(we_CAQHID_TXT(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry
		value = AutomationBase.generateRandomString(data.getcaqhIdCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (SeleniumHelper.getAttribute(we_CAQHID_TXT(), "value").equals(value)) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getcaqhIdCharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), Constants.spl_Char + value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (SeleniumHelper.getAttribute(we_CAQHID_TXT(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}
		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getcaqhIdCharLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (SeleniumHelper.getAttribute(we_CAQHID_TXT(), "value").length() != data.getcaqhIdCharLen()) {
			return false;
		}
		// Validating character limit
		// not exceeding error
		value = AutomationBase.generateRandomString(data.getcaqhIdCharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (!SeleniumHelper.getText(we_CAQH_ID_ErrMsg()).equals(data.getCAQHLimitErrMsg())) {
			return false;
		}
		// validating normal entry
		if (!SeleniumHelper.enterText(we_CAQHID_TXT(), data.getCAQHID())) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_CAQHID_TXT());

		if (SeleniumHelper.getAttribute(we_CAQHID_TXT(), "value").length() != data.getcaqhIdCharLen()) {
			return false;
		}
		if (SeleniumHelper.isElementDisplayed(we_CAQH_ID_ErrMsg())) {
			return false;
		}

		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to perform provider name fields
	 *              error validations
	 * @name verifyProviderNameFieldsErrorPrones
	 */
	public boolean verifyProviderNameFieldsErrorPrones(AddProviderData data) {

		// Entry of numeric characters
		// validation
		String value = AutomationBase.generateRandomString(data.getLastNameCharLen(), "N");
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getLastNameCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_TXT());
		if (SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getLastNameCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_TXT());
		if (SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").length() != data.getLastNameCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getLastNameCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), Constants.lName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").equals(Constants.lName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getLastNameCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_TXT());
		if (SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").equals(Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_LNAME_TXT(), data.getLastName())) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_LNAME_TXT());

		if (!SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").equals(data.getLastName())) {
			return false;
		}

		// Fname

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getFirstNameCharLen(), "N");
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getFirstNameCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getFirstNameCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").length() != data.getFirstNameCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getFirstNameCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), Constants.fName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").equals(Constants.fName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getFirstNameCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").equals(Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_FNAME_TXT(), data.getFirstName())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").equals(data.getFirstName())) {
			return false;
		}

		// Middle Name

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getMiddleNameLen(), "N");
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getMiddleNameLen(), "AN");
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getMiddleNameLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").length() != data.getMiddleNameLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getMiddleNameLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), Constants.mName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").equals(Constants.mName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getMiddleNameLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").equals(Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_MNAME_TXT(), data.getMiddleName())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_TXT());
		if (!SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").equals(data.getMiddleName())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to perform provider npi field
	 *              validations
	 * @name validateProviderNPIField
	 */
	public boolean validateProviderNPIField(AddProviderData data) {

		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getNPICharLen(), "AB");
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (!SeleniumHelper.getAttribute(we_NPI_TXT(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry
		value = AutomationBase.generateRandomString(data.getNPICharLen(), "AN");
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (SeleniumHelper.getAttribute(we_NPI_TXT(), "value").equals(value)) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getNPICharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_TXT(), Constants.spl_Char + value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (SeleniumHelper.getAttribute(we_NPI_TXT(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}
		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getNPICharLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (SeleniumHelper.getAttribute(we_NPI_TXT(), "value").length() != data.getNPICharLen()) {
			return false;
		}
		// Validating character limit
		// not exceeding error
		value = AutomationBase.generateRandomString(data.getNPICharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (!SeleniumHelper.getText(we_NPI_ErrMsg()).equals(data.getNpiLenErr())) {
			return false;
		}
		// Validating LUHN error
		value = Constants.inValidNPI;
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (!SeleniumHelper.getText(we_NPI_ErrMsg()).equals(data.getNpiLuhnErr())) {
			return false;
		}
		// validating normal entry
		value = getLuhnFormatNPI(Long.parseLong(data.getNPI()));
		if (!SeleniumHelper.enterText(we_NPI_TXT(), value)) {
			return false;
		}

		SeleniumHelper.tabOutElement(we_NPI_TXT());

		if (SeleniumHelper.getAttribute(we_NPI_TXT(), "value").length() != data.getNPICharLen()) {
			return false;
		}
		if (SeleniumHelper.isElementDisplayed(we_NPI_ErrMsg())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to add provider information data
	 * @name enterProviderInfo
	 */
	public boolean enterProviderInfo(AddProviderData data) {
		if (data.getLastName() != "") {
			if (!SeleniumHelper.enterText(we_LNAME_TXT(), data.getLastName())) {
				return false;
			}
		}
		if (data.getFirstName() != "") {
			if (!SeleniumHelper.enterText(we_FNAME_TXT(), data.getFirstName())) {
				return false;
			}
		}
		if (data.getMiddleName() != "") {
			if (!SeleniumHelper.enterText(we_MNAME_TXT(), data.getMiddleName())) {
				return false;
			}
		}
		if (data.getCAQHID() != "") {
			if (!SeleniumHelper.enterText(we_CAQHID_TXT(), data.getCAQHID())) {
				return false;
			}
		}
		if (data.getNPI() != "") {
			// String value =
			// getLuhnFormatNPI(Long.parseLong(data.getNPI()));
			if (!SeleniumHelper.enterText(we_NPI_TXT(), data.getNPI())) {
				return false;
			}
			SeleniumHelper.tabOutElement(we_NPI_TXT());
		}

		if (data.getSpecialty() != "") {
			if (!SeleniumHelper.clickElement(we_SPECIALTY_DDN())) {
				return false;
			}

			// if
			// (AutomationBase.getOSName().toLowerCase().contains("mac"))
			// {
			// int getIndex =
			// SeleniumHelper.getIndex(we_select_Specialty_List(),
			// data.getSpecialty());
			// SeleniumHelper.scrollToViewElement(we_select_Specialty_List().get(getIndex));
			// }

			selectSpecialty(data);
			SeleniumHelper.tabOutElement(we_SPECIALTY_DDN());
		}

		if (data.getPracticeSetting() != "") {

			if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
				SeleniumHelper.sleep(1000);
			}
			if (!SeleniumHelper.clickElement(we_PRACTICE_SETTING_DDN())) {
				return false;
			}
			selectPSValue(data);
		}

		if (data.getZipCode() != "") {
			if (!SeleniumHelper.enterText(we_PRACTICE_ZIP_CODE_TXT(), data.getZipCode())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to click continue button on the
	 *              add provider modal
	 * @name clickContinue
	 */

	public boolean clickContinue() {
		if (!SeleniumHelper.clickElement(we_Continue_BTN())) {
			return false;
		}
		
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to enter zipcode
	 * @name enterZipCode
	 */
	public boolean enterZipCode(AddProviderData data) {
		currentValueToSet = data.getZipCode();
		if (!SeleniumHelper.enterText(we_PRACTICE_ZIP_CODE_TXT(), data.getZipCode())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_PRACTICE_ZIP_CODE_TXT());
		return true;
	}

	/**
	 * @param {String
	 *            type} which tells which scenario's execute
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to perform zipcode field
	 *              validations
	 * @name validateZipcode
	 */
	public boolean validateZipCode(String type) {

		boolean isValid = true;
		try {
			switch (type) {
			case "alphabets_special_chars":
				String validation1 = SeleniumHelper.getAttribute(we_PRACTICE_ZIP_CODE_TXT(), "value");
				isValid = (validation1.equals(""));
				break;
			case "five_numeric_value":
				String validation2 = SeleniumHelper.getAttribute(we_PRACTICE_ZIP_CODE_TXT(), "value");
				isValid = (validation2.equals(currentValueToSet));
				break;
			}
		} catch (Exception e) {
			System.out.println("validateZipCode ||" + e);
		}

		return isValid;

	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @param {String
	 *            type} which tells which scenario's execute
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to perform zipcode field
	 *              validations
	 * @name validateZipcodeErrorMessages
	 */
	public boolean validateZipcodeErrorMessages(AddProviderData data) {

		if (!SeleniumHelper.getText(we_PRACTICE_ZIP_CODE_ERR_MSG()).equals(data.getZipcodeErrMsg())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to validate CAQH field error
	 *              messages for provider not found
	 * @name validateCAQHPrvNotFoundErrMsg
	 */
	public boolean validateCAQHPrvNotFoundErrMsg(AddProviderData data) {

		if (we_CAQH_INPUT_ERR_ICON() == null) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_CAQH_Err_Box());
		if (we_CAQH_ERR_MSG(data.getCAQHPrvNtFndErr()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(data.getCAQHPrvNtFndErrHdrMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(Constants.errPrefix) == null) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_Continue_BTN())) {
			return false;
		}
		if (we_CAQH_GOTO_LNK() != null) {
			return false;
		}

		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to validate CAQH field error
	 *              messages for attestation expire
	 * @name validateCAQHAttestationReqErrMsg
	 */
	public boolean validateCAQHAttestationReqErrMsg(AddProviderData data) {

		if (we_CAQH_INPUT_ERR_ICON() == null) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_CAQH_Err_Box());
		if (we_CAQH_ERR_MSG(data.getCAQHAttestationExprHdrMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(data.getCAQHAttestationExprMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(Constants.errPrefix) == null) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_Continue_BTN())) {
			return false;
		}
		if (we_CAQH_GOTO_LNK() == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to validate CAQH field error
	 *              messages for Authorization Required message
	 * @name validateCAQHAuthReqErrMsg
	 */
	public boolean validateCAQHAuthReqErrMsg(AddProviderData data) {

		if (we_CAQH_INPUT_ERR_ICON() == null) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_CAQH_Err_Box());
		if (we_CAQH_ERR_MSG(data.getCAQHAuthReqMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(data.getCAQHAuthReqHdrMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(Constants.errPrefix) == null) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_Continue_BTN())) {
			return false;
		}
		if (we_CAQH_GOTO_LNK() == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to validate CAQH field error
	 *              messages for attestation expire and auth required
	 * @name validateCAQHAttestationReqAndAuthReqErrMsg
	 */
	public boolean validateCAQHAttestationReqAndAuthReqErrMsg(AddProviderData data) {

		if (we_CAQH_INPUT_ERR_ICON() == null) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_CAQH_Err_Box());
		if (we_CAQH_ERR_MSG(data.getAttestAndAuthReqErrMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(data.getAttestAndAuthReqErrHdrMsg()) == null) {
			return false;
		}
		if (we_CAQH_ERR_MSG(Constants.errPrefix) == null) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_Continue_BTN())) {
			return false;
		}
		if (we_CAQH_GOTO_LNK() == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to validate CAQH Application is 
	 *              not complete message
	 * @name validateCAQHApplicationIncompleteErrMsg
	 */
	public boolean validateCAQHApplicationIncompleteErrMsg(AddProviderData data) {

		if (we_CAQH_INPUT_ERR_ICON() == null) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_CAQH_Err_Box());
		if (we_CAQH_ERR_MSG(data.getCAQHAppIncompleteErrHdrMsg()) == null) {
			return false;
		}
		if (!SeleniumHelper.getText(we_CAQH_ERR_MSG_BODY()).contains(data.getCAQHAppIncompleteErr())) {
			return false;
		}
		if (we_CAQH_ERR_MSG(Constants.errPrefix) == null) {
			return false;
		}
		if (we_CAQH_GOTO_LNK() == null) {
			return false;
		}

		return true;
	}
	
	/**
	 * @param {AddProviderData
	 *            data} to hold Add Provider Data page data members
	 * @return {boolean} returns True or false
	 * @function
	 *@description The below function is used to validate pre-populated data from CAQH on Add provider screen 
	 * @name validatePrepopulatedData
	 */
	public boolean validatePrepopulatedData(AddProviderData data)
	{
		SeleniumHelper.sleep(3000);
		if(!SeleniumHelper.getAttribute(we_LNAME_TXT(), "value").trim().equals(data.getLastName().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_FNAME_TXT(), "value").trim().equals(data.getFirstName().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_MNAME_TXT(), "value").trim().equals(data.getMiddleName().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_NPI_TXT(), "value").trim().equals(data.getNPI().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_SPECIALTY_TXT(), "value").trim().equals(data.getSpecialty().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_DEGREE_TXT(), "value").trim().equals(data.getDegree().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_PRACTICE_SETTING_TXT(), "value").trim().equals(data.getPracticeSetting().trim()))
		{
			return false;
		}
		if(!SeleniumHelper.getAttribute(we_PRACTICE_STATE_TXT(), "value").trim().equals(data.getPracticeSettingState().trim()))
		{
			return false;
		}
		return true;
	}
	/**
	 * @return {boolean} returns True or false
	 * @function
	 *@description The below function is used to validate pre-populated degree field from CAQH on Add provider screen 
	 * @name validatePrepopulatedDegreeData
	 */
	public boolean validatePrepopulatedDegreeField(AddProviderData data)
	{
		int count=1;
		while(!SeleniumHelper.isElementEnabled(we_Continue_BTN())&&count<=3)
		{
			SeleniumHelper.sleep(500);
			count++;
		}
		if(!SeleniumHelper.getAttribute(we_DEGREE_TXT(), "value").trim().equals(data.getDegree().trim()))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * @return {boolean} returns True or false
	 * @function
	 * @description The below function is used to perform click action on Check provider button
	 * @name clickCheckProvider
	 */
	public boolean clickCheckProvider()
	{
		if(!SeleniumHelper.clickElement(we_CHK_PROVIDER_BTN()))
		{
			return false;
		}
		return true;
	}
	
	/**
	 * This method will close the add provider popup
	 */
	public void closeAddProvider() {
		SeleniumHelper.clickElement(we_CLOSE_ICON_BTN());
	}

}
