package onboarding.dataobjects;

import java.util.Map;

import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;

public class DashBoardData extends AddProviderData {

	public static final String welComeText = "Welcome, " + Constants.TEST_AUTOMATION_EXTERNAL_USER_FNAME + " "
			+ Constants.TEST_AUTOMATION_EXTERNAL_USER_MNAME + " " + Constants.TEST_AUTOMATION_EXTERNAL_USER_LNAME;

	public static final String optumUserName = Constants.TEST_AUTOMATION_EXTERNAL_USER_FNAME + " "
			+ Constants.TEST_AUTOMATION_EXTERNAL_USER_MNAME + " " + Constants.TEST_AUTOMATION_EXTERNAL_USER_LNAME;
	
	private String groupName = "";
	private int groupInd = -1;
	private String tin = "";
	private String speciality = "";
	private String npi = "";
	private String contactUsLink = "";
	private String contactUsNumber = "";
	private String requestSubmitted = "";
	private String credentialsVerified = "";
	private int tinInd = -1;
	private String HeaderNames = "";
	private String addProviderMessage = "";
	private String providerName="";
	private String rfpRecordType="";
	private String credStatus="";
	private String crNumber="";
	private String rfpSubDate="";
	private String rfpCredEstDate="";
	private String selectGrpTINText="";
	private String addPrvdrTxt="";
	private String inEligibleDate ="";
	Map<String, String> data = null;

	public DashBoardData(DataTable table) {
		super(table);
		data = table.asMap(String.class, String.class);
		if (data.containsKey("ADD_PROVIDER_MESSAGE")) {
			this.addProviderMessage = data.get("ADD_PROVIDER_MESSAGE");
		}
		if (data.containsKey("Group")) {
			this.groupName = data.get("Group");
			if (this.groupName.trim().toLowerCase().equals("random")) {
				this.groupInd = (int) AutomationBase.generateRandomInteger(0, 9);
			}
		}
		if (data.containsKey("TIN")) {
			this.tin = data.get("TIN");
			if (this.tin.trim().toLowerCase().equals("random")) {
				this.tinInd = (int) AutomationBase.generateRandomInteger(0, 3);
			}
		}
		if (data.containsKey("SPECIALITY")) {
			this.speciality = data.get("SPECIALITY");
		}
		if (data.containsKey("NPI")) {
			this.npi = data.get("NPI");
		}
		if (data.containsKey("CONTACTUS_LINK")) {
			this.contactUsLink = data.get("CONTACTUS_LINK");
		}
		if (data.containsKey("CONTACTUS_NUMBER")) {
			this.contactUsNumber = data.get("CONTACTUS_NUMBER");
		}
		if (data.containsKey("REQUEST_SUBMITTED")) {
			this.requestSubmitted = data.get("REQUEST_SUBMITTED");
		}
		if (data.containsKey("CREDENTIALS_VERIFIED")) {
			this.credentialsVerified = data.get("CREDENTIALS_VERIFIED");
		}
		if (data.containsKey("HeaderNames")) {
			this.HeaderNames = data.get("HeaderNames");
		}
		if (data.containsKey("PROVIDER_NAME")) {
			setProviderName(data.get("PROVIDER_NAME"));
		}
		if (data.containsKey("RFP_Record_Type")) {
			setRfpRecordType(data.get("RFP_Record_Type"));
		}
		if (data.containsKey("CRED_Status")) {
			setCredStatus(data.get("CRED_Status"));
		}
		if (data.containsKey("CR_NUMBER")) {
			setCrNumber(data.get("CR_NUMBER"));
		}
		if (data.containsKey("RFP_CRED_EST_DATE")) {
			setRfpCredEstDate(data.get("RFP_CRED_EST_DATE"));
		}
		if (data.containsKey("RFP_SUBMITTED_DATE")) {
			setRfpSubDate(data.get("RFP_SUBMITTED_DATE"));
		}
		if (data.containsKey("DashBrd_Selct_Grp_TIN_Txt")) {
			setSelectGrpTINText(data.get("DashBrd_Selct_Grp_TIN_Txt"));
		}
		if (data.containsKey("DashBrd_Add_Prv_Btn_Info_Txt")) {
			setAddPrvdrTxt(data.get("DashBrd_Add_Prv_Btn_Info_Txt"));
		}
		if (data.containsKey("REFERENCE_NUMBER")) {
			setInEligibleDate(data.get("REFERENCE_NUMBER"));
		}
	}

	public String getWelcomeText() {
		return welComeText;
	}

	public String getAddProviderMessage() {
		return addProviderMessage;
	}

	public String getGroup() {
		return groupName;
	}

	public int getGroupInd() {
		return groupInd;
	}

	public String getTIN() {
		return tin;
	}

	public void setGroup(String groupName) {
		this.groupName = groupName;
	}

	public int getTINInd() {
		return tinInd;
	}

	public void setTIN(String tin) {
		this.tin = tin;
	}

	public String getHeaderNames() {
		return HeaderNames;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getRfpRecordType() {
		return rfpRecordType;
	}

	public void setRfpRecordType(String rfpRecordType) {
		this.rfpRecordType = rfpRecordType;
	}

	public String getCredStatus() {
		return credStatus;
	}

	public void setCredStatus(String credStatus) {
		this.credStatus = credStatus;
	}

	public String getCrNumber() {
		return crNumber;
	}

	public void setCrNumber(String crNumber) {
		this.crNumber = crNumber;
	}

	public String getRfpSubDate() {
		return rfpSubDate;
	}

	public void setRfpSubDate(String rfpSubDate) {
		this.rfpSubDate = rfpSubDate;
	}

	public String getRfpCredEstDate() {
		return rfpCredEstDate;
	}

	public void setRfpCredEstDate(String rfpCredEstDate) {
		this.rfpCredEstDate = rfpCredEstDate;
	}

	public String getSelectGrpTINText() {
		return selectGrpTINText;
	}

	public void setSelectGrpTINText(String selectGrpTINText) {
		this.selectGrpTINText = selectGrpTINText;
	}

	public String getAddPrvdrTxt() {
		return addPrvdrTxt;
	}

	public void setAddPrvdrTxt(String addPrvdrTxt) {
		this.addPrvdrTxt = addPrvdrTxt;
	}
	
	public String getNPI() {
		return npi;
	}

	public void setNPI(String npi) {
		this.npi = addPrvdrTxt;
	}
	
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String getContactusLink() {
		return contactUsLink;
	}

	public void setContactUsLink(String contactUsLink) {
		this.contactUsLink = contactUsLink;
	}

	public String getContactUsNumber() {
		return contactUsNumber;
	}

	public void setContactUsNumber(String contactUsNumber) {
		this.contactUsNumber = contactUsNumber;
	}
	
	public String getRequestSubmitted() {
		return requestSubmitted;
	}

	public void setRequestSubmitted(String requestSubmitted) {
		this.requestSubmitted = requestSubmitted;
	}
	
	public String getCredentialsRequired() {
		return credentialsVerified;
	}

	public void setCredentialsRequired(String credentialsVerified) {
		this.credentialsVerified = credentialsVerified;
	}
	
	public String getInEligibleDate() {
		return inEligibleDate;
	}
	
	public void setInEligibleDate(String inEligibleDate) {
		this.inEligibleDate = inEligibleDate;
	}
}
