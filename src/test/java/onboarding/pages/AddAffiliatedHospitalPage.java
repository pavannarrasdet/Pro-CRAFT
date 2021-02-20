package onboarding.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import onboarding.dataobjects.AddAffiliatedHospitalData;
import onboarding.dataobjects.Constants;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class AddAffiliatedHospitalPage extends BasePage {

	private String currentScreenName;

	public AddAffiliatedHospitalPage() {
		currentScreenName = getClassName(this.getClass());
	}

	public WebElement we_HSPTL_NAME_TXT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSPTLNAME-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PRVLGS_LST() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRVLG-DDN")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_PRVLGS_LST_SELECTED() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRVLG-DDN-SELECTED")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_PRVLG_List_Items() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRVLG-DDN-LIST-Items")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_Cancel_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CANCEL-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-BTN")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Close_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CLOSE-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Reqrd_Msg(String msg) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "ALL-FLDS-REQ-LBL");
		properties[1] = properties[1].replace("$value", msg);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Admtng_Msg(String hdrMsg, String tailMsg) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "ADMITNG-TXT-LBL");
		properties[1] = properties[1].replace("$HdrVal", " " + hdrMsg);
		properties[1] = properties[1].replace("$tailVal", " " + tailMsg);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_FNAME_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FIRSTNAME-ADMTNG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_LNAME_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LASTNAME-ADMTNG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_MNAME_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "MIDDLENAME-ADMTNG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SPCLTY_DDN_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SPECIALTY-ADMTNG-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_NPI_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "NPI-ADMTNG-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_SPCLTY_ADMTNG_List_Items() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "SPCLTY-DDN-ADMTNG-LIST-Items")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}
	
	public WebElement we_NPI_ErrMsg() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "NPI-ERR-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}
	
	public WebElement we_PRVLG_ADMTNG_Msg() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADMTNG-PRVDR-PRVLG-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	/**
	 * @param {AddAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to verify controls on Add
	 *              Affiliated Hospital modal
	 * @name verifyControls
	 */
	public boolean verifyControls(AddAffiliatedHospitalData data) {
		if (!SeleniumHelper.isElementDisplayed(we_HSPTL_NAME_TXT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PRVLGS_LST())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Cancel_Btn())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Add_Btn())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Close_Icon())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Reqrd_Msg(data.getReqrdMsg()))) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to perform validations on Add
	 *              Affiliated Hospital
	 * @name validations
	 */
	public boolean validations(AddAffiliatedHospitalData data) {
		try {
			String value = AutomationBase.generateRandomString(data.getHospitalNameCharLen(), "AB");
			if (!SeleniumHelper.enterText(we_HSPTL_NAME_TXT(), value)) {
				return false;
			}
			value = AutomationBase.generateRandomString(data.getHospitalNameCharLen() + Constants.two, "AB");
			if (!SeleniumHelper.enterText(we_HSPTL_NAME_TXT(), value)) {
				return false;
			}
			String entrValue = SeleniumHelper.getAttribute(we_HSPTL_NAME_TXT(), "value");
			if (entrValue.length() != data.getHospitalNameCharLen()) {
				return false;
			}
			ArrayList<String> expectedDropDownItems = new ArrayList<String>();
			ArrayList<String> actualDropDownItems = new ArrayList<String>();
			String[] items = data.getPrivilegesValues().split(",");
			for (String item : items) {
				expectedDropDownItems.add(item);
			}
			if (!SeleniumHelper.clickElement(we_PRVLGS_LST())) {
				return false;
			}
			for (WebElement prvlgItem : we_PRVLG_List_Items()) {

				actualDropDownItems.add(SeleniumHelper.getText(prvlgItem));
			}
			if (!actualDropDownItems.equals(expectedDropDownItems)) {
				return false;
			}
			String actDefltVal = SeleniumHelper.getText(we_PRVLGS_LST_SELECTED());
			SeleniumHelper.selectOption(we_PRVLG_List_Items(), actDefltVal);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param {AddAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to perform validations on
	 *              Privileges drop down on 'Add Affiliated Hospital Modal'
	 *              window
	 * @name validatePrvlgsDdn
	 */
	public boolean validatePrvlgsDdn(AddAffiliatedHospitalData data) {

		if(!SeleniumHelper.clickElement(we_PRVLGS_LST()))
		{
			return false;
		}
		if (!SeleniumHelper.selectOption(we_PRVLG_List_Items(), data.getPrivileges())) {
			return false;
		}
		/*if (!SeleniumHelper.isElementDisplayed(we_Admtng_Msg(data.getAdmitngHdrMsg(), data.getAdmitngTailMsg()))) {
			return false;
		}*/
		String actualMsg=SeleniumHelper.getText(we_PRVLG_ADMTNG_Msg());
		if(!actualMsg.equals(data.getAdmitngHdrMsg()+" "+data.getAdmitngTailMsg()))
		{
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_FNAME_ADMTNG())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_LNAME_ADMTNG())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_MNAME_ADMTNG())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_NPI_ADMTNG())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SPCLTY_DDN_ADMTNG())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to enter data on 'Add Affiliated
	 *              Hospital Modal' window
	 * @name enterData
	 */
	public boolean enterData(AddAffiliatedHospitalData data) {
		if (!SeleniumHelper.enterText(we_HSPTL_NAME_TXT(), data.getHospitalName())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_PRVLGS_LST())) {
			return false;
		}
		if (!SeleniumHelper.selectOption(we_PRVLG_List_Items(), data.getPrivileges())) {
			return false;
		}
		if (data.getFirstNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), data.getFirstNameAdmitting())) {
				return false;
			}
		}
		if (data.getMiddleNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), data.getMiddleNameAdmitting())) {
				return false;
			}
		}
		if (data.getLastNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), data.getLastNameAdmitting())) {
				return false;
			}
		}
		if (data.getSpecialityAdmitting() != "") {
			if (!SeleniumHelper.clickElement(we_SPCLTY_DDN_ADMTNG())) {
				return false;
			}
			if (!SeleniumHelper.selectOption(we_SPCLTY_ADMTNG_List_Items(), data.getSpecialityAdmitting())) {
				return false;
			}
		}
		if (data.getNPIAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), data.getNPIAdmitting())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description The below function is used to submit 'Add Affiliated
	 *              Hospital Modal' window
	 * @name submitForm
	 */
	public boolean submitForm() {
		if (!SeleniumHelper.clickElement(we_Add_Btn())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description The below function is used to do not submit 'Add Affiliated
	 *              Hospital Modal' window
	 * @name DonNotsubmitForm
	 */
	public boolean DonNotsubmitForm() {
		if (!SeleniumHelper.clickElement(we_Cancel_Btn())) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param {AddAffiliatedHospitalData
	 *            data} to hold Add
	 *            affiliated hospital page
	 *            data members
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to perform
	 *              admitting provider name fields
	 *              error validations
	 * @name verifyAdmtngProviderNameFieldsErrorPrones
	 */
	public boolean verifyAdmtngProviderNameFieldsErrorPrones(AddAffiliatedHospitalData data) {

		// Entry of numeric characters
		// validation
		String value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen(), "N");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").length() != data.getLnameAdmtngChrLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), Constants.lName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").equals(Constants.lName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").equals(Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG(), data.getLastNameAdmitting())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG(), "value").equals(data.getLastNameAdmitting())) {
			return false;
		}

		// Fname

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen(), "N");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").length() != data.getFnameAdmittingChrLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), Constants.fName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").equals(Constants.fName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").equals(Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG(), data.getFirstNameAdmitting())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG(), "value").equals(data.getFirstNameAdmitting())) {
			return false;
		}

		// Middle Name

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen(), "N");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").length() != data.getMnameAdmitngCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), Constants.mName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").equals(Constants.mName_Spl_Char + value)) {
			return false;
		}
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").equals(Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG(), data.getMiddleNameAdmitting())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG(), "value").equals(data.getMiddleNameAdmitting())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data} to hold Add
	 *            Provider Data page
	 *            data members
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to perform
	 *              provider npi field
	 *              validations
	 * @name validateAdmtngProviderNPIField
	 */
	public boolean validateAdmtngProviderNPIField(AddAffiliatedHospitalData data) {

		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getNPIChrLen(), "AB");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (!SeleniumHelper.getAttribute(we_NPI_ADMTNG(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG(), "value").equals(value)) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), Constants.spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}
		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG(), "value").length() != data.getNPIChrLen()) {
			return false;
		}
		// Validating character limit
		// not exceeding error
		value = AutomationBase.generateRandomString(data.getNPIChrLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg()).equals(data.getNPILenErr())) {
			return false;
		}
		// Validating LUHN error
		value = Constants.inValidNPI;
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg()).equals(data.getNPILUHNErr())) {
			return false;
		}
		// validating normal entry
		value = getLuhnFormatNPI(Long.parseLong(data.getNPIAdmitting()));
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG(), "value").length() != data.getNPIChrLen()) {
			return false;
		}
		if (SeleniumHelper.isElementDisplayed(we_NPI_ErrMsg())) {
			return false;
		}
		return true;
	}
}
