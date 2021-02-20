package procraft.core.utilities.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import procraft.core.utilities.automationbase.AutomationBase;
import procraft.core.utilities.automationbase.JenkinsHelper;
import procraft.core.utilities.automationbase.LoggerHelper;

public class SeleniumHelper {

	/**
	 * Properties of Seleniumhelper class
	 */
	private static Logger log = Logger.getLogger(SeleniumHelper.class);
	private static long scriptTimeOut;
	private static WebDriver currentDriver = null;
	private static NgWebDriver ngDriver = null;
	private static String sauceUserName = null;
	private static String sauceAccessKey = null;
	private static String sauceUrl = null;
	private static WebDriverWait wait = null;
	private static String currentObjName = null;
	private static Actions actions = null;
	private static JavascriptExecutor js = null;
	private static int count = 0;
	private static final String SAUCE_PARENT_TUNNEL = AutomationBase.Environment("sauceParentTunnel");
	private static final String SAUCE_TUNNEL_IDENTIFIER = AutomationBase.Environment("sauceTunnelIdentifier");
	private static final String SAUCE_JOB_VISIBILITY = AutomationBase.Environment("jobVisibility");

	/**
	 * Private constructor to restrict initialization
	 */
	private SeleniumHelper() {

	}

	/**
	 * Enum for element locators
	 *
	 * @author pnarra
	 */
	public static enum elementLocators {
		id, name, xpath, linkText, cssSelector, tagName, partialLinkText, className, repeater, exactRepeater, binding, exactBinding, model, options, buttonText, partialButtonText, cssContainingText
	}

	/**
	 * Enum for expected conditions
	 *
	 * @author pnarra
	 */

	public static enum expectedConditions {
		alertIsPresent, attributeContains, attributeToBe, attributeToBeNotEmpty, elementSelectionState, elementToBeClickable, frameToBeAvailableAndSwitch, invisiblityOfElement, inVisiblityOfElementWithText, elementToBeSelected, noOfElements, presenceOfElement, presenceOfElements, presenceOfNestedElement, presenceOfNestedElements, staleNess, textToBe, textToBePresentInElement, titleContains, titleIs, urlContains, urlMatches, urlToBe, visiblityOfElement, visibilityOfElements, visibilityOfNestedElements, invisibilityOfElements
	}

	/**
	 * Enum for supported browsers
	 *
	 * @author pnarra
	 */
	public static enum browserNames {
		firefox, chrome, ie, edge
	}

	/**
	 * This method is used to launch the given browser
	 *
	 * @param browserName
	 *            a string type value that holds browser name to be launched
	 * @return returns a browser of type webdriver
	 */
	public static WebDriver launchDriver(String browserName) {
		LoggerHelper.logInfo(log, "Launching Webdriver was called..");
		InternetExplorerOptions ieoptions = null;
		ChromeDriverService service;
		ChromeOptions options;
		try {
			switch (browserName.toLowerCase()) {
			case "ie":
				
				  System.setProperty("webdriver.ie.driver",
				  AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(AutomationBase.
				  getDriverPath())));
				 
				//System.setProperty("webdriver.ie.driver","C:\\Users\\pnarra\\Downloads\\IEDriverServer_x64_3.9.0\\IEDriverServer.exe");
				ieoptions = new InternetExplorerOptions();
				ieoptions.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
				ieoptions.setCapability(CapabilityType.VERSION, "11");
				ieoptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				ieoptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				ieoptions.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, false);
				ieoptions.setCapability("ignoreZoomSetting", true);
				ieoptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				currentDriver = new InternetExplorerDriver(ieoptions);
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(AutomationBase.getDriverPath())));
				service = ChromeDriverService.createDefaultService();
				options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("--start-maximized");
				options.addArguments("--disable-extensions");
				options.setExperimentalOption("useAutomationExtension", false);
				currentDriver = new ChromeDriver(service, options);
				break;

			default:
				LoggerHelper.logInfo(log, "No browser argument was supplied- " + browserName);
				throw new IllegalArgumentException();
			}
			LoggerHelper.logInfo(log, "Webdriver was launched successfully for the given browser.." + browserName);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while initializing webdriver for given browser " + browserName);
			LoggerHelper.logError(log, e);
			return currentDriver;
		}
		currentDriver.manage().deleteAllCookies();
		currentDriver.manage().window().maximize();
		// currentDriver.manage().window().setSize(new
		// Dimension(1024, 768));
		scriptTimeOut = Long.parseLong(AutomationBase.Environment("globalScriptSyncTime"));
		currentDriver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.SECONDS);
		actions = new Actions(currentDriver);
		js = (JavascriptExecutor) currentDriver;
		return currentDriver;
	}

	/**
	 * This method is used to launch the chrome browser
	 * 
	 * @return returns a chrome browser of type webdriver
	 */
	public static WebDriver launchChromeDriver() {
		LoggerHelper.logInfo(log, "Launching chrome driver was called..");
		ChromeDriverService service;
		ChromeOptions options;
		try {

			System.setProperty("webdriver.chrome.driver",
					AutomationBase.getAbsoulteFilePath(AutomationBase.getFile(AutomationBase.getChromeDriverPath())));
			service = ChromeDriverService.createDefaultService();
			options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			//options.addArguments("--headless");
			options.setExperimentalOption("useAutomationExtension", false);
			currentDriver = new ChromeDriver(service, options);
			LoggerHelper.logInfo(log, "Webdriver was launched successfully for the chrome browser..");
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while initializing webdriver for chrome browser ");
			LoggerHelper.logError(log, e);
			return currentDriver;
		}
		currentDriver.manage().deleteAllCookies();
		currentDriver.manage().window().maximize();
		scriptTimeOut = Long.parseLong(AutomationBase.Environment("globalScriptSyncTime"));
		currentDriver.manage().timeouts().setScriptTimeout(scriptTimeOut, TimeUnit.SECONDS);
		actions = new Actions(currentDriver);
		js = (JavascriptExecutor) currentDriver;
		return currentDriver;
	}

	/**
	 * This method is used to launch a browser in sauce
	 *
	 * @param browserName
	 *            a string type value that holds browser name to be launched
	 * @return returns remote driver type of webdriver
	 */
	public static WebDriver launchSauceDriver(String browserName) {

		try {
			LoggerHelper.logInfo(log, "Launch sauce driver was called for a given browser: " + browserName);
			LoggerHelper.logInfo(log,
					"Sauce tunnels details.." + SAUCE_PARENT_TUNNEL + " / " + SAUCE_TUNNEL_IDENTIFIER);
			DesiredCapabilities ieCaps = null;
			ChromeOptions chromeOps = null;
			RemoteWebDriver remoteDriver = null;
			sauceUserName = AutomationBase.Environment("sauce_userName");
			sauceAccessKey = AutomationBase.Environment("sauce_accessKey");
			sauceUrl = AutomationBase.Environment("sauce_url");
			sauceUrl = sauceUrl.replaceAll("userName", sauceUserName);
			sauceUrl = sauceUrl.replaceAll("accessKey", sauceAccessKey);
			if (sauceAccessKey == null || sauceUserName == null) {
				throw new IllegalArgumentException();
			}
			switch (browserName) {
			case "ie":
				ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability("parentTunnel", SAUCE_PARENT_TUNNEL);
				ieCaps.setCapability("tunnelIdentifier", SAUCE_TUNNEL_IDENTIFIER);
				ieCaps.setCapability("public", SAUCE_JOB_VISIBILITY);
				ieCaps.setCapability("platform", "Windows 7");
				ieCaps.setCapability("version", AutomationBase.Environment("ieVersion"));
				ieCaps.setCapability("screenResolution", "1920x1080");
				if (!AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					ieCaps.setCapability("name", AutomationBase.getCurrentScenarioName());
					ieCaps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					ieCaps.setCapability("name", AutomationBase.getCurrentScenarioName());
					/*
					 * ieCaps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					ieCaps.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				} else if (!AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					ieCaps.setCapability("name", "Post setup-ignore");
					ieCaps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					ieCaps.setCapability("screenResolution", "1280x1024");
					ieCaps.setCapability("name", "Post setup-ignore");
					/*
					 * ieCaps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					ieCaps.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				}
				remoteDriver = new RemoteWebDriver(new URL(sauceUrl), ieCaps);
				remoteDriver.setFileDetector(new LocalFileDetector());
				currentDriver = remoteDriver;
				break;
			case "chrome":
				chromeOps = new ChromeOptions();
				chromeOps.setCapability("parentTunnel", SAUCE_PARENT_TUNNEL);
				chromeOps.setCapability("tunnelIdentifier", SAUCE_TUNNEL_IDENTIFIER);
				chromeOps.setCapability("public", SAUCE_JOB_VISIBILITY);
				chromeOps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
				chromeOps.setCapability(CapabilityType.VERSION, AutomationBase.Environment("chromeVersion"));
				chromeOps.setCapability("platform", "Windows 7");
				chromeOps.setCapability("screenResolution", "1920x1080");
				chromeOps.addArguments("--incognito");
				if (!AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					chromeOps.setCapability("name", AutomationBase.getCurrentScenarioName());
					chromeOps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					chromeOps.setCapability("name", AutomationBase.getCurrentScenarioName());
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					chromeOps.setCapability("build", "Onboarding_Test_build_Jenkins_"
							+ JenkinsHelper.getCurrentJobName() + "__" + JenkinsHelper.getCurrentBuildNumber());
				} else if (!AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					chromeOps.setCapability("name", "Post setup-ignore");
					chromeOps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					chromeOps.setCapability("screenResolution", "1280x1024");
					chromeOps.setCapability("name", "Post setup-ignore");
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					chromeOps.setCapability("build", "Onboarding_Test_build_Jenkins_"
							+ JenkinsHelper.getCurrentJobName() + "__" + JenkinsHelper.getCurrentBuildNumber());
				}
				remoteDriver = new RemoteWebDriver(new URL(sauceUrl), chromeOps);
				remoteDriver.setFileDetector(new LocalFileDetector());
				currentDriver = remoteDriver;

				break;
			case "firefox":
				DesiredCapabilities ffCap = DesiredCapabilities.firefox();
				ffCap.setCapability("parentTunnel", SAUCE_PARENT_TUNNEL);
				ffCap.setCapability("tunnelIdentifier", SAUCE_TUNNEL_IDENTIFIER);
				ffCap.setCapability("public", SAUCE_JOB_VISIBILITY);
				ffCap.setCapability(CapabilityType.VERSION, AutomationBase.Environment("ffVersion"));
				ffCap.setCapability("platform", "Windows 7");
				ffCap.setCapability("screenResolution", "1920x1080");

				if (!AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					ffCap.setCapability("name", AutomationBase.getCurrentScenarioName());
					ffCap.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					ffCap.setCapability("name", AutomationBase.getCurrentScenarioName());
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					ffCap.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				} else if (!AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					ffCap.setCapability("name", "Post setup-ignore");
					ffCap.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					ffCap.setCapability("screenResolution", "1280x1024");
					ffCap.setCapability("name", "Post setup-ignore");
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					ffCap.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				}
				remoteDriver = new RemoteWebDriver(new URL(sauceUrl), ffCap);
				remoteDriver.setFileDetector(new LocalFileDetector());
				currentDriver = remoteDriver;

				break;
			case "edge":
				DesiredCapabilities edgeCaps = DesiredCapabilities.edge();
				edgeCaps.setCapability("parentTunnel", SAUCE_PARENT_TUNNEL);
				edgeCaps.setCapability("tunnelIdentifier", SAUCE_TUNNEL_IDENTIFIER);
				edgeCaps.setCapability("public", SAUCE_JOB_VISIBILITY);
				edgeCaps.setCapability(CapabilityType.VERSION, AutomationBase.Environment("edgeVersion"));
				edgeCaps.setCapability("platform", "Windows 10");
				edgeCaps.setCapability("screenResolution", "1920x1080");

				if (!AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					edgeCaps.setCapability("name", AutomationBase.getCurrentScenarioName());
					edgeCaps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && !AutomationBase.captureSnap) {
					edgeCaps.setCapability("name", AutomationBase.getCurrentScenarioName());
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					edgeCaps.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				} else if (!AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					edgeCaps.setCapability("name", "Post setup-ignore");
					edgeCaps.setCapability("build", "Onboarding_Test_Local_build_" + AutomationBase.reportDate);
				} else if (AutomationBase.getJenkinsMode() && AutomationBase.captureSnap) {
					edgeCaps.setCapability("screenResolution", "1280x1024");
					edgeCaps.setCapability("name", "Post setup-ignore");
					/*
					 * chromeOps. setCapability( "build",
					 * "Onboarding_Test_build_Jenkins_" + System.getenv(
					 * "JOB_NAME") + "__" + System.getenv( "BUILD_NUMBER"));
					 */
					edgeCaps.setCapability("build", "Onboarding_Test_build_Jenkins_" + JenkinsHelper.getCurrentJobName()
							+ "__" + JenkinsHelper.getCurrentBuildNumber());
				}
				remoteDriver = new RemoteWebDriver(new URL(sauceUrl), edgeCaps);
				remoteDriver.setFileDetector(new LocalFileDetector());
				currentDriver = remoteDriver;

				break;

			default:
				LoggerHelper.logInfo(log, "No browser argument was supplied- " + browserName);
				throw new IllegalArgumentException();
			}
			// printSessionId(System.getenv("JOB_NAME"));
			JenkinsHelper.printSessionId();
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while launching sauce driver for a given browser: " + browserName);
			LoggerHelper.logError(log, ia);
		} catch (MalformedURLException me) {
			LoggerHelper.logInfo(log, "Errored out while launching sauce driver for a given browser: " + browserName);
			LoggerHelper.logError(log, me);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while launching sauce driver for a given browser: " + browserName);
			LoggerHelper.logError(log, e);
		}
		actions = new Actions(currentDriver);
		js = (JavascriptExecutor) currentDriver;
		return currentDriver;
	}

	public static void browserRefresh() {
		currentDriver.navigate().refresh();
	}

	/**
	 * This method is used to set the driver for NgWebDriver
	 *
	 * @param driver
	 *            current driver of Webdriver type
	 */
	public static void setNGWebDriver(WebDriver driver) {
		try {
			ngDriver = new NgWebDriver((JavascriptExecutor) driver);
			LoggerHelper.logInfo(log, "ngWebdriver was initiated");

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out during ngWebDriver was initiated");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to wait for angular session to complete
	 *
	 * @param timeInSeconds
	 *            a long type value that holds time to hold driver
	 */
	public static void waitForAngular(long timeInSeconds) {
		try {
			LoggerHelper.logInfo(log, "Wait for Angualr Request was initiated");
			ngDriver.waitForAngularRequestsToFinish();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out during wait for angular request was initiated");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to get current driver
	 *
	 * @return webdriver type
	 */
	public static WebDriver getDriver() {
		return currentDriver;
	}

	/**
	 * This method is used to get current browser title
	 *
	 * @return a string type value that holds title of a browser/page
	 */
	public static String getTitle() {
		try {
			LoggerHelper.logInfo(log, "Gettig current title..");
			return currentDriver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "null";
		}
	
	}

	/**
	 * This method is used to get current url
	 *
	 * @return returns string type value of URL
	 */
	public static String getURL() {
		LoggerHelper.logInfo(log, "Gettig current URL.." + currentDriver.getCurrentUrl());
		return currentDriver.getCurrentUrl();
	}

	/**
	 * This method is used to validate whether the given URL is existed or not
	 *
	 * @param partURL
	 *            a string type of URL
	 * @param timeOutInsec
	 *            a long type value that holds the driver
	 * @return boolean type value i.e., true or false Eg:-
	 *         isURLExist("http:/hello.com")
	 */
	public static boolean isURLExist(String partURL, long timeOutInsec) {
		initDriverWait(timeOutInsec);
		try {
			LoggerHelper.logInfo(log, "Validating URL of the given page '" + AutomationBase.getPageName()
					+ "' for a given browser '" + AutomationBase.getBrowser() + "'");
			return wait.until(ExpectedConditions.urlContains(partURL));
		} catch (WebDriverException we) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the existense of given resource '" + partURL + " in given URL '"
							+ getURL() + "' of the given page '" + AutomationBase.getPageName()
							+ "' for a given browser '" + AutomationBase.getBrowser() + "'");
			LoggerHelper.logError(log, we);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the existense of given resource '" + partURL + " in given URL '"
							+ getURL() + "' of the given page '" + AutomationBase.getPageName()
							+ "' for a given browser '" + AutomationBase.getBrowser() + "'");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to quit the current driver
	 */
	public static void quitDriver() {
		try {
			LoggerHelper.logInfo(log, "Quitting the driver");
			currentDriver.quit();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while quitting the driver");
			LoggerHelper.logError(log, e);
		}
	}

	public static String getCurrentSessionId() {
		try {
			LoggerHelper.logInfo(log, "Getting current session id of webdriver");
			return (((RemoteWebDriver) currentDriver).getSessionId()).toString();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while fetching the session id");
			LoggerHelper.logError(log, e);
			return null;
		}

	}

	/**
	 * This method is used to validate the given tile is present or not
	 *
	 * @param expTitle
	 *            a string type value that holds expected tile
	 * @param timeOutInsec
	 *            a long type value that holds time in seconds to hold driver
	 * @return boolean type value of true or false Eg:-
	 *         isTitlePresent("hello",10) - it holds driver for 10 seconds till
	 *         title presents
	 */
	public static boolean isTitlePresent(String expTitle, long timeOutInsec) {
		initDriverWait(timeOutInsec);
		try {
			LoggerHelper.logInfo(log, "Validating title of the browser to be: " + expTitle);
			return wait.until(ExpectedConditions.titleIs(expTitle));
		} catch (WebDriverException we) {
			LoggerHelper.logInfo(log, "Browser title was not found and an exception was triggered");
			LoggerHelper.logError(log, we);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Browser title was not found and an exception was triggered");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to validate given text is present in element or not
	 *
	 * @param element
	 *            Webelement type
	 * @param timeOutInsec
	 *            long type holds time in milliseconds
	 * @param expText
	 *            String type holds text to be validated
	 * @return boolean type true or false
	 */
	public static boolean isTextPresent(WebElement element, long timeOutInsec, String expText) {
		initDriverWait(timeOutInsec);
		try {
			LoggerHelper.logInfo(log,
					"Validating the given text '" + expText + "' present in given element" + currentObjName);
			return wait.until(ExpectedConditions.textToBePresentInElement(element, expText));
		} catch (WebDriverException we) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the text'" + expText + "' present in given element" + currentObjName);
			LoggerHelper.logError(log, we);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the text'" + expText + "' present in given element" + currentObjName);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to validate given attribute is existed in element or
	 * not
	 *
	 * @param element
	 *            Webelement type
	 * @param attrName
	 *            String type holds attribute name
	 * @param attrValue
	 *            String type holds attribute value
	 * @param timeOutInsec
	 *            long type holds time in milliseconds
	 * @return boolean type true or false
	 */
	public static boolean isAttributeContains(WebElement element, String attrName, String attrValue,
			long timeOutInsec) {
		initDriverWait(timeOutInsec);
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Validating the given attribute '" + attrName + "' contains the given value '"
					+ attrValue + "' for a given object" + currentObjName);
			return wait.until(ExpectedConditions.attributeContains(element, attrName, attrValue));
		} catch (WebDriverException we) {
			LoggerHelper.logInfo(log, "Errored out while validating the given attribute '" + attrName
					+ "' contains the given value '" + attrValue + "' for a given object" + currentObjName);
			LoggerHelper.logError(log, we);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while validating the given attribute '" + attrName
					+ "' contains the given value '" + attrValue + "' for a given object" + currentObjName);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to resize the given browser
	 */
	public static void browserResize() {
		Dimension d = new Dimension(800, 480);
		currentDriver.manage().window().setSize(d);
	}

	/**
	 * This method is used to maximize the given browser
	 */
	public static void browserMaximize() {
		currentDriver.manage().window().maximize();
	}

	/**
	 * This method is used to navigate to given URL
	 *
	 * @param url
	 *            String type value that holds URLvalue
	 * @return boolean type true or false
	 */
	public static boolean navigateToURL(String url) {
		try {
			LoggerHelper.logInfo(log, "Navigation of URL: " + url);
			currentDriver.get(url);
			return true;
		} catch (IllegalArgumentException ie) {
			LoggerHelper.logInfo(log, "Navigation of URL was not success due to an exception: " + url);
			LoggerHelper.logError(log, ie);
		} catch (WebDriverException we) {
			LoggerHelper.logInfo(log, "Navigation of URL was not success due to an exception: " + url);
			LoggerHelper.logError(log, we);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Navigation of URL was not success due to an exception: " + url);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to retrieve by locator
	 *
	 * @param eleProperties
	 *            Array type to hold element properties
	 * @return By type locator
	 */
	public static By byLocator(String[] eleProperties) {
		try {
			currentObjName = AutomationBase.getObjectName();
			if (eleProperties == null) {
				return null;
			}
			String value = eleProperties[1];
			elementLocators loc = elementLocators.valueOf(eleProperties[0]);
			switch (loc) {
			case id:
				return By.id(value);
			case xpath:
				return By.xpath(value);
			case name:
				return By.name(value);
			case tagName:
				return By.tagName(value);
			case linkText:
				return By.linkText(value);
			case partialLinkText:
				return By.partialLinkText(value);
			case cssSelector:
				return By.cssSelector(value);
			case className:
				return By.className(value);
			case repeater:
				return ByAngular.repeater(value);
			case model:
				return byAngularWithRoot(eleProperties);
			case exactRepeater:
				return ByAngular.exactRepeater(value);
			case binding:
				return ByAngular.binding(value);
			case exactBinding:
				return ByAngular.exactBinding(value);
			case options:
				return ByAngular.options(value);
			case buttonText:
				return ByAngular.buttonText(value);
			case partialButtonText:
				return ByAngular.partialButtonText(value);
			case cssContainingText:
				String[] values;
				if (value.contains(":")) {
					values = value.split(":");
					return ByAngular.cssContainingText(values[0], values[1]);
				}
				LoggerHelper.logInfo(log, "CSS containing text  was given wrongly");
				throw new IllegalArgumentException();
			default:
				LoggerHelper.logInfo(log, "Given locator was invalid: " + loc);
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException ie) {
			LoggerHelper.logInfo(log, "Illegal argument was supplied while fetching By locator '" + eleProperties[0]
					+ "," + eleProperties[1] + "' for the given element '" + eleProperties[2] + "'");
			LoggerHelper.logError(log, ie);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while fetching By locator '" + eleProperties[0] + ","
					+ eleProperties[1] + "' for the given element '" + eleProperties[2] + "'");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to retrieve by angular locator
	 *
	 * @param eleProperties
	 *            Arry type that holds properties of given element
	 * @param rootNode
	 *            root element of to be found element
	 * @return By type locator
	 */
	public static By byAngularWithRoot(String[] eleProperties, String rootNode) {
		try {
			currentObjName = AutomationBase.getObjectName();
			if (eleProperties == null) {
				return null;
			}
			String value = eleProperties[1];
			elementLocators loc = elementLocators.valueOf(eleProperties[0]);
			switch (loc) {
			case repeater:
				return ByAngular.withRootSelector(rootNode).repeater(value);
			case model:
				return ByAngular.withRootSelector(rootNode).model(value);
			case exactRepeater:
				return ByAngular.withRootSelector(rootNode).exactRepeater(value);
			case binding:
				return ByAngular.withRootSelector(rootNode).binding(value);
			case exactBinding:
				return ByAngular.withRootSelector(rootNode).exactBinding(value);
			case options:
				return ByAngular.withRootSelector(rootNode).options(value);
			case buttonText:
				return ByAngular.withRootSelector(rootNode).buttonText(value);
			case partialButtonText:
				return ByAngular.withRootSelector(rootNode).partialButtonText(value);
			case cssContainingText:
				String[] values;
				if (value.contains(":")) {
					values = value.split(":");
					return ByAngular.withRootSelector(rootNode).cssContainingText(values[0], values[1]);
				}
				LoggerHelper.logInfo(log, "CSS containing text  was given wrongly");
				throw new IllegalArgumentException();
			default:
				LoggerHelper.logInfo(log, "No locator was given");
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException ie) {
			LoggerHelper.logError(log, ie);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Unexpected exception was thrown");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to retrieve by angular locator
	 *
	 * @param eleProperties
	 *            Arry type that holds properties of given element
	 * @return By type locator
	 */
	public static By byAngularWithRoot(String[] eleProperties) {
		try {
			currentObjName = AutomationBase.getObjectName();
			if (eleProperties == null) {
				return null;
			}
			String value = eleProperties[1].split("\\.", 2)[1];
			String rootNode = eleProperties[1].split("\\.", 2)[0];
			elementLocators loc = elementLocators.valueOf(eleProperties[0]);
			switch (loc) {
			case repeater:
				return ByAngular.withRootSelector(rootNode).repeater(value);
			case model:
				return ByAngular.withRootSelector(rootNode).model(value);
			case exactRepeater:
				return ByAngular.withRootSelector(rootNode).exactRepeater(value);
			case binding:
				return ByAngular.withRootSelector(rootNode).binding(value);
			case exactBinding:
				return ByAngular.withRootSelector(rootNode).exactBinding(value);
			case options:
				return ByAngular.withRootSelector(rootNode).options(value);
			case buttonText:
				return ByAngular.withRootSelector(rootNode).buttonText(value);
			case partialButtonText:
				return ByAngular.withRootSelector(rootNode).partialButtonText(value);
			case cssContainingText:
				String[] values;
				if (value.contains(":")) {
					values = value.split(":");
					return ByAngular.withRootSelector(rootNode).cssContainingText(values[0], values[1]);
				}
				LoggerHelper.logInfo(log, "CSS containing text  was given wrongly");
				throw new IllegalArgumentException();
			default:
				LoggerHelper.logInfo(log, "No locator was given");
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException ie) {
			LoggerHelper.logError(log, ie);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Unexpected exception was thrown");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to find an element
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @param condition
	 *            Expected conditions
	 * @return returns webelement type
	 */
	public static WebElement findElement(By by, long timeOutInSec, expectedConditions condition) {
		initDriverWait(timeOutInSec);
		try {
			if (by == null) {
				return null;
			}
			LoggerHelper.logInfo(log, "finding an element '" + currentObjName + "' with given expected condition: '"
					+ condition.toString() + "' and locator: '" + by.toString() + "'");
			switch (condition) {
			case elementToBeClickable:
				return wait.until(ExpectedConditions.elementToBeClickable(by));
			case presenceOfElement:
				return wait.until(ExpectedConditions.presenceOfElementLocated((by)));
			case visiblityOfElement:
				return wait.until(ExpectedConditions.visibilityOfElementLocated((by)));
			default:
				LoggerHelper.logInfo(log,
						"Given condition: " + condition.toString() + " was not matching with any switch case");
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log,
					"Errored out while finding an element--'" + currentObjName + "' with given expected condition: '"
							+ condition.toString() + "and locator: " + by.toString() + "'");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while finding an element--'" + currentObjName + "' with given expected condition: '"
							+ condition.toString() + "and locator: " + by.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * <<<<<<< HEAD This method is used to check an element invisibility
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @return returns boolean type
	 */
	public static boolean isElementInVisible(By by, long timeOutInSec) {
		initDriverWait(timeOutInSec);
		try {
			if (by == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Checking an element '" + currentObjName + "' invisibility with given locator: '"
					+ by.toString() + "'");

			return wait.until(ExpectedConditions.invisibilityOfElementLocated((by)));

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while checking an element--'" + currentObjName
					+ "' invisibility with given  locator: " + by.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to find an element
	 *
	 * @param by
	 *            By type
	 * @return Webelement type
	 */
	public static WebElement findElement(By by) {

		try {
			if (by == null) {
				return null;
			}
			LoggerHelper.logInfo(log,
					"finding an element '" + currentObjName + "' with given locator: '" + by.toString() + "'");
			return currentDriver.findElement(by);

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding an element--'" + currentObjName
					+ "' with given locator: " + by.toString() + "'");
			LoggerHelper.logError(log, e);
			return null;
		}

	}

	/**
	 * This method is used to find a given element
	 *
	 * @param element
	 *            Webelemt type holds element to be found
	 * @param timeOutInSec
	 *            long type holds time in milliseconds
	 * @param cond
	 *            Expected conditions
	 * @return Webelement type
	 */
	public static WebElement findElement(WebElement element, long timeOutInSec, expectedConditions cond) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log, "finding an element '" + currentObjName + "' with given expected condition: '"
					+ cond.toString() + "'");
			switch (cond) {
			case elementToBeClickable:
				return wait.until(ExpectedConditions.elementToBeClickable(element));
			case visiblityOfElement:
				return wait.until(ExpectedConditions.visibilityOf((element)));
			default:
				LoggerHelper.logInfo(log, "Given condition: " + cond.toString() + " was not matching with any case");
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding an element '" + currentObjName
					+ "' with given expected condition: '" + cond.toString() + "'");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding an element '" + currentObjName
					+ "' with given expected condition: '" + cond.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to get child element from parent element
	 *
	 * @param parentBy
	 *            By type locator
	 * @param childBy
	 *            By type locator
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @return webelement type
	 */
	public static WebElement findNestedElement(By parentBy, By childBy, long timeOutInSec) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log, "finding nested element '" + currentObjName
					+ "' with given parent and child locators: " + parentBy.toString() + ", " + childBy.toString());
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentBy, childBy));
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding nested element '" + currentObjName
					+ "' with given condition and locator");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding nested element '" + currentObjName
					+ "' with given condition and locator");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to find nested element of given element
	 *
	 * @param parentEle
	 *            Webelemt type
	 * @param childBy
	 *            By type locator
	 * @param timeOutInSec
	 *            Long type that holds time in milliseconds
	 * @return Webelement type from given parent element
	 */
	public static WebElement findNestedElement(WebElement parentEle, By childBy, long timeOutInSec) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log,
					"finding nested element '" + currentObjName + "' with given parent element and child locators: "
							+ parentEle.toString() + ", " + childBy.toString());
			return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parentEle, childBy));
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding nested element '" + currentObjName
					+ "' with given condition and locator");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding nested element '" + currentObjName
					+ "' with given condition and locator");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to find elements
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type value that holds time in milliseconds
	 * @param condition
	 *            Expected condition from seleniumhelper to hold given element
	 * @return List of elements
	 */
	public static List<WebElement> findElements(By by, long timeOutInSec, expectedConditions condition) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log, "finding collection of elements with given expected condition: "
					+ condition.toString() + " and locator: " + by.toString());
			switch (condition) {
			case presenceOfElements:
				return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((by)));
			case visibilityOfElements:
				return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((by)));
			default:
				LoggerHelper.logInfo(log,
						"Given condition: " + condition.toString() + " was not matching with any switch case");
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding an element with given condition and locator");
			LoggerHelper.logError(log, ia);
		} catch (StaleElementReferenceException sa) {
			List<WebElement> eles = wait
					.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy((by))));
			if (eles != null) {
				return eles;
			}
			LoggerHelper.logInfo(log, "Errored out while finding an element with given condition and locator");
			LoggerHelper.logError(log, sa);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding an element with given condition and locator");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to get list of nested elements from a given parent
	 * element
	 *
	 * @param parentBy
	 *            By type locator
	 * @param childBy
	 *            By type locator
	 * @param timeOutInSec
	 *            Long type in milliseconds
	 * @param condition
	 *            Expected conditions of seleniumhelper
	 * @return List of elements form given parent element
	 */
	public static List<WebElement> findNestedElements(By parentBy, By childBy, long timeOutInSec,
			expectedConditions condition) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log,
					"finding collection of nested elements with given expected condition: " + condition.toString()
							+ " and with both parent locator: " + parentBy.toString() + " child locator: " + childBy);
			switch (condition) {
			case presenceOfNestedElements:
				return wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(parentBy, childBy));
			case visibilityOfNestedElements:
				return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parentBy, childBy));
			default:
				LoggerHelper.logInfo(log,
						"Given condition: " + condition.toString() + " was not matching with any switch case");
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding an element with given condition and locator");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding an element with given condition and locator");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to find all nested elements of a given parent element
	 *
	 * @param parent
	 *            Webelement type
	 * @param childBy
	 *            By type locator
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @return list of webelements form a given parent element
	 */
	public static List<WebElement> findNestedElements(WebElement parent, By childBy, long timeOutInSec) {
		initDriverWait(timeOutInSec);
		try {
			LoggerHelper.logInfo(log, "finding collection of nested elements with both parent element: "
					+ parent.toString() + " and child locator: " + childBy.toString());
			return wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parent, childBy));

		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while finding nested elements with given condition and locator");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding nested elements with given condition and locator");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to validate element is enabled or not
	 *
	 * @param by
	 *            By locator type
	 * @param cond
	 *            Expected conditions of seleniumhelper
	 * @param timeOutInSec
	 *            Long type value that holds time in milliseconds
	 * @return boolean type that holds true or false
	 */
	public static boolean isElementEnabled(By by, expectedConditions cond, long timeOutInSec) {
		try {
			LoggerHelper.logInfo(log, "Validating  the given element'" + currentObjName + "' enability");
			return findElement(by, timeOutInSec, cond).isEnabled();
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the given element '" + currentObjName + "' enability");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to validate given element enabled or not
	 *
	 * @param element
	 *            to be validate of webelement type
	 * @return boolean type true or false
	 */
	public static boolean isElementEnabled(WebElement element) {
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log,
					"Validating  the given element'" + currentObjName + "' enability to perfrom user action");
			return element.isEnabled();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while validating the given element '" + currentObjName
					+ "' enability to perform user action");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to validate given element presence
	 *
	 * @param by
	 *            By type locator
	 * @param cond
	 *            Expected conditions
	 * @param timeOutInSec
	 *            Time out in seconds of long type
	 * @return boolean type true or false
	 */
	public static boolean isElementDisplayed(By by, expectedConditions cond, long timeOutInSec) {
		try {
			LoggerHelper.logInfo(log, "Validating the given element '" + currentObjName + "' appearence");
			return findElement(by, timeOutInSec, cond).isDisplayed();
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the given element '" + currentObjName + "' appearence");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to validate element presence
	 *
	 * @param element
	 *            Webelement type
	 * @return boolean type true or false
	 */
	public static boolean isElementDisplayed(WebElement element) {
		try {

			LoggerHelper.logInfo(log, "Validating the given element '" + currentObjName + "' appearence");
			return element.isDisplayed();
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while validating the given element '" + currentObjName + "' appearence");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to enter text into a given webelement
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type value that holds time in milliseconds
	 * @param cond
	 *            Expected conditions
	 * @param valueToEnter
	 *            String type value to enter
	 * @return boolean type value holds true or false
	 */
	public static boolean enterText(By by, long timeOutInSec, expectedConditions cond, String valueToEnter) {
		try {
			LoggerHelper.logInfo(log,
					"Entering the given value '" + valueToEnter + "' into '" + currentObjName + "' text filed");
			WebElement element = findElement(by, timeOutInSec, cond);
			if (isElementEnabled(element)) {
				element.sendKeys(valueToEnter);
			}
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to enter the text in a given element
	 *
	 * @param element
	 *            Webelement type
	 * @param valueToEnter
	 *            String type value to enter
	 * @return boolean that returns true or false
	 */
	public static boolean enterText(WebElement element, String valueToEnter) {
		try {
			LoggerHelper.logInfo(log,
					"Entering the given value '" + valueToEnter + "' into '" + currentObjName + "' text filed");
			if (element == null) {
				throw new NullPointerException();
			}
			if (isElementEnabled(element)) {
				element.clear();
				element.sendKeys(valueToEnter);
				return true;
			}
			return false;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to enter the text in a given element
	 *
	 * @param element
	 *            Webelement type
	 * @param valueToEnter
	 *            String type value to enter
	 * @return boolean that returns true or false
	 */
	public static boolean enterTextwithOutClear(WebElement element, String valueToEnter) {
		try {
			LoggerHelper.logInfo(log,
					"Entering the given value '" + valueToEnter + "' into '" + currentObjName + "' text filed");
			if (element == null) {
				throw new NullPointerException();
			}
			if (isElementEnabled(element)) {
				// element.clear();
				element.sendKeys(valueToEnter);
				return true;
			}
			return false;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to type the text into given element
	 *
	 * @param element
	 *            Webelement type where value to be entered
	 * @param valueToEnter
	 *            String type value that holds value to enter
	 * @return boolean type true or false
	 */
	public static boolean typeText(WebElement element, String valueToEnter) {
		try {
			LoggerHelper.logInfo(log,
					"Entering the given value '" + valueToEnter + "' into '" + currentObjName + "' text filed");
			if (element == null) {
				throw new NullPointerException();
			}
			if (isElementEnabled(element)) {
				js.executeScript("arguments[0].value= arguments[1]", element, valueToEnter);
				return true;
			}
			return false;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while entering the given value '" + valueToEnter + "' into '"
					+ currentObjName + "' text filed");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to click a given element by using locator
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type value that holds time in milliseconds
	 * @param cond
	 *            Expected conditions of enum type
	 * @return boolean type that holds true or false
	 */
	public static boolean clickElement(By by, long timeOutInSec, expectedConditions cond) {
		try {
			LoggerHelper.logInfo(log, "Clicking the given element '" + currentObjName + "'");
			WebElement element = findElement(by, timeOutInSec, cond);
			if (isElementEnabled(element)) {
				element.click();
			}
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while clicking the given element '" + currentObjName + "'");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to click on given element for multiple times
	 *
	 * @param element
	 *            Webelement type
	 * @return boolean type value holds true or false
	 */
	public static boolean multipleClick(WebElement element) {
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Clicking the given element '" + currentObjName + "'");
			if (isElementEnabled(element)) {
				element.click();
				return true;
			} else {
				LoggerHelper.logInfo(log, "Clicking the given element '" + currentObjName
						+ "' was unsuccess due to element was not enabled");
				return false;
			}

		} catch (NullPointerException ne) {
			if (ne.getMessage().contains("element not visible") && count <= 2) {
				LoggerHelper.logInfo(log, "Trying to fetch element for the given count '" + count
						+ "' once again while errored our for clicking the given element '" + currentObjName + "'");
				element = findElement(element, 20, expectedConditions.visiblityOfElement);
				clickElement(element);
				count++;
			} else if (ne.getMessage().contains("Other element would receive the click") && count <= 2) {

				LoggerHelper.logInfo(log, "Trying to fetch element for the given count '" + count
						+ "' once again while errored our for clicking the given element '" + currentObjName + "'");
				element = findElement(element, 20, expectedConditions.visiblityOfElement);
				clickElement(element);
				count++;
			} else {
				LoggerHelper.logInfo(log, "Errored out while clicking the given element '" + currentObjName + "'");
				LoggerHelper.logError(log, ne);
			}

		} catch (Exception e) {
			if (e.getMessage().contains("element not visible") && count <= 2) {
				LoggerHelper.logInfo(log, "Trying to fetch element for the given count '" + count
						+ "' once again while errored our for licking the given element '" + currentObjName + "'");
				count++;
				element = findElement(element, 20, expectedConditions.visiblityOfElement);
				clickElement(element);
			} else if (e.getMessage().contains("Other element would receive the click") && count <= 2) {

				LoggerHelper.logInfo(log, "Trying to fetch element for the given count '" + count
						+ "' once again while errored our for licking the given element '" + currentObjName + "'");
				count++;
				element = findElement(element, 20, expectedConditions.visiblityOfElement);
				clickElement(element);
			} else {
				LoggerHelper.logInfo(log, "Errored out while clicking the given element '" + currentObjName + "'");
				LoggerHelper.logError(log, e);
			}
		}
		return false;
	}

	/**
	 * This method is used to click an element
	 *
	 * @param element
	 *            Webelement type to be clicked
	 * @return boolean type value holds true or false
	 */
	public static boolean clickElement(WebElement element) {
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Clicking the given element '" + currentObjName + "'");
			if (isElementEnabled(element)) {
				element.click();
				return true;
			} else {
				LoggerHelper.logInfo(log, "Clicking the given element '" + currentObjName
						+ "' was unsuccess due to element was not enabled");
				return false;
			}

		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log, "Errored out while clicking the given element '" + currentObjName + "'");
			LoggerHelper.logError(log, ne);

		} catch (Exception e) {

			LoggerHelper.logInfo(log, "Errored out while clicking the given element '" + currentObjName + "'");
			LoggerHelper.logError(log, e);

		}
		return false;
	}

	/**
	 * This method is used to get select element from given webelement
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            Long type value in milliseconds to hold the driver
	 * @param cond
	 *            Enum for expected conditions
	 * @return Select type element
	 */
	public static Select selectElement(By by, long timeOutInSec, expectedConditions cond) {
		try {
			LoggerHelper.logInfo(log, "Fetching select element '" + currentObjName + "' to perfrom user action");
			return new Select(findElement(by, timeOutInSec, cond));
		} catch (IllegalArgumentException ie) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, ie);
			return null;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, ne);
			return null;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to get select element by a given element
	 *
	 * @param element
	 *            Webelement type
	 * @return Select type element
	 */
	public static Select selectElement(WebElement element) {
		try {
			if (element == null) {
				return null;
			}
			LoggerHelper.logInfo(log, "Fetching select element '" + currentObjName + "' to perfrom user action");
			return new Select(element);
		} catch (IllegalArgumentException ie) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, ie);
			return null;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, ne);
			return null;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching select element '" + currentObjName + "' to perfrom user action");
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to get text of an element
	 *
	 * @param element
	 *            Webelement type
	 * @return string type value that holds text of given element
	 */
	public static String getText(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Fetching the text of given element " + currentObjName);
			return element.getText();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while fetching the text of given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to wait for a given title
	 *
	 * @param expTitle
	 *            String type value that holds given title
	 * @return boolean type value that holds true or false
	 */
	public static boolean waitForTitle(String expTitle) {
		try {
			return wait.until(ExpectedConditions.titleContains(expTitle));
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method is used to get an attribute value from given element
	 *
	 * @param element
	 *            Webelement type
	 * @param attrButeName
	 *            String type that holds attribute name
	 * @return String type value that holds given attribute value of given
	 *         element
	 */
	public static String getAttribute(WebElement element, String attrButeName) {
		try {
			LoggerHelper.logInfo(log,
					"Fetching the value of given attribute " + attrButeName + " of given element " + currentObjName);
			return element.getAttribute(attrButeName);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while fetching the value of given attribute " + attrButeName
					+ " of given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to get selected option's text from select element
	 *
	 * @param selectElement
	 *            a select element type
	 * @return string type value that holds text of selected option
	 */
	public static String getFirstSelectedOptionText(Select selectElement) {
		try {
			LoggerHelper.logInfo(log, "Fetching the selected option text from select element " + currentObjName);
			return getText(selectElement.getFirstSelectedOption());
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching the selected option text from select element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to get selected option element
	 *
	 * @param selectElement
	 *            select object
	 * @return webelement type that holds Option
	 */
	public static WebElement getFirstSelectedOption(Select selectElement) {
		try {
			LoggerHelper.logInfo(log, "Fetching the selected option from select element " + currentObjName);
			return selectElement.getFirstSelectedOption();
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching the selected option from select element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to select given option from select element by index
	 *
	 * @param selectElement
	 *            a select type of object
	 * @param index
	 *            integer type that holds index of option
	 * @return string type that holds selected option's text
	 */
	public static String selectOption(Select selectElement, int index) {
		try {
			if (selectElement == null) {
				return null;
			}
			LoggerHelper.logInfo(log,
					"Selecting the option indexed at " + index + " from given element " + currentObjName);
			selectElement.selectByIndex(index);
			String text = selectElement.getFirstSelectedOption().getText();
			LoggerHelper.logInfo(log,
					"The given option '" + text + "' was selected successfully from given element " + currentObjName);
			return text;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while selecting the option indexed at " + index
					+ " from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/***
	 * This method is used to select an option using index
	 *
	 * @param by
	 *            By type value that holds by locator to find element
	 * @param timeOutInSec
	 *            long type value that holds time in milliseconds
	 * @param condition
	 *            an enum that holds expected conditions
	 * @param index
	 *            an integer type value that holds index of option to be
	 *            selected
	 * @return string type value that holds selected option's text
	 */
	public static String selectOption(By by, long timeOutInSec, expectedConditions condition, int index) {
		try {
			LoggerHelper.logInfo(log,
					"Selecting the option indexed at " + index + " from given element " + currentObjName);
			WebElement element = findElements(by, timeOutInSec, condition).get(index);
			element.click();
			String text = element.getText();
			LoggerHelper.logInfo(log,
					"The given option '" + text + "' was selected successfully from given element " + currentObjName);
			return text;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while selecting the option indexed at " + index
					+ " from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to select an option by index from list of options
	 *
	 * @param options
	 *            List type of values that holds given option elements
	 * @param index
	 *            an integer value that holds an index of option to be selected
	 * @return String type value that holds selected option text
	 */
	public static String selectOption(List<WebElement> options, int index) {
		try {
			LoggerHelper.logInfo(log,
					"Selecting the option indexed at " + index + " from given element " + currentObjName);
			WebElement element = options.get(index);
			String text = element.getText();
			scrollToViewElement(element);
			element.click();
			LoggerHelper.logInfo(log,
					"The given option '" + text + "' was selected successfully from given element " + currentObjName);
			return text;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while selecting the option indexed at " + index
					+ " from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to select an option by index from list of options
	 * <<<<<<< HEAD
	 *
	 * @param options
	 *            List type of values that holds given option elements
	 * @param text
	 *            String type value that holds selected option text
	 * @param options
	 *            List type of values that holds given option elements
	 * @param index
	 *            an integer value that holds an index of option to be selected
	 * @return String type value that holds selected option text
	 */
	public static boolean selectOption(List<WebElement> options, String text) {
		try {
			LoggerHelper.logInfo(log, "Selecting the option '" + text + "' from given element " + currentObjName);
			for (WebElement option : options) {
				if (option.getText().trim().equals(text)) {
					clickElement(option);
					LoggerHelper.logInfo(log, "The given option '" + text
							+ "' was selected successfully from given element " + currentObjName);
					return true;
				}

			}
			return false;

		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while selecting the option " + text + " from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * This method is used to select an option from select element by using text
	 *
	 * @param by
	 *            By type value that holds by locator to find an element
	 * @param timeOutInSec
	 *            long type vaue that holds time in milliseconds
	 * @param condition
	 *            an enum which holds expected conditions
	 * @param text
	 *            a string type value that holds text
	 * @return boolean type value that holds true or false
	 */
	public static boolean selectOption(By by, long timeOutInSec, expectedConditions condition, String text) {
		try {
			LoggerHelper.logInfo(log, "Selecting the option '" + text + "' from given element " + currentObjName);
			List<WebElement> elements = findElements(by, timeOutInSec, condition);
			for (WebElement element : elements) {
				if (element.getText().equals(text)) {
					element.click();
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while selecting the option '" + text + "' from given element" + currentObjName);
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * This method is used to select an option from select element by using
	 * given text
	 *
	 * @param element
	 *            a select type that holds given select element
	 * @param text
	 *            a string type value that holds text
	 * @return boolean type value holds true or false
	 */
	public static boolean selectOption(Select element, String text) {
		try {
			LoggerHelper.logInfo(log, "Selecting the option '" + text + "' from given element " + currentObjName);
			element.selectByVisibleText(text);
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while selecting the option '" + text + "' from given element" + currentObjName);
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * This method is used to initialize webdriver wait
	 *
	 * @param time
	 *            long type value that holds time in seconds
	 */
	private static void initDriverWait(long time) {
		wait = new WebDriverWait(currentDriver, time);
	}

	/**
	 * This method is used to hover on given element
	 *
	 * @param element
	 *            a webelement type that holds element to be hovered
	 * @return boolean type value holds true or false
	 */
	public static boolean mouseHover(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Mouse hovering on given element '" + currentObjName + "'");
			actions.moveToElement(element).build().perform();
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while mouse hovering on given element '" + currentObjName + "'");
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * This method is used to hover and click on given element
	 *
	 * @param element
	 *            a webelement type that holds element to be hovered and clicked
	 * @return boolean type value holds true or false
	 */
	public static boolean mouseHoverAndClick(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Mouse hovering and clicking on given element '" + currentObjName + "'");
			actions.moveToElement(element).click().build().perform();
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while mouse hovering and clicking on given element '" + currentObjName + "'");
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * This method is used to scroll the page to a given element
	 *
	 * @param element
	 *            a webelement type that holds control to be visible
	 * @return boolean type value of true or false
	 */
	public static boolean scrollToViewElement(WebElement element) {
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Scrolling  to view given element '" + currentObjName + "'");
			js.executeScript("arguments[0].scrollIntoView();", element);
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while scrolling to view given element '" + currentObjName + "'");
			LoggerHelper.logError(log, e);
			return false;
		}

	}

	/**
	 * This method is used to find the index of a String input
	 *
	 * @param a
	 *            list of WebElements and a String input
	 * @return integer of the index
	 */
	public static int getIndex(List<WebElement> elements, String text) {
		try {
			LoggerHelper.logInfo(log, "Get Index method was called");
			// this logic takes more time to execute hence commented out this
			// and added new logic.
			// Reason: The for loop iteration is executing for all elements
			// which is not needed.
			// for example , though if the required element is existed at first
			// position, the loop still iterates all elements to capture the
			// text.
			/*
			 * List<WebElement> getAllElements = elements; List<String> values =
			 * new ArrayList<String>(); for (WebElement we : getAllElements) {
			 * values.add(we.getText()); } int ind = values.indexOf(text);
			 * return ind;
			 */
			for (int ind = 0; ind <= elements.size() - 1; ind++) {
				if (elements.get(ind).getText().equals(text)) {
					return ind;
				}
			}
			return -1;

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while finding the index of the string text from the list");
			LoggerHelper.logError(log, e);
			return -1;
		}
	}

	public static void scrollTo(int xPixels, int yPixels) {
		try {
			LoggerHelper.logInfo(log, "Scroll To method was called");
			js.executeScript("window.scrollTo(arguments[0],arguments[1])", xPixels, yPixels);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while scrolling down");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to remove attribute from DOM
	 *
	 * @param id
	 *            a string type value that holds id attribute
	 * @param attriButeName
	 *            a string type value that holds attribute name to be removed
	 * @return boolean type value true or false Eg:-
	 *         removeAttribute("id","class")
	 */
	public static boolean removeAttriBute(String id, String attriButeName) {
		try {
			LoggerHelper.logInfo(log, "Removing the given attribute '" + attriButeName + "' for a given element '"
					+ currentObjName + "'");
			js.executeScript("document.getElementById(arguments[0]).removeAttribute(arguments[1])", id, attriButeName);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.id(id))));
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while removing the given attribute '" + attriButeName
					+ "' for a given element '" + currentObjName + "");
			LoggerHelper.logError(log, e);
			return false;
		}

	}

	/**
	 * This method is used to take screenshot of pages
	 *
	 * @param filePath
	 *            filepath to save the screenshot
	 *            <p>
	 *            Example:- SeleniumHelper.takeSnapShot(driver,"C:\test")
	 */
	public static void takeSnapShot(String filePath) {
		try {
			LoggerHelper.logInfo(log, "Taking screenshot for the given screen '" + AutomationBase.getPageName() + "'");
			TakesScreenshot scrShot = ((TakesScreenshot) currentDriver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(filePath);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (NullPointerException e) {
			LoggerHelper.logInfo(log,
					"Errored out while taking screenshot for the given screen '" + AutomationBase.getPageName() + "'");
			LoggerHelper.logError(log, e);
		} catch (FileNotFoundException e) {
			LoggerHelper.logInfo(log,
					"Errored out while taking screenshot for the given screen '" + AutomationBase.getPageName() + "'");
			LoggerHelper.logError(log, e);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while taking screenshot for the given screen '" + AutomationBase.getPageName() + "'");
			LoggerHelper.logError(log, e);
		}

	}

	/**
	 * This method is used to pause current thread for a given time
	 *
	 * @param timeOutInMilliseconds
	 *            a long type value that holds time in milliseconds
	 */
	public static void sleep(long timeOutInMilliseconds) {
		try {
			LoggerHelper.logInfo(log, "Making driver to wait for current action");
			AutomationBase.threadSleep(timeOutInMilliseconds);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while making browser to wait for certain amount of time in milli-seconds"
							+ timeOutInMilliseconds);
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to check an element invisibility
	 *
	 * @param by
	 *            By type locator
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @return returns boolean type
	 */

	public static boolean isElementInvisible(By by, long timeOutInSec) {
		initDriverWait(timeOutInSec);
		try {
			if (by == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Validating  invisibility of an element '" + currentObjName + "' with locator: '"
					+ by.toString() + "'");
			return wait.until(ExpectedConditions.invisibilityOfElementLocated((by)));

		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while Validating  invisibility of an element" + currentObjName
					+ "' with locator:" + by.toString() + "'");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while Validating  invisibility of an element" + currentObjName
					+ "' with locator:" + by.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to check an element invisibility
	 *
	 * @param element
	 *            WebElement type
	 * @param timeOutInSec
	 *            long type that holds time in milliseconds
	 * @return returns boolean type
	 */
	public static boolean isElementInvisible(WebElement element, long timeOutInSec) {

		initDriverWait(timeOutInSec);
		try {
			if (element == null) {
				return false;
			}
			LoggerHelper.logInfo(log, "Validating  invisibility of an element '" + currentObjName + "' with locator: '"
					+ element.toString() + "'");
			return wait.until(ExpectedConditions.invisibilityOf((element)));

		} catch (IllegalArgumentException ia) {
			LoggerHelper.logInfo(log, "Errored out while Validating  invisibility of an element" + currentObjName
					+ "' with locator:" + element.toString() + "'");
			LoggerHelper.logError(log, ia);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while Validating  invisibility of an element" + currentObjName
					+ "' with locator:" + element.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This method is used to get the Sauce video link pointing to Jenkins to be
	 * attached to report
	 *
	 * @return {String} that holds video URL
	 */

	public static String getSauceVideoLink() {
		try {
			LoggerHelper.logInfo(log, "Fetching sauce video path ");
			System.out.println("Build path..." + System.getenv("BUILD_URL"));
			String path = System.getenv("BUILD_URL") + "sauce-ondemand-report" + File.separator + "jobReport?jobId="
					+ getCurrentSessionId();
			System.out.println("Sauce video path..." + path);
			return path;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while Fetching sauce video path ");
			LoggerHelper.logError(log, e);
			return "";
		}
	}

	/**
	 * This method is used to get sauce Asset video link directly
	 *
	 * @return {String} that holds asset video link from Sauce
	 */
	public static String getSauceAssetVideoLink() {
		try {
			LoggerHelper.logInfo(log, "Fetching sauce video path from sauce assets ");
			String path = "https://assets.saucelabs.com/jobs/" + getCurrentSessionId() + "/video.mp4";
			LoggerHelper.logInfo(log, "Sauce video assets path for given scenario.."
					+ AutomationBase.getCurrentScenarioName() + " was " + path);
			return path;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while Fetching sauce video path from assets ");
			LoggerHelper.logError(log, e);
			return "";
		}
	}

	/**
	 * This method is used to double click on given element
	 *
	 * @param element
	 *            WebElement type
	 * @return returns boolean true or false
	 */
	public static boolean doubleClick(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Double clicking on given element: " + currentObjName + "'");
			actions.doubleClick(element).build().perform();
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while double clicking on given element: " + currentObjName + "'");
			LoggerHelper.logError(log, e);
			return false;
		}

	}

	public static boolean tabOutElement(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Tabbing out from given element " + currentObjName);
			if (AutomationBase.getBrowser().toString().equals(browserNames.firefox.toString())) {
				element.sendKeys(Keys.TAB);
			} else {
				actions.moveToElement(element).sendKeys(Keys.TAB).build().perform();
			}

			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while tabbing out from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	public static boolean pressTab() {
		try {
			LoggerHelper.logInfo(log, "Tabbing out from given element " + currentObjName);
			actions.sendKeys(Keys.TAB).build().perform();
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while tabbing out from given element " + currentObjName);
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	public static boolean waitForPageLoad(long timeOutInsec) {
		try {
			LoggerHelper.logInfo(log, "Waiting for page to load.." + AutomationBase.getPageName());
			initDriverWait(timeOutInsec);

			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			return wait.until(expectation);

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while wWaiting for page to load.." + AutomationBase.getPageName());
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	/**
	 * This function is used to get the count of elements list
	 *
	 * @param elements
	 *            {List of WebElements}
	 * @return {int} return integer value that holds count
	 */
	public static int getElementsCount(List<WebElement> elements) {
		try {
			LoggerHelper.logInfo(log, "Fetching the count of elements.." + AutomationBase.getObjectName());
			return elements.size();
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while fetching the elements count.." + AutomationBase.getObjectName());
			LoggerHelper.logError(log, e);
		}
		return 0;
	}

	/**
	 * @param element
	 *            {WebElement}
	 * @function
	 * @description This function is used to clear the text box using java
	 *              script
	 * @name js_clearInput
	 */
	public static void js_clearInput(WebElement element) {
		try {
			LoggerHelper.logInfo(log, "Clearing the value of given element.." + AutomationBase.getObjectName());
			((JavascriptExecutor) currentDriver).executeScript("arguments[0].value ='';", element);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while clearing the value of given element.." + AutomationBase.getObjectName());
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * @param element
	 *            {WebElement}
	 * @function
	 * @description This function is used to verify the edit state of object
	 *              script
	 * @name isElementEditable
	 */
	public static boolean isElementEditable(WebElement element, boolean expVal) {
		try {
			LoggerHelper.logInfo(log, "Clearing the value of given element.." + AutomationBase.getObjectName());
			return ((JavascriptExecutor) currentDriver).executeScript("arguments[0].isContentEditable", element)
					.equals(expVal);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while clearing the value of given element.." + AutomationBase.getObjectName());
			LoggerHelper.logError(log, e);
			return false;
		}
	}

	/**
	 * @param element
	 *            {WebElement}
	 * @return {boolean}
	 * @function
	 * @description This function is used to get the selection status of given
	 *              element
	 * @name isElementSelected
	 */
	public static boolean isElementSelected(WebElement element) {
		try {
			LoggerHelper.logInfo(log,
					"Capturing the given element selection status..." + AutomationBase.getObjectName());
			return element.isSelected();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while capturing the given element selection status..."
					+ AutomationBase.getObjectName());
			LoggerHelper.logError(log, e);
			return false;
		}

	}

	/**
	 * @param element
	 *            {WebElement}
	 * @param cssPrpName
	 *            {String}
	 * @return {String}
	 * @function
	 * @description This function is used to get the CSS property value of given
	 *              element
	 * @name getCSSValue
	 */
	public static String getCSSValue(WebElement element, String cssPrpName) {
		try {
			LoggerHelper.logInfo(log, "Getting CSS attribute '" + cssPrpName + "' value of given element"
					+ AutomationBase.getObjectName());
			if (element == null) {
				throw new NullPointerException();
			}
			return element.getCssValue(cssPrpName);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting CSS attribute '" + cssPrpName
					+ "' value of given element" + AutomationBase.getObjectName());
			LoggerHelper.logError(log, e);
			return null;
		}

	}
	
	public static ArrayList<String> getWindows() {
		ArrayList<String> windows = new ArrayList<String>();
		try {
			LoggerHelper.logInfo(log, "Getting the current opened windows/tabs...");
			windows = new ArrayList<String>(currentDriver.getWindowHandles());
			return windows;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Error at getting current open windows");
			LoggerHelper.logError(log, e);
		return null;
		}
	}
	
	public static void switchToWindow(String window) {
		try {
			LoggerHelper.logInfo(log, "Switching to the window -- "+window);
			currentDriver.switchTo().window(window);
		}catch (Exception e) {
			LoggerHelper.logInfo(log, "Couldn't switch to given window...");
			LoggerHelper.logError(log, e);
		}
	}

	public static void switchToWindowAndClose(String window) {
		try {
			LoggerHelper.logInfo(log, "Switching to the window -- "+window);
			currentDriver.switchTo().window(window);
			currentDriver.close();
		}catch (Exception e) {
			LoggerHelper.logInfo(log, "Couldn't switch to given window...");
			LoggerHelper.logError(log, e);
		}
		
	}
}
