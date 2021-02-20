package onboarding.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import onboarding.pages.AcknowledgementAndSubmitPage;
import onboarding.pages.AddAffiliatedHospitalPage;
import onboarding.pages.AddLicensesPage;
import onboarding.pages.AddLocationPage;
import onboarding.pages.AddProviderPage;
import onboarding.pages.BasePage;
import onboarding.pages.ContactUsPage;
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
import onboarding.steps.MasterSteps;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.automationbase.JenkinsHelper;
import procraft.core.utilities.automationbase.ReportHelper;
import procraft.core.utilities.ui.SeleniumHelper;
import procraft.core.utilities.ui.SeleniumHelper.elementLocators;
import procraft.core.utilities.ui.SeleniumHelper.expectedConditions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/resource-files/features", glue = { "onboarding.steps" }, plugin = {
		"pretty", "json:target/cucumber-reports/json-reports/json-report.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, tags = {
				"@US2089109" }, monochrome = true)
public class JunitRunnerTest {

	@BeforeClass
	public static void getPages() {

		if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().toLowerCase().equals("sauce")) {
			AutomationBase.reportDate = AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(),
					AutomationBase.Environment("ssdateFormat"));
		} else if (AutomationBase.getJenkinsMode()) {
			AutomationBase.reportDate = System.getenv("currentDate");
		}
		MasterSteps.setLoginPage((LoginPage) BasePage.getPage(LoginPage.class.getCanonicalName()));
		MasterSteps.setDashBoardPage((DashBoardPage) BasePage.getPage(DashBoardPage.class.getCanonicalName()));
		MasterSteps.setAddProviderPage((AddProviderPage) BasePage.getPage(AddProviderPage.class.getCanonicalName()));
		MasterSteps.setCredentialingDecisionPage(
				(CredentialingDecisionPage) BasePage.getPage(CredentialingDecisionPage.class.getCanonicalName()));
		MasterSteps.setRFPPage((RFPPage) BasePage.getPage(RFPPage.class.getCanonicalName()));
		MasterSteps.setAddAffiliatedHospitalPage(
				(AddAffiliatedHospitalPage) BasePage.getPage(AddAffiliatedHospitalPage.class.getCanonicalName()));
		MasterSteps.setLicensesPage((LicensesPage) BasePage.getPage(LicensesPage.class.getCanonicalName()));
		MasterSteps.setAddLicensesPage((AddLicensesPage) BasePage.getPage(AddLicensesPage.class.getCanonicalName()));
		MasterSteps.setEditHsptlAfltPage(
				(EditAffiliatedHospitalPage) BasePage.getPage(EditAffiliatedHospitalPage.class.getCanonicalName()));
		MasterSteps.setDelHsptlAfltPage(
				(DeleteAffiliatedHospitalPage) BasePage.getPage(DeleteAffiliatedHospitalPage.class.getCanonicalName()));
		MasterSteps.setEditLicensePage((EditLicensesPage) BasePage.getPage(EditLicensesPage.class.getCanonicalName()));
		MasterSteps.setDelLicensePage((DeleteLicensePage) BasePage.getPage(DeleteLicensePage.class.getCanonicalName()));
		MasterSteps.setAddLocationPage((AddLocationPage) BasePage.getPage(AddLocationPage.class.getCanonicalName()));
		MasterSteps.setAckSubPage(
				(AcknowledgementAndSubmitPage) BasePage.getPage(AcknowledgementAndSubmitPage.class.getCanonicalName()));
		MasterSteps.setContactUsPage((ContactUsPage) BasePage.getPage(ContactUsPage.class.getCanonicalName()));
		MasterSteps.setEditLocationPage((EditLocationPage) BasePage.getPage(EditLocationPage.class.getCanonicalName()));
	}

	@AfterClass
	public static void writeExtentReport() {

		ReportHelper.writeReport();
		if (AutomationBase.getJenkinsMode()) {
			captureSummarySnap();
		} else {
			openLocalReprt();
		}

	}

	private static void captureSummarySnap() {
		AutomationBase.captureSnap = true;
		MasterSteps.invokeDriver("ie");
		String url = "";
		url = JenkinsHelper.getCurrentJobURL() + "/ws/target/cucumber-reports/report.html";
		System.out.println("Report URL in Jenkins workspace.." + url);
		SeleniumHelper.navigateToURL(url);
		String[] unameProps = { elementLocators.id.toString(), "j_username", "jenkins_uname" };
		String[] pwdProps = { elementLocators.name.toString(), "j_password", "jenkins_pwd" };
		String[] signBtnProps = { elementLocators.name.toString(), "Submit", "Submit" };
		SeleniumHelper.enterText(SeleniumHelper.byLocator(unameProps), 20, expectedConditions.elementToBeClickable,
				"propel_dev1");
	/*	SeleniumHelper.enterText(SeleniumHelper.byLocator(pwdProps), 20, expectedConditions.elementToBeClickable,
				AutomationBase.decrypt("C8BExD6W2"));*/
		SeleniumHelper.enterText(SeleniumHelper.byLocator(pwdProps), 20, expectedConditions.elementToBeClickable,"C8BExD6W2");
		SeleniumHelper.clickElement(SeleniumHelper.byLocator(signBtnProps), 20,
				expectedConditions.elementToBeClickable);
		String[] props = { elementLocators.cssSelector.toString(), "a[view='dashboard-view']", "report dashboard" };
		SeleniumHelper.clickElement(SeleniumHelper.byLocator(props), 20, expectedConditions.elementToBeClickable);
		SeleniumHelper.scrollTo(0, 1000);
		SeleniumHelper.takeSnapShot("target/reportSum.png");
		SeleniumHelper.quitDriver();
	}

	private static void openLocalReprt() {
		SeleniumHelper.launchChromeDriver();
		String url = AutomationBase.getRootPath() + File.separator + "target/cucumber-reports/report.html";
		SeleniumHelper.navigateToURL(url);
	}
}
