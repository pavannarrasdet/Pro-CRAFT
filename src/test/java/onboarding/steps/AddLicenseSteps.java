package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.AddLicenseData;
import procraft.core.utilities.automationbase.Assertions;

public class AddLicenseSteps extends MasterSteps {

	@Then("^I can see the below Add license modal controls information$")
	public void verify_Add_License_Header_Elements(DataTable arg1) {
		Assertions.assertTrue("Add License Page Header Elements not seen",
				getAddLicensesPage().verifyAddLicensesHeaderElements());
	}

	@Then("^I can see the below headers$")
	public void verify_Headers(DataTable arg1) {
		Assertions.assertTrue("License Type headers not seen",
				getAddLicensesPage().verifyHeaderElementsAfterSelectingLicenseType());
	}

	@And("^I select license type$")
	public void select_license_type(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("License Type cannot be selected",
				getAddLicensesPage().selectLicenseType(addlicensedata));
	}

	@Then("^I can add below license information$")
	public void add_license_info(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("License data cannot be added", getAddLicensesPage().populateLicenseData(addlicensedata));

	}

	@Then("^Perform State Licnese functionality as mentioned below$")
	public void performStateLicneseDropdownFunctionalityAsMentionedBelow(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("Verification Of State License functionality was failed", getAddLicensesPage().verifyStateLicenseFunctionality(addlicensedata));
	}

	@Then("^Perform CDS License functionality as mentioned below$")
	public void performCDSDropdownFunctionalityAsMentionedBelow(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("Verification Of CDS License functionality was failed", getAddLicensesPage().verifyCDSLicenseFunctionality(addlicensedata));
	}

	@Then("^Perform Federal DEA License functionality as mentioned below$")
	public void performFederalDEADropdownFunctionalityAsMentionedBelow(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("Verification Of Federal DEA License functionality was failed", getAddLicensesPage().verifyFederalDEALicenseFunctionality(addlicensedata));
	}

	@Then("^Perform Medicare License functionality as mentioned below$")
	public void performMedicareDropdownFunctionalityAsMentionedBelow(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("Verification Of Medicare License functionality was failed", getAddLicensesPage().verifyMedicareLicenseFunctionality(addlicensedata));
	}

	@Then("^Perform Medicaid License functionality as mentioned below$")
	public void performMedicaidDropdownFunctionalityAsMentionedBelow(DataTable arg1) {
		addlicensedata = new AddLicenseData(arg1);
		Assertions.assertTrue("Verification Of Medicaid License functionality was failed", getAddLicensesPage().verifyMedicaidLicenseFunctionality(addlicensedata));
	}

	@When("^user canceladd license modal$")
	public void userCanceladdLicenseModal() {
		Assertions.assertTrue("Add License modal Cancel functionality was failed",
				getAddLicensesPage().DonNotsubmitForm());
	}

	@When("^user submits the add license modal window$")
	public void userSubmitsTheAddLicenseModalWindow()  {
		Assertions.assertTrue("Add License modal Submission' was failed",
				getAddLicensesPage().submitForm());
	}
}
