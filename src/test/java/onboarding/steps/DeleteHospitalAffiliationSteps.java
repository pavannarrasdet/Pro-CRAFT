package onboarding.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import onboarding.dataobjects.DeleteAffiliatedHospData;
import procraft.core.utilities.automationbase.Assertions;

public class DeleteHospitalAffiliationSteps extends MasterSteps {
	


	@When("^I delete below hospital information$")
	public void iDeleteBelowHospitalInformation(DataTable arg1)  {
		
		deleteAfflData = new DeleteAffiliatedHospData(arg1);
		Assertions.assertTrue("Deleting hospital affiliated record was failed ",
				getDelHsptlAfltPage().deleteRecord(deleteAfflData));
		
	}

	@When("^I cancel deleting below hospital information$")
	public void iCancelDeletingBelowHospitalInformation(DataTable arg1)  {
		
		deleteAfflData = new DeleteAffiliatedHospData(arg1);
		Assertions.assertTrue("Cancel deleting hospital affiliated record was failed ",
				getDelHsptlAfltPage().dontDeleteRecord(deleteAfflData));
		
	}

}
