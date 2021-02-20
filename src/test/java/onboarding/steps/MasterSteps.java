package onboarding.steps;

import onboarding.dataobjects.AddAffiliatedHospitalData;
import onboarding.dataobjects.AddContractInfoData;
import onboarding.dataobjects.AddLicenseData;
import onboarding.dataobjects.AddLocationData;
import onboarding.dataobjects.AddProviderData;
import onboarding.dataobjects.AttachmentsData;
import onboarding.dataobjects.CredentialingDecisionData;
import onboarding.dataobjects.DashBoardData;
import onboarding.dataobjects.DeleteAffiliatedHospData;
import onboarding.dataobjects.DeleteLicenseData;
import onboarding.dataobjects.EditAffiliatedHospitalData;
import onboarding.dataobjects.EditLicenseData;
import onboarding.dataobjects.EditLocationData;
import onboarding.dataobjects.LoginData;
import onboarding.dataobjects.RFPData;
import onboarding.dataobjects.WelcomeData;
import onboarding.pages.AcknowledgementAndSubmitPage;
import onboarding.pages.AddAffiliatedHospitalPage;
import onboarding.pages.AddLicensesPage;
import onboarding.pages.AddLocationPage;
import onboarding.pages.AddProviderPage;
import onboarding.pages.CredentialingDecisionPage;
import onboarding.pages.DashBoardPage;
import onboarding.pages.DeleteAffiliatedHospitalPage;
import onboarding.pages.DeleteLicensePage;
import onboarding.pages.EditAffiliatedHospitalPage;
import onboarding.pages.EditLicensesPage;
import onboarding.pages.EditLocationPage;
import onboarding.pages.LicensesPage;
import onboarding.pages.LoginPage;
import onboarding.pages.RFPPage;
import onboarding.pages.ContactUsPage;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.ui.SeleniumHelper;

public class MasterSteps {

	// Page Data Objects
	public static LoginData loginData = null;
	public static WelcomeData welComeData = null;
	public static DashBoardData dashBoardData = null;
	public static AddProviderData addproviderdata = null;
	public static CredentialingDecisionData credentialingdecisiondata = null;
	public static RFPData rfpData = null;
	public static AddAffiliatedHospitalData addAffHspData = null;
	public static AddContractInfoData addContractInfoData = null;
	public static AddLicenseData addlicensedata = null;
	public static AttachmentsData attachmentsdata = null;
	public static EditAffiliatedHospitalData editAffliatedData=null;
	public static DeleteAffiliatedHospData deleteAfflData=null;
	public static EditLicenseData editLicenseData=null;
	public static DeleteLicenseData deleteLicenseData=null;
	public static AddLocationData addLocationData=null;
	public static EditLocationData editLocationData=null;

	// Page Objects
	private static LoginPage loginPage = null;
	private static DashBoardPage dashboardPage = null;
	private static AddProviderPage addProviderPage = null;
	private static CredentialingDecisionPage credentialingDecisionPage = null;
	private static RFPPage rfpPage = null;
	private static AddAffiliatedHospitalPage addAffHspPage = null;
	private static LicensesPage licensesPage = null;
	private static AddLicensesPage addLicensesPage = null;
	private static EditAffiliatedHospitalPage editAffiliatedHospitalPage=null;
	private static DeleteAffiliatedHospitalPage deltAfflHspPage=null;
	private static EditLicensesPage editLicensePage=null;
	private static DeleteLicensePage deleteLicensePage=null;
	private static AddLocationPage addLocation=null;
	private static AcknowledgementAndSubmitPage ackSubPage=null;
	private static ContactUsPage contactUsPage = null;
	private static EditLocationPage editLocation=null;
	
	public static void setLoginPage(LoginPage object) {
		loginPage = object;
	}

	public static LoginPage getLoginPage() {
		return loginPage;
	}

	public static DashBoardPage getDashBoardPage() {
		return dashboardPage;
	}

	public static void setDashBoardPage(DashBoardPage object) {
		dashboardPage = object;
	}
	
	public static void setContactUsPage(ContactUsPage object) {
		contactUsPage = object;
	}
	
	public static ContactUsPage getContactUsPage() {
		return contactUsPage;
	}

	public static void setAddProviderPage(AddProviderPage object) {
		addProviderPage = object;
	}

	public static AddProviderPage getAddProviderPage() {
		return addProviderPage;
	}

	public static void setCredentialingDecisionPage(CredentialingDecisionPage object) {
		credentialingDecisionPage = object;
	}

	public static CredentialingDecisionPage getCredentialingDecisionPage() {
		return credentialingDecisionPage;
	}

	public static void setRFPPage(RFPPage object) {
		rfpPage = object;
	}

	public static RFPPage getRFPPage() {
		return rfpPage;
	}

	public static AddAffiliatedHospitalPage getAddAffiliatedHospitalPage() {
		return addAffHspPage;
	}

	public static void setAddAffiliatedHospitalPage(AddAffiliatedHospitalPage object) {
		addAffHspPage = object;
	}

	public static void setLicensesPage(LicensesPage object) {
		licensesPage = object;
	}

	public static LicensesPage getLicensesPage() {
		return licensesPage;
	}

	public static void setAddLicensesPage(AddLicensesPage object) {
		addLicensesPage = object;
	}

	public static AddLicensesPage getAddLicensesPage() {
		return addLicensesPage;
	}
	
	public static void setEditHsptlAfltPage(EditAffiliatedHospitalPage object) {
		editAffiliatedHospitalPage = object;
	}

	public static EditAffiliatedHospitalPage getEditHsptlAfltPage() {
		return editAffiliatedHospitalPage;
	}
	
	public static void setDelHsptlAfltPage(DeleteAffiliatedHospitalPage object) {
		deltAfflHspPage = object;
	}
	
	public static DeleteAffiliatedHospitalPage getDelHsptlAfltPage() {
		return deltAfflHspPage;
	}
	
	public static void setEditLicensePage(EditLicensesPage object) {
		editLicensePage = object;
	}

	public static EditLicensesPage getEditLicensePage() {
		return editLicensePage;
	}
	
	public static void setDelLicensePage(DeleteLicensePage object) {
		deleteLicensePage = object;
	}
	
	public static DeleteLicensePage getDelLicensePage() {
		return deleteLicensePage;
	}
	
	public static AddLocationPage getAddLocationPage() {
		return addLocation;
	}

	public static void setAddLocationPage(AddLocationPage addLocation) {
		MasterSteps.addLocation = addLocation;
	}
	
	public static EditLocationPage getEditLocationPage() {
		return editLocation;
	}

	public static void setEditLocationPage(EditLocationPage editLocation) {
		MasterSteps.editLocation = editLocation;
	}
	public static boolean invokeDriver() {
		if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().toLowerCase().trim().equals("local")) {
			SeleniumHelper.launchDriver(AutomationBase.getBrowser());
			return true;
		} else if (AutomationBase.getJenkinsMode()
				|| AutomationBase.getPlatform().toLowerCase().trim().equals("sauce")) {
			SeleniumHelper.launchSauceDriver(AutomationBase.getBrowser());
			return true;
		}
		return false;
	}

	public static boolean invokeDriver(String browser) {
		if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().toLowerCase().trim().equals("local")) {
			SeleniumHelper.launchDriver(browser);
			return true;
		} else if (AutomationBase.getJenkinsMode()
				|| AutomationBase.getPlatform().toLowerCase().trim().equals("sauce")) {
			SeleniumHelper.launchSauceDriver(browser);
			return true;
		}
		return false;
	}

	public static void resetDataObjects() {
		loginData = null;
		welComeData = null;
	}

	public static AcknowledgementAndSubmitPage getAckSubPage() {
		return ackSubPage;
	}

	public static void setAckSubPage(AcknowledgementAndSubmitPage ackSubPage) {
		MasterSteps.ackSubPage = ackSubPage;
	}

	

}
