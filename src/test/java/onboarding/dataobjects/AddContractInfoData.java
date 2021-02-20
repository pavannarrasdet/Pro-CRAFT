package onboarding.dataobjects;

import java.util.Map;
import cucumber.api.DataTable;

public class AddContractInfoData {
	
	private String validDate="";
	private String inValidDate="";
	
	Map<String, String> data = null;
	
	public AddContractInfoData(DataTable table) {
        data = table.asMap(String.class, String.class);
        if (data.containsKey("Valid_Date")) {
            this.validDate = data.get("Valid_Date");
        }
        if (data.containsKey("InValid_Date")) {
            this.inValidDate = data.get("InValid_Date");
        }
        
	}
	
	public String getValidDate()
	{
		return validDate;
	}
	
	public String getInValidDate()
	{
		return inValidDate;
	}
	
	
	
}
