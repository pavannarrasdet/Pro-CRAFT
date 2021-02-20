package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;

public class DeleteAffiliatedHospData {
	
	private String deleteCnfrmText="";
	//private String hospitalName="";
	Map<String, String> data = null;
	
	public DeleteAffiliatedHospData(DataTable table) {
        data = table.asMap(String.class, String.class);
        if (data.containsKey("DELCONFIRMTEXT")) {
            this.deleteCnfrmText = data.get("DELCONFIRMTEXT");
        }
        
      /*  if (data.containsKey("HospitalName")) {
            this.hospitalName = data.get("HospitalName");
        }*/
	}
	
	public String getDeleteConfirmationText()
	{
		return deleteCnfrmText;
	}
	
	/*public String getHospitalName()
	{
		return hospitalName;
	}*/
}
