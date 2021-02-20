package procraft.core.utilities.automationbase;

import java.io.File;

import org.apache.log4j.Logger;
import procraft.core.utilities.ui.SeleniumHelper;

public class JenkinsHelper {
    private static Logger log = Logger.getLogger(JenkinsHelper.class);

    private JenkinsHelper() {

    }

    public static String getCurrentJobName() {
        LoggerHelper.logInfo(log, "Fetching current job name from Jenkins");
        try {
            return System.getenv("JOB_NAME");
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored our while fetching the current job name from Jenkins server");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    public static String getCurrentBuildURL() {
        LoggerHelper.logInfo(log, "Fetching current build url from Jenkins");
        try {
            return System.getenv("BUILD_URL");
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored our while fetching the current build url from Jenkins server");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    public static String getCurrentJobURL() {
        LoggerHelper.logInfo(log, "Fetching current job url from Jenkins");
        try {
            return System.getenv("JOB_URL");
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored our while fetching the current job url from Jenkins server");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    public static String getCurrentBuildNumber() {
        LoggerHelper.logInfo(log, "Fetching current build number from Jenkins");
        try {
            return System.getenv("BUILD_NUMBER");
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored our while fetching the current build number from Jenkins server");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    public static void printSessionId() {

        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
                SeleniumHelper.getCurrentSessionId(), getCurrentJobName());
        System.out.println(message);
    }

    public static String getSauceVideoLink() {
        try {
            LoggerHelper.logInfo(log, "Fetching sauce video path ");
            String path = getCurrentBuildURL() + "sauce-ondemand-report" + File.separator + "jobReport?jobId="
                    + SeleniumHelper.getCurrentSessionId();
            LoggerHelper.logInfo(log, "Sauce video path..." + path);
            return path;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while Fetching sauce video path ");
            LoggerHelper.logError(log, e);
            return "";
        }
    }
}
