package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import onboarding.dataobjects.AddLocationData;
import onboarding.dataobjects.EditLocationData;
import onboarding.dataobjects.RFPData;
import procraft.core.utilities.automationbase.Assertions;

public class LocationSteps extends MasterSteps {



	@Then("^I can verify Add Location controls as mentioned below$")
	public void iCanVerifyAddLocationControlsAsMentionedBelow(DataTable arg1)  {
		Assertions.assertTrue("Verification of Add Location Controls was failed ",
				getAddLocationPage().verifyAddLocationDlg(rfpData));
	}

	@When("^I close the Add location window$")
	public void iCloseTheAddLocationWindow()  {
		Assertions.assertTrue("Verification of Closing Add Location  was failed ",
				getAddLocationPage().closeLocationWindow());
	}

	@When("^I cancel the Add location window$")
	public void iCancelTheAddLocationWindow()  {
		Assertions.assertTrue("Verification of Cancelling Add Location Controls was failed ",
				getAddLocationPage().cancelLocationWindow());
	}
	
	@Then("^Adding the below address into the modal$")
	public void addingTheBelowAddressIntoTheModal(DataTable arg1)  {
		addLocationData = new AddLocationData(arg1);
		Assertions.assertTrue("Verification of Add Location Controls was failed ",
				getAddLocationPage().addLocationInfo(addLocationData));
	}
	
	@Then("^I update below information and save locations data$")
	public void iUpdateBelowInformationAndSaveLocationsData(DataTable arg1)  {
		editLocationData = new EditLocationData(arg1);
		Assertions.assertTrue("Edition of the existing address was failed ",
				getEditLocationPage().editLocationInfo(editLocationData));
	}
	
	@Then("^I verify the existing address in the modal$")
	public void iVerifyBelowControlsOnLocationsSectionOfRFP(DataTable arg1) {
		editLocationData = new EditLocationData(arg1);
		Assertions.assertTrue("Verification of existing address was failed ",
				getEditLocationPage().verifyExistingAddress(editLocationData));
	}

}
