package onboarding.dataobjects;

import java.util.Map;
import cucumber.api.DataTable;

public class EditAffiliatedHospitalData {
	
	private String hospitalName="";
	private String privileges="";
	private String privilegesValues="";
	private String reqrdMsg="";
	private String admitingHdrMsg="";
	private String admitingMsg="";
	private String fstNameAdmtng="";
	private String lstNameAdmtng="";
	private String mNameAdmtng="";
	private String spctlyAdmtng="";
	private String npiAdmtng="";
	private int hospitalNameCharLength=0;
	private int fstNameChrLen=0;
	private int lstNameChrLen=0;
	private int mNmeChrLen=0;
	private int npiChrLen=0;
	private String npiLenErr="";
	private String npiLuhnErr="";
	
	Map<String, String> data = null;
	
	public EditAffiliatedHospitalData(DataTable table) {
        data = table.asMap(String.class, String.class);
        if (data.containsKey("HospitalName")) {
            this.hospitalName = data.get("HospitalName");
        }
        if (data.containsKey("Privileges")) {
            this.privileges = data.get("Privileges");
        }
        if (data.containsKey("Privileges_Values")) {
            this.privilegesValues = data.get("Privileges_Values");
        }
        if (data.containsKey("RequiredMsg")) {
            this.reqrdMsg = data.get("RequiredMsg");
        }
        if (data.containsKey("HospitalName_Char_Length")) {
        	this.hospitalNameCharLength = Integer.parseInt(data.get("HospitalName_Char_Length"));
        }
        if (data.containsKey("AdmittingMsgHdr")) {
            this.admitingHdrMsg = data.get("AdmittingMsgHdr");
        }
        if (data.containsKey("AdmittingMsg")) {
            this.admitingMsg = data.get("AdmittingMsg");
        }
        if (data.containsKey("LastNameAdmitting")) {
            this.lstNameAdmtng = data.get("LastNameAdmitting");
        }
        if (data.containsKey("FirstNameAdmitting")) {
            this.fstNameAdmtng = data.get("FirstNameAdmitting");
        }
        if (data.containsKey("MiddleNameAdmitting")) {
            this.mNameAdmtng = data.get("MiddleNameAdmitting");
        }
        if (data.containsKey("SpecialityAdmitting")) {
            this.spctlyAdmtng = data.get("SpecialityAdmitting");
        }
        if (data.containsKey("NPIAdmitting")) {
            this.npiAdmtng = data.get("NPIAdmitting");
        }
        if (data.containsKey("FirstName_Char_Length")) {
            this.fstNameChrLen = Integer.parseInt(data.get("FirstName_Char_Length"));
        }
        if (data.containsKey("MiddleName_Char_Length")) {
            this.mNmeChrLen = Integer.parseInt(data.get("MiddleName_Char_Length"));
        }
        if (data.containsKey("LastName_Char_Length")) {
            this.lstNameChrLen = Integer.parseInt(data.get("LastName_Char_Length"));
        }
        if (data.containsKey("NPI_Char_Length")) {
            this.npiChrLen = Integer.parseInt(data.get("NPI_Char_Length"));
        }
        if (data.containsKey("NPI_Len_Err")) {
            this.npiLenErr = data.get("NPI_Len_Err");
        }
        if (data.containsKey("NPI_Luhn_Err")) {
            this.npiLuhnErr = data.get("NPI_Luhn_Err");
        }
	}
	
	public String getHospitalName()
	{
		return hospitalName;
	}
	
	public String getPrivileges()
	{
		return privileges;
	}
	
	public String getPrivilegesValues()
	{
		return privilegesValues;
	}
	
	public String getReqrdMsg()
	{
		return reqrdMsg;
	}
	
	public int getHospitalNameCharLen()
	{
		return hospitalNameCharLength;
	}
	
	public String getAdmitngHdrMsg()
	{
		return admitingHdrMsg;
	}
	public String getAdmitngTailMsg()
	{
		return admitingMsg;
	}
	public String getFirstNameAdmitting()
	{
		return fstNameAdmtng;
	}
	public String getLastNameAdmitting()
	{
		return lstNameAdmtng;
	}
	public String getMiddleNameAdmitting()
	{
		return mNameAdmtng;
	}
	public String getSpecialityAdmitting()
	{
		return spctlyAdmtng;
	}
	public String getNPIAdmitting()
	{
		return npiAdmtng;
	}
	public int getFnameAdmittingChrLen()
	{
		return fstNameChrLen;
	}
	public int getMnameAdmitngCharLen()
	{
		return mNmeChrLen;
	}
	public int getLnameAdmtngChrLen()
	{
		return lstNameChrLen;
	}
	public int getNPIChrLen()
	{
		return npiChrLen;
	}
	public String getNPILUHNErr()
	{
		return npiLuhnErr;
	}
	public String getNPILenErr()
	{
		return npiLenErr;
	}
	
}
