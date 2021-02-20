package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import onboarding.dataobjects.AddProviderData;
import procraft.core.utilities.automationbase.Assertions;

public class AddProviderSteps extends MasterSteps {
    @Then("^I can see the following elements$")
    public void iCanSeeTheFollowingDataElements(DataTable arg1) {
        Assertions.assertTrue("Verification of 'Add Provider' modal window controls was failed",
                getAddProviderPage().verifyAddProviderModalControls());
    }
    @Then("^only the CAQH ID field is active for entry$")
    public void only_CAQHID_Active() {
        Assertions.assertTrue("Verification of only CAQHID active was failed",
                getAddProviderPage().verifyOnlyCAQHIDActive());
    }
    @Then("^Specialty field has \"(.*)\" default value$")
    public void verify_specialty_default_value(String text) {
        Assertions.assertTrue("Specialty Default Value is not present",
                getAddProviderPage().verifyDefaultSpecialtyValue(text));
    }

    @And("^I can select one specialty from the specialty field drop down$")
    public void select_specialty(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Specialty cannot be selected", getAddProviderPage().selectSpecialty(addproviderdata));
    }

    @Then("^the count of specialties in the drop down is as below$")
    public void verify_specialty_count(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Specialty count is not matching", getAddProviderPage().verifyCount(addproviderdata));
    }

    @Then("^the practice setting drop down has below values in the drop down$")
    public void verify_practice_setting_values(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Practice Setting drop down verification failed",
                getAddProviderPage().verifyPSDropDown(addproviderdata));
    }

    @Then("^the practice setting field has \"(.*)\" default value$")
    public void verify_default_value(String text) {
        Assertions.assertTrue("Practice Setting default value is not present",
                getAddProviderPage().verifyDefaultPSValue(text));
    }

    @And("^I can select one Practice setting value from the practice setting drop down$")
    public void select_practice_setting_value(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Practice Setting value cannot be selected",
                getAddProviderPage().selectPSValue(addproviderdata));

    }

    @Then("^perform CAQH field validations as below$")
    public void performCAQHFieldValidationsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("CAQH field validations were failed",
                getAddProviderPage().verifyCAQHFieldErrorPrones(addproviderdata));
    }

    @Then("^perform provider name fields validations as below$")
    public void performProviderNameFieldsValidationsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Provider name fields validations were failed",
                getAddProviderPage().verifyProviderNameFieldsErrorPrones(addproviderdata));
    }

    @Then("^perform provider npi fields validations as below$")
    public void performProviderNpiFieldsValidationsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("NPI field validations were failed",
                getAddProviderPage().validateProviderNPIField(addproviderdata));
    }

    @And("^I enter add provider information$")
    public void enter_all_fields(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Add provider information failed",
                getAddProviderPage().enterProviderInfo(addproviderdata));
    }

    @And("^I click Continue$")
    public void click_continue() {
        Assertions.assertTrue("Continue cannot be clicked", getAddProviderPage().clickContinue());
    }

    @And("^enters ZipCode which has special chars and alphabets as below$")
    public void performZipCodeValidationsHasSpecialCharsAlphabetsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Zipcode with special chars and alphabets field validations were failed",
                getAddProviderPage().enterZipCode(addproviderdata));
    }

    @Then("^zip code field should be empty$")
    public void zip_code_empty() {
        Assertions.assertTrue("Zipcode was not empty", getAddProviderPage().validateZipCode("alphabets_special_chars"));
    }

    @And("^enters ZipCode which has five numeric chars as below$")
    public void performZipCodeValidationsHas5NumericCharsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Zipcode with 5 numeric chars field validations were failed",
                getAddProviderPage().enterZipCode(addproviderdata));
    }

    @Then("^zip code field should not be empty$")
    public void zip_code_not_empty() {
        Assertions.assertTrue("Zipcode is empty", getAddProviderPage().validateZipCode("five_numeric_value"));
    }

    @And("^enters ZipCode which has less than five numeric chars as below$")
    public void performZipCodeValidationsHasLessThan5NumericCharsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Zipcode with less than 5 numeric chars field validations were failed",
                getAddProviderPage().enterZipCode(addproviderdata));
    }

    @Then("^zip code field should not be empty and error message should be visible$")
    public void zip_code_error_message(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Zipcode is empty and does not have error message",
                getAddProviderPage().validateZipcodeErrorMessages(addproviderdata));
    }

    @And("^enters ZipCode which contains repetitive chars as below$")
    public void performZipCodeValidationsHasRepetitiveNumericCharsAsBelow(DataTable arg1) {
        addproviderdata = new AddProviderData(arg1);
        Assertions.assertTrue("Zipcode with repetitive numeric chars field validations were failed",
                getAddProviderPage().enterZipCode(addproviderdata));
    }

	@Then("^I am displayed with CAQH auth required error messages$")
	public void iAmDisplayedWithBelowCAQHErrorMessages(DataTable arg1)  {
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Provider not found error validation was failed",
	                getAddProviderPage().validateCAQHAuthReqErrMsg(addproviderdata));
	}

	@Then("^I am displayed with provider not found error messages$")
	public void iAmDisplayedWithProviderNotFoundErrorMessages(DataTable arg1) 
	{
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Provider not found error validation was failed",
	                getAddProviderPage().validateCAQHPrvNotFoundErrMsg(addproviderdata));
	}

	@Then("^I am displayed with below attestation CAQH error messages$")
	public void iAmDisplayedWithBelowAttestationCAQHErrorMessages(DataTable arg1) 
	{
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Attestation expired error validation was failed",
	                getAddProviderPage().validateCAQHAttestationReqErrMsg(addproviderdata));
	}

	@Then("^I am displayed with CAQH auth and attest required error messages$")
	public void iAmDisplayedWithCAQHAuthAndAttestRequiredErrorMessages(DataTable arg1) 
	{
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Attestation and Auth required error validation was failed",
	                getAddProviderPage().validateCAQHAttestationReqAndAuthReqErrMsg(addproviderdata));
	}
	@Then("^I must see the below fields prepoulated from CAQH$")
	public void iMustSeeTheBelowFieldsPrepoulatedFromCAQH(DataTable arg1) {
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Verification of pre-population of provider data from CAQH was failed",
	                getAddProviderPage().validatePrepopulatedData(addproviderdata));
	}
	@And("^I click Provider Check button$")
	public void iClickProviderCheckButton()  {
		Assertions.assertTrue("Clicking on Check Provider button was failed",
                getAddProviderPage().clickCheckProvider());
	}
	@Then("^I must see the degree field Pre-Populated from CAQH$")
	public void iMustSeeTheDegreeFieldPrePopulatedFromCAQH(DataTable arg1) {
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Verification of pre-population of degree field from CAQH was failed",
	                getAddProviderPage().validatePrepopulatedDegreeField(addproviderdata));
	}
	@Then("^I must not see the degree field on provider modal$")
	public void iMustNotSeeTheDegreeFieldOnProviderModal(DataTable arg1) {
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("Verification of pre-population of degree field from CAQH was failed",
	                getAddProviderPage().validatePrepopulatedDegreeField(addproviderdata));
	}
	@Then("^I am displayed with CAQH application is not Complete message$")
	public void iAmDisplayedWithCAQHApplicationIsNotCompleteMessage(DataTable arg1) 
	{
		addproviderdata = new AddProviderData(arg1);
		 Assertions.assertTrue("CAQH application is not complete error validation was failed",
	                getAddProviderPage().validateCAQHApplicationIncompleteErrMsg(addproviderdata));
	}
}
