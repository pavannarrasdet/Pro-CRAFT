package procraft.core.utilities.automationbase;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import procraft.core.utilities.ui.SeleniumHelper;

public class ReportHelper {
    private static Logger log = Logger.getLogger(ReportHelper.class);
    private static ExtentProperties ep;
    private static File txtFile = null;

    private ReportHelper() {

    }

    /**
     * This method is used to log the message on extent report at step level
     *
     * @param message String type to hold message to write
     */
    public static void logStepDetails(String message) {
        try {
            LoggerHelper.logInfo(log, "Writing step details to report: " + message);
            Reporter.addStepLog(message);
        } catch (Exception e) {
            LoggerHelper.logError(log, "Error out while writing step to report: " + message);
        }
    }

    /**
     * This method is used to load the config xml of report
     *
     * @param filePath string type to hold xml path
     */
    public static void loadConfig(String filePath) {
        try {
            LoggerHelper.logInfo(log, "Loading report config xml");
            Reporter.loadXMLConfig(AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(filePath)));
        } catch (Exception e) {
            LoggerHelper.logError(log, "Error out while loading report config xml: " + filePath);
        }
    }

    /**
     * This method is used to add config values/ env values to reprot in runtime
     *
     * @param key   String type value to hold Config variable name
     * @param value String type value to hold config variable value
     */
    public static void addConfigVariable(String key, String value) {
        try {
            LoggerHelper.logInfo(log, "Adding configure variable to report");
            Reporter.setSystemInfo(key, value);
        } catch (Exception e) {
            LoggerHelper.logError(log, "Error out while adding configure variable to reprot");
        }
    }

    /**
     * This method is used to add config details to report
     *
     * @param details Map object type which holds config values in key and format
     */
    public static void addConfigVariables(Map<String, String> details) {
        try {
            LoggerHelper.logInfo(log, "adding custom configurable values to report");
            for (String key : details.keySet()) {
                Reporter.setSystemInfo(key, details.get(key));
            }
        } catch (Exception e) {
            LoggerHelper.logError(log, "Error out while adding custom configurable values to report");
        }
    }

    /**
     * This method is used to add screenshot to report
     *
     * @param imgPath string type value to hold image path
     */
    public static void addScreenshot(String imgPath) {
        try {
            LoggerHelper.logInfo(log, "Adding screenshot to report: " + imgPath);
            SeleniumHelper.takeSnapShot(imgPath);
            if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().trim().toLowerCase().equals("sauce")) {
                Reporter.addScreenCaptureFromPath(AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(imgPath)));
            } else if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().trim().toLowerCase().equals("local")) {
                Reporter.addScreenCaptureFromPath(AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(imgPath)));
            } else if (AutomationBase.getJenkinsMode()) {

                if (AutomationBase.Environment("reportsServer").toLowerCase().equals("jenkins")) {
                    imgPath = JenkinsHelper.getCurrentBuildURL() + File.separator + "artifact" + File.separator + imgPath;
                    Reporter.addScreenCaptureFromPath(imgPath);
                } else if (AutomationBase.Environment("reportsServer").toLowerCase().equals("local")) {
                    imgPath = AutomationBase.Environment("serverURL") + File.separator + "JENKINS" + File.separator + AutomationBase.reportDate + File.separator + imgPath;
                    Reporter.addScreenCaptureFromPath(imgPath);
                }
            }

        } catch (Exception e) {
            LoggerHelper.logError(log, "Error out while adding screenshot to report: " + imgPath);
        }

    }

    public static void addVideo(String videoPath) {
        try {
            LoggerHelper.logInfo(log, "Adding video from given path.." + videoPath + " to report");
            Reporter.addScreenCast(videoPath);
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while adding video from given path.." + videoPath + "");
            LoggerHelper.logError(log, e);
        }

    }

    /**
     * This method is used to set report path to be saved
     *
     * @param filePath String type value to hold path
     */
    public static void setReportPath(String filePath) {
        ep = ExtentProperties.INSTANCE;
        ep.setReportPath(filePath);
    }

    /**
     * This method is used to log the test runner details
     *
     * @param message String to hold message to display
     */
    public static void logTestRunner(String message) {
        Reporter.setTestRunnerOutput(message);
    }

    public static void addJsonFileToReport(String filePath) {
        try {
            log.info("Adding json file to report: " + filePath);
            if (AutomationBase.getJenkinsMode()) {
                Reporter.addStepLog("<div><br><br><a href=" + filePath + ">json<a></div>");
            } else if (!AutomationBase.getJenkinsMode() && (AutomationBase.getPlatform().toLowerCase().equals("local") || AutomationBase.getPlatform().toLowerCase().equals("sauce"))) {
                Reporter.addStepLog("<div><br><br><a href=" + AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(filePath)) + ">json<a></div>");
            }

        } catch (Exception e) {
            log.error("Error out while adding screenshot to report: " + filePath);
        }

    }

    public static void closeReport() {
        Reporter.getExtentReport().flush();
    }

    public static void writeReport() {
        ReportHelper.loadConfig(new File("src//test//resources//extentConfig.xml").getAbsolutePath());
        Map<String, String> configValues = new HashMap<String, String>();
        configValues.put("user", AutomationBase.getUserName());
        configValues.put("OS", AutomationBase.getOSName());
        configValues.put("Region", AutomationBase.getRegion());
        configValues.put("URL", AutomationBase.buildURL(AutomationBase.getRegion()));
        ReportHelper.addConfigVariables(configValues);
        if (!AutomationBase.getJenkinsMode() && AutomationBase.getPlatform().toLowerCase().trim().equals("sauce")) {
            ReportHelper.logTestRunner("<div>Test logs section<br><a href="
                    + AutomationBase.getAbsoulteFilePath(AutomationBase.getFile("target\\logs\\execution.log"))
                    + ">please find logs here</a></br></div>");
            ReportHelper.closeReport();
        } else if (!AutomationBase.getJenkinsMode()
                && AutomationBase.getPlatform().toLowerCase().trim().equals("local")) {
            ReportHelper.logTestRunner("<div>Test logs section<br><a href="
                    + AutomationBase.getAbsoulteFilePath(AutomationBase.getFile("target\\logs\\execution.log"))
                    + ">please find logs here</a></br></div>");
            ReportHelper.closeReport();
        } else if (AutomationBase.getJenkinsMode()) {
            if (AutomationBase.Environment("reportsServer").toLowerCase().equals("jenkins")) {
                ReportHelper.logTestRunner("<div>Test logs section<br><a href=" + JenkinsHelper.getCurrentBuildURL() + File.separator + "artifact" + File.separator + "target/logs/execution.log" + ">please find logs here</a></br></div>");
            } else if (AutomationBase.Environment("reportsServer").toLowerCase().equals("local")) {
                txtFile = AutomationBase.createFile(
                        AutomationBase.getAbsoulteFilePath(AutomationBase.getFile("target//logs//execution.txt")));
                String logContent = AutomationBase.readFileAsString(AutomationBase.getFile("target//logs//execution.log"),
                        "utf-8");
                AutomationBase.writeAndSaveTextFile(txtFile, logContent);
                ReportHelper.logTestRunner("<div>Test logs section<br><a href=" + AutomationBase.Environment("serverURL")
                        + File.separator + "JENKINS" + File.separator + AutomationBase.reportDate + File.separator
                        + "target/logs/execution.txt" + ">please find logs here</a></br></div>");
            }

            ReportHelper.closeReport();
        }
    }
}
