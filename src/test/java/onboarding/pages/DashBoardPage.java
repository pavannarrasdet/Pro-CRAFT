package onboarding.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import onboarding.dataobjects.Constants;
import onboarding.dataobjects.DashBoardData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class DashBoardPage extends BasePage {
	private String currentScreenName;

	public DashBoardPage() {
		currentScreenName = getClassName(this.getClass());
	}

	// controls

	public List<WebElement> we_selectList() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "UL-LIST")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_HeaderInfo_Welcome_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "HEADERINFO-WELCOME-SECTION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBrd_Content_Section() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-SECTION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HeaderInfo_Welcome_LogOut_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-LOGOUT-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_HeaderInfo_Logo_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HEADERINFO-LOGO-SECTION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HeaderInfo_LogOut_Link() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "HEADERINFO-LOGOUT-SECTION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_NetWork_Participation_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "NETWORK-PARTICIPATION")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Ribbon_Section_Group_Dropdown() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-GROUP-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Ribbon_Selected_Group() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-SELECTED-GROUP")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Ribbon_Section_Tin_Dropdown() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-TIN-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Ribbon_Selected_TIN() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-SELECTED-TIN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Ribbon_Section_Group_Dropdown_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-GROUP-DDN-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Ribbon_Section_Tin_Dropdown_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "RIBBON-SECTION-TIN-DDN-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Group_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-GROUP-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Tin_Label() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-TIN-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Selected_Group_Label(String grpName) {
		SeleniumHelper.sleep(4000);
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-SECTION-SELECTED-GROUP-LBL");
		properties[1] = properties[1].replace("$value", grpName);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Selected_Tin_Label(String tin) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-SELECTED-TIN-LBL");
		properties[1] = properties[1].replace("$value", tin);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Search_Providers_Txt() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-SEARCH-PROVIDERS-TXT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_Section_Search_Providers_Img() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-SEARCH-PROVIDERS-IMG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Provider_Section_Message() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SECTION-MSG")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Provider_Button() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-SECTION-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}

	public WebElement we_Add_Provider_Button_Info_Content() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-AddPrvInfo_CONTENT")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Provider_Dlg() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-PROVIDER-DLG")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Provider_Name() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-PROVIDER-NAME-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Primary_Practice_Location() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName,
						"DASHBOARD-SECTION-PRIMARY-PRACTICE-LOCATION")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Request_Created() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-REQUEST-CREATED")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Credentials_Verified() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-CREDENTIALS-VERIFIED")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Contract_Initiated() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-CONTRACT-INITIATED")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Contract_Finalized() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-CONTRACT-FINALIZED")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Header_Take_Action() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-TAKE-ACTION")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Provider_Name_Data() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-PROVIDER-NAME-DATA")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Specialty_Data() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-SPECIALTY-DATA")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_NPI_Data() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-NPI-DATA")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Request_Created_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-REQUEST-CREATED-ICON")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Take_Action_Btn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-SECTION-TAKE-ACTION-BTN")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_rfp_Records() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORDS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_practitionerRecord_Divcontent(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD-DIV");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Btn(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD-BTN");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Pcontent(int recordIndx, String divVal, String pVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		properties[1] = properties[1].replace("$pValue", pVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Strong(int recordIndx, String divVal, String pVal, String strngVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD-LBL");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		properties[1] = properties[1].replace("$pValue", pVal);
		properties[1] = properties[1].replace("$strngVal", strngVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Green_StatusIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-GREEN-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Gray_StatusIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-GRAY-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_InProgress_StatusIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-IN-PROGRESS-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_InComplete_StatusIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-IN-COMPLETE-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_H6Content(String value) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-H6CONTENT");
		properties[1] = properties[1].replace("$value", value);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Not_Required_StatusIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-Not-Rqrd-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	// --
	public List<WebElement> we_rfp_provider_name_Records() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT_RECORD-PROVIDER-NAME")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_practitionerRecord_Progress_ClosedIcon(int recordIndx, String divVal) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-PROGRESS-CLOSE-STATUS");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$divValue", divVal);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Provider_ContactUs_Link(int recordIndx) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-PROVIDER-CONTACT-US-LINK");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_practitionerRecord_Provider_ContactUs_Number(int recordIndx, String number) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-PROVIDER-CONTACT-US-NUMBER");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$spanValue", number);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord(int recordIndx) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_practitionerRecord_Provider_Action_Button(int recordIndx) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-PROVIDER-ACTION-BUTTON");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_rfp_provider_RecordData(int recordIndex) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBOARD-CONTENT-RECORD-DATA");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndex));
		return SeleniumHelper.findElements(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_practitionerRecord_Provider_InEligible_Date(int recordIndx, String number) {
		String[] properties = AutomationBase.readORProperties(currentScreenName,
				"DASHBOARD-CONTENT-RECORD-PROVIDER-INELIGIBLE-DATE");
		properties[1] = properties[1].replace("$rIndex", String.valueOf(recordIndx));
		properties[1] = properties[1].replace("$spanValue", number);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	// methods

	/**
	 * @param {String             expTitle} holds expected page title
	 * @param {UnrecognizedDevice myUnrecognizedDevice} holds Unrecognized page
	 * @param {WelcomePage        myWelcomePage} holds WelcomePage
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to validate Dashboard page existence
	 * @name validateDashboard
	 */
	public boolean validateDashboard(String expTitle) {

		if (!SeleniumHelper.isTitlePresent(expTitle, mediumSync())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to validate the TIN drop down
	 *              functionality
	 * @name validateOrgTin
	 */
	public boolean validateOrgTin() {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(1000);
		}

		if (!SeleniumHelper.clickElement(we_Ribbon_Section_Group_Dropdown())) {
			return false;
		}
		if (!(SeleniumHelper.getElementsCount(we_selectList()) > 0)
				&& SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Group_Dropdown())
				&& SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Tin_Dropdown())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String defaultValue} holds the value to be validated in drop down
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to validate the group drop down
	 *              functionality
	 * @name validateGroupDropDown
	 */
	public boolean validateGroupDropDown(String defaultValue) {

		if (!SeleniumHelper.getText(we_Ribbon_Selected_Group()).equals(defaultValue)) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_Ribbon_Section_Group_Dropdown())) {
			return false;
		}
		if (SeleniumHelper.getElementsCount(we_selectList()) <= 0) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_Ribbon_Section_Tin_Dropdown());
		return true;
	}

	/**
	 * @param {DashBoardData data} that holds data members of DasBoard page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify the selection of group and tin
	 *              drop down functionality
	 * @name verifySelectionOfGroupAndTin
	 */
	public boolean verifySelectionOfGroupAndTin(DashBoardData data) {
		if (!selectItemFromGroupDdn(data)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_Section_Selected_Group_Label(data.getGroup()))) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Ribbon_Selected_TIN()).equals((data.getTIN()))) {
			if (!selectItemFromTINdDn(data)) {
				return false;
			}
		}
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_Section_Selected_Tin_Label(data.getTIN()))) {
			return false;
		}
		return true;
	}

	/**
	 * @param {DashBoardData data} that holds data members of DasBoard page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify Dashboard page controls
	 * @name verifyControls
	 */
	public boolean verifyControls(DashBoardData data) {
		if (!SeleniumHelper.isElementDisplayed(we_HeaderInfo_Welcome_Label())) {
			return false;
		} else {
			String actualText = SeleniumHelper.getText(we_HeaderInfo_Welcome_Label());
			if (!actualText.equals(data.getWelcomeText())) {
				return false;
			}

		}
		if (!SeleniumHelper.isElementDisplayed(we_HeaderInfo_Logo_Icon())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_HeaderInfo_LogOut_Link())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Group_Dropdown())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Group_Dropdown_Label())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Tin_Dropdown())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Ribbon_Section_Tin_Dropdown_Label())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_NetWork_Participation_Label())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_Section_Group_Label())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_Section_Tin_Label())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_Section_Search_Providers_Txt())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Add_Provider_Button())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String title} that holds expected title of Add provider modal window
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to select the value from drop down
	 * @name selectItemFromGroupDdn
	 */
	public boolean nvigateToAddProvider(String title) {
		if (!SeleniumHelper.clickElement(we_Add_Provider_Button())) {
			return false;
		}

		String actTitle = SeleniumHelper.getText(we_Add_Provider_Dlg());

		if (!actTitle.contains(title)) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify the add button active state
	 * @name isAddProviderBtnActive
	 */
	public boolean isAddProviderBtnActive() {

		return SeleniumHelper.isElementEnabled(we_Add_Provider_Button());
	}

	/**
	 * @param {DashBoardData data} that holds data members of DashBoard page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to select the value from drop down
	 * @name selectItemFromGroupDdn
	 */
	public boolean selectItemFromGroupDdn(DashBoardData data) {
		if (!SeleniumHelper.clickElement(we_Ribbon_Section_Group_Dropdown())) {
			return false;
		}
		if (data.getGroup().equalsIgnoreCase("random")) {
			String selectedItem = SeleniumHelper.selectOption(we_selectList(), data.getGroupInd());
			if (selectedItem == null) {
				return false;
			}
			data.setGroup(selectedItem);
		} else {

			SeleniumHelper.selectOption(we_selectList(), data.getGroup());
		}

		if (!SeleniumHelper.getText(we_Ribbon_Selected_Group()).equals(data.getGroup())) {
			return false;
		}

		return true;

	}

	/**
	 * @param {DashBoardData data} that holds data members of DashBoard class
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to select the value from tin drop down
	 * @name selectItemFromTINdDn
	 */
	public boolean selectItemFromTINdDn(DashBoardData data) {
		if (!SeleniumHelper.clickElement(we_Ribbon_Section_Tin_Dropdown())) {
			return false;
		}
		if (data.getTIN().equalsIgnoreCase("random")) {
			String selectedItem = SeleniumHelper.selectOption(we_selectList(), data.getTINInd());
			if (selectedItem == null) {
				return false;
			}
			data.setTIN(selectedItem);
		} else {
			SeleniumHelper.selectOption(we_selectList(), data.getTIN());
			if (!SeleniumHelper.getText(we_Ribbon_Selected_TIN()).equals((data.getTIN()))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify all the dash-board header
	 *              elements
	 * @name verifyHeaderElements
	 */
	public boolean verifyHeaderElements() {

		if (!SeleniumHelper.isElementDisplayed(we_Header_Provider_Name())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Primary_Practice_Location())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Request_Created())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Credentials_Verified())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Contract_Initiated())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Contract_Finalized())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Header_Take_Action())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify the record
	 * @name verifyRecord
	 * @param Takes the DashBoardData data object
	 */
	public boolean verifyRecord(DashBoardData data) {
		char[] getInitial = data.getMiddleName().toCharArray();
		if (!SeleniumHelper.getText(we_Provider_Name_Data())
				.contains(data.getFirstName() + " " + getInitial[0] + "." + " " + data.getLastName())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Specialty_Data()).contains(data.getSpecialty())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_NPI_Data()).contains(data.getNPI())) {
			return false;
		}
		if (we_Request_Created_Icon() == null) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Take_Action_Btn())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to logout from provider on-boarding
	 *              application
	 * @name logOut
	 * @param {String loginPageTitle}
	 */
	public boolean logOut(String loginPageTitle) {
		SeleniumHelper.scrollToViewElement(we_HeaderInfo_Welcome_LogOut_Btn());
		if (!SeleniumHelper.clickElement(we_HeaderInfo_Welcome_LogOut_Btn())) {
			return false;
		}
		if (!SeleniumHelper.isTitlePresent(loginPageTitle, highSync())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to click the next steps button from
	 *              provider on-boarding application
	 * @name clickNextSteps
	 */
	public boolean clickNextSteps() {
		if (!SeleniumHelper.clickElement(we_Take_Action_Btn())) {
			return false;
		}
		return true;
	}

	/*
	 * @return {boolean}
	 * 
	 * @function
	 * 
	 * @description This function is used to verify dash board content section
	 * presence
	 * 
	 * @name clickNextSteps
	 */
	public boolean verifyDashBoardContent() {
		int num = 0;
		while (we_DashBrd_Content_Section() == null && num <= 50) {
			SeleniumHelper.sleep(1000);
			num++;
		}
		return SeleniumHelper.isElementDisplayed(we_DashBrd_Content_Section());
	}

	/**
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get provider record index on dash-board
	 *              / status tracker page
	 * @name getPractitionerRecordId
	 */
	public int getPractitionerRecordId(String value) {
		int ind = 0;
		List<WebElement> records = we_rfp_Records();
		for (WebElement record : records) {
			if (SeleniumHelper.getText(record).contains(value.trim())) {
				return ind;
			}
			++ind;
		}
		return -1;
	}

	/**
	 * @param {String}
	 * @param {boolean}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get provider record index on
	 *              dash-board/status tracker page
	 * @name getPractitionerRecordId
	 */
	public int getPractitionerRecordId(String value, boolean isRFPSubmitted) {
		int ind = 0;
		List<WebElement> records = we_rfp_Records();
		for (WebElement record : records) {
			if (SeleniumHelper.getText(record).contains(value.trim()) && !isRFPSubmitted
					&& SeleniumHelper.getText(record).contains("Begin RFP")) {
				return ind;
			}
			++ind;
		}
		return -1;
	}

	/**
	 * @param {DashBoardData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify provider record on dash board /
	 *              status tracker page
	 * @name verifyRFPRecord
	 */
	public boolean verifyRFPRecord(DashBoardData dshData) {
		if (dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_New_Submitted_Record)) {
			return verifyLatestRFPRecord(dshData);
		} else if (dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_Existing_Submitted_Record)
				|| dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_Existing_In_Completed_Record)
				|| dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_Existing_Completed_Record)
				|| dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_Existing_Closed_Record)
				|| dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_Existing_Denied_Record)
				|| dshData.getRfpRecordType().equalsIgnoreCase(Constants.rfp_New_In_Completed_Record)) {
			return verifyExistingRFPRecord(dshData);
		}
		return false;
	}

	/**
	 * @param {DashBoardData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to click on Begin RFP button for a
	 *              specified practitioner record
	 * @name beginRFP
	 */
	public boolean beginRFP(DashBoardData dta) {
		int index = -1;
		index = getPractitionerRecordId(dta.getNPI(), false);
		if (index == -1) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_practitionerRecord_Btn(index, "Begin RFP"))) {
			return false;
		}
		return true;
	}

	/**
	 * @param {DashBoardData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify latest provider record on dash
	 *              board / status tracker page
	 * @name verifyLatestRFPRecord
	 */
	public boolean verifyLatestRFPRecord(DashBoardData data) {

		int index = getPractitionerRecordId(AcknowledgementAndSubmitPage.getCrNumber());
		if (index == -1 || index > 0) {
			return false;
		}
		if (!verifyProviderDetailsSection(index, data.getProviderName(), data.getNPI(), data.getSpecialty())) {
			return false;
		}
		if (!verifyReferenceNumberSection(index, AcknowledgementAndSubmitPage.getCrNumber())) {
			return false;
		}

		String rfpSubmrdDate = "";
		if (data.getRfpSubDate().equalsIgnoreCase(Constants.auto)) {
			rfpSubmrdDate = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(),
					Constants.rfp_Record_Date_Format);
		} else {
			rfpSubmrdDate = data.getRfpSubDate();
		}
		if (!verifyRequestSubmittedSection(index, rfpSubmrdDate, Constants.rfpStatus_Submitted)) {
			return false;
		}
		String crdEstDt = "";
		if ((data.getRfpCredEstDate().equalsIgnoreCase(Constants.auto) || data.getRfpCredEstDate().isEmpty()
				|| data.getRfpCredEstDate() == "") && (!rfpSubmrdDate.isEmpty() || rfpSubmrdDate != "")) {
			crdEstDt = AutomationBase.formatDateAndTime(
					AutomationBase.getSpecificDayDate(14,
							AutomationBase.convertStringToDate(rfpSubmrdDate, Constants.rfp_Record_Date_Format)),
					Constants.rfp_Record_Date_Format);
		} else if (!rfpSubmrdDate.isEmpty() || rfpSubmrdDate != "") {
			crdEstDt = data.getRfpCredEstDate();
		}
		if (data.getRfpRecordType().contains(Constants.rfpStatus_Submitted)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_Submitted,

					data.getCredStatus())) {

				return false;
			}
		} else if (data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_In_Completed,

					data.getCredStatus())) {

				return false;
			}
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Btn(index, "View Summary"))) {
			return false;
		}
		if (SeleniumHelper.isElementEnabled(we_practitionerRecord_Btn(index, "View Summary"))) {
			return false;
		}

		return true;
	}

	/**
	 * @param {DashBoardData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify existing provider record on dash
	 *              board / status tracker page
	 * @name verifyExistingRFPRecord
	 */
	public boolean verifyExistingRFPRecord(DashBoardData data) {

		int index = -1;
		String crNum = "";
		if (!data.getCrNumber().isEmpty() || data.getCrNumber() != "") {
			crNum = data.getCrNumber();
		}

		if (!data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)) {
			index = getPractitionerRecordId(crNum);
		} else {
			index = getPractitionerRecordId(data.getNPI(), false);
		}
		if (index == -1) {
			return false;
		}
		if (!verifyProviderDetailsSection(index, data.getProviderName(), data.getNPI(), data.getSpecialty())) {
			return false;
		}
		if (data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)) {
			if (!verifyReferenceNumberSection(index, "CR-", Constants.rfpStatus_In_Completed)) {
				return false;
			}
		} else {
			if (!verifyReferenceNumberSection(index, data.getCrNumber())) {
				return false;
			}
		}
		String rfpSubmrdDate = "";
		if (data.getRfpSubDate().equalsIgnoreCase(Constants.auto)) {
			rfpSubmrdDate = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(),
					Constants.rfp_Record_Date_Format);
		} else {
			rfpSubmrdDate = data.getRfpSubDate();
		}
		if (data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)) {
			if (!verifyRequestSubmittedSection(index, rfpSubmrdDate, Constants.rfpStatus_In_Completed)) {
				return false;
			}
		} else if (data.getRfpRecordType().contains(Constants.rfpStatus_Submitted)) {
			if (!verifyRequestSubmittedSection(index, rfpSubmrdDate, Constants.rfpStatus_Submitted)) {
				return false;
			}
		}

		String crdEstDt = "";
		if ((data.getRfpCredEstDate().equalsIgnoreCase(Constants.auto) || data.getRfpCredEstDate().isEmpty()
				|| data.getRfpCredEstDate() == "") && (!rfpSubmrdDate.isEmpty() || rfpSubmrdDate != "")) {
			crdEstDt = AutomationBase.formatDateAndTime(
					AutomationBase.getSpecificDayDate(Constants.estDaysLen,
							AutomationBase.convertStringToDate(rfpSubmrdDate, Constants.rfp_Record_Date_Format)),
					Constants.rfp_Record_Date_Format);
		} else if (!rfpSubmrdDate.isEmpty() || rfpSubmrdDate != "") {
			crdEstDt = data.getRfpCredEstDate();
		}
		if (data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)
				&& data.getCredStatus().equals(Constants.credStatus_Required)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_In_Completed,
					Constants.credStatus_Required)) {
				return false;
			}
		} else if (data.getRfpRecordType().contains(Constants.rfpStatus_Submitted)
				&& data.getCredStatus().equals(Constants.credStatus_Required)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_Submitted,
					Constants.credStatus_Required)) {
				return false;
			}
		} else if (data.getRfpRecordType().contains(Constants.rfpStatus_In_Completed)
				&& data.getCredStatus().equals(Constants.credStatus_Not_Required)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_In_Completed,
					Constants.credStatus_Not_Required)) {
				return false;
			}
		} else if (data.getRfpRecordType().contains(Constants.rfpStatus_Submitted)
				&& data.getCredStatus().equals(Constants.credStatus_Not_Required)) {
			if (!verifyCredentialVerifiedSection(index, crdEstDt, Constants.rfpStatus_Submitted,
					Constants.credStatus_Not_Required)) {
				return false;
			}
		}
		if (data.getRfpRecordType().contains(Constants.rfpStatus_Submitted)) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Btn(index, "View Summary"))) {
				return false;
			}
			if (SeleniumHelper.isElementEnabled(we_practitionerRecord_Btn(index, "View Summary"))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param {int}
	 * @param {String}
	 * @param {String}
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify provider section of provider
	 *              record on dash board / status tracker page
	 * @name verifyProviderDetailsSection
	 */
	private boolean verifyProviderDetailsSection(int recrdInd, String prvName, String npi, String spclty) {
		if (!SeleniumHelper.isElementDisplayed(
				we_practitionerRecord_Strong(recrdInd, prvName, npi, Constants.statusTracker_PrctRcrd_NPI_LBL))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdInd, prvName, npi))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdInd, prvName, spclty))) {
			return false;
		}
		return true;
	}

	/**
	 * @param {int}
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify reference number section of
	 *              provider record on dash board / status tracker page
	 * @name verifyReferenceNumberSection
	 */
	private boolean verifyReferenceNumberSection(int recrdIndex, String value, String status) {
		if (status.equals(Constants.rfpStatus_In_Completed)) {
			String text = SeleniumHelper.getText(
					we_practitionerRecord_Divcontent(recrdIndex, Constants.status_Tracker_PrctRecrd_RefrenceNum_Lbl));
			if (text.contains(value)) {
				return false;
			}
		} else {
			if (SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdIndex,
					Constants.status_Tracker_PrctRecrd_RefrenceNum_Lbl, value))) {
				return false;
			}

		}
		return true;
	}

	/**
	 * @param {int}
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify reference number section of
	 *              provider record on dash board / status tracker page
	 * @name verifyReferenceNumberSection
	 */
	private boolean verifyReferenceNumberSection(int recrdIndex, String value) {
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdIndex,
				Constants.status_Tracker_PrctRecrd_RefrenceNum_Lbl, value))) {
			return false;
		}

		return true;
	}
	
	/**
	 * @param {int}
	 * @param {String}
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify request submitted section of
	 *              provider record on dash board / status tracker page
	 * @name verifyRequestSubmittedSection
	 */
	private boolean verifyRequestSubmittedSection(int recrdIndex, String submittedDate, String rfpStatus) {
		if (rfpStatus.endsWith(Constants.rfpStatus_Submitted)) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdIndex,
					Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl, submittedDate))) {
				return false;
			}
		} else if (rfpStatus.equals(Constants.rfpStatus_In_Completed)) {
			String text = SeleniumHelper.getText(
					we_practitionerRecord_Divcontent(recrdIndex, Constants.status_Tracker_PrctRecrd_RefrenceNum_Lbl));
			if (text.contains(submittedDate)) {
				return false;
			}
		}

		if (rfpStatus.equals(Constants.rfpStatus_Submitted)) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Green_StatusIcon(recrdIndex,
					Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
				return false;
			}

		} else if (rfpStatus.equals(Constants.rfpStatus_In_Completed)) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_InProgress_StatusIcon(recrdIndex,
					Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param {int}
	 * @param {String}
	 * @param {String}
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify credential verified section of
	 *              provider record on dash board / status tracker page
	 * @name verifyCredentialVerifiedSection
	 */
	private boolean verifyCredentialVerifiedSection(int recrdIndex, String estDate, String rfpStatus,
			String credStatus) {
		if (rfpStatus.equals(Constants.rfpStatus_Submitted) && credStatus.equals(Constants.credStatus_Required)) {
			String reqrdLable = Constants.status_Tracker_PrctRecrd_Cred_Required_lbl;
			reqrdLable = reqrdLable.replace(Constants.estDateAuto, estDate);
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Pcontent(recrdIndex,
					Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl, reqrdLable))) {
				return false;
			}
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_InProgress_StatusIcon(recrdIndex,
					Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
				return false;
			}
		} else if (rfpStatus.equals(Constants.rfpStatus_In_Completed)
				&& credStatus.equals(Constants.credStatus_Required)) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_InComplete_StatusIcon(recrdIndex,
					Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
				return false;
			}
		}
		if ((rfpStatus.equals(Constants.rfpStatus_Submitted) && credStatus.equals(Constants.credStatus_Not_Required))
				|| ((rfpStatus.equals(Constants.rfpStatus_In_Completed)
						&& credStatus.equals(Constants.credStatus_Not_Required)))) {
			if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Not_Required_StatusIcon(recrdIndex,
					Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
				return false;
			}
			if (!SeleniumHelper.isElementDisplayed(
					we_practitionerRecord_Pcontent(recrdIndex, Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl,
							Constants.status_Tracker_PrctRecrd_Cred_Not_Required_lbl))) {
				return false;
			}
		}

		return true;
	}

	public boolean verifyDshBrdPgeDefaultSt(DashBoardData dt) {
		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_H6Content(dt.getSelectGrpTINText()))) {
			return false;
		}
		return true;
	}

	public boolean verifyDshBrdPgeAdPrvInfAftrGrpTinSelect(DashBoardData dt) {
		if (!SeleniumHelper.isElementDisplayed(we_Add_Provider_Button())) {
			return false;
		}
		String text = SeleniumHelper.getText(we_Add_Provider_Button_Info_Content());
		if (!text.equals(dt.getAddPrvdrTxt())) {
			return false;
		}
		return true;
	}

	public void verifyProviderRecordLinkedToOptumBehaviorHealthDescision(DashBoardData dt) {
		int count = SeleniumHelper.getElementsCount(we_rfp_Records());
	}

	/**
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get provider record index on dash-board
	 *              / status tracker page
	 * @name getRecordIndexByProviderName
	 */
	public int getRecordIndexByProviderName(String value) {
		int ind = 0;
		List<WebElement> records = we_rfp_provider_name_Records();
		for (WebElement record : records) {
			if (SeleniumHelper.getText(record).contains(value.trim())) {
				return ind;
			}
			++ind;
		}
		return -1;
	}

	public boolean verifyRFPRecordData(DashBoardData data) {
		int index = getRecordIndexByProviderName(data.getProviderName());
		if (index < 0) {
			return false;
		}
		SeleniumHelper.scrollToViewElement(we_practitionerRecord_Provider_Action_Button(index));	
		if (!verifyProviderDetailsSection(index, data.getProviderName(), data.getNPI(), data.getSpeciality())) {
			return false;
		}		
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Divcontent(index,
			Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
			return false;
		}

		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Divcontent(index,
			Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
			return false;
			}
		
		if (!SeleniumHelper.isElementDisplayed(
				we_practitionerRecord_Progress_ClosedIcon(index, Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(
				we_practitionerRecord_Progress_ClosedIcon(index, Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Provider_ContactUs_Link(index))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Provider_ContactUs_Number(index, data.getContactUsNumber()))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Provider_Action_Button(index))) {
			return false;
		}
		return true;
	}

	public boolean verifyClickOnButtonsInRecord(DashBoardData data) {
		int index = getRecordIndexByProviderName(data.getProviderName());
		if (index < 0) {
			return false;
		}
		// Verifying click on Contactus
		SeleniumHelper.clickElement(we_practitionerRecord_Provider_ContactUs_Link(index));
		ArrayList<String> windows = SeleniumHelper.getWindows();
		if (windows.size() != 2) {
			return false;
		}
		SeleniumHelper.switchToWindowAndClose(windows.get(1));
		SeleniumHelper.switchToWindow(windows.get(0));
		// Verifying click on Go to site
		SeleniumHelper.clickElement(we_practitionerRecord_Provider_Action_Button(index));
		windows.clear();
		windows = SeleniumHelper.getWindows();
		if (windows.size() != 2) {
			return false;
		}
		SeleniumHelper.switchToWindowAndClose(windows.get(1));
		SeleniumHelper.switchToWindow(windows.get(0));
		return true;
	}
	
	/**
	 * @param {DashBoardData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify latest provider record on
	 *              dash board / status tracker page
	 * @name verifyLatestCredNotAllowedRecordData
	 */
	public boolean verifyCredNotAllowedRecord(DashBoardData data) {

		int index = getRecordIndexByProviderName(data.getProviderName());
		if (index == -1 || index > 0) {
			return false;
		}
		if (!verifyProviderDetailsSection(index, data.getProviderName(), data.getNPI(), data.getSpecialty())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Provider_InEligible_Date(index, data.getInEligibleDate()))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(
				we_practitionerRecord_Progress_ClosedIcon(index, Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(
				we_practitionerRecord_Progress_ClosedIcon(index, Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Gray_StatusIcon(index,
					Constants.status_Tracker_PrctRecrd_ReqstSub_Lbl))) {
				return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_practitionerRecord_Gray_StatusIcon(index,
				Constants.status_Tracker_PrctRecrd_Cred_Verfd_Lbl))) {
			return false;
		}
		if (!SeleniumHelper.isElementEnabled(we_practitionerRecord_Btn(index, "Contact Us"))) {
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
	 *              contact_us button on the
	 *              dash board / status tracker
	 * @name clickContactUsButton
	 */
	public boolean clickContactUsButton(DashBoardData data) {
		int index = getRecordIndexByProviderName(data.getProviderName());
		if (index == -1 || index > 0) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_practitionerRecord_Btn(index, "Contact Us"))) {
			return false;
		}
		return true;
	}

}
