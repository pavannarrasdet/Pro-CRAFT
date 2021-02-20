package onboarding.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.AddAffiliatedHospitalData;
import onboarding.dataobjects.Constants;
import onboarding.dataobjects.EditAffiliatedHospitalData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.automationbase.LoggerHelper;
import procraft.core.utilities.ui.SeleniumHelper;

public class EditAffiliatedHospitalPage extends BasePage {
	private String currentScreenName;

	public EditAffiliatedHospitalPage() {
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
	
	public WebElement we_SPCLTY_LST_SELECTED() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SPECIALTY-ADMTNG-DDN-SELCTD")), mediumSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
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
	
	public WebElement we_HSPNAME_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSPTLNAME-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_PRIVILEGES_ADMTNG() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRVLG-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	/**
	 * @param {EditAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to enter data on 'Edit Affiliated
	 *              Hospital Modal' window
	 * @name enterData
	 */
	public boolean enterData(EditAffiliatedHospitalData data) {
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

	public boolean enterHspAflData(EditAffiliatedHospitalData data) {
		/*if (!SeleniumHelper.enterText(we_HSPTL_NAME_TXT(), data.getHospitalName())) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_PRVLGS_LST())) {
			return false;
		}
		if (!SeleniumHelper.selectOption(we_PRVLG_List_Items(), data.getPrivileges())) {
			return false;
		}*/
	
		if (data.getFirstNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), data.getFirstNameAdmitting())) {
				return false;
			}
		}
		
		if (data.getMiddleNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), data.getMiddleNameAdmitting())) {
				return false;
			}
		}
		
		if (data.getLastNameAdmitting() != "") {
			if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), data.getLastNameAdmitting())) {
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
			if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), data.getNPIAdmitting())) {
				return false;
			}
		}
		return true;
	}
	/**
	 * @return {boolean}
	 * @function
	 * @description The below function is used to submit 'Edit Affiliated
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
	 * @description The below function is used to do not submit 'Edit Affiliated
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
	 * @param {EditAffiliatedHospitalData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description The below function is used to verify previous saved data on 'Edit Affiliated
	 *              Hospital Modal' window
	 * @name validatePreviousSavedInfo
	 */
	public boolean validatePreviousSavedInfo(EditAffiliatedHospitalData data) {
		
		if(!SeleniumHelper.getAttribute(we_HSPTL_NAME_TXT(), "value").equals(data.getHospitalName()))
		{
			return false;
		}
		if(!SeleniumHelper.getText(we_PRVLGS_LST_SELECTED()).equals(data.getPrivileges()))
		{
			return false;
		}
		if (data.getFirstNameAdmitting() != "") {
			if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG(),"value").equals(data.getFirstNameAdmitting())) {
				return false;
			}
		}
		if (data.getMiddleNameAdmitting() != "") {
			if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG(),"value").equals(data.getMiddleNameAdmitting())) {
				return false;
			}
		}
		if (data.getLastNameAdmitting() != "") {
			if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG(),"value").equals(data.getLastNameAdmitting())) {
				return false;
			}
		}
		if(!SeleniumHelper.getText(we_SPCLTY_LST_SELECTED()).equals(data.getSpecialityAdmitting()))
		{
			return false;
		}
		if (data.getNPIAdmitting() != "") {
			if (!SeleniumHelper.getAttribute(we_NPI_ADMTNG(),"value").equals(data.getNPIAdmitting())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyEditAffiliatedHospitalModalControls(EditAffiliatedHospitalData data) {
//		if (!SeleniumHelper.isElementDisplayed(we_HSPNAME_ADMTNG())) {
//			return false;
//		}
//		if (!SeleniumHelper.isElementDisplayed(we_PRIVILEGES_ADMTNG())) {
//			return false;
//		}
		if (!SeleniumHelper.isElementDisplayed(we_LNAME_ADMTNG_EDT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_FNAME_ADMTNG_EDT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_MNAME_ADMTNG_EDT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SPCLTY_DDN_ADMTNG_EDT())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_NPI_ADMTNG_EDT())) {
			return false;
		}
		return true;
	}

	public WebElement we_FNAME_ADMTNG_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FIRSTNAME-ADMTNG-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_LNAME_ADMTNG_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LASTNAME-ADMTNG-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_MNAME_ADMTNG_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "MIDDLENAME-ADMTNG-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SPCLTY_DDN_ADMTNG_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SPECIALTY-ADMTNG-DDN-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_NPI_ADMTNG_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "NPI-ADMTNG-TXT-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_NPI_ErrMsg_EDT() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "NPI-ERR-MSG-EDT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	/**
	 * @param {EditAffiliatedHospitalData
	 *            data} to hold edit
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
	public boolean verifyEditAdmtngProviderNameFieldsErrorPrones(EditAffiliatedHospitalData data) {

		// Entry of numeric characters
		// validation
		String value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen(), "N");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").length() != data.getLnameAdmtngChrLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), Constants.lName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		/*if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").equals(Constants.lName_Spl_Char + value)) {
			return false;
		}*/
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getLnameAdmtngChrLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").equals(Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_LNAME_ADMTNG_EDT(), data.getLastNameAdmitting())) {
			return false;
		}
		/*SeleniumHelper.tabOutElement(we_LNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_LNAME_ADMTNG_EDT(), "value").equals(data.getLastNameAdmitting())) {
			return false;
		}*/
		
		// Fname

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen(), "N");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").length() != data.getFnameAdmittingChrLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), Constants.fName_Spl_Char + value)) {
			return false;
		}
		/*SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").equals(Constants.fName_Spl_Char + value)) {
			return false;
		}*/
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getFnameAdmittingChrLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").equals(Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_FNAME_ADMTNG_EDT(), data.getFirstNameAdmitting())) {
			return false;
		}
		/*SeleniumHelper.tabOutElement(we_FNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_FNAME_ADMTNG_EDT(), "value").equals(data.getFirstNameAdmitting())) {
			return false;
		}*/

		// Middle Name

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen(), "N");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").length() != data.getMnameAdmitngCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), Constants.mName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		/*if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").equals(Constants.mName_Spl_Char + value)) {
			return false;
		}*/
		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getMnameAdmitngCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").equals(Constants.mName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_MNAME_ADMTNG_EDT(), data.getMiddleNameAdmitting())) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_MNAME_ADMTNG_EDT());
		/*if (!SeleniumHelper.getAttribute(we_MNAME_ADMTNG_EDT(), "value").equals(data.getMiddleNameAdmitting())) {
			return false;
		}*/
		return true;
	}
	
	/**
	 * @param {EditAffiliatedHospitalData
	 *            data} to hold Edit
	 *            Affiliated Hospital Data page
	 *            data members
	 * @return {boolean} returns True to
	 *         false
	 * @function
	 * @description The below function
	 *              is used to perform
	 *              provider npi field
	 *              validations
	 * @name validateEditAdmtngProviderNPIField
	 */
	public boolean validateEditAdmtngProviderNPIField(EditAffiliatedHospitalData data) {

		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getNPIChrLen(), "AB");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (!SeleniumHelper.getAttribute(we_NPI_ADMTNG_EDT(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen(), "AN");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG_EDT(), "value").equals(value)) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), Constants.spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG_EDT(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}
		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getNPIChrLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG_EDT(), "value").length() != data.getNPIChrLen()) {
			return false;
		}
		// Validating character limit
		// not exceeding error
		value = AutomationBase.generateRandomString(data.getNPIChrLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg_EDT()).equals(data.getNPILUHNErr())) {
			return false;
		}
		// Validating LUHN error
		value = Constants.inValidNPI;
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg_EDT()).equals(data.getNPILUHNErr())) {
			return false;
		}
		// validating normal entry
		value = getLuhnFormatNPI(Long.parseLong(data.getNPIAdmitting()));
		if (!SeleniumHelper.enterText(we_NPI_ADMTNG_EDT(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (SeleniumHelper.getAttribute(we_NPI_ADMTNG_EDT(), "value").length() != data.getNPIChrLen()) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_NPI_ADMTNG_EDT());
		if (!SeleniumHelper.isElementDisplayed(we_NPI_ErrMsg_EDT())) {
			return false;
		}
		return true;
	}
}
