package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import onboarding.dataobjects.LoginData;
import procraft.core.utilities.automationbase.Assertions;
import procraft.core.utilities.automationbase.ReportHelper;

public class CommonSteps extends MasterSteps {
    @Given("^Demo step is executed$")
    public void demo_step_is_executed() {
        ReportHelper.logStepDetails("Demo step");
    }

    @Given("^I have logged into Optum ID portal with given user name and password$")
    public void enter_id_and_password(DataTable arg1) {
        loginData = new LoginData(arg1);
        Assertions.assertTrue("Failed to submit login form", getLoginPage().loginToOnboarding(loginData), true);
    }

    @Then("^I am displayed with an error message \"(.*)\" on the page$")
    public void error_message_displayed(String text) {
        Assertions.assertTrue("Error message was not found", getLoginPage().validateErrorMessage(text));
    }

	@Then("^User should be able to logout from application and redirect to \"([^\"]*)\" page\\.$")
	public void userShouldBeAbleToLogoutFromApplicationAndRedirectToPage(String arg1) 
	{
		Assertions.assertTrue("Logging out from application was failed", getDashBoardPage().logOut(arg1));
	}
}
