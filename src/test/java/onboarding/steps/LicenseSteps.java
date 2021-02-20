package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.DeleteLicenseData;
import onboarding.dataobjects.EditLicenseData;
import procraft.core.utilities.automationbase.Assertions;

public class LicenseSteps extends MasterSteps {

	@Then("^I can see the below license header information$")
	public void verify_License_Header_Elements(DataTable arg1) {
		Assertions.assertTrue("Licenses Page Header Elements not seen", getRFPPage().verifyLicensesHeaderElements());
	}

	@And("^I click on Add License$")
	public void click_Add_License() {
		Assertions.assertTrue("Add License Page cannot be clicked", getRFPPage().clickAddLicense());
	}

	@Then("^I can see previous saved information on edit license window as mentioned below$")
	public void iCanSeePreviousSavedInformationOnEditLicenseWindowAsMentionedBelow(DataTable arg1)  {
		editLicenseData=new EditLicenseData(arg1);
		Assertions.assertTrue("Previous saved info was not displayed as expected on 'Edit License' modal",
				getEditLicensePage().validatePreviousSavedInfo(editLicenseData));
	}

	@When("^I update below information and cancel the edit license modal$")
	public void iUpdateBelowInformationAndCancelTheEditLicenseModal(DataTable arg1) {
		editLicenseData=new EditLicenseData(arg1);
		Assertions.assertTrue("Populating data on 'Edit License' modal was failed",
				getEditLicensePage().populateLicenseData(editLicenseData));
		Assertions.assertTrue("Cancelng the edit license was failed",
				getEditLicensePage().DonNotsubmitForm());
	}

	@When("^I update below information and save license$")
	public void iUpdateBelowInformationAndSaveLicense(DataTable arg1)  {
		editLicenseData=new EditLicenseData(arg1);
		Assertions.assertTrue("Populating data on 'Edit License' modal was failed",
				getEditLicensePage().populateLicenseData(editLicenseData));
		Assertions.assertTrue("Saving the edit license was failed",
				getEditLicensePage().submitForm());
	}

	@When("^I cancel deleting below license information$")
	public void iCancelDeletingBelowLicenseInformation(DataTable arg1) {
		deleteLicenseData = new DeleteLicenseData(arg1);
		Assertions.assertTrue("Cancel deleting license record was failed ",
				getDelLicensePage().dontDeleteRecord(deleteLicenseData));
	}

	@When("^I delete below license information$")
	public void iDeleteBelowLicenseInformation(DataTable arg1)  {
		deleteLicenseData = new DeleteLicenseData(arg1);
		Assertions.assertTrue("Deleting license record was failed ",
				getDelLicensePage().deleteRecord(deleteLicenseData));
	}
}
