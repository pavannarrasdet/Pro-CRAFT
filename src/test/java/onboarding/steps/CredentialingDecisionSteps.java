package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import onboarding.dataobjects.CredentialingDecisionData;
import procraft.core.utilities.automationbase.Assertions;

public class CredentialingDecisionSteps extends MasterSteps {

	@Then("^I am displayed below message$")
	public void display_message(DataTable arg1) {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("Message not displayed", getCredentialingDecisionPage().displayMessage(credentialingdecisiondata));
	}

	@And("^I click x button$")
	public void click_x_button() {
		Assertions.assertTrue("User cannot click X button", getCredentialingDecisionPage().clickXButton());
	}

	@And("^I click cancel button$")
	public void click_cancel_button() {
		Assertions.assertTrue("User cannot click Cancel button", getCredentialingDecisionPage().clickCancelButton());
	}

	@And("^I click Continue on Cred decision page$")
	public void iClickContinueOnCredDecisionPage()  {
		  Assertions.assertTrue("Continue cannot be clicked", getCredentialingDecisionPage().clickContinue());
	}
	
	@And("^I click Cancel on Cred decision page$")
	public void iClickCancelOnCredDecisionPage()  {
		  Assertions.assertTrue("Continue cannot be clicked", getCredentialingDecisionPage().clickCancelButton());
	}
	
	@Then("^I am displayed below Behavioral Health Message Information$")
	public void i_am_displayed_below_Behavioral_Health_Message_Information(DataTable arg1) throws Throwable {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("Message not displayed", getCredentialingDecisionPage().displayBehavioralHealthMessage(credentialingdecisiondata));

	}
	
	@Then("^I am displayed below Physical Health Message Information$")
	public void i_am_displayed_below_Physical_Health_Message_Information(DataTable arg1) throws Throwable {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("Message not displayed", getCredentialingDecisionPage().displayPhysicalHealthMessage(credentialingdecisiondata)); 
	}
	
	@Then("^I verify the Optum PhysicalHealth link$")
	public void i_verify_the_Optum_PhysicalHealth_link() throws Throwable {
		Assertions.assertTrue("Error on clicking Physical link", getCredentialingDecisionPage().verifyOptumPhysicalHealthLink());
	}
	
	@Given("^I click on close button after verifying ContactusLink$")
	public void i_click_on_close_button_after_verifying_ContactUsMessageLink(DataTable arg1) throws Throwable {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("MessageLink not displayed", getCredentialingDecisionPage().verifyContactMessageLink(credentialingdecisiondata));
		click_x_button();
	}
	
	@Then("^The Credentialing Decision service is Not Allowed$")
	public void theCredentialingDecisionServiceIsNotAllowed(DataTable arg1) throws Throwable {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("Message not displayed", getCredentialingDecisionPage().displayCredNotAllowedMessage(credentialingdecisiondata));

	}
	
	@And("^I click close button$")
	public void iClickCloseButton() {
		Assertions.assertTrue("User cannot click Close button", getCredentialingDecisionPage().clickCloseButton());
	}
	
	@Then("^I verify the Optum Behavioral link$")
	public void i_verify_the_Optum_Contactus_link() throws Throwable {
		Assertions.assertTrue("Error on clicking Behavioral link", getCredentialingDecisionPage().verifyOptumBehavioralHealthLink());
	}

}
