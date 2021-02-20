package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;

public class DeleteLicenseData {
	
	private String deleteCnfrmText="";
	Map<String, String> data = null;
	
	public DeleteLicenseData(DataTable table) {
        data = table.asMap(String.class, String.class);
        if (data.containsKey("DELCONFIRMTEXT")) {
            this.deleteCnfrmText = data.get("DELCONFIRMTEXT");
        }
	}
	
	public String getDeleteConfirmationText()
	{
		return deleteCnfrmText;
	}

}
