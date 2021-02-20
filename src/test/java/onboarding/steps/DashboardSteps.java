package onboarding.steps;

import cucumber.api.java.en.And;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.DashBoardData;
import procraft.core.utilities.automationbase.Assertions;

public class DashboardSteps extends MasterSteps {

	@When("^I navigate to Onboarding self service page with given title \"([^\"]*)\"$")
	public void iNavigatesToOnboardingSelfServicePageWithGivenTitle(String expTitle) {
		Assertions.assertTrue("Onboarding page was not found", getDashBoardPage().validateDashboard(expTitle));
	}

	@Then("^user navigates to Onboarding self service page with given title \"([^\"]*)\"$")
	public void I_navigate_to_onboarding_page(String expTitle) {
		Assertions.assertTrue("Onboarding page was not found", getDashBoardPage().validateDashboard(expTitle));
	}

	@Then("^I can see the following information on Landing page$")
	public void iCanSeeTheFollowingInformationOnLandingPage(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Verification of 'Landing page / Dashboard page info was failed",
				getDashBoardPage().verifyControls(dashBoardData));
	}

	@And("^navigate to add provider modal with given title \"([^\"]*)\"$")
	public void navigateToAddProviderModalwithGivenTitle(String arg1) {
		Assertions.assertTrue("Navigation of 'Add Provider modal' window was failed",
				getDashBoardPage().nvigateToAddProvider(arg1));
	}

	@And("^user can see the associated organizations and tax ID$")
	public void get_the_org_and_tin() {
		Assertions.assertTrue("Organization and TIN is not displayed", getDashBoardPage().validateOrgTin());
	}

	@Then("^user can see the list of groups names with default value as \"([^\"]*)\"$")
	public void userCanSeeTheListOfGroupsNamesWithDefaultValueAs(String arg1) {
		Assertions.assertTrue("Group name drop down validation was failed",
				getDashBoardPage().validateGroupDropDown(arg1));
		
	}

	@Then("^user can select the below Group and TIN$")
	public void userCanSelectTheBelowGroupAndTIN(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Selection of group and tin was failed",
				getDashBoardPage().verifySelectionOfGroupAndTin(dashBoardData));
	}

	@Then("^I see the below header elements$")
	public void verify_Header_Elements(DataTable arg1) {
		Assertions.assertTrue("Header Elements not seen", getDashBoardPage().verifyHeaderElements());
	}

	@Then("^I see the record displayed$")
	public void verify_Record_Displayed(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Record is not Displayed on the dashboard page",
				getDashBoardPage().verifyRecord(dashBoardData));
	}

	@And("^I click Next Steps button$")
	public void click_Next_Steps() {
		Assertions.assertTrue("Next Steps button cannot be clicked", getDashBoardPage().clickNextSteps());
	}

	@When("^user selects the below Group and TIN$")
	public void userSelecsTheBelowGroupAndTIN(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Selection of group and tin was failed",
				getDashBoardPage().verifySelectionOfGroupAndTin(dashBoardData));
	}

	@Then("^Add Provider button should be active and enabled$")
	public void addProviderButtonShouldBeActiveAndEnabled() {
		Assertions.assertTrue("Verification of  Add Provider button state was failed",
				getDashBoardPage().isAddProviderBtnActive());
	}

	@When("^user selects the below Group$")
	public void userSelectsTheBelowGroup(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Selection of group was failed",
				getDashBoardPage().selectItemFromGroupDdn(dashBoardData));
	}

	@Then("^Add Provider button should be in-active$")
	public void addProviderButtonShouldBeInActive() {
		Assertions.assertFalse("Verification of  Add Provider button state was failed",
				getDashBoardPage().isAddProviderBtnActive());
	}

	@When("^user selects the below TIN$")
	public void userSelectsTheBelowTIN(DataTable arg1) {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Selection of TIN was failed", getDashBoardPage().selectItemFromTINdDn(dashBoardData));
	}

	@Then("^I am brought to the dashboard page$")
	public void iAmBroughtToTheDashboardPage() {
		Assertions.assertTrue("Dashboard content was not displayed", getDashBoardPage().verifyDashBoardContent());
	}

	@Then("^I must see the practitioner record on status tracker page$")
	public void iMustSeeThePractitionerRecordOnStatusTrackerPageAtTop(DataTable data) {
		dashBoardData = new DashBoardData(data);
		Assertions.assertTrue("Specified RFP record was not found as expected",
				getDashBoardPage().verifyRFPRecord(dashBoardData));
	}

	@When("^I Begin RFP for an in-progress record as mentioned below$")
	public void iBeginRFPForAnInProgressRecordAsMentionedBelow(DataTable dta)  {
		dashBoardData = new DashBoardData(dta);
		Assertions.assertTrue("Begin RFP was not working as expected",
				getDashBoardPage().beginRFP(dashBoardData));
	}

	@Then("^I must see below information text on dashboard page$")
	public void iMustSeeBelowInformationTextOnDashboardPage(DataTable dta)  {
		dashBoardData = new DashBoardData(dta);
		Assertions.assertTrue("Verification of default text on dash board was failed",
				getDashBoardPage().verifyDshBrdPgeDefaultSt(dashBoardData));
	}

	@Then("^I must see add provider info on dashboard page$")
	public void iMustSeeAddProviderInfoOnDashboardPage(DataTable dta)  {
		dashBoardData = new DashBoardData(dta);
		Assertions.assertTrue("Verification of add provider info text on dash board was failed",
				getDashBoardPage().verifyDshBrdPgeAdPrvInfAftrGrpTinSelect(dashBoardData));
	}
	
	@Then("^I can see below data fields on provider record that is linked to Optum Behavioral Health decision$")
	public void i_can_see_below_data_fields_on_provider_record_that_is_linked_to_Optum_Behavioral_Health_decision(DataTable arg1) throws Throwable {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Verification of provider info at record level has failed",
				getDashBoardPage().verifyRFPRecordData(dashBoardData));
		Assertions.assertTrue("Verification of actions of ContactUs Link and GoToSite has failed",
				getDashBoardPage().verifyClickOnButtonsInRecord(dashBoardData));
	}
	
	@Then("^I must see the cred not allowed record on status tracker page$")
	public void iMustSeeTheCredNotAllowedRecordOnStatusTrackerPage(DataTable arg1) throws Throwable {
		dashBoardData = new DashBoardData(arg1);
		Assertions.assertTrue("Verification of cred not allowed info at record level has failed",
				getDashBoardPage().verifyCredNotAllowedRecord(dashBoardData));
		Assertions.assertTrue("User cannot click Contact_Us button", getDashBoardPage().clickContactUsButton(dashBoardData));
	}
	
}
