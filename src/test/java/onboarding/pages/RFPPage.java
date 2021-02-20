package onboarding.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import onboarding.dataobjects.AddContractInfoData;
import onboarding.dataobjects.AddLocationData;
import onboarding.dataobjects.AddProviderData;
import onboarding.dataobjects.AttachmentsData;
import onboarding.dataobjects.Constants;
import onboarding.dataobjects.DashBoardData;
import onboarding.dataobjects.EditAffiliatedHospitalData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;
import procraft.core.utilities.ui.SeleniumHelper.expectedConditions;

public class RFPPage extends BasePage {
	private String currentScreenName;
	private int hsptlRowsCount = -1;
	private int hsptlCurrentRowIndx = -1;
	public RFPPage() {
		currentScreenName = getClassName(this.getClass());
	}

	private String[] licenseHeaders = { "License Type", "State", "License Number", "Issue Date", "Expiration Date" };
	private String[] hspaflHeaders = { "Hospital Name", "Address", "Privileges", "Admitting Provider", "View", "Edit" };

	public WebElement we_rfp_bckTodshBrdBtn() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "GRAYBAR-BACKTONWPARTDASHBRD")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_selectList() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "UL-LIST")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_rfp_lblTxt() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "GRAYBAR-RQSTFRPARTLBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DashBoard_CAQH_Info_Label(String caqhInfo) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "DASHBRD-CAQHINFO");
		properties[1] = properties[1].replace("$value", caqhInfo);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_lname() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-LNAME")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Fname() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-FNAME")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Mname() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-MNAME")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Suffix() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-SUFFIX-Txt")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_prvInfo_Suffix_Items() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-SUFFIX-List-Items")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_prvInfo_Dob() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DOB")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Gender() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-GENDER")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Gender_ReadOnly() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-GENDER-Txt")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Degree_ReadOnly() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DEGRE-Txt")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_prvInfo_Gender_Items() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-GENDER-List-Items")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_prvInfo_SPCLTY() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-SPCLTY")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_SPCLTY_ReadOnly() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-SPCLTY-Txt")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_NPI() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-NPI")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_CAQHID() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-CAQHID")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_PCP_DESGNTION_RADIOBTN(String radioName) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "PRV-INFO-PCP-DESGNTION-RADIO");
		properties[1] = properties[1].replace("$value", radioName.toLowerCase());
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Degree() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DEGRE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_prvInfo_Degree_Items() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DEGRE-List-Items")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_prvInfo_Board_Certfd_RADIOBTN(String radioName) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "PRV-INFO-BRD-CERTFD-RADIO");
		properties[1] = properties[1].replace("$value", radioName.toLowerCase());
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_prvInfo_Exp_Date() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-EXP-DATE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_prvInfo() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-Pract-Info")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_prvInfo_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_prvInfo(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_bubbleNav_hsptlAfl() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-HSPTL-AFFL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_hsptlAfl_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_hsptlAfl(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_bubbleNav_attachments() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "BUBBLE-NAV-ATTACHMENTS")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_attachments_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_attachments(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_bubbleNav_licenses() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "BUBBLE-NAV-LICENSES")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_licenses_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_licenses(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_bubbleNav_locations() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "BUBBLE-NAV-LOCATIONS")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_locations_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_locations(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_bubbleNav_contractInfo() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "BUBBLE-NAV-CONTRACT-INFO")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_bubbleNav_contractInfo_Svg() {
		return SeleniumHelper.findNestedElement(we_bubbleNav_contractInfo(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "Bubble-Nav-SVG")),
				mediumSync());
	}

	public WebElement we_HSP_AFL_ADD_BTN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ADDAFFLHSP-BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_CURNT_HSP_AFFL_LBL() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-CURNT-HSP-AFFL-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_NO_AFFLTD_HSP_LBL() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-NO-AFFLTD-HSP-LBL")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_HEDR_LBL(String headerName) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-HEADING-LBL");
		properties[1] = properties[1].replace("$value", headerName);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_EDIT_HSP_AFL_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-EDIT-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DEL_HSP_AFL_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-DEL-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Edit_License_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-EDIT-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_DEL_License_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-DEL-DLG-TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_VIEW_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-VIEW-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_EDIT_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-EDIT-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_CLEAR_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-CLEAR-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_DASHES_ICON() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-DASHES-ICON")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_NAME_CELL_VALUE(String name) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-NAME-CELL-VALUE");
		properties[1] = properties[1].replace("$value", name);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_HSP_AFL_CELL_VALUE(String cellValue) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-CELL-VALUE");
		properties[1] = properties[1].replace("$value", cellValue);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_CELL_VALUE(String cellValue) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-CELL-VALUE");
		properties[1] = properties[1].replace("$value", cellValue);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_click_License_Page() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-PAGE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_License_Heading() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Attachments_Heading() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ATTACHMENTS-HEADER")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_Icon() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-ICON")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Add_License() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ADD-LICENSE-BTN")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Prv_Info_Dob_Err_Msg() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DOB-ERR-MSG")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_PrvInfo_Date_Err_Msg(String msgValue) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "PRV-INFO-DATE-ERR-MSG");
		properties[1] = properties[1].replace("$value", msgValue);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_attachmentType() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ATTACHMENT-TYPE")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_fileName() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FILENAME")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_fileSize() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FILESIZE")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_actions() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ACTIONS")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_attachmentsMessage() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ATTACHMENTMESSAGE")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_upload() {
		return SeleniumHelper
				.findElement(SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "UPLOAD")));
	}

	public WebElement we_displayType(String name) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DISPLAYTYPE");
		properties[1] = properties[1].replace("$value", name);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_displaySize(String name) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "DISPLAYSIZE");
		properties[1] = properties[1].replace("$value", name);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_getLimitErrorMessage() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FILELIMITERROR")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_getTypeErrorMessage() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FILETYPEERROR")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_getVirusErrorMessage() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "FILEVIRUSERROR")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_hspl_rows() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ROW-ELEMENTS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_hspl_row(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ROW-ELEMENT");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_hspl_row_edit(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ROW-EDITICON");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_hspl_row_delete(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ROW-DELICON");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_license_rows() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-ROW-ELEMENTS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public List<WebElement> we_license_table_headers() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LICENSE-HEADER-ELEMENTS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_license_row(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-ROW-ELEMENT");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_license_row_edit(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-ROW-EDITICON");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_license_row_delete(int ind) {
		String index = String.valueOf(ind);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-ROW-DELICON");
		properties[1] = properties[1].replace("$index", index);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_getAttachemntInfoMessage() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ATTACHMENTINFOMESSAGE")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_license_row_cell(WebElement licenseRow, int cellIndex) {
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-CELL-TAGNAME");
		List<WebElement> cells = SeleniumHelper.findNestedElements(licenseRow, SeleniumHelper.byLocator(properties),
				highSync());
		return cells.get(cellIndex);
	}

	public WebElement we_license_cell_Text(int rowInd, int colInd) {
		String rowIndex = String.valueOf(rowInd);
		String colIndex = String.valueOf(colInd);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "LICENSE-CELL-Text");
		properties[1] = properties[1].replace("$rowIndex", rowIndex);
		properties[1] = properties[1].replace("$cellIndex", colIndex);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Locations_PractState() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-PRIMARY-PRACT-STATE")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_Locations_PractState_Deflt() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "LOCATIONS-PRIMARY-PRACT-STATE-DEFAULT")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_ContractInfo_TIN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "CONTRACT-INFO-TIN-INPUT")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_ContractInfo_Cntr_Grp_Ddn() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CONTRACT-INFO-SELECT-CNTR-GRP-DDN")),
				highSync(), SeleniumHelper.expectedConditions.elementToBeClickable);
	}
	
	public WebElement we_ContractInfo_Practice_Start_Date() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(
						AutomationBase.readORProperties(currentScreenName, "CONTRACT-INFO-PRACTICE-START-DATE")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_Heading(String headingName) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "LOCATIONS-HEADING");
		properties[1] = properties[1].replace("$value", headingName);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_Header(String headerName) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "LOCATIONS-HEADER");
		properties[1] = properties[1].replace("$value", headerName);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_CellText(String cellText) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "LOCATIONS-CELL");
		properties[1] = properties[1].replace("$value", cellText);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_Billing_Row() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-BILLING-ROW")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_PLSV_Row() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-PLSV-ROW")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_CRED_Row() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-CRED-ROW")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_RFP_Location_ADD_CRED_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_CRED_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-CRED-ADD-ICON")),
				mediumSync());
	}
	
	public WebElement we_RFP_Location_ADD_BLNG_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_Billing_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-BLNG-ADD-ICON")),
				mediumSync());
	}

	public WebElement we_RFP_Location_ADD_PLSV_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_PLSV_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-PLSV-ADD-ICON")),
				mediumSync());
	}
	
	public WebElement we_RFP_Location_ADD_Location_Title() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-ADD-LOCATION_TITLE")),
				mediumSync(), expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_hspl_table_headers() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-HEADER-ELEMENTS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public List<WebElement> we_hospital_affiliation_rows() {
		return SeleniumHelper.findElements(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "HSP-AFL-ROW-ELEMENTS")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_hospital_affiliation_name_cell_Text(int rowInd, int colInd) {
		String rowIndex = String.valueOf(rowInd);
		String colIndex = String.valueOf(colInd);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-NAME-CELL-VALUE-DYN");
		properties[1] = properties[1].replace("$rowIndex", rowIndex);
		properties[1] = properties[1].replace("$cellIndex", colIndex);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_hospital_affiliation_cell_Text(int rowInd, int colInd) {
		String rowIndex = String.valueOf(rowInd);
		String colIndex = String.valueOf(colInd);
		String[] properties = AutomationBase.readORProperties(currentScreenName, "HSP-AFL-CELL-Text-IN");
		properties[1] = properties[1].replace("$rowIndex", rowIndex);
		properties[1] = properties[1].replace("$cellIndex", colIndex);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SuperVsng_LName() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUPV-LNAME")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SuperVsng_FName() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUPV-FNAME")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SuperVsng_NPI() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUPV-NPI")), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public WebElement we_SuperVsng_Splcty_DDN() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUPV-SPECIALTY-DDN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}

	public List<WebElement> we_select_Specialty_List() {
		return SeleniumHelper.findElements(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUPV-SPECIALTY-DDN-LIST")),
				highSync(), SeleniumHelper.expectedConditions.presenceOfElements);
	}

	public WebElement we_NPI_ErrMsg_Supervising() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "NPI-ERR-MSG-SUPV")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}

	public WebElement we_Submit_RFP() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "SUBMIT_RFP_BTN")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);

	}
	
	public WebElement we_ACK_SUB_DLG_TITLE() {
		return SeleniumHelper.findElement(
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "ACK_SUBMIT_WINDOW_TITLE")),
				mediumSync(), SeleniumHelper.expectedConditions.presenceOfElement);
	}
	
	public WebElement we_RFP_Location_EDIT_CRED_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_CRED_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-CRED-EDIT-ICON")),
				mediumSync());
	}
	
	public WebElement we_RFP_Location_EDIT_BLNG_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_Billing_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-BLNG-EDIT-ICON")),
				mediumSync());
	}

	public WebElement we_RFP_Location_EDIT_PLSV_Btn() {
		return SeleniumHelper.findNestedElement(we_RFP_Location_PLSV_Row(),
				SeleniumHelper.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-PLSV-EDIT-ICON")),
				mediumSync());
	}

	public WebElement we_RFP_Location_EDIT_Location_Title() {
		return SeleniumHelper.findElement(
				SeleniumHelper
						.byLocator(AutomationBase.readORProperties(currentScreenName, "LOCATIONS-EDIT-LOCATION_TITLE")),
				mediumSync(), expectedConditions.presenceOfElement);
	}
	
	public WebElement we_UPDATED_ADDRS(String cellText) {

		String[] properties = AutomationBase.readORProperties(currentScreenName, "UPDATED-ADRS-TXT");
		properties[1] = properties[1].replace("$value", cellText);
		return SeleniumHelper.findElement(SeleniumHelper.byLocator(properties), highSync(),
				SeleniumHelper.expectedConditions.presenceOfElement);
	}
	/**
	 * @param {DashBoardPage
	 *            page}
	 * @param {AddProviderData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify header , dashboard , gray
	 *              and ribbion controls
	 * @name verifyHdrRibnDshBrdAndGrayCntrls
	 */

	public boolean verifyHdrRibnDshBrdAndGrayCntrls(DashBoardPage page, AddProviderData data) {
		if (!SeleniumHelper.isElementDisplayed(page.we_HeaderInfo_Welcome_Label())) {
			return false;
		} else {
			String actualText = SeleniumHelper.getText(page.we_HeaderInfo_Welcome_Label());
			if (!actualText.equals(DashBoardData.welComeText)) {
				return false;
			}

		}
		if (!SeleniumHelper.isElementDisplayed(page.we_HeaderInfo_Logo_Icon())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(page.we_HeaderInfo_LogOut_Link())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(page.we_Ribbon_Section_Group_Dropdown())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(page.we_Ribbon_Section_Tin_Dropdown())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_rfp_bckTodshBrdBtn())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_rfp_lblTxt())) {
			return false;
		}
		String expTxt = "";
		if (data.getMiddleName().equals("") || data.getMiddleName().isEmpty()) {
			expTxt = data.getFirstName() + "  " + data.getLastName() + " - CAQH# " + data.getCAQHID();
		} else {
			expTxt = data.getFirstName() + " " + data.getMiddleName().substring(0, 1) + "." + " " + data.getLastName()
					+ " " + " - CAQH# " + data.getCAQHID();
		}

		if (!SeleniumHelper.isElementDisplayed(we_DashBoard_CAQH_Info_Label(expTxt))) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} return true or false
	 * @function
	 * @description This function is used to verify RFP page practitioner info
	 *              controls
	 * @name verifyPractInfoControls
	 */
	public boolean verifyPractInfoControls() {

		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Fname())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Mname())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_lname())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Suffix())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Dob())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Gender())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_SPCLTY())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_NPI())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_CAQHID())) {
			return false;
		}
		if (we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.yes) == null) {
			return false;
		}
		if (we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.no) == null) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Degree())) {
			return false;
		}
		if (we_prvInfo_Board_Certfd_RADIOBTN(Constants.yes) == null) {
			return false;
		}
		if (we_prvInfo_Board_Certfd_RADIOBTN(Constants.no) == null) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_prvInfo_Exp_Date())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify pre-populated provider info
	 *              fields
	 * @name verifyProviderInfoPrepopulatedFields
	 */
	public boolean verifyProviderInfoPrepopulatedFields(AddProviderData data) {
		if (!SeleniumHelper.getAttribute(we_prvInfo_Fname(), "value").equals(data.getFirstName())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Mname(), "value").equals(data.getMiddleName())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_lname(), "value").equals(data.getLastName())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_prvInfo_SPCLTY()).equals(data.getSpecialty())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_NPI(), "value").equals(data.getNPI())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_CAQHID(), "value").equals(data.getCAQHID())) {
			return false;
		}

		return true;
	}

	/**
	 * @param {AddProviderData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify pre-populated provider info
	 *              fields
	 * @name verifyProviderInfoPrepopulatedReadOnlyFields
	 */
	public boolean verifyProviderInfoPrepopulatedReadOnlyFields(AddProviderData data, RFPData rfpData) {
		if (!SeleniumHelper.getAttribute(we_prvInfo_Fname(), "value").equals(data.getFirstName())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Fname())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Mname(), "value").equals(data.getMiddleName())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Mname())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_lname(), "value").equals(data.getLastName())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_lname())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_prvInfo_SPCLTY_ReadOnly()).equals(data.getSpecialty())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_SPCLTY_ReadOnly())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_NPI(), "value").equals(data.getNPI())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_NPI())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_CAQHID(), "value").equals(data.getCAQHID())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_CAQHID())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Degree_ReadOnly(), "value").equals(data.getDegree())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Degree())) {
			return false;
		}
		if (!SeleniumHelper.isElementSelected(we_prvInfo_Board_Certfd_RADIOBTN(rfpData.getBoardCertified()))
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Board_Certfd_RADIOBTN(Constants.yes))
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Board_Certfd_RADIOBTN(Constants.no))) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Gender_ReadOnly(), "value").equals(rfpData.getGender())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Gender_ReadOnly())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Exp_Date(), "value").equals(rfpData.getExpirationDate())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Exp_Date())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Suffix(), "value").equals(rfpData.getSuffix())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Suffix())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_prvInfo_Dob(), "value").equals(rfpData.getDOB())
				&& SeleniumHelper.isElementEnabled(we_prvInfo_Dob())) {
			return false;
		}
		/*
		 * if (!SeleniumHelper.getAttribute(we_prvInfo_Dob(),
		 * "value").equals(data.())) { return false; }
		 */
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify RFP page existence
	 * @name isRFPPageExist
	 */
	public boolean isRFPPageExist() {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(1000);
		}
		String url = SeleniumHelper.getURL();
		return AutomationBase.stringContains(url, Constants.rfpURL);
	}

	/**
	 * @param {String
	 *            menuName}
	 * @return {boolean}
	 * @function
	 * @description This function is used for bubble navigation on RFP page
	 * @name bubbleNavigation
	 */
	public boolean bubbleNavigation(String menuName) {
		switch (menuName) {
		case Constants.practitionerInfo:
			if (!SeleniumHelper.clickElement(we_bubbleNav_prvInfo())) {
				return false;
			}
			break;
		case Constants.hospitalAffiliation:
			if (!SeleniumHelper.clickElement(we_bubbleNav_hsptlAfl())) {
				return false;
			}
			break;
		case Constants.attachments:
			if (!SeleniumHelper.clickElement(we_bubbleNav_attachments())) {
				return false;
			}
			break;
		case Constants.licenses:
			if (!SeleniumHelper.clickElement(we_bubbleNav_licenses())) {
				return false;
			}
			break;
		case Constants.locations:
			if (!SeleniumHelper.clickElement(we_bubbleNav_locations())) {
				return false;
			}
			break;
		case Constants.contractInfo:
			if (!SeleniumHelper.clickElement(we_bubbleNav_contractInfo())) {
				return false;
			}
			break;
		default:
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            menuName}
	 * @return {boolean}
	 * @function
	 * @description This function is used enter pract info on RFP page
	 * @name enterPractInfo
	 */
	public boolean enterPractInfo(RFPData data) {
		if (!enterSupervisingPhysicianInfo(data)) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            menuName}
	 * @return {boolean}
	 * @function
	 * @description This function is used enter pract info on RFP page
	 * @name enterPractInfo
	 */
	public boolean editHosptialAffiliationAndSave(RFPData data, EditAffiliatedHospitalPage edtHspPage,
			EditAffiliatedHospitalData edHspData) {
		if (!navigateToEditHospitalAffiliationModal(data, "EDIT HOSPITAL")) {
			return false;
		}
		if (!edtHspPage.enterHspAflData(edHspData)) {
			return false;
		}
		if (!edtHspPage.submitForm()) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            menuName}
	 * @return {boolean}
	 * @function
	 * @description This function is used to enter locations info on RFP page
	 * @name enterLocationsAndSave
	 */
	public boolean enterLocationsAndSave(RFPData data, AddLocationPage addLocation, AddLocationData adlData) {
		if (!navigateToAddaLocationScreen((data))) {
			return false;
		}
		if (!addLocation.addLocation(adlData)) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String}
	 * @param {RFPData}
	 * @param {AddLocationPage}
	 * @param {AddLocationData}
	 * @param {EditAffiliatedHospitalPage}
	 * @param {EditAffiliatedHospitalData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to enter locations info on RFP page
	 * @name verifyRFPSections
	 */
	public boolean verifyRFPSections(String menuName, RFPData data, AddLocationPage adlPage, AddLocationData adlData,
			EditAffiliatedHospitalPage editHospAflPage, EditAffiliatedHospitalData editHspAlData) {
		switch (menuName) {
		case Constants.practitionerInfo:
			
			if (SeleniumHelper.getCSSValue(we_bubbleNav_prvInfo_Svg(), "color").equals(Constants.getRedRGBA())) {
				if (!enterPractInfo(data)) {
					return false;
				}
			}
			if (!SeleniumHelper.getCSSValue(we_bubbleNav_prvInfo_Svg(), "color").equals(Constants.getGreenRGBA())) {
				return false;
			}

			break;
		case Constants.hospitalAffiliation:
			if (SeleniumHelper.getCSSValue(we_bubbleNav_hsptlAfl_Svg(), "color").equals(Constants.getRedRGBA())) {
				if (!SeleniumHelper.clickElement(we_bubbleNav_hsptlAfl())) {
					return false;
				}
				if (!editHosptialAffiliationAndSave(data, editHospAflPage, editHspAlData)) {
					return false;
				}
			}
			if (!SeleniumHelper.getCSSValue(we_bubbleNav_hsptlAfl_Svg(), "color").equals(Constants.getGreenRGBA())) {
				return false;
			}
			break;
		case Constants.attachments:
			if (!SeleniumHelper.clickElement(we_bubbleNav_attachments())) {
				return false;
			}
			break;
		case Constants.licenses:
			if (!SeleniumHelper.clickElement(we_bubbleNav_licenses())) {
				return false;
			}
			break;
		case Constants.locations:
			if (SeleniumHelper.getCSSValue(we_bubbleNav_locations_Svg(), "color").equals(Constants.getRedRGBA())) {
				if (!SeleniumHelper.clickElement(we_bubbleNav_locations())) {
					return false;
				}
				if (!enterLocationsAndSave(data, adlPage, adlData)) {
					return false;
				}
			}
			if (!SeleniumHelper.getCSSValue(we_bubbleNav_locations_Svg(), "color").equals(Constants.getGreenRGBA())) {
				return false;
			}
			break;
		case Constants.contractInfo:
			if (SeleniumHelper.getCSSValue(we_bubbleNav_contractInfo_Svg(), "color").equals(Constants.getRedRGBA())) {
				if (!SeleniumHelper.clickElement(we_bubbleNav_contractInfo())) {
					return false;
				}
				if (!selectItemFromContractingGroupDdn(data)) {
					return false;
				}
			}
			/*if (!SeleniumHelper.getCSSValue(we_bubbleNav_contractInfo_Svg(), "color").equals(Constants.getGreenRGBA())) {
				return false;
			}*/
			break;
		}
		SeleniumHelper.tabOutElement(we_bubbleNav_contractInfo());
		return true;
	}

	/*
	 * @return {boolean}
	 * 
	 * @function
	 * 
	 * @description This function is used to click on the license bubble
	 * 
	 * @name clickLicenseBubble
	 */
	public boolean clickLicenseBubble() {
		if (!SeleniumHelper.clickElement(we_click_License_Page())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify Hospital Affiliation
	 *              Controls
	 * @name verifyHsptlAflControls
	 */
	public boolean verifyHsptlAflControls(RFPData data) {
		try {
			if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_ADD_BTN())) {
				return false;
			}
			if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_CURNT_HSP_AFFL_LBL())) {
				return false;
			}
			if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_NO_AFFLTD_HSP_LBL())) {
				return false;
			}
			if (data.getHsptlAflHdrs() != "") {
				String[] hdrStrngs = data.getHsptlAflHdrs().split(",");
				for (String headr : hdrStrngs) {
					if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_HEDR_LBL(headr))) {
						return false;
					}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to Add Affiliated hospital
	 *              modal window
	 * @name navigateToAddAffiliatedHospital
	 */
	public boolean navigateToAddAffiliatedHospital(String title) {
		try {
			if (!SeleniumHelper.clickElement(we_HSP_AFL_ADD_BTN())) {
				return false;
			}

			String expTitle = SeleniumHelper.getText(we_HSP_AFL_DLG_TITLE());
			if (!expTitle.equals(title)) {
				return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to Add Affiliated hospital
	 *              modal window
	 * @name navigateToAddAffiliatedHospital
	 */
	public boolean verifyAcknowledgeAndSubmitWindow(RFPData data) {
		try {

			String expTitle = SeleniumHelper.getText(we_ACK_SUB_DLG_TITLE());
			if (!expTitle.equals(data.getAckTitle())) {
				return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify added hospital affiliated
	 *              record
	 * @name veirfyHospitalAffiliationRecord
	 */
	public boolean veirfyHospitalAffiliationRecord(RFPData data) {
		if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_NAME_CELL_VALUE(data.getHospitalName()))) {
			return false;
		}

		if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_CELL_VALUE(data.getPrivileges()))) {
			return false;
		}

		if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_CELL_VALUE(data.getAdmittingProvider()))) {
			return false;
		}
		if (data.getAdmittingProvider().equals("N/A")) {
			if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_DASHES_ICON())) {
				return false;
			}
		} else {
			if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_VIEW_ICON())) {
				return false;
			}
		}
		if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_EDIT_ICON())) {
			return false;
		}

		if (!SeleniumHelper.isElementDisplayed(we_HSP_AFL_CLEAR_ICON())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify cancellation of hospital
	 *              affiliated record
	 * @name veirfyCancellingHospitalAffiliationRecord
	 */
	public boolean veirfyCancellingHospitalAffiliationRecord(RFPData data) {
		if (SeleniumHelper.isElementDisplayed(we_HSP_AFL_NAME_CELL_VALUE(data.getHospitalName()))) {
			return false;
		}

		if (SeleniumHelper.isElementDisplayed(we_HSP_AFL_CELL_VALUE(data.getPrivileges()))) {
			return false;
		}

		if (SeleniumHelper.isElementDisplayed(we_HSP_AFL_CELL_VALUE(data.getAdmittingProvider()))) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify all the Licenses Page header
	 *              elements
	 * @name verifyLicensesHeaderElements
	 */
	public boolean verifyLicensesHeaderElements() {

		if (!SeleniumHelper.isElementDisplayed(we_License_Heading())) {
			return false;
		}
		if (we_Add_Icon() == null) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_Add_License())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to click Add License
	 * @name clickAddLicense
	 */
	public boolean clickAddLicense() {
		if (!SeleniumHelper.clickElement(we_Add_License())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to Verify Degree Drop down
	 * @name verifyDegreeDropdown
	 */
	public boolean verifyDegreeDropdown(RFPData data) {
		ArrayList<String> expectedDropDownItems = new ArrayList<String>();
		ArrayList<String> actualDropDownItems = new ArrayList<String>();
		String[] items = data.getDegreValues().split(",");
		for (String item : items) {
			expectedDropDownItems.add(item);
		}
		String actDefltVal = SeleniumHelper.getText(we_prvInfo_Degree());
		if (!actDefltVal.equals(expectedDropDownItems.get(0))) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_prvInfo_Degree())) {
			return false;
		}
		for (WebElement degree : we_prvInfo_Degree_Items()) {

			actualDropDownItems.add(SeleniumHelper.getText(degree));
		}
		if (!actualDropDownItems.equals(expectedDropDownItems)) {
			return false;
		}
		SeleniumHelper.selectOption(we_prvInfo_Degree_Items(), actDefltVal);
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to Verify Gender Drop down
	 *              functionality
	 * @name verifyGenderDropdown
	 */
	public boolean verifyGenderDropdown(RFPData data) {
		ArrayList<String> expectedDropDownItems = new ArrayList<String>();
		ArrayList<String> actualDropDownItems = new ArrayList<String>();
		String[] items = data.getGenderValues().split(",");
		for (String item : items) {
			expectedDropDownItems.add(item);
		}
		String actDefltVal = SeleniumHelper.getText(we_prvInfo_Gender());
		if (!actDefltVal.equals(expectedDropDownItems.get(0))) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_prvInfo_Gender())) {
			return false;
		}
		for (WebElement gender : we_prvInfo_Gender_Items()) {

			actualDropDownItems.add(SeleniumHelper.getText(gender));
		}
		if (!actualDropDownItems.equals(expectedDropDownItems)) {
			return false;
		}
		SeleniumHelper.selectOption(we_prvInfo_Gender_Items(), actDefltVal);
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to Verify Suffix Drop down
	 *              functionality
	 * @name verifySuffixDropdown
	 */
	public boolean verifySuffixDropdown(RFPData data) {
		ArrayList<String> expectedDropDownItems = new ArrayList<String>();
		ArrayList<String> actualDropDownItems = new ArrayList<String>();
		String[] items = data.getSufxValues().split(",");
		for (String item : items) {
			expectedDropDownItems.add(item);
		}
		String actDefltVal = SeleniumHelper.getText(we_prvInfo_Suffix());
		if (!actDefltVal.equals(expectedDropDownItems.get(0))) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_prvInfo_Suffix())) {
			return false;
		}
		for (WebElement suffix : we_prvInfo_Suffix_Items()) {

			actualDropDownItems.add(SeleniumHelper.getText(suffix));
		}
		if (!actualDropDownItems.equals(expectedDropDownItems)) {
			return false;
		}
		SeleniumHelper.selectOption(we_prvInfo_Suffix_Items(), actDefltVal);
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to validate DOB field validations
	 * @name dobFieldValidations
	 */
	public boolean dobFieldValidations(RFPData data) {
		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getDateFieldLen(), "AB");
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (!SeleniumHelper.getAttribute(we_prvInfo_Dob(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		value = Constants.invalidDateAlphaNumeric;
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (SeleniumHelper.getAttribute(we_prvInfo_Dob(), "value").equals(value)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getDOBInvalidFormatMsg()))) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getDateFieldLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), Constants.spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (SeleniumHelper.getAttribute(we_prvInfo_Dob(), "value").contains(Constants.spl_Char)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getDOBInvalidFormatMsg()))) {
			return false;
		}
		// Validating character limit
		value = AutomationBase.formatDateAndTime(AutomationBase.getYesterDayDate(), Constants.MMddyyyy);
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (value.length() != data.getDateFieldLen()) {
			return false;
		}
		// Validating forward slash
		// existence
		String enteredValue = SeleniumHelper.getAttribute(we_prvInfo_Dob(), "value");
		String[] subValues = enteredValue.split(Constants.forwardSlash);
		if (subValues.length < Constants.three) {
			return false;
		}
		String currentMonth = "";
		String yestrDay = "";
		if (AutomationBase.getCurrentMonth() > Constants.nine) {
			currentMonth = String.valueOf(AutomationBase.getCurrentMonth());
		} else {
			currentMonth = Constants.zeroInString + String.valueOf(AutomationBase.getCurrentMonth());
		}
		if (AutomationBase.getCurrentDay() > Constants.nine) {
			yestrDay = String.valueOf(AutomationBase.getCurrentDay());
		} else {
			yestrDay = Constants.zeroInString + String.valueOf(AutomationBase.getCurrentDay() - Constants.one);
		}
		if (!subValues[0].equals(currentMonth)) {
			return false;
		}
		if (!subValues[1].equals(yestrDay)) {
			return false;
		}
		// Validating invalid date error
		// message
		value = AutomationBase.formatDateAndTime(AutomationBase.getYesterDayDate(), Constants.yyyyMMdd);
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getDOBInvalidDateErrMsg()))) {
			return false;
		}
		// Validating invalid date
		// format error message
		value = Constants.invalidDate;
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getDOBInvalidFormatMsg()))) {
			return false;
		}
		// Validating earlier than
		// current date error message
		value = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(), Constants.MMddyyyy);
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		String errText = SeleniumHelper.getText(we_Prv_Info_Dob_Err_Msg());
		if (!errText.equals(data.getDOBGrtErrMsg())) {
			return false;
		}
		value = AutomationBase.formatDateAndTime(AutomationBase.getTomorrowDate(), Constants.MMddyyyy);
		if (!SeleniumHelper.enterText(we_prvInfo_Dob(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Dob());
		errText = SeleniumHelper.getText(we_Prv_Info_Dob_Err_Msg());
		if (!errText.equals(data.getDOBGrtErrMsg())) {
			return false;
		}
		return true;

	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to validate expiration date field
	 *              validations
	 * @name expDateFieldValidations
	 */
	public boolean expDateFieldValidations(RFPData data) {
		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getDateFieldLen(), "AB");
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (!SeleniumHelper.getAttribute(we_prvInfo_Exp_Date(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		value = Constants.invalidDateAlphaNumeric;
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (SeleniumHelper.getAttribute(we_prvInfo_Exp_Date(), "value").equals(value)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getExpDtInvalidFormatMsg()))) {
			return false;
		}
		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getDateFieldLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), Constants.spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (SeleniumHelper.getAttribute(we_prvInfo_Exp_Date(), "value").contains(Constants.spl_Char)) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getExpDtInvalidFormatMsg()))) {
			return false;
		}
		// Validating character limit
		value = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(), Constants.MMddyyyy);
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (value.length() != data.getDateFieldLen()) {
			return false;
		}
		// Validating forward slash
		// existence
		String enteredValue = SeleniumHelper.getAttribute(we_prvInfo_Exp_Date(), "value");
		String[] subValues = enteredValue.split(Constants.forwardSlash);
		if (subValues.length < Constants.three) {
			return false;
		}
		String currentMonth = "";
		String currentDay = "";
		if (AutomationBase.getCurrentMonth() > Constants.nine) {
			currentMonth = String.valueOf(AutomationBase.getCurrentMonth());
		} else {
			currentMonth = Constants.zeroInString + String.valueOf(AutomationBase.getCurrentMonth());
		}
		if (AutomationBase.getCurrentDay() > Constants.nine) {
			currentDay = String.valueOf(AutomationBase.getCurrentDay());
		} else {
			currentDay = Constants.zeroInString + String.valueOf(AutomationBase.getCurrentDay());
		}
		if (!subValues[0].equals(currentMonth)) {
			return false;
		}
		if (!subValues[1].equals(currentDay)) {
			return false;
		}
		// Validating invalid date error
		// message
		value = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(), Constants.yyyyMMdd);
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getExpDateInvalidDateErrMsg()))) {
			return false;
		}
		// Validating invalid date
		// format error message
		value = Constants.invalidDate;
		if (!SeleniumHelper.enterText(we_prvInfo_Exp_Date(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_prvInfo_Exp_Date());
		if (!SeleniumHelper.isElementDisplayed(we_PrvInfo_Date_Err_Msg(data.getExpDtInvalidFormatMsg()))) {
			return false;
		}
		return true;

	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to select pcp designation radio
	 *              buttons
	 * @name selectPCPDeshRadioBtns
	 */
	public boolean selectPCPDeshRadioBtns() {
		if (!SeleniumHelper.clickElement(we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.yes))) {
			return false;
		}
		if (!SeleniumHelper.isElementSelected(we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.yes))) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.no))) {
			return false;
		}
		if (!SeleniumHelper.isElementSelected(we_prvInfo_PCP_DESGNTION_RADIOBTN(Constants.no))) {
			return false;
		}

		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to select board certified radio
	 *              buttons
	 * @name selectBoardCertRadioBtns
	 */
	public boolean selectBoardCertRadioBtns() {
		if (!SeleniumHelper.clickElement(we_prvInfo_Board_Certfd_RADIOBTN(Constants.yes))) {
			return false;
		}
		if (!SeleniumHelper.isElementSelected(we_prvInfo_Board_Certfd_RADIOBTN(Constants.yes))) {
			return false;
		}
		if (!SeleniumHelper.clickElement(we_prvInfo_Board_Certfd_RADIOBTN(Constants.no))) {
			return false;
		}
		if (!SeleniumHelper.isElementSelected(we_prvInfo_Board_Certfd_RADIOBTN(Constants.no))) {
			return false;
		}

		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify all the Attachments Page
	 *              header elements
	 * @name verifyAttachmentsElements
	 * @param This
	 *            method takes AttachmentsData dataobject
	 */
	public boolean verifyAttachmentsElements(AttachmentsData data) {

		if (!SeleniumHelper.isElementDisplayed(we_Attachments_Heading())) {
			return false;
		}
		if (!SeleniumHelper.getText(we_attachmentsMessage()).equals(data.getattachmentsMessage())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_attachmentType())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_fileName())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_fileSize())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_actions())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify if document can be uploaded
	 * @name verifyUpload
	 * @param This
	 *            method takes AttachmentsData dataobject
	 */
	public boolean verifyUpload(AttachmentsData data) {
		data.setUpload(data.getUpload());
		if (!SeleniumHelper.enterTextwithOutClear(we_upload(), data.getUploaded())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify if uploaded document is
	 *              visible
	 * @name verifyUploaded
	 */
	public boolean verifyUploadedFileDetails(AttachmentsData data) {
		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(1000);
		}
		if (!SeleniumHelper.isElementDisplayed(we_displayType(data.getUploadedFile()))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_displaySize(data.getUploadedFileSize()))) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify if large size document shows
	 *              error message
	 * @name verifyLimitErrorFileMessage * @param This method takes
	 *       AttachmentsData dataobject
	 */
	public boolean verifyLimitErrorFileMessage(AttachmentsData data) {

		if (!SeleniumHelper.getText(we_getLimitErrorMessage()).equals(data.getLimitErrorMessage())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify if incorrect file type shows
	 *              error message
	 * @name verifyTypeErrorFileMessage * @param This method takes
	 *       AttachmentsData dataobject
	 */
	public boolean verifyTypeErrorFileMessage(AttachmentsData data) {

		if (!SeleniumHelper.getText(we_getTypeErrorMessage()).equals(data.getTypeErrorMessage())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify if a document contains virus
	 *              shows error message
	 * @name verifyVirusErrorFileMessage * @param This method takes
	 *       AttachmentsData dataobject
	 */
	public boolean verifyVirusErrorFileMessage(AttachmentsData data) {

		if (AutomationBase.getOSName().toLowerCase().contains("mac")) {
			SeleniumHelper.sleep(1000);
		}
		if (!SeleniumHelper.getText(we_getVirusErrorMessage()).equals(data.getVirusErrorMessage())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to Add License modal
	 *              window
	 * @name navigateToAddLicense
	 */
	public boolean navigateToAddLicense(String title) {
		try {
			if (!SeleniumHelper.clickElement(we_Add_License())) {
				return false;
			}

			String expTitle = SeleniumHelper.getText(we_License_DLG_TITLE());
			if (!expTitle.equals(title)) {
				return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify added license record
	 * @name verifyLicenseRecord
	 */
	public boolean verifyLicenseRecord(RFPData data) {
		if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE(data.getLicenseType()))) {
			return false;
		}

		if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE(data.getLicenseNumber()))) {
			return false;
		}
		if (data.getState().isEmpty() && data.getLicenseType().equals("Medicare")) {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE("N/A"))) {
				return false;
			}
		} else {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE(data.getState()))) {
				return false;
			}
		}

		if (data.getIssueDate().isEmpty() && (data.getLicenseType().equals("Federal DEA")
				|| data.getLicenseType().equals("Medicare") || data.getLicenseType().equals("Medicaid"))) {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE("N/A"))) {
				return false;
			}
		} else {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE(data.getIssueDate()))) {
				return false;
			}
		}

		if (data.getExpirationDate().isEmpty()
				&& (data.getLicenseType().equals("Medicare") || data.getLicenseType().equals("Medicaid"))) {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE("N/A"))) {
				return false;
			}
		} else {
			if (!SeleniumHelper.isElementDisplayed(we_License_CELL_VALUE(data.getExpirationDate()))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify pre-filled license records
	 * @name verifyPreFilledLicenseRecords
	 */
	public boolean verifyPreFilledLicenseRecords(RFPData data) {
		if (!getLicenseCellData(getReqLicenseRowInd(data.getUniqueValue()), getLicenseHeaderIndex(licenseHeaders[0]))
				.equals(data.getLicenseType())) {
			return false;
		}

		if (!getLicenseCellData(getReqLicenseRowInd(data.getUniqueValue()), getLicenseHeaderIndex(licenseHeaders[1]))
				.equals(data.getState())) {
			return false;
		}
		if (!getLicenseCellData(getReqLicenseRowInd(data.getUniqueValue()), getLicenseHeaderIndex(licenseHeaders[2]))
				.equals(data.getLicenseNumber())) {
			return false;
		}

		if (!getLicenseCellData(getReqLicenseRowInd(data.getUniqueValue()), getLicenseHeaderIndex(licenseHeaders[3]))
				.equals(data.getIssueDate())) {
			return false;
		}
		if (!getLicenseCellData(getReqLicenseRowInd(data.getUniqueValue()), getLicenseHeaderIndex(licenseHeaders[4]))
				.equals(data.getExpirationDate())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            hspName}
	 * @return {Integer}
	 * @function
	 * @description This function is used to get license record index based on
	 *              hospital name
	 * @name getReqLicenseRowInd
	 */
	public int getReqLicenseRowInd(String uniqueValue) {
		int index = -1;
		for (WebElement lcnRecrd : we_license_rows()) {

			index++;
			if (SeleniumHelper.getText(lcnRecrd).contains(uniqueValue)) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * @return {Integer}
	 * @function
	 * @description This function is used to fetch count of license row elements
	 * @name getLicenseRowsCount
	 */
	public int getLicenseRowsCount() {
		int count = we_license_rows().size();
		return count;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to edit license modal
	 * @name navigateToEditLicenseModal
	 */
	public boolean navigateToEditLicenseModal(RFPData data, String title) {
		if (!SeleniumHelper.clickElement(we_license_row_edit(getReqLicenseRowInd(data.getLicenseNumber())))) {
			return false;
		}
		if (!SeleniumHelper.getText(we_Edit_License_DLG_TITLE()).equals(title)) {
			return false;
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to delete license modal
	 * @name navigateToDelLicenseModal
	 */
	public boolean navigateToDelLicenseModal(RFPData data, String title) {
		if (!SeleniumHelper.clickElement(we_license_row_delete(getReqLicenseRowInd(data.getLicenseNumber())))) {
			return false;
		}
		if (!SeleniumHelper.getText(we_DEL_License_DLG_TITLE()).equals(title)) {
			return false;
		}
		return true;
	}

	/**
	 * @param {String
	 *            hspName}
	 * @return {Integer}
	 * @function
	 * @description This function is used to get hospital affiliated record
	 *              index based on hospital name
	 * @name getReqHsptlRowInd
	 */
	public int getReqHsptlRowInd(String hspName) {
		hsptlCurrentRowIndx = -1;
		for (WebElement hspRecrd : we_hspl_rows()) {

			hsptlCurrentRowIndx++;
			if (SeleniumHelper.getText(hspRecrd).contains(hspName)) {
				return hsptlCurrentRowIndx;
			}
		}
		return -1;
	}

	/**
	 * @return {Integer}
	 * @function
	 * @description This function is used to fetch count of affiliated hospital
	 *              row elements
	 * @name getHosptlAfflRowsCount
	 */
	public int getHosptlAfflRowsCount() {
		hsptlRowsCount = we_hspl_rows().size();
		return hsptlRowsCount;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to edit hospital
	 *              affiliation modal
	 * @name navigateToEditHospitalAffiliationModal
	 */
	public boolean navigateToEditHospitalAffiliationModal(RFPData data, String title) {
		if (!SeleniumHelper.clickElement(we_hspl_row_edit(getReqHsptlRowInd(data.getHospitalName())))) {
			return false;
		}
		if (!SeleniumHelper.getText(we_EDIT_HSP_AFL_DLG_TITLE()).equals(title)) {
			return false;
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data}
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to delete hospital
	 *              affiliation modal
	 * @name navigateToDelHospitalAffiliationModal
	 */
	public boolean navigateToDelHospitalAffiliationModal(RFPData data, String title) {
		if (!SeleniumHelper.clickElement(we_hspl_row_delete(getReqHsptlRowInd(data.getHospitalName())))) {
			return false;
		}
		if (!SeleniumHelper.getText(we_DEL_HSP_AFL_DLG_TITLE()).equals(title)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param {RFPData
	 *            data}
	 * @param {String
	 *            title}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify attachment info message on
	 *              attachemnt page/screen
	 * @name verifyAttachmentInfoMessage
	 */
	public boolean verifyAttachmentInfoMessage(RFPData data) {

		String[] messages = data.getAttachemntInfoMessage().split("\\.");
		String actText = SeleniumHelper.getText(we_getAttachemntInfoMessage());

		if (!actText.contains(messages[0])) {
			return false;
		}

		if (!actText.contains(messages[1])) {
			return false;
		}
		return true;
	}

	/*
	 * *
	 * 
	 * @param {String headerName}
	 * 
	 * @return {integer}
	 * 
	 * @function
	 * 
	 * @description This function is used to get the index of license header
	 * 
	 * @name getLicenseHeaderIndex
	 */
	public int getLicenseHeaderIndex(String headerName) {
		int index = 1;
		for (WebElement header : we_license_table_headers()) {

			if (SeleniumHelper.getText(header).equals(headerName)) {
				break;
			}
			index++;
		}
		return index;
	}

	/**
	 * 
	 * @param {integer
	 *            trIndex}
	 * @param {integer
	 *            tdIndex}
	 * @return {String}
	 * @function
	 * @description This function is used to get the text of license cell
	 * @name getLicenseCellData
	 */
	public String getLicenseCellData(int trIndex, int tdIndex) {
		return SeleniumHelper.getText(we_license_cell_Text(trIndex, tdIndex));
	}

	/**
	 * 
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify pre-filling state of primary
	 *              practitioner state drop down on location of RFP
	 * @name verifyPrefiilingLocationsPrimaryPractState
	 */
	public boolean verifyPrefiilingLocationsPrimaryPractState(String practState) {
		if (!SeleniumHelper.getText(we_Locations_PractState()).equals(practState)) {
			return false;
		}
		if (SeleniumHelper.isElementSelected(we_Locations_PractState_Deflt())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify location section controls of
	 *              RFP page
	 * @name verifyLocationsControls
	 */
	public boolean verifyLocationsControls(RFPData data) {
		if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_Heading(data.getLocationsMainHdr()))) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_Heading(data.getLocationsSubHdr()))) {
			return false;
		}
		String[] hdrs = data.getLocationsHdrs().split(",");
		for (String hdr : hdrs) {

			if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_Header(hdr))) {
				return false;
			}

		}
		String[] cells = data.getLocationsCells().split(",");
		for (String cell : cells) {

			if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_CellText(cell))) {
				return false;
			}

		}
		for (String cell : cells) {
			switch (cell) {
			case "Billing":
				if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_ADD_BLNG_Btn())) {
					return false;
				}
				break;
			case "Place of Service":
				if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_ADD_PLSV_Btn())) {
					return false;
				}
				break;
			case "Credentialing":
				if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_ADD_CRED_Btn())) {
					return false;
				}
				break;
			}
		}
		return true;
	}

	/**
	 * @param {RFPData
	 *            data} that holds data members of RFP page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to verify the contract info section
	 *              controls and default nature
	 * @name verifyContractInfoSection
	 */
	public boolean verifyContractInfoSection(RFPData data) {
		if (!SeleniumHelper.isElementDisplayed(we_ContractInfo_TIN())) {
			return false;
		}
		if (!SeleniumHelper.getAttribute(we_ContractInfo_TIN(), "value").equals("#" + data.getContractTin())) {
			return false;
		}
	
		if (!SeleniumHelper.isElementDisplayed(we_ContractInfo_Cntr_Grp_Ddn())) {
			return false;
		}
		int num=1;
		while (!SeleniumHelper.getText(we_ContractInfo_Cntr_Grp_Ddn()).contains(data.getContractGroupDfltTxt())&&num<=3) {
			SeleniumHelper.sleep(1000);
			num++;
		}
		return true;

	}

	/**
	 * @param {RFPData
	 *            data} that holds data members of RFP page
	 * @return {boolean} returns true or false
	 * @function
	 * @description This function is used to select the value from contracting
	 *              group drop down
	 * @name selectItemFromContractingGroupDdn
	 */
	public boolean selectItemFromContractingGroupDdn(RFPData data) {

		if (!SeleniumHelper.clickElement(we_ContractInfo_Cntr_Grp_Ddn())) {
			return false;
		}
		int num=1;
		while(we_selectList()==null&&num<=3)
		{
			SeleniumHelper.sleep(1000);
			SeleniumHelper.clickElement(we_ContractInfo_Cntr_Grp_Ddn());
			num++;
		}
		String[] items = data.getContractGroups().split(",");
		for (String item : items) {
			if (!SeleniumHelper.selectOption(we_selectList(), item)) {
				return false;
			}
		}
		SeleniumHelper.tabOutElement(we_ContractInfo_Cntr_Grp_Ddn());
		return true;

	} 
	
	public boolean isSubmitRFPEnabled(AddContractInfoData contractInfoData, String dateType) {
		if(dateType.equals("valid")) {
			SeleniumHelper.enterText(we_ContractInfo_Practice_Start_Date(), contractInfoData.getValidDate());
		}else if(dateType.equals("invalid")) {
			SeleniumHelper.enterText(we_ContractInfo_Practice_Start_Date(), contractInfoData.getInValidDate());
		}				
		return SeleniumHelper.isElementEnabled(we_Submit_RFP());
	}	

	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify
	 *              PreFilledHospitalAffiliationRecords
	 * @name verifyPreFilledHospitalAffiliationRecords
	 */
	public boolean verifyPreFilledHospitalAffiliationRecords(RFPData data) {

		if (!getHospitalAffiliationNameCellData(getReqHspAflRowInd(data.getUniqueValue()),
				getHspAflHeaderIndex(hspaflHeaders[1]))

						.equals(data.getHospitalName())) {
			return false;
		}
		if (!getHospitalAffiliationCellData(getReqHspAflRowInd(data.getUniqueValue()),
				getHspAflHeaderIndex(hspaflHeaders[2])).equals(data.getPrivileges())) {
			return false;
		}
		if (!getHospitalAffiliationCellData(getReqHspAflRowInd(data.getUniqueValue()),
				getHspAflHeaderIndex(hspaflHeaders[3])).equals(data.getAdmittingProvider())) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify
	 *              UpdatedHospitalAffiliationRecords
	 * @name verifyUpdatedHospitalAffiliationRecords
	 */
	public boolean verifyUpdatedHospitalAffiliationRecords(RFPData data) {

		/*
		 * if (!getHospitalAffiliationNameCellData(getReqHspAflRowInd(data.
		 * getUniqueValue()), getHspAflHeaderIndex(hspaflHeaders[1]))
		 * 
		 * .equals(data.getHospitalName())) { return false; }
		 */
		if (!getHospitalAffiliationCellData(getReqHspAflRowInd(data.getUniqueValue()),
				getHspAflHeaderIndex(hspaflHeaders[2])).equals(data.getPrivileges())) {
			return false;
		}
		if (!getHospitalAffiliationCellData(getReqHspAflRowInd(data.getUniqueValue()),
				getHspAflHeaderIndex(hspaflHeaders[3])).equals(data.getAdmittingProvider())) {
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @param {Integer}
	 * @param {Integer}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get hospital affiliation cell data
	 * @name verifyUpdatedHospitalAffiliationRecords
	 */
	public String getHospitalAffiliationNameCellData(int trIndex, int tdIndex) {
		return SeleniumHelper.getText(we_hospital_affiliation_name_cell_Text(trIndex, tdIndex));
	}

	public String getHospitalAffiliationCellData(int trIndex, int tdIndex) {
		return SeleniumHelper.getText(we_hospital_affiliation_cell_Text(trIndex, tdIndex));
	}

	/**
	 * 
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get hospital row index
	 * @name getReqHspAflRowInd
	 */
	public int getReqHspAflRowInd(String uniqueValue) {
		int index = -1;
		for (WebElement lcnRecrd : we_hospital_affiliation_rows()) {

			index++;
			if (SeleniumHelper.getText(lcnRecrd).contains(uniqueValue)) {
				return index;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param {String}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get hospital header index
	 * @name getHspAflHeaderIndex
	 */

	public int getHspAflHeaderIndex(String headerName) {
		int index = 1;
		for (WebElement header : we_hspl_table_headers()) {

			if (SeleniumHelper.getText(header).equals(headerName)) {
				break;
			}
			index++;
		}
		return index;
	}

	/**
	 * @return {boolean} returns true or false
	 * @description This function is used to verify supervising controls
	 * @name verifySupervisingControls
	 */
	public boolean verifySupervisingControls() {

		if (!SeleniumHelper.isElementDisplayed(we_SuperVsng_LName())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SuperVsng_FName())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SuperVsng_Splcty_DDN())) {
			return false;
		}
		if (!SeleniumHelper.isElementDisplayed(we_SuperVsng_NPI())) {
			return false;
		}
		return true;
	}

	/**
	 * @param {EnterSupervisingPhysicianData
	 *            data} to hold Supervising Data page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to enter supervising physician
	 *              data
	 * @name enterSupervisingPhysicianInfo
	 */
	public boolean enterSupervisingPhysicianInfo(RFPData data) {
		if (data.getSupervisingLastName() != "") {
			SeleniumHelper.js_clearInput(we_SuperVsng_LName());
			if (!SeleniumHelper.enterText(we_SuperVsng_LName(), data.getSupervisingLastName())) {
				return false;
			}
		}
		if (data.getSupervisingFirstName() != "") {
			if (!SeleniumHelper.enterText(we_SuperVsng_FName(), data.getSupervisingFirstName())) {
				return false;
			}
		}
		if (data.getSupervisingSpecialty() != "") {
			if (!SeleniumHelper.clickElement(we_SuperVsng_Splcty_DDN())) {
				return false;
			}

			selectSpecialty(data);
			SeleniumHelper.tabOutElement(we_SuperVsng_Splcty_DDN());
		}
		if (data.getSupervisingNPI() != "") {
			if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), data.getSupervisingNPI())) {
				return false;
			}
			SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		}

		return true;
	}

	/**
	 * @param {SupervisingPhysicianData
	 *            data} Takes SupervisingPhysician data object containing the
	 *            datatable with the values passed from the feature file
	 * @return {Boolean}
	 * @function
	 * @description The below function is to select the specialty from the drop
	 *              down
	 * @name selectSpecialty
	 */
	public Boolean selectSpecialty(RFPData data) {
		String text = "";
		if (data.getSupervisingSpecialty().trim().toLowerCase().contains("random")) {
			text = SeleniumHelper.selectOption(we_select_Specialty_List(), data.getSupervisingSpecialtyInd());
			data.setSupervisingSpecialty(text);
			if (!text.equals(data.getSupervisingSpecialty())) {
				return false;
			}
		} else {
			if (!SeleniumHelper.selectOption(we_select_Specialty_List(), data.getSupervisingSpecialty())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param {SupervisingPhysicianData
	 *            data} to hold Practitioner Info data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to perform Supervising Physician
	 *              name fields error validations
	 * @name verifySupervisingPhysicianameFieldsErrorPrones
	 */
	public boolean verifySupervisingPhysicianNameFieldsErrorPrones(RFPData data) {

		// Entry of numeric characters
		// validation
		String value = AutomationBase.generateRandomString(data.getSupervisingLastNameCharLen(), "N");
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_LName());
		if (!SeleniumHelper.getAttribute(we_SuperVsng_LName(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getSupervisingLastNameCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_LName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_LName(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getSupervisingLastNameCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_LName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_LName(), "value").length() != data
				.getSupervisingLastNameCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getSupervisingLastNameCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), Constants.lName_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_LName());

		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getSupervisingLastNameCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_LName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_LName(), "value").equals(Constants.lName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_SuperVsng_LName(), data.getSupervisingLastName())) {
			return false;
		}

		// Fname

		// Entry of numeric characters
		// validation
		value = AutomationBase.generateRandomString(data.getSupervisingFirstNameCharLen(), "N");
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_FName());
		if (!SeleniumHelper.getAttribute(we_SuperVsng_FName(), "value").equals("")) {
			return false;
		}
		// Entry of alpha numeric
		// characters validation
		value = AutomationBase.generateRandomString(data.getSupervisingFirstNameCharLen(), "AN");
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_FName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_FName(), "value").equals(value)) {
			return false;
		}
		// Entry of alpha characters
		// exceeding validation
		value = AutomationBase.generateRandomString(data.getSupervisingFirstNameCharLen() + Constants.two, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_FName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_FName(), "value").length() != data
				.getSupervisingFirstNameCharLen()) {
			return false;
		}
		// Entry of alpha characters
		// with special chars validation
		value = AutomationBase.generateRandomString(data.getSupervisingFirstNameCharLen() - Constants.six, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), Constants.fName_Spl_Char + value)) {
			return false;
		}

		// Entry of alpha characters
		// with special chars and
		// numerics validation
		value = AutomationBase.generateRandomString(data.getSupervisingFirstNameCharLen() - Constants.seven, "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_FName());
		if (SeleniumHelper.getAttribute(we_SuperVsng_FName(), "value").equals(Constants.fName_Num_Spl_Char + value)) {
			return false;
		}
		// Entry of alphabets validation
		if (!SeleniumHelper.enterText(we_SuperVsng_FName(), data.getSupervisingFirstName())) {
			return false;
		}

		return true;
	}

	/**
	 * @param {SupervisingPhysicianData
	 *            data} to hold Practitioner Info page data members
	 * @return {boolean} returns True to false
	 * @function
	 * @description The below function is used to perform provider NPI field
	 *              validations
	 * @name validateSupervisingPhysicianNPIField
	 */
	public boolean validateSupervisingPhysicianNPIField(RFPData data) {

		// Validating alpha character
		// entry
		String value = AutomationBase.generateRandomString(data.getSupervisingNPICharLen(), "AB");
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (!SeleniumHelper.getAttribute(we_SuperVsng_NPI(), "value").equals("")) {
			return false;
		}
		// Validating alpha numeric
		// character entry

		value = AutomationBase.generateRandomString(data.getSupervisingNPICharLen(), "AN");
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (SeleniumHelper.getAttribute(we_SuperVsng_NPI(), "value").equals(value)) {
			return false;
		}

		// Validating numeric with
		// special char character entry
		value = AutomationBase.generateRandomString(data.getSupervisingNPICharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), Constants.spl_Char + value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (SeleniumHelper.getAttribute(we_SuperVsng_NPI(), "value").equals(Constants.spl_Char + value)) {
			return false;
		}

		// Validating character limit
		// exceeding entry
		value = AutomationBase.generateRandomString(data.getSupervisingNPICharLen() + Constants.two, "N");
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (SeleniumHelper.getAttribute(we_SuperVsng_NPI(), "value").length() != data.getSupervisingNPICharLen()) {
			return false;
		}

		// Validating character limit
		// not exceeding error
		value = AutomationBase.generateRandomString(data.getSupervisingNPICharLen() - Constants.two, "N");
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg_Supervising()).equals(data.getSupervisingNpiLuhnErr())) {
			return false;
		}

		// Validating LUHN error
		value = Constants.inValidNPI;
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (!SeleniumHelper.getText(we_NPI_ErrMsg_Supervising()).equals(data.getSupervisingNpiLuhnErr())) {
			return false;
		}

		// validating normal entry
		// value = getLuhnFormatNPI(Long.parseLong(data.getNPI()));
		value = "1013919851";
		if (!SeleniumHelper.enterText(we_SuperVsng_NPI(), value)) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (SeleniumHelper.getAttribute(we_SuperVsng_NPI(), "value").length() != data.getSupervisingNPICharLen()) {
			return false;
		}
		SeleniumHelper.tabOutElement(we_SuperVsng_NPI());
		if (!SeleniumHelper.isElementDisplayed(we_NPI_ErrMsg_Supervising())) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to add location screen
	 * @name navigateToAddaLocationScreen
	 */
	public boolean navigateToAddaLocationScreen(RFPData data) {
		String locationType = data.getLocationType();
		switch (locationType) {
		case "Billing":
			if (!SeleniumHelper.clickElement(we_RFP_Location_ADD_BLNG_Btn())) {
				return false;
			}
			break;
		case "Place of Service":
			if (!SeleniumHelper.clickElement(we_RFP_Location_ADD_PLSV_Btn())) {
				return false;
			}
			break;
		case "Credentialing":
			if (!SeleniumHelper.clickElement(we_RFP_Location_ADD_CRED_Btn())) {
				return false;
			}
			break;
		}
		if (!SeleniumHelper.getText(we_RFP_Location_ADD_Location_Title()).equals(data.getAddLocationTitle())) {
			return false;
		}
		return true;
	}

	/**
	 * @return {boolean}
	 * @function
	 * @description This function is used to submit RFP screen
	 * @name submitRFP
	 */
	public boolean submitRFP() {
		if (!SeleniumHelper.clickElement(we_Submit_RFP())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to add location screen
	 * @name navigateToAddaLocationScreen
	 */
	public boolean verifyPencilIcon(RFPData data) {
		String locationType = data.getLocationType();
		switch (locationType) {
		case "Billing":
			if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_EDIT_BLNG_Btn())) {
				return false;
			}
			break;
		case "Place of Service":
			if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_EDIT_PLSV_Btn())) {
				return false;
			}
			break;
		case "Credentialing":
			if (!SeleniumHelper.isElementDisplayed(we_RFP_Location_EDIT_CRED_Btn())) {
				return false;
			}
			break;
		}
	return true;
	}
	
	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to navigate to edit location screen
	 * @name navigateToEditLocationScreen
	 */
	public boolean navigateToEditLocationScreen(RFPData data) {
		String locationType = data.getLocationType();
		switch (locationType) {
		case "Billing":
			if (!SeleniumHelper.clickElement(we_RFP_Location_EDIT_BLNG_Btn())) {
				return false;
			}
			break;
		case "Place of Service":
			if (!SeleniumHelper.clickElement(we_RFP_Location_EDIT_PLSV_Btn())) {
				return false;
			}
			break;
		case "Credentialing":
			if (!SeleniumHelper.clickElement(we_RFP_Location_EDIT_CRED_Btn())) {
				return false;
			}
			break;
		}
		if (!SeleniumHelper.getText(we_RFP_Location_EDIT_Location_Title()).equals(data.getEditLocationTitle())) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param {RFPData}
	 * @return {boolean}
	 * @function
	 * @description This function is used to verify updated location screen
	 * @name verifyUpdatedAddress
	 */
	public boolean verifyUpdatedAddress(RFPData data) {
		String locationType = data.getLocationType();
		switch (locationType) {
		case "Billing":
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedStreetAddress()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedCity()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedState()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedZipCode()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedPhone()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("bill")).contains(data.getUpdatedFax()))
			{
				return false;
			}
			break;
		case "Place of Service":
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedStreetAddress()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedCity()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedState()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedZipCode()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedPhone()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("plsv")).contains(data.getUpdatedFax()))
			{
				return false;
			}
			break;
		case "Credentialing":
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedStreetAddress()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedCity()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedState()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedZipCode()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedPhone()))
			{
				return false;
			}
			if(!SeleniumHelper.getText(we_UPDATED_ADDRS("cred")).contains(data.getUpdatedFax()))
			{
				return false;
			}
			break;
		}
		return true;
	}
}
