package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;


public class EditLicenseData  {


    private String licenseType = "";
    private String state = "";
    private String licenseNumber = "";
    private String issueDate = "";
    private String expirationDate = "";
    private int licenseTypeInd = -1;

    Map<String, String> data = null;

    public EditLicenseData(DataTable table) {
        
        this.data = table.asMap(String.class, String.class);
        if (data.containsKey("LicenseType")) {
            this.licenseType = data.get("LicenseType");
            if (licenseType.trim().toLowerCase().equals("random")) {
            	licenseTypeInd = (int) AutomationBase.generateRandomInteger(1, 5);
            }
        }
        if (data.containsKey("State")) {
            this.state = data.get("State");
        }
        if (data.containsKey("LicenseNumber")) {
            this.licenseNumber = data.get("LicenseNumber");
        }
        if (data.containsKey("IssueDate")) {
            this.issueDate = data.get("IssueDate");
        }
        if (data.containsKey("ExpirationDate")) {
            this.expirationDate = data.get("ExpirationDate");
        }
     
    }
    public String getLicenseType() {
        return licenseType;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }

	public String getState() {
        return state;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }

	public int getlicenseTypeInd() {
        return licenseTypeInd;
    }

    public void setLicenseType(String Value) {
        this.licenseType = Value;
    }
    
}
