package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.AddContractInfoData;
import onboarding.dataobjects.AddLocationData;
import onboarding.dataobjects.AddProviderData;
import onboarding.dataobjects.EditAffiliatedHospitalData;
import onboarding.dataobjects.RFPData;
import onboarding.pages.AcknowledgementAndSubmitPage;
import procraft.core.utilities.automationbase.Assertions;
import procraft.core.utilities.automationbase.ReportHelper;

public class RFPSteps extends MasterSteps {

	@Then("^I am brought to the RFP page$")
	public void iAmBroughtToTheRFPPage() {
		Assertions.assertTrue("RFP page was not displayed", getRFPPage().isRFPPageExist());
	}

	@Then("^I can see the following information on RFP page$")
	public void iCanSeeTheFollowingInformationOnRFPPage(DataTable arg1) {
		addproviderdata = new AddProviderData(arg1);
		Assertions.assertTrue("RFP page was not displayed",
				getRFPPage().verifyHdrRibnDshBrdAndGrayCntrls(getDashBoardPage(), addproviderdata));
	}

	@And("^I can see the following practitioner info fields$")
	public void iCanSeeTheFollowingPractitionerInfoFields(DataTable arg1) {
		Assertions.assertTrue("RFP page was not displayed with practitioner info fields",
				getRFPPage().verifyPractInfoControls());
	}

	@And("^I can see the following fields pre-populated$")
	public void iCanSeeTheFollowingFieldsPrePopulated(DataTable arg1) {
		Assertions.assertTrue("Specified practitioner info fields were not prepopulated",
				getRFPPage().verifyProviderInfoPrepopulatedFields(addproviderdata));

	}

	@When("^I navigate to \"([^\"]*)\" via bubble navigation$")
	public void iNavigateToViaBubbleNavigation(String arg1) {
		Assertions.assertTrue("Bubble navigation was failed for given menu '" + arg1 + "'",
				getRFPPage().bubbleNavigation(arg1));
	}

	@When("^I navigate to add affiliated hospital modal with given title \"([^\"]*)\"$")
	public void iNavigateToAddAffiliatedHospitalModalWithGivenTitle(String arg1) {
		Assertions.assertTrue("Navigation of 'Add affiliated hospital' dialog was failed",
				getRFPPage().navigateToAddAffiliatedHospital(arg1));
	}

	@Then("^I must see the following hospital affiliation fields on RFP page$")
	public void iMustSeeTheFollowingHospitalAffiliationFieldsOnRFPPage(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of hospital affiliated controls on RFP page was failed ",
				getRFPPage().verifyHsptlAflControls(rfpData));
	}

	@Then("^I can see current affiliations details as mentioned below$")
	public void iCanSeeCurrentAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyHospitalAffiliationRecord(rfpData));
	}

	@And("^I click on the medical license section of the RFP$")
	public void click_medical_license_section() {
		Assertions.assertTrue("Licenses Page cannot be clicked", getRFPPage().clickLicenseBubble());
	}

	@Then("^Verify Suffix dropdown values as mentioned below$")
	public void verifySuffixDropdownValuesAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Suffix dropdown items were not displayed as expected",
				getRFPPage().verifySuffixDropdown(rfpData));
	}

	@Then("^Verify Degree dropdown values as mentioned below$")
	public void verifyDegreeDropdownValuesAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Degree dropdown items were not displayed as expected",
				getRFPPage().verifyDegreeDropdown(rfpData));
	}

	@Then("^Verify Gender dropdown values as mentioned below$")
	public void verifyGenderDropdownValuesAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Gender dropdown items were not displayed as expected",
				getRFPPage().verifyGenderDropdown(rfpData));
	}

	@Then("^Validate DOB field on Pract info section$")
	public void validateDOBFieldOnPractInfoSection(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("DOB field validations were failed", getRFPPage().dobFieldValidations(rfpData));
	}

	@Then("^Validate Expiration Date field on Pract info section$")
	public void validateExpirationDateFieldOnPractInfoSection(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("DOB field validations were failed", getRFPPage().expDateFieldValidations(rfpData));
	}

	@Then("^Verify selection of PCP designation$")
	public void verifySelectionOfPCPDesignation() {
		Assertions.assertTrue("Selection of PCP Degination radio buttons was failed",
				getRFPPage().selectPCPDeshRadioBtns());
	}

	@Then("^Verify selection of Board Certified values$")
	public void verifySelectionOfBoardCertifiedValues() {
		Assertions.assertTrue("Selection of Board Certifed radio buttons was failed",
				getRFPPage().selectBoardCertRadioBtns());
	}

	@Then("^I can not see current affiliations details as mentioned below$")
	public void iCanNotSeeCurrentAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of Cancellation of hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyCancellingHospitalAffiliationRecord(rfpData));
	}

	@When("^I navigate to add license modal with given title \"([^\"]*)\"$")
	public void iNavigateToAddLicenseModalWithGivenTitle(String arg1) {
		Assertions.assertTrue("Navigation of 'Add License modal' window was failed",
				getRFPPage().navigateToAddLicense(arg1));
	}

	@Then("^I can see current licenses details as mentioned below$")
	public void iCanSeeCurrentLicensesDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of License record on RFP page was failed ",
				getRFPPage().verifyLicenseRecord(rfpData));
	}

	@When("^I navigate to edit affiliated hospital modal with given title \"([^\"]*)\"$")
	public void iNavigateToEditAffiliatedHospitalModalWithGivenTitle(String title, DataTable arg2) {
		rfpData = new RFPData(arg2);
		Assertions.assertTrue("Navigation of edit hospital affiliated window was failed ",
				getRFPPage().navigateToEditHospitalAffiliationModal(rfpData, title));
	}

	@Then("^I can see updated affiliations details as mentioned below$")
	public void iCanSeeUpdatedAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of updated hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyHospitalAffiliationRecord(rfpData));
	}

	@When("^I navigate to remove affiliated hospital modal with given title \"([^\"]*)\"$")
	public void iNavigateToRemoveAffiliatedHospitalModalWithGivenTitle(String title, DataTable arg2) {
		rfpData = new RFPData(arg2);
		Assertions.assertTrue("Navigation of remove hospital affiliated window was failed ",
				getRFPPage().navigateToDelHospitalAffiliationModal(rfpData, title));
	}

	@Then("^I can not see deleted hospital affiliations details as mentioned below$")
	public void iCanNotSeeDeletedHospitalAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Cancellation of deleted hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyCancellingHospitalAffiliationRecord(rfpData));
	}

	@Then("^I can see affiliations details as mentioned below$")
	public void iCanSeeAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of existense hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyHospitalAffiliationRecord(rfpData));
	}

	@Then("^I can not see updated affiliations details as mentioned below$")
	public void iCanNotSeeUpdatedAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Cancellation of edit hospital affiliated record on RFP page was failed ",
				getRFPPage().veirfyCancellingHospitalAffiliationRecord(rfpData));
	}

	@When("^I navigate to edit license modal with given title \"([^\"]*)\"$")
	public void iNavigateToEditLicenseModalWithGivenTitle(String title, DataTable arg2) {
		rfpData = new RFPData(arg2);
		Assertions.assertTrue("Navigation of Edit License modal window was failed",
				getRFPPage().navigateToEditLicenseModal(rfpData, title));

	}

	@Then("^I can not see updated license details as mentioned below$")
	public void iCanNotSeeUpdatedLicenseDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertFalse("Cancellation of edit license record on RFP page was failed ",
				getRFPPage().verifyLicenseRecord(rfpData));
	}

	@Then("^I can see updated license details as mentioned below$")
	public void iCanSeeUpdatedLicenseDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of License record on RFP page was failed ",
				getRFPPage().verifyLicenseRecord(rfpData));
	}

	@When("^I navigate to remove license modal with given title \"([^\"]*)\"$")
	public void iNavigateToRemoveLicenseModalWithGivenTitle(String title, DataTable arg2) {
		rfpData = new RFPData(arg2);
		Assertions.assertTrue("Navigation of Edit License modal window was failed",
				getRFPPage().navigateToDelLicenseModal(rfpData, title));
	}

	@Then("^I can see license details as mentioned below$")
	public void iCanSeeLicenseDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of License record on RFP page was failed ",
				getRFPPage().verifyLicenseRecord(rfpData));
	}

	@Then("^I can not see deleted license details as mentioned below$")
	public void iCanNotSeeDeletedLicenseDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertFalse("Cancellation of deleteing license record on RFP page was failed ",
				getRFPPage().verifyLicenseRecord(rfpData));
	}

	@And("^I can see all practitioner fields must be pre-populated and readonly$")
	public void iCanSeeAllPractitionerFieldsMustBePrePopulatedAndReadonly(DataTable rfpTable) {
		rfpData = new RFPData(rfpTable);
		addproviderdata = new AddProviderData(rfpTable);
		Assertions.assertTrue("Validation of pre-filling practitioner data was failed ",
				getRFPPage().verifyProviderInfoPrepopulatedReadOnlyFields(addproviderdata, rfpData));
	}

	@Then("^I can see the below attachment information message$")
	public void iCanSeeTheBelowAttachmentInformationMessage(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification on attachemnt info message was failed ",
				getRFPPage().verifyAttachmentInfoMessage(rfpData));
	}

	@And("^I can see pre-populated license fields as mentioned below$")
	public void iCanSeePrePopulatedLicenseFieldsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of pre filled License record on RFP page was failed ",
				getRFPPage().verifyPreFilledLicenseRecords(rfpData));
	}

	@Then("^the primary practice state dropdown field should be auto-filled and disabled\"([^\"]*)\"$")
	public void thePrimaryPracticeStateDropdownFieldShouldBeAutoFilled(String practState) {
		Assertions.assertTrue("Verification of pre filled primary practice state drodown was failed ",
				getRFPPage().verifyPrefiilingLocationsPrimaryPractState(practState));
	}

	@Then("^verify below controls on locations section of RFP$")
	public void verifyBelowControlsOnLocationsSectionOfRFP(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of location section controls was failed ",
				getRFPPage().verifyLocationsControls(rfpData));
	}

	@And("^I can see pre-populated Hospital Affiliation records as mentioned below$")
	public void iCanSeePrePopulatedHospitalAffiliationRecordsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of pre filled Hospital Affiliation record on RFP page was failed ",
				getRFPPage().verifyPreFilledHospitalAffiliationRecords(rfpData));
	}

	@Then("^I can see updated hospital affiliations details as mentioned below$")
	public void iCanSeeUpdatedHospitalAffiliationsDetailsAsMentionedBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of pre filled Hospital Affiliation record on RFP page was failed ",
				getRFPPage().verifyUpdatedHospitalAffiliationRecords(rfpData));
	}

	@Then("^verify below controls on contract info section of RFP$")
	public void verifyBelowControlsOnContractInfoSectionOfRFP(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of contract info section controls was failed ",
				getRFPPage().verifyContractInfoSection(rfpData));
	}

	@Then("^user should be able to select below contracting groups$")
	public void userShouldBeAbleToSelectBelowContractingGroups(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of selection of contract group was failed ",
				getRFPPage().selectItemFromContractingGroupDdn(rfpData));
	}

	@And("^I can see the following supervising physician fields if request supervising physician is True$")
	public void iCanSeeTheFollowingSupervisingPhysicianFieldsIfRequestSupervisingPhysicianIsTrue(DataTable arg1) {
		Assertions.assertTrue("RFP page was not displayed with supervising physician fields",
				getRFPPage().verifySupervisingControls());
	}

	@Then("^perform supervising physician name fields validation as below$")
	public void performSupervisingPhysicianNameFieldsValidationsAsBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Validations of Supervising Physician Names fields were failed",
				getRFPPage().verifySupervisingPhysicianNameFieldsErrorPrones(rfpData));
	}

	@Then("^perform supervising physician npi field validations as below$")
	public void performSupervisingPhysicianNpiFieldsValidationsAsBelow(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Validations of Supervising Pysician NPI field were failed",
				getRFPPage().validateSupervisingPhysicianNPIField(rfpData));
	}

	@Then("^I enter below information$")
	public void iEnterBelowInformation(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Add provider information failed", getRFPPage().enterSupervisingPhysicianInfo(rfpData));
	}

	@When("^I navigate to Add Location Page$")
	public void iNavigateToAddLocationPage(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of selection of contract group was failed ",
				getRFPPage().navigateToAddaLocationScreen(rfpData));
	}

	@Then("^Verify \"([^\"]*)\" section and populate missing fields$")
	public void verifySectionAndPopulateMissingFields(String menuName, DataTable data) {
		rfpData = new RFPData(data);
		addLocationData = new AddLocationData(data);
		editAffliatedData = new EditAffiliatedHospitalData(data);
		Assertions.assertTrue("Verification of RFP sections", getRFPPage().verifyRFPSections(menuName, rfpData,
				getAddLocationPage(), addLocationData, getEditHsptlAfltPage(), editAffliatedData));

	}
	
	@And("^Verify if SubmitRFP is \"([^\"]*)\" for \"([^\"]*)\" date$")
	public void verify_if_SubmitRFP_is_enabled_for_date(DataTable data, String rfpButton, String dateType) throws Throwable {
		addContractInfoData = new AddContractInfoData(data);
		if(rfpButton.equals("enabled")) {
		Assertions.assertTrue("RFP Button is not enabled for given valid date", getRFPPage().isSubmitRFPEnabled(addContractInfoData, dateType));
		}else if(rfpButton.equals("disabled")) {
		Assertions.assertFalse("RFP Button is not enabled for invalid date", getRFPPage().isSubmitRFPEnabled(addContractInfoData, dateType));
		}
	}
	
	@And("^Verify if SubmitRFP is enabled for \"([^\"]*)\" date$")
	public void verify_if_SubmitRFP_is_enabled_for_date(String dateType, DataTable data) throws Throwable {
		addContractInfoData = new AddContractInfoData(data);		
		Assertions.assertTrue("RFP Button is not enabled for valid date", getRFPPage().isSubmitRFPEnabled(addContractInfoData, dateType));	
	}
	
	@And("^Verify if SubmitRFP is not enabled for \"([^\"]*)\" date$")
	public void verify_if_SubmitRFP_is_not_enabled_for_date(String dateType, DataTable data) throws Throwable {
		addContractInfoData = new AddContractInfoData(data);		
		Assertions.assertFalse("RFP Button is not enabled for invalid date", getRFPPage().isSubmitRFPEnabled(addContractInfoData, dateType));	
	}	

	@When("^I Submit RFP form$")
	public void iSubmitRFPForm() {
		Assertions.assertTrue("Sumission of RFP was failed", getRFPPage().submitRFP());
	}

	@Then("^I can perform below validations$")
	public void iCanPerformBelowValidations(DataTable data) {
		rfpData = new RFPData(data);
		Assertions.assertTrue("Verification of Acknowledgement and submit window was failed",
				getAckSubPage().verifyAckSubmitModalControls(rfpData));
		Assertions.assertTrue("Validation of attestor name text box was failed",
				getAckSubPage().validateAttstrNameAndCancelBtn(rfpData, getRFPPage()));
	}

	@Then("^I must navigate to Acknowledgement window$")
	public void iMustNavigateToAcknowledgementWindow(DataTable data) {
		rfpData = new RFPData(data);
		Assertions.assertTrue("Sumission of RFP was failed", getRFPPage().verifyAcknowledgeAndSubmitWindow(rfpData));
	}

	@When("^I Attest the modal with below data$")
	public void iAttestTheModalWithBelowData(DataTable data) {
		rfpData = new RFPData(data);
		Assertions.assertTrue("Attesting of RFP was failed", getAckSubPage().attestRFP(rfpData));
	}

	@Then("^I must see success message with confirmation number$")
	public void iMustSeeSuccessMessageWithConfirmationNumber(DataTable data) {
		rfpData = new RFPData(data);
		Assertions.assertTrue("Verification of attestation success message and capturing reference number was failed ",
				getAckSubPage().validateSuccessMsgAndCaptureCR(rfpData));
		ReportHelper.logStepDetails("CR number was.." + AcknowledgementAndSubmitPage.getCrNumber());
	}

	@When("^I close the attest modal$")
	public void iCloseTheAttestModal() {
		Assertions.assertTrue("Closing attest modal was failed ",
				getAckSubPage().cancelWindow());
	}
	
	@And("^Verify pencil icon when an address is successfully added$")
	public void verifyPencilIconWhenAnAddressIsSuccessfullyAdded(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of pencil icon was failed ",
				getRFPPage().verifyPencilIcon(rfpData));
	}
	
	@When("^I navigate to Edit Location Page$")
	public void iNavigateToEditLocationPage(DataTable arg1) {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of selection of contract group was failed ",
				getRFPPage().navigateToEditLocationScreen(rfpData));
	}
	
	@And("^I verify the updated address in the modal$")
	public void iVerifyTheUpdatedAddressInTheModal(DataTable arg1)  {
		rfpData = new RFPData(arg1);
		Assertions.assertTrue("Verification of Add Location Controls was failed ",
				getRFPPage().verifyUpdatedAddress(rfpData));
	}
}
