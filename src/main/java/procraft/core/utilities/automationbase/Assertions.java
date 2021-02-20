package procraft.core.utilities.automationbase;

import java.io.File;

import org.junit.Assert;

public class Assertions {

    private Assertions() {

    }

    /**
     * This method is used to assert the given condition and throws exception if its false and doesnt take the screenshot
     *
     * @param assertMessage  String type value that holds message to display
     * @param successMessage String type value that holds message to display
     * @param condition      boolean type that holds true or false
     */
    public static void assertTrue(String assertMessage, String successMessage, boolean condition) {
        Assert.assertTrue(assertMessage, condition);
        ReportHelper.logStepDetails(successMessage);
    }

    /**
     * This method is used to assert the given condition and throws exception if its false and takes the screenshot
     *
     * @param assertMessage String type value that holds message to display
     * @param condition     boolean type value that holds true or false
     */
    public static void assertTrue(String assertMessage, boolean condition) {
        try {
            Assert.assertTrue(assertMessage, condition);
            ReportHelper.addScreenshot(getScreenShotPath());

        } catch (AssertionError ae) {
            ReportHelper.addScreenshot(getScreenShotPath());
            throw new AssertionError(assertMessage);
        }
    }

    /**
     * This This method is used to assert the given condition and throws exception if its false and takes the screenshot based on user input
     *
     * @param assertMessage String type value that holds message to display
     * @param condition     boolean type value that holds true or false
     * @param screenShot    boolean type value to hold true or false
     */
    public static void assertTrue(String assertMessage, boolean condition, boolean screenShot) {
        try {
            Assert.assertTrue(assertMessage, condition);
            if (screenShot)
                ReportHelper.addScreenshot(getScreenShotPath());
        } catch (AssertionError ae) {
            ReportHelper.addScreenshot(getScreenShotPath());
            throw new AssertionError(assertMessage);
        }
    }

    /**
     * This method is used to assert the given condition false or not and throws an exception if its true
     *
     * @param assertMessage  String type value that holds message to display
     * @param successMessage String type value that holds message to display
     * @param condition      boolean type value that holds true or false
     */
    public static void assertFalse(String assertMessage, String successMessage, boolean condition) {
        Assert.assertFalse(assertMessage, condition);
        ReportHelper.logStepDetails(successMessage);
    }

    /**
     * This method is used to assert the given condition false or not and throws an exception if its true
     *
     * @param assertMessage String type value that holds message to display
     * @param condition     boolean type value that holds true or false
     */
    public static void assertFalse(String assertMessage, boolean condition) {
        try {
            Assert.assertFalse(assertMessage, condition);
            ReportHelper.addScreenshot(getScreenShotPath());
        } catch (AssertionError ae) {
            ReportHelper.addScreenshot(getScreenShotPath());
            throw new AssertionError(assertMessage);
        }

    }

    /**
     * This method is used to asserts the given object is null or not, fails if its null
     *
     * @param obj     Object type value
     * @param message String type value that holds message to dispaly
     */
    public static void assertNotNull(Object obj, String message) {
        Assert.assertNotNull(message, obj);
    }

    public static void assertTrue(String assertMessage, boolean condition, String filePath) {
        try {
            Assert.assertTrue(assertMessage, condition);
            if (filePath != null) {
                ReportHelper.addJsonFileToReport(getJSONFilePath(filePath));
            }

        } catch (AssertionError ae) {
            ReportHelper.addJsonFileToReport(getJSONFilePath(filePath));
            throw new AssertionError(assertMessage);
        }
    }

    public static String getScreenShotPath() {

        return AutomationBase.Environment("screenShotsPath") + File.separator + AutomationBase.getBrowser() +
                File.separator + AutomationBase.getPageName() + "-" + AutomationBase.formatDateAndTime(AutomationBase.getCurrentDateAndTime(), AutomationBase.Environment("dateFormat")) + ".png";
    }

    public static String getJSONFilePath(String jsonFilePath) {
        if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().toLowerCase().trim().equals("sauce")) {
            return jsonFilePath;
        } else if (AutomationBase.getPlatform().toLowerCase().trim().equals("local") && !AutomationBase.getJenkinsMode()) {
            return jsonFilePath;
        } else if (AutomationBase.getJenkinsMode()) {
            if (AutomationBase.Environment("reportsServer").toLowerCase().equals("jenkins")) {
                return JenkinsHelper.getCurrentBuildURL() + File.separator + "artifact" + File.separator + jsonFilePath;
            } else if (AutomationBase.Environment("reportsServer").toLowerCase().equals("local")) {
                return AutomationBase.Environment("serverURL") + File.separator + "JENKINS" + File.separator + AutomationBase.reportDate + File.separator + jsonFilePath;
            }

        }
        return null;
    }

}
