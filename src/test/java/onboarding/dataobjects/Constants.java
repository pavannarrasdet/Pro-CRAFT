package onboarding.dataobjects;

import procraft.core.utilities.automationbase.AutomationBase;

public class Constants {

	public static final String TEST_AUTOMATION_EXTERNAL_USER_FNAME = "Pavan";
	public static final String TEST_AUTOMATION_EXTERNAL_USER_LNAME = "Narra";
	public static final String TEST_AUTOMATION_EXTERNAL_USER_MNAME="L";
	public static final String app_Title = "Provider Onboarding";
	public static final String fName_Spl_Char = "fName'";
	public static final String lName_Spl_Char = "lName'";
	public static final String mName_Spl_Char = "mName'";
	public static final String fName_Num_Spl_Char = "f1Name'";
	public static final String lName_Num_Spl_Char = "l2Name'";
	public static final String mName_Num_Spl_Char = "m3Name'";
	public static final String spl_Char = "'@";
	public static final int one = 1;
	public static final int two = 2;
	public static final int six = 6;
	public static final int seven = 7;
	public static final int three = 3;
	public static final int nine = 9;
	public static final String inValidNPI = "1234455679";
	public static final String prefix = "Dr.";
	public static final String errPrefix = "Error: ";
	public static final String rfpURL = "/rfp";
	public static final String yes = "yes";
	public static final String no = "no";
	public static final String practitionerInfo = "Practitioner Info";
	public static final String hospitalAffiliation = "Hospital Affiliation";
	public static final String attachments = "Attachments";
	public static final String licenses = "Licenses";
	public static final String locations = "Locations";
	public static final String contractInfo="Contract Info";
	public static final String invalidDateAlphaNumeric = "Test1238";
	public static final String invalidDate = "333333";
	public static final String forwardSlash = "/";
	public static final String zeroInString = "0";
	public static final String MMddyyyy = "MMddyyyy";
	public static final String yyyyMMdd = "yyyyMMdd";
	public static final String redRGBA="rgba(177, 12, 0, 1)";
	public static final String greenRGBA="rgba(0, 112, 0, 1)";
	public static final String statusTracker_PrctRcrd_NPI_LBL="NPI: ";
	public static final String statusTracker_PrctRcrd_SPCLTY_LBL="Specialty: ";
	public static final String status_Tracker_PrctRecrd_RefrenceNum_Lbl="Reference Number";
	public static final String status_Tracker_PrctRecrd_ReqstSub_Lbl="Request Submitted";
	public static final String status_Tracker_PrctRecrd_Cred_Verfd_Lbl="Credentials Verified";
	public static final String status_Tracker_PrctRecrd_Cred_Required_lbl = "EST: $auto";
	public static final String status_Tracker_PrctRecrd_Cred_Not_Required_lbl = "Not Required";
	public static final String rfpStatus_Submitted="Submitted";
	public static final String rfpStatus_In_Completed="In-Completed";
	public static final String credStatus_Required="Required";
	public static final String credStatus_Not_Required="Not-Required";
	public static final String rfp_New_Submitted_Record="New-Submitted";
	public static final String rfp_New_Completed_Record="New-Completed";
	public static final String rfp_New_In_Completed_Record="New-In-Completed";
	public static final String rfp_Existing_Completed_Record="Existing-Completed";
	public static final String rfp_Existing_Submitted_Record="Existing-Submitted";
	public static final String rfp_Existing_In_Completed_Record="Existing-In-Completed";
	public static final String rfp_Existing_Closed_Record="Existing-Closed";
	public static final String rfp_Existing_Denied_Record="Existing-Denied";
	public static final String rfp_Record_Date_Format="MM/dd/yyyy";
	public static final String auto="Auto";
	public static final String estDateAuto="$auto";
	public static final int estDaysLen=14;
	
	public static  final String getRedRGBA()
	{
		if(AutomationBase.getBrowser().equals("chrome")||AutomationBase.getBrowser().equals("ie"))
		{
			return "rgba(177, 12, 0, 1)";
		}
		else if (AutomationBase.getBrowser().equals("firefox")||AutomationBase.getBrowser().equals("edge"))
		{
			return "rgb(177, 12, 0)";
		}
		return "";
	}
	
	public static  final String getGreenRGBA()
	{
		if(AutomationBase.getBrowser().equals("chrome")||AutomationBase.getBrowser().equals("ie"))
		{
			return "rgba(0, 112, 0, 1)";
		}
		else if (AutomationBase.getBrowser().equals("firefox")||AutomationBase.getBrowser().equals("edge"))
		{
			return "rgb(0, 112, 0)";
		}
		return "";
	}
	
	
	
	//rgb(0, 112, 0)
}
