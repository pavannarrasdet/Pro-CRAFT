package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.EditAffiliatedHospitalData;
import procraft.core.utilities.automationbase.Assertions;

public class EditHospitalAffiliationSteps extends MasterSteps {
	

	@When("^I update below information and save hospital affiliation$")
	public void iUpdateBelowInformationAndSaveHospitalAffiliation(DataTable arg1)  {
		
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Entering data on edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().enterData(editAffliatedData));
		Assertions.assertTrue("Saving edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().submitForm());
		
	}

	@When("^I update below information and cancel the modal$")
	public void iUpdateBelowInformationAndCancelTheModal(DataTable arg1)  {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Entering data on edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().enterData(editAffliatedData));
		Assertions.assertTrue("Canceling edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().DonNotsubmitForm());
	}
	
	@When("^I update below information and cancel the edit hsp afl modal$")
	public void iUpdateBelowInformationAndCancelTheEditHspAflModal(DataTable arg1)  {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Entering data on edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().enterHspAflData(editAffliatedData));
		Assertions.assertTrue("Canceling edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().DonNotsubmitForm());
	}
	@When("^I update below information and save hospital affiliation data$")
	public void iUpdateBelowInformationAndSaveHospitalAffiliationData(DataTable arg1)  {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Entering data on edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().enterHspAflData(editAffliatedData));
		Assertions.assertTrue("Saving edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().submitForm());
		
	}

	@Then("^I can see previous saved information on edit hospital window as mentioned below$")
	public void iCanSeePreviousSavedInformationOnEditHospitalWindowAsMentionedBelow(DataTable arg1) {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Verification of previous saved data on edit hospital affiliated window was failed ",
				getEditHsptlAfltPage().validatePreviousSavedInfo(editAffliatedData));
	}
	
	@And("^verify Edit Hospital Modal fields$")
	public void verifyViewingEditHospitalModalFields(DataTable arg1) {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Verfication of edit hosptial fileds was failed", 
				getEditHsptlAfltPage().verifyEditAffiliatedHospitalModalControls(editAffliatedData));
	}
	
	@Then("^perform edit admitting provider name fields validations as below$")
	public void performEditAdmittingProviderNameFieldsValidationsAsBelow(DataTable arg1)  {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations of Provider Admitting Names fields were failed",
				getEditHsptlAfltPage().verifyEditAdmtngProviderNameFieldsErrorPrones(editAffliatedData));
	}
	
	@Then("^perform edit admitting provider npi fields validations as below$")
	public void performEditAdmittingProviderNpiFieldsValidationsAsBelow(DataTable arg1)  {
		editAffliatedData = new EditAffiliatedHospitalData(arg1);
		Assertions.assertTrue("Validations of Provider Edit Admitting NPI field were failed",
				getEditHsptlAfltPage().validateEditAdmtngProviderNPIField(editAffliatedData));
	}
}
