package onboarding.dataobjects;

import java.util.Map;
import cucumber.api.DataTable;
import procraft.core.utilities.automationbase.AutomationBase;

public class RFPData {

	Map<String, String> data = null;

	private String hsptlAfflHeaders = "";
	private String hsptlName = "";
	private String privileges = "";
	private String admitngProvder = "";
	private String practInfoSufixValues = "";
	private String practInfoGndrValues = "";
	private String practInfoDegrValus = "";
	private int dateFieldLength = -1;
	private String dobInvalidFrmtMsg = "";
	private String dobGrterErrMsg = "";
	private String expDateInvalidFrmtMsg = "";
	private String expDateGrterErrMsg = "";
	private String dobInvalidDateErrMsg = "";
	private String expDateInvalidDateErrMsg = "";
	private String licenseType = "";
	private String state = "";
	private String licenseNumber = "";
	private String issueDate = "";
	private String expirationDate = "";
	private int licenseTypeInd = -1;
	private String dob = "";
	private String gender = "";
	private String suffix = "";
	private String brdCertfd = "";
	private String attachemntInfoMessage = "";
	private String uniqueValue = "";
	private String locationsSubHdr = "";
	private String locationsMainHdr = "";
	private String locationsHdrs = "";
	private String locationsCells = "";
	private String contractTin = "";
	private String contractGroups = "";
	private String contractGroupDfltTxt = "";
	private String superVising_LastName = "";
	private String superVising_FirstName = "";
	private int superVising_FirstNameCharLength = 0;
	private int superVising_LastNameCharLength = 0;
	private String superVising_Npi = "";
	private int superVising_SpecialtyInd = -1;
	private String superVising_Specialty = "";
	private int superVising_SpecialtyCount = -1;
	private String superVising_NpiLuhnErr = "";
	private String superVising_NpiLenErr = "";
	private int superVising_NpiCharLen = 0;
	private String locationType = "";
	private String addLocationTitle = "";
	private String ackTitle = "";
	private String attestorName = "";
	private int attestorNameCharLen = 0;
	private String infoAtstMsg = "";
	private String userCnfrmAtstMsg = "";
	private String providerName = "";
	private String attestSucsMsg="";
	private String editLocationTitle = "";
	private String updatedStreetAddress = "";
	private String updatedCity = "";
	private String updatedState = "";
	private String updatedZipCode = "";
	private String updatedPhone = "";
	private String updatedFax = "";
	
	public RFPData(DataTable table) {
		data = table.asMap(String.class, String.class);
		if (data.containsKey("AFFL_HEADERS")) {
			this.hsptlAfflHeaders = data.get("AFFL_HEADERS");
		}
		if (data.containsKey("Name")) {
			this.hsptlName = data.get("Name");
		}
		if (data.containsKey("Privileges")) {
			this.privileges = data.get("Privileges");
		}
		if (data.containsKey("AdmittingProvider")) {
			this.admitngProvder = data.get("AdmittingProvider");
		}
		if (data.containsKey("SUFFIX_VALUES")) {
			this.practInfoSufixValues = data.get("SUFFIX_VALUES");
		}
		if (data.containsKey("DEGREE_VALUES")) {
			this.practInfoDegrValus = data.get("DEGREE_VALUES");
		}
		if (data.containsKey("GENDER_VALUES")) {
			this.practInfoGndrValues = data.get("GENDER_VALUES");
		}
		if (data.containsKey("Date_Field_Length")) {
			this.dateFieldLength = Integer.parseInt(data.get("Date_Field_Length"));
		}
		if (data.containsKey("DOB_FormatErrMsg")) {
			this.dobInvalidFrmtMsg = data.get("DOB_FormatErrMsg");
		}
		if (data.containsKey("DOB_GreterDateErr")) {
			this.dobGrterErrMsg = data.get("DOB_GreterDateErr");
		}
		if (data.containsKey("ExpDate_FormatErrMsg")) {
			this.expDateInvalidFrmtMsg = data.get("ExpDate_FormatErrMsg");
		}
		if (data.containsKey("ExpDate_GreterDateErr")) {
			this.expDateGrterErrMsg = data.get("ExpDate_GreterDateErr");
		}
		if (data.containsKey("DOB_Invalid_Format_Msg")) {
			this.dobInvalidDateErrMsg = data.get("DOB_Invalid_Format_Msg");
		}
		if (data.containsKey("Exp_Date_Invalid_Format_Msg")) {
			this.expDateInvalidDateErrMsg = data.get("Exp_Date_Invalid_Format_Msg");
		}
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
		if (data.containsKey("Suffix")) {
			this.suffix = data.get("Suffix");
		}
		if (data.containsKey("Gender")) {
			this.gender = data.get("Gender");
		}
		if (data.containsKey("BoardCertified")) {
			this.brdCertfd = data.get("BoardCertified");
		}
		if (data.containsKey("DateOfBirth")) {
			this.dob = data.get("DateOfBirth");
		}

		if (data.containsKey("AttachmentsMessage")) {
			this.attachemntInfoMessage = data.get("AttachmentsMessage");
		}
		if (data.containsKey("UniqueValue")) {
			this.uniqueValue = data.get("UniqueValue");
		}
		if (data.containsKey("Locations_Main_Heading")) {
			this.locationsMainHdr = data.get("Locations_Main_Heading");
		}
		if (data.containsKey("Locations_Sub_Heading")) {
			this.locationsSubHdr = data.get("Locations_Sub_Heading");
		}
		if (data.containsKey("Headers")) {
			this.locationsHdrs = data.get("Headers");
		}
		if (data.containsKey("Cells")) {
			this.locationsCells = data.get("Cells");
		}
		if (data.containsKey("Contracting_Groups")) {
			this.contractGroups = data.get("Contracting_Groups");
		}
		if (data.containsKey("Contracting_TIN")) {
			this.contractTin = data.get("Contracting_TIN");
		}
		if (data.containsKey("Contract_Group_Default_Text")) {
			this.contractGroupDfltTxt = data.get("Contract_Group_Default_Text");
		}
		if (data.containsKey("SuperVising_Specialty")) {
			this.superVising_Specialty = data.get("SuperVising_Specialty");
			if (superVising_Specialty.trim().toLowerCase().equals("random")) {
				superVising_SpecialtyInd = (int) AutomationBase.generateRandomInteger(1, 10);
			}
		}
		if (data.containsKey("SuperVising_SpecialtyCount")) {
			this.superVising_SpecialtyCount = Integer.parseInt(data.get("SuperVising_SpecialtyCount"));
		}
		if (data.containsKey("SuperVising_LastName_Char_Length")) {
			this.superVising_LastNameCharLength = Integer.parseInt(data.get("SuperVising_LastName_Char_Length"));
		}

		if (data.containsKey("SuperVising_LastName")) {
			this.superVising_LastName = data.get("SuperVising_LastName");
		}

		if (data.containsKey("SuperVising_FirstName_Char_Length")) {
			this.superVising_FirstNameCharLength = Integer.parseInt(data.get("SuperVising_FirstName_Char_Length"));
		}

		if (data.containsKey("SuperVising_FirstName")) {
			this.superVising_FirstName = data.get("SuperVising_FirstName");
		}
		if (data.containsKey("SuperVising_NPI_Char_Length")) {
			this.superVising_NpiCharLen = Integer.parseInt(data.get("SuperVising_NPI_Char_Length"));
		}

		if (data.containsKey("SuperVising_NPI")) {
			this.superVising_Npi = data.get("SuperVising_NPI");
		}

		if (data.containsKey("SuperVising_NPI_Len_Err")) {
			this.superVising_NpiLenErr = data.get("SuperVising_NPI_Len_Err");
		}

		if (data.containsKey("SuperVising_NPI_Luhn_Err")) {
			this.superVising_NpiLuhnErr = data.get("SuperVising_NPI_Luhn_Err");
		}
		if (data.containsKey("RFP_LocationType")) {
			this.locationType = data.get("RFP_LocationType");
		}
		if (data.containsKey("ADD_Location_Title")) {
			this.addLocationTitle = data.get("ADD_Location_Title");
		}
		if (data.containsKey("Ack_Title")) {
			this.setAckTitle(data.get("Ack_Title"));
		}
		if (data.containsKey("Attestor_Name")) {
			this.setAttestorName(data.get("Attestor_Name"));
		}
		if (data.containsKey("Attestor_Char_Len")) {
			this.setAttestorNameCharLen(Integer.parseInt(data.get("Attestor_Char_Len")));
		}
		if (data.containsKey("INFO_ATTEST_MSG")) {
			this.setInfoAtstMsg(data.get("INFO_ATTEST_MSG"));
		}
		if (data.containsKey("USER_CONFIRM_ATST_MSG")) {
			this.setUserCnfrmAtstMsg(data.get("USER_CONFIRM_ATST_MSG"));
		}
		if (data.containsKey("PROVIDER_NAME")) {
			this.setProviderName(data.get("PROVIDER_NAME"));
		}
		if (data.containsKey("ATTEST_SUCCESS_MSG")) {
			this.setAttestSucsMsg(data.get("ATTEST_SUCCESS_MSG"));
		}
		if (data.containsKey("EDIT_Location_Title")) {
			this.editLocationTitle = data.get("EDIT_Location_Title");
		}
		if (data.containsKey("UpdatedStreetAddress")) {
			this.updatedStreetAddress = data.get("UpdatedStreetAddress");
		}
		if (data.containsKey("UpdatedCity")) {
			this.updatedCity = data.get("UpdatedCity");
		}
		if (data.containsKey("UpdatedState")) {
			this.updatedState = data.get("UpdatedState");
		}
		if (data.containsKey("UpdatedZipCode")) {
			this.updatedZipCode = data.get("UpdatedZipCode");
		}
		if (data.containsKey("UpdatedPhone")) {
			this.updatedPhone = data.get("UpdatedPhone");
		}
		if (data.containsKey("UpdatedFax")) {
			this.updatedFax = data.get("UpdatedFax");
		}
		
	}

	public String getHsptlAflHdrs() {
		return hsptlAfflHeaders;
	}

	public String getHospitalName() {
		return hsptlName;
	}

	public String getPrivileges() {
		return privileges;
	}

	public String getAdmittingProvider() {
		return admitngProvder;
	}

	public String getSufxValues() {
		return practInfoSufixValues;
	}

	public String getDegreValues() {
		return practInfoDegrValus;
	}

	public String getGenderValues() {
		return practInfoGndrValues;
	}

	public int getDateFieldLen() {
		return dateFieldLength;
	}

	public String getDOBInvalidFormatMsg() {
		return dobInvalidFrmtMsg;
	}

	public String getDOBGrtErrMsg() {
		return dobGrterErrMsg;
	}

	public String getExpDtInvalidFormatMsg() {
		return expDateInvalidFrmtMsg;
	}

	public String getExpDtGrtErrMsg() {
		return expDateGrterErrMsg;
	}

	public String getDOBInvalidDateErrMsg() {
		return dobInvalidDateErrMsg;
	}

	public String getExpDateInvalidDateErrMsg() {
		return expDateInvalidDateErrMsg;
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

	public String getDOB() {
		return dob;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getBoardCertified() {
		return brdCertfd;
	}

	public String getGender() {
		return gender;
	}

	public String getAttachemntInfoMessage() {
		return attachemntInfoMessage;
	}

	public void setAttachemntInfoMessage(String attachemntInfoMessage) {
		this.attachemntInfoMessage = attachemntInfoMessage;
	}

	public String getUniqueValue() {
		return uniqueValue;
	}

	public void setUniqueValue(String uniqueValue) {
		this.uniqueValue = uniqueValue;
	}

	public String getLocationsSubHdr() {
		return locationsSubHdr;
	}

	public void setLocationsSubHdr(String locationsSubHdr) {
		this.locationsSubHdr = locationsSubHdr;
	}

	public String getLocationsMainHdr() {
		return locationsMainHdr;
	}

	public void setLocationsMainHdr(String locationsMainHdr) {
		this.locationsMainHdr = locationsMainHdr;
	}

	public String getLocationsHdrs() {
		return locationsHdrs;
	}

	public void setLocationsHdrs(String locationsHdrs) {
		this.locationsHdrs = locationsHdrs;
	}

	public String getLocationsCells() {
		return locationsCells;
	}

	public void setLocationsCells(String locationsCells) {
		this.locationsCells = locationsCells;
	}

	public String getContractTin() {
		return contractTin;
	}

	public void setContractTin(String contractTin) {
		this.contractTin = contractTin;
	}

	public String getContractGroups() {
		return contractGroups;
	}

	public void setContractGroups(String contractGroups) {
		this.contractGroups = contractGroups;
	}

	public String getContractGroupDfltTxt() {
		return contractGroupDfltTxt;
	}

	public void setContractGroupDfltTxt(String contractGroupDfltTxt) {
		this.contractGroupDfltTxt = contractGroupDfltTxt;
	}

	public String getSupervisingSpecialty() {
		return superVising_Specialty;
	}

	public int getSupervisingSpecialtyInd() {
		return superVising_SpecialtyInd;
	}

	public void setSupervisingSpecialty(String Value) {
		this.superVising_Specialty = Value;
	}

	public int getSupervisingSpecialtyCount() {
		return superVising_SpecialtyCount;
	}

	public String getSupervisingFirstName() {
		return superVising_FirstName;
	}

	public int getSupervisingFirstNameCharLen() {
		return superVising_FirstNameCharLength;
	}

	public String getSupervisingLastName() {
		return superVising_LastName;
	}

	public int getSupervisingLastNameCharLen() {
		return superVising_LastNameCharLength;
	}

	public String getSupervisingNPI() {
		return superVising_Npi;
	}

	public int getSupervisingNPICharLen() {
		return superVising_NpiCharLen;
	}

	public String getSupervisingNpiLuhnErr() {
		return superVising_NpiLuhnErr;
	}

	public String getSupervisingNpiLenErr() {
		return superVising_NpiLenErr;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getAddLocationTitle() {
		return addLocationTitle;
	}

	public void setAddLocationTitle(String addLocationTitle) {
		this.addLocationTitle = addLocationTitle;
	}

	public String getAckTitle() {
		return ackTitle;
	}

	public void setAckTitle(String ackTitle) {
		this.ackTitle = ackTitle;
	}

	public String getAttestorName() {
		return attestorName;
	}

	public void setAttestorName(String attestorName) {
		this.attestorName = attestorName;
	}

	public int getAttestorNameCharLen() {
		return attestorNameCharLen;
	}

	public void setAttestorNameCharLen(int attestorNameCharLen) {
		this.attestorNameCharLen = attestorNameCharLen;
	}

	public String getInfoAtstMsg() {
		return infoAtstMsg;
	}

	public void setInfoAtstMsg(String infoAtstMsg) {
		this.infoAtstMsg = infoAtstMsg;
	}

	public String getUserCnfrmAtstMsg() {
		return userCnfrmAtstMsg;
	}

	public void setUserCnfrmAtstMsg(String userCnfrmAtstMsg) {
		this.userCnfrmAtstMsg = userCnfrmAtstMsg;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getAttestSucsMsg() {
		return attestSucsMsg;
	}

	public void setAttestSucsMsg(String attestSucsMsg) {
		this.attestSucsMsg = attestSucsMsg;
	}
	
	public String getEditLocationTitle() {
		return editLocationTitle;
	}

	public void setEditLocationTitle(String editLocationTitle) {
		this.editLocationTitle = editLocationTitle;
	}
	
	public String getUpdatedStreetAddress() {
		return updatedStreetAddress;
	}

	public void setUpdatedStreetAddress(String updatedStreetAddress) {
		this.updatedStreetAddress = updatedStreetAddress;
	}

	public String getUpdatedCity() {
		return updatedCity;
	}

	public void setUpdatedCity(String updatedCity) {
		this.updatedCity = updatedCity;
	}

	public String getUpdatedState() {
		return updatedState;
	}

	public void setUpdatedState(String updatedState) {
		this.updatedState = updatedState;
	}

	public String getUpdatedZipCode() {
		return updatedZipCode;
	}

	public void setUpdatedZipCode(String updatedZipCode) {
		this.updatedZipCode = updatedZipCode;
	}

	public String getUpdatedPhone() {
		return updatedPhone;
	}

	public void setUpdatedPhone(String updatedPhone) {
		this.updatedPhone = updatedPhone;
	}

	public String getUpdatedFax() {
		return updatedFax;
	}

	public void setUpdatedFax(String updatedFax) {
		this.updatedFax = updatedFax;
	}
	
}
