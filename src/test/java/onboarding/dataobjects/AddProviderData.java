package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;

public class AddProviderData {

    private String practiceSettingValues = "";
    private int PracticeSettingInd = -1;
    private String PracticeSetting = "";
    private int SpecialtyInd = -1;
    private String Specialty = "";
    private int SpecialtyCount = -1;
    private String caqhLimitErrMsg = "";
    private String caqhID = "";
    private int caqhIdCharLength = 0;
    private String lastName = "";
    private String firstName = "";
    private String middleName = "";
    private String npi = "";
    private String degree = "";
    private String prcStngState = "";
    private int npiCharLen = 0;
    private int firstNameCharLength = 0;
    private int middleNameCharLength = 0;
    private int lastNameCharLength = 0;
    private String npiLuhnErr = "";
    private String npiLenErr = "";
    private String credMessage = "";
    private String caqhMessage = "";
    private String credDecisionMessage = "";
    private String zipCode = "";
    private String zipcodeErrMsg = "";
    private String prvNotFoundErrMsg="";
    private String prvNotFoundHdrMsg="";
    private String attestationExprdErrMsg="";
    private String attestationExprdHdrMsg="";
    private String authReqErrMsg="";
    private String authReqErrHeadrMsg="";
    private String attestationAndAuthReqMsg="";
    private String attestationAndAuthReqHdrMsg="";
    private String appIncompleteErrMsg="";
    private String appIncompleteHdrMsg="";
    Map<String, String> data = null;

    public AddProviderData(DataTable table) {
        data = table.asMap(String.class, String.class);

        if (data.containsKey("practiceSettingValues")) {
            this.practiceSettingValues = data.get("practiceSettingValues");
        }
        if (data.containsKey("PracticeSetting")) {
            this.PracticeSetting = data.get("PracticeSetting");
            if (PracticeSetting.trim().toLowerCase().equals("random")) {
                PracticeSettingInd = (int) AutomationBase.generateRandomInteger(1, 3);
            }
        }

        if (data.containsKey("Specialty")) {
            this.Specialty = data.get("Specialty");
            if (Specialty.trim().toLowerCase().equals("random")) {
                SpecialtyInd = (int) AutomationBase.generateRandomInteger(1, 10);
            }
        }
        if (data.containsKey("CREDMessage")) {
            this.credMessage = data.get("CREDMessage");
        }
        if (data.containsKey("CAQHMessage")) {
            this.caqhMessage = data.get("CAQHMessage");
        }
        if (data.containsKey("CREDDecision ")) {
            this.credDecisionMessage = data.get("CREDDecision ");
        }

        if (data.containsKey("SpecialtyCount")) {
            this.SpecialtyCount = Integer.parseInt(data.get("SpecialtyCount"));
        }

        if (data.containsKey("CAQH_Limit_Error_Message")) {
            this.caqhLimitErrMsg = data.get("CAQH_Limit_Error_Message");
        }

        if (data.containsKey("CAQHID_Char_Length")) {
            this.caqhIdCharLength = Integer.parseInt(data.get("CAQHID_Char_Length"));
        }

        if (data.containsKey("CAQHID")) {
            this.caqhID = data.get("CAQHID");
            if (caqhID.trim().toLowerCase().equals("random")) {
                caqhID = AutomationBase.generateRandomString(caqhIdCharLength, "N");
            }
        }

        if (data.containsKey("LastName_Char_Length")) {
            this.lastNameCharLength = Integer.parseInt(data.get("LastName_Char_Length"));
        }

        if (data.containsKey("LastName")) {
            this.lastName = data.get("LastName");
            if (lastName.trim().toLowerCase().equals("random")) {
                lastName = AutomationBase.generateRandomString(lastNameCharLength, "AB");
            }
        }

        if (data.containsKey("FirstName_Char_Length")) {
            this.firstNameCharLength = Integer.parseInt(data.get("FirstName_Char_Length"));
        }

        if (data.containsKey("FirstName")) {
            this.firstName = data.get("FirstName");
            if (firstName.trim().toLowerCase().equals("random")) {
                firstName = AutomationBase.generateRandomString(firstNameCharLength, "AB");
            }
        }

        if (data.containsKey("MiddleName_Char_Length")) {
            this.middleNameCharLength = Integer.parseInt(data.get("MiddleName_Char_Length"));
        }

        if (data.containsKey("MiddleName")) {
            this.middleName = data.get("MiddleName");
            if (middleName.trim().toLowerCase().equals("random")) {
                middleName = AutomationBase.generateRandomString(middleNameCharLength, "AB");
            }
        }

        if (data.containsKey("NPI_Char_Length")) {
            this.npiCharLen = Integer.parseInt(data.get("NPI_Char_Length"));
        }

        if (data.containsKey("NPI")) {
            this.npi = data.get("NPI");
            if (npi.trim().toLowerCase().equals("random")) {
                npi = AutomationBase.generateRandomString(npiCharLen - 1, "N");
            }
        }

        if (data.containsKey("NPI_Len_Err")) {
            this.npiLenErr = data.get("NPI_Len_Err");
        }

        if (data.containsKey("NPI_Luhn_Err")) {
            this.npiLuhnErr = data.get("NPI_Luhn_Err");
        }

        if (data.containsKey("ZipCode")) {
            this.zipCode = data.get("ZipCode");
        }

        if (data.containsKey("ZipCodeErrorMsg")) {
            this.zipcodeErrMsg = data.get("ZipCodeErrorMsg");
        }
        if (data.containsKey("CAQH_Provider_Not_Found")) {
            this.prvNotFoundErrMsg = data.get("CAQH_Provider_Not_Found");
        }
        if (data.containsKey("CAQH_Provider_Not_Found_Hdr_Msg")) {
            this.prvNotFoundHdrMsg = data.get("CAQH_Provider_Not_Found_Hdr_Msg");
        }
        if (data.containsKey("CAQH_Attestation_Expired")) {
            this.attestationExprdErrMsg = data.get("CAQH_Attestation_Expired");
        }
        if (data.containsKey("CAQH_Attestation_Header_Msg")) {
            this.attestationExprdHdrMsg = data.get("CAQH_Attestation_Header_Msg");
        }
        if (data.containsKey("CAQH_Authorization_Req_Err_Msg")) {
            this.authReqErrMsg = data.get("CAQH_Authorization_Req_Err_Msg");
        }
        if (data.containsKey("CAQH_Authorization_Header_Msg")) {
            this.authReqErrHeadrMsg = data.get("CAQH_Authorization_Header_Msg");
        }
        if (data.containsKey("CAQH_Authorization_Attestation_Req_Err_Msg")) {
            this.attestationAndAuthReqMsg = data.get("CAQH_Authorization_Attestation_Req_Err_Msg");
        }
        if (data.containsKey("CAQH_Authorization_Attestation_Header_Msg")) {
            this.attestationAndAuthReqHdrMsg = data.get("CAQH_Authorization_Attestation_Header_Msg");
        }
        if (data.containsKey("CAQH_Application_Incomplete_Err_Msg")) {
            this.appIncompleteErrMsg = data.get("CAQH_Application_Incomplete_Err_Msg");
        }
        if (data.containsKey("CAQH_Application_Incomplete_Header_Msg")) {
            this.appIncompleteHdrMsg = data.get("CAQH_Application_Incomplete_Header_Msg");
        }
        if (data.containsKey("Degree")) {
            this.degree = data.get("Degree");
        }
        if (data.containsKey("PrimaryPracticeSettingState")) {
            this.prcStngState = data.get("PrimaryPracticeSettingState");
        }
    }

    public String getpracticeSettingValues() {
        return practiceSettingValues;
    }

    public String getPracticeSetting() {
        return PracticeSetting;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public int getSpecialtyInd() {
        return SpecialtyInd;
    }

    public int getPracticeSettingInd() {
        return PracticeSettingInd;
    }

    public void setPracticeSetting(String Value) {
        this.PracticeSetting = Value;
    }

    public void setSpecialty(String Value) {
        this.Specialty = Value;
    }

    public int getSpecialtyCount() {
        return SpecialtyCount;
    }

    public String getCAQHLimitErrMsg() {
        return caqhLimitErrMsg;
    }

    public String getCAQHID() {
        return caqhID;
    }

    public int getcaqhIdCharLen() {
        return caqhIdCharLength;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getFirstNameCharLen() {
        return firstNameCharLength;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLastNameCharLen() {
        return lastNameCharLength;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getMiddleNameLen() {
        return middleNameCharLength;
    }

    public String getNPI() {
        return npi;
    }

    public int getNPICharLen() {
        return npiCharLen;
    }

    public String getNpiLuhnErr() {
        return npiLuhnErr;
    }

    public String getNpiLenErr() {
        return npiLenErr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCREDMessgae() {
        return credMessage;
    }

    public String getCAQHMessage() {
        return caqhMessage;
    }

    public String getCredDecisionMessage() {
        return credDecisionMessage;
    }

    public String getZipcodeErrMsg() {
        return zipcodeErrMsg;
    }
    
    public String getCAQHAttestationExprMsg()
    {
    	return attestationExprdErrMsg;
    }
    
    public String getCAQHAttestationExprHdrMsg()
    {
    	return attestationExprdHdrMsg;
    }
    public String getCAQHAuthReqMsg()
    {
    	return authReqErrMsg;
    }
    public String getCAQHAuthReqHdrMsg()
    {
    	return authReqErrHeadrMsg;
    }
    public String getCAQHPrvNtFndErr()
    {
    	return prvNotFoundErrMsg;
    }
    public String getCAQHPrvNtFndErrHdrMsg()
    {
    	return prvNotFoundHdrMsg;
    }
    public String getAttestAndAuthReqErrHdrMsg()
    {
    	return attestationAndAuthReqHdrMsg;
    }
    public String getAttestAndAuthReqErrMsg()
    {
    	return attestationAndAuthReqMsg;
    }
    public String getCAQHAppIncompleteErr()
    {
    	return appIncompleteErrMsg;
    }
    public String getCAQHAppIncompleteErrHdrMsg()
    {
    	return appIncompleteHdrMsg;
    }
    public String getDegree()
    {
    	return degree;
    }
    public String getPracticeSettingState()
    {
    	return prcStngState;
    }

}
