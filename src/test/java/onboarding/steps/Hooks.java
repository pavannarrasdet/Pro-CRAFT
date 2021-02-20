package onboarding.steps;

import org.apache.log4j.Logger;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import procraft.core.utilities.automationbase.Assertions;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.automationbase.LoggerHelper;
import procraft.core.utilities.automationbase.ReportHelper;
import procraft.core.utilities.ui.SeleniumHelper;

public class Hooks {
	private static Logger log = Logger.getLogger(Hooks.class);

	@Before
	public void tearUP(Scenario scenario) {
		AutomationBase.setCurrentScenarioName(scenario.getName().toString());
		LoggerHelper.logInfo(log,
				"********* Execution of Scenario--" + scenario.getName().toString() + "-- was started************");
		Assertions.assertNotNull(MasterSteps.invokeDriver(), "tearUP failed while initializing the driver");
		SeleniumHelper.navigateToURL(AutomationBase.buildURL());
		// SeleniumHelper.navigateToURL("http://onboarding-ui-provider-onboarding-dev.ocp-ctc-dmz-nonprod.optum.com/");
	}

	@After
	public void tearDown(Scenario scenario) {
		LoggerHelper.logInfo(log,
				"********* Execution of Scenario--" + scenario.getName().toString() + "-- was ended************");
		MasterSteps.resetDataObjects();
		if (AutomationBase.getJenkinsMode() || AutomationBase.getPlatform().toLowerCase().equals("sauce")) {
			ReportHelper.logStepDetails("<div><br><br><a href=" + SeleniumHelper.getSauceAssetVideoLink()
					+ ">click here to watch video<a></div>");
		}
		SeleniumHelper.quitDriver();
	}
}
