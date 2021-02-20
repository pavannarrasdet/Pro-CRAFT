package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.AddAffiliatedHospitalData;
import procraft.core.utilities.automationbase.Assertions;

public class AddAffiliationSteps extends MasterSteps {
	

	@Then("^I must see below controls on Add Affiliated Hospital modal$")
	public void iMustSeeBelowControlsOnAddAffiliatedHospitalModal(DataTable arg1)  {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Expected controls were not present on Add Affiliated Hospital modal",
				getAddAffiliatedHospitalPage().verifyControls(addAffHspData));
	}

	@And("^perform fields validations on modal$")
	public void performFieldsValidationsOnModal(DataTable arg1)  {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations on Add Affiliated Hospital modal was failed",
				getAddAffiliatedHospitalPage().validations(addAffHspData));
	}

	@And("^verify viewing admitting physician fields$")
	public void verifyViewingAdmittingPhysicianFields(DataTable arg1)  {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations on Privleges dropdown on Add Affiliated Hospital modal was failed",
				getAddAffiliatedHospitalPage().validatePrvlgsDdn(addAffHspData));
	}

	@When("^I enter below information and add hospital affiliation$")
	public void iEnterBelowInformationAndAddHospitalAffiliation(DataTable arg1) {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Entering data on Add Affiliated Hospital modal was failed",
				getAddAffiliatedHospitalPage().enterData(addAffHspData));
	}

	@And("^submit the affiliation modal$")
	public void submitTheAffiliationModal()  {
		Assertions.assertTrue("Submission of Add Affiliated Hospital modal was failed",
				getAddAffiliatedHospitalPage().submitForm());
	}

	@Then("^perform admitting provider name fields validations as below$")
	public void performAdmittingProviderNameFieldsValidationsAsBelow(DataTable arg1)  {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations of Provider Admitting Names fields were failed",
				getAddAffiliatedHospitalPage().verifyAdmtngProviderNameFieldsErrorPrones(addAffHspData));
	}

	@Then("^perform admitting provider npi fields validations as below$")
	public void performAdmittingProviderNpiFieldsValidationsAsBelow(DataTable arg1)  {
		addAffHspData = new AddAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations of Provider Admitting NPI field were failed",
				getAddAffiliatedHospitalPage().validateAdmtngProviderNPIField(addAffHspData));
	}

	@And("^cancel the affiliation modal$")
	public void cancelTheAffiliationModal() {
		Assertions.assertTrue("Add Affiliated Hospital modal Cancel functionality was failed",
				getAddAffiliatedHospitalPage().DonNotsubmitForm());
	}

}
