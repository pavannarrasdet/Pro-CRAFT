package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;


public class CredentialingDecisionData extends AddProviderData {


    private String credMessage = "";
    private String caqhMessage = "";
    private String credDecisionMessage = "";
    private String behavioralHealthMessage = "";
    private String physicalHealthMessage = "";
    private String contactMessageLink = "";
    private String contactMessageNumber = "";
    private String credNotAllowedMessage = "";
    private String credNotAllowedCallUsMessage = "";
    private String credNotAllowedPhoneNum = "";
    
    Map<String, String> data = null;

    public CredentialingDecisionData(DataTable table) {
        super(table);
        this.data = table.asMap(String.class, String.class);
        if (data.containsKey("CREDMessage")) {
            this.credMessage = data.get("CREDMessage");
        }
        if (data.containsKey("CAQHMessage")) {
            this.caqhMessage = data.get("CAQHMessage");
        }
        if (data.containsKey("BehavioralHealthMessage")) {
            this.behavioralHealthMessage = data.get("BehavioralHealthMessage");
        }
        if (data.containsKey("PhysicalHealthMessage")) {
            this.behavioralHealthMessage = data.get("PhysicalHealthMessage");
        }
        if (data.containsKey("ContactMessageLink")) {
            this.contactMessageLink = data.get("ContactMessageLink");
        }
        if (data.containsKey("ContactMessageNumber")) {
            this.contactMessageNumber = data.get("ContactMessageNumber");
        }
        if (data.containsKey("CREDNotAllowedMessage")) {
            this.credNotAllowedMessage = data.get("CREDNotAllowedMessage");
        }
        if (data.containsKey("CREDNotAllowedCallUsMessage")) {
            this.credNotAllowedCallUsMessage = data.get("CREDNotAllowedCallUsInfo");
        }
        if (data.containsKey("CREDNotAllowedPhoneNum")) {
            this.credNotAllowedPhoneNum = data.get("CREDNotAllowedPhoneNum");
        }
    }


    public String getCREDMessage() {
        return credMessage;
    }

    public String getCAQHMessage() {
        return caqhMessage;
    }

    public String getBehavioralHealthMessage() {
        return behavioralHealthMessage;
    }
    
    public String getPhysicalHealthMessage() {
        return physicalHealthMessage;
    }
    
    public String getContactMessageLink() {
        return contactMessageLink;
    }
    
    public String getContactMessageNumber() {
        return contactMessageNumber;
    }
    
    public String getCREDNotAllowedMessage() {
        return credNotAllowedMessage;
    }
    
    public String getCREDNotAllowedCallUsMessage() {
        return credNotAllowedCallUsMessage;
    }
    
    public String getCREDNotAllowedPhoneNum() {
        return credNotAllowedPhoneNum;
    }

}
