package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import onboarding.dataobjects.CredentialingDecisionData;
import procraft.core.utilities.automationbase.Assertions;
public class ContactUsSteps extends MasterSteps{
	
	@Then("^I am brought to the ContactUs page$")
	public void iAmBroughtToTheContactUsPage() {
		Assertions.assertTrue("ContactUs content was not displayed", getContactUsPage().verifyContactUsContent());
	}

	@Then("^The following information is displayed in the modal$")
	public void theFollowwingInformationIsDisplayedInTheModal(DataTable arg1) throws Throwable {
		credentialingdecisiondata = new CredentialingDecisionData(arg1);
		Assertions.assertTrue("Message not displayed", getContactUsPage().displayContactUsMessage(credentialingdecisiondata));

	}
	@And("^I click close button on ContactUs page$")
	public void iClickCloseButtonOnContactUsPage() {
		Assertions.assertTrue("User cannot click Close button", getContactUsPage().clickCloseButton());
	}

}
