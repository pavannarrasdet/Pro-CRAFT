package procraft.core.utilities.automationbase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AutomationBase {

	/**
	 * AutomationBase class properties
	 */
	private static String jenkinsMode = "";
	private static Logger log = Logger.getLogger(AutomationBase.class);
	private static Properties properties = null;
	private static String currentPageName = "";
	private static String objectUnderTestName = "";
	public static String reportDate = "";
	private static String glbregionValue = "";
	public static boolean captureSnap = false;

	private static String currentScenarioName = null;

	private AutomationBase() {

	}

	/*********************************************************************************
	 * Methods definition
	 ***************************************************************************/

	/**
	 * this method is used to load the properties file
	 *
	 * @return properties
	 */
	public static Properties loadProperties() {

		try {
			LoggerHelper.logInfo(log, "Loading environment properties");
			InputStream instream = AutomationBase.class.getClassLoader().getResourceAsStream("config.properties");
			if (instream != null) {
				properties = new Properties();
				properties.load(instream);
			}
			LoggerHelper.logInfo(log, "Loading environment properties was success");
			return properties;
		} catch (IOException ie) {
			LoggerHelper.logError(log, "Error out while environment properties loading");
			LoggerHelper.logError(log, ie);
			return properties;
		} catch (NullPointerException ne) {
			LoggerHelper.logError(log, "Error out while environment properties loading");
			LoggerHelper.logError(log, ne);
			return properties;
		} catch (Exception e) {
			LoggerHelper.logError(log, "Error out while environment properties loading");
			LoggerHelper.logError(log, e);
			return properties;
		}
	}

	/**
	 * This method is used to pause the current thread for a given time
	 *
	 * @param milliseconds
	 *            long type value Eg:- threadSleep(100) : it pauses current
	 *            thread/task for 100 milliseconds
	 */
	public static void threadSleep(long milliseconds) {
		try {
			LoggerHelper.logInfo(log,
					"Waiting for '" + milliseconds + "' milli seconds to complete the current thread ");
			Thread.sleep(milliseconds);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while waiting for '" + milliseconds
					+ "' milli seconds to complete the current thread ");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * Setting the screen name that was currently under test
	 *
	 * @param pageName
	 *            String type value for current screen
	 */
	public static void setPageName(String pageName) {
		LoggerHelper.logInfo(log, "Setting the current screen name as '" + pageName + "'");
		currentPageName = pageName;
	}

	/**
	 * Getting current screen name
	 *
	 * @return string type value of screen name
	 */
	public static String getPageName() {
		LoggerHelper.logInfo(log, "Getting the current screen name as '" + currentPageName + "'");
		return currentPageName;
	}

	/**
	 * Setting current control/element name that was under test
	 *
	 * @param objName
	 *            String type value
	 */
	public static void setObjectName(String objName) {
		LoggerHelper.logInfo(log, "Setting the current object name as '" + objName + "'");
		objectUnderTestName = objName;
	}

	/**
	 * Getting control/element name that was currently under test
	 *
	 * @return String type holds control name under test
	 */
	public static String getObjectName() {
		LoggerHelper.logInfo(log, "Getting the current object name as '" + objectUnderTestName + "'");
		return objectUnderTestName;
	}

	/**
	 * This method is used close all opened browsers
	 */
	public static void closeAllOpenedBrowsers() {
		String os = System.getProperty("os.name");
		try {
			LoggerHelper.logInfo(log, "Killing all opened browsers for the give OS: " + os);
			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
				threadSleep(500);
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
				threadSleep(500);
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				threadSleep(500);
			} else if (os.contains("mac")) {
				// logic for mac
			}
			LoggerHelper.logInfo(log, "All opened browsers were killed");
		} catch (IOException e) {
			LoggerHelper.logError(log, "Error out while killing all opened browsers for given OS " + os);
			LoggerHelper.logError(log, e);
		} catch (Exception e) {
			LoggerHelper.logError(log, "Error out while killing all opened browsers for given OS " + os);
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to close all opened drivers
	 */
	public static void closeAllOpenedDrivers() {
		try {
			LoggerHelper.logInfo(log, "Closing all Opened driver executables of given browser '" + getBrowser() + "'");

			if (getOSName().toLowerCase().contains("windows")) {

				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			} else if (getOSName().toLowerCase().contains("mac")) {
				// logic for mac driver quitting
			}
		} catch (IOException e) {
			LoggerHelper.logError(log,
					"Error out while killing all Opened driver executables of given browser '" + getBrowser() + "'");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to kill the excel process
	 */
	public static void killExcel() {
		try {
			LoggerHelper.logInfo(log, "Killing opened excel file");
			if (getOSName().toLowerCase().contains("windows")) {
				Runtime.getRuntime().exec("taskkill /F /IM EXCEL.EXE");
			}
		} catch (IOException e) {
			LoggerHelper.logInfo(log, "Errored out while Killing opened excel file");
			LoggerHelper.logError(log, e);
		}
	}

	/**
	 * This method is used to get the property value from config.properties
	 * file.
	 *
	 * @param propertyName
	 *            : The name of the property for which user need to retrieve the
	 *            value
	 * @return the property value for specified property name
	 *         <p>
	 *         Ex: Environment("browserName"):- it returns the value of
	 *         browserName property from config.properties file
	 */
	public static String Environment(String propertyName) {
		try {
			if (!getJenkinsMode()) {
				if (properties == null) {
					properties = loadProperties();
				}
				return properties.getProperty(propertyName);
			} else if (getJenkinsMode()) {
				return System.getenv(propertyName);
			}
		} catch (NullPointerException e) {
			LoggerHelper.logError(log,
					"Errored our while getting environment variable value for a given variable : " + propertyName);
			LoggerHelper.logError(log, e);
		} catch (Exception e) {
			LoggerHelper.logError(log,
					"Errored our while getting environment variable value for a given variable : " + propertyName);
			LoggerHelper.logError(log, e);
		}
		return null;

	}

	/**
	 * This method is used to read the object properties for each element of
	 * specified screen
	 *
	 * @param screenName
	 *            The screen name/page name on which the required element/exists
	 *            is exists
	 * @param objectName
	 *            The Property name / property value of the control/element for
	 *            which selenium is searching for
	 *            <p>
	 *            Example for calling function :-
	 *            readORProperties("LoginaPgae","userNameXpath"), which returns
	 *            the xpath value of username filed that is saved in
	 *            objectRepositry.xml document
	 * @return Array to hold element properties
	 */
	public static String[] readORProperties(String screenName, String objectName) {

		try {
			LoggerHelper.logInfo(log,
					"Reading locator from object repository for a given element '" + objectName + "'");
			setPageName(screenName.replace("Page", "").trim());
			setObjectName(objectName);
			String[] elementProperties = new String[3];
			File fXmlFile = new File(Environment("objectRepoPath"));
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(screenName);
			if (nList.getLength() <= 0) {
				LoggerHelper.logInfo(log, screenName + " tag name was not found in object repositroy");
				throw new IllegalArgumentException();
			}
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					elementProperties[0] = eElement.getElementsByTagName(objectName).item(0).getAttributes()
							.getNamedItem("locatorName").getTextContent().trim();
					elementProperties[1] = eElement.getElementsByTagName(objectName).item(0).getTextContent().trim();
					elementProperties[2] = objectName.trim();
					return elementProperties;
				}
			}
		} catch (IllegalArgumentException ie) {
			LoggerHelper.logInfo(log,
					"Illegal argument was supplied while  reading locator from object repository for a given element '"
							+ objectName + "'");
			LoggerHelper.logInfo(log,
					"No element name was found with given name'" + objectName + "' in object repository");
			LoggerHelper.logError(log, ie);
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log, "Errored out while reading locator from object repository for a given element '"
					+ objectName + "'");
			LoggerHelper.logInfo(log,
					"No element name was found with given name'" + objectName + "' in object repository");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while reading locator from object repository for a given element '"
					+ objectName + "'");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to format the date type value into required date
	 * format in string
	 *
	 * @param dateValue
	 *            The date value that is in other format
	 * @param format
	 *            Required format type to be formatted
	 * @return Returns the string type date value
	 *         <p>
	 *         Example:-
	 *         <p>
	 *         formatDateAndTime(13 dec 2015, "MM_dd_yyyy");
	 */
	public static String formatDateAndTime(Date dateValue, String format) {
		try {
			LoggerHelper.logInfo(log, "Format date and time method was called for given date '" + dateValue + " "
					+ "' and the exepcted format was '" + format + "'");
			SimpleDateFormat ft = new SimpleDateFormat(format);
			String formatedDateValue = ft.format(dateValue);
			return formatedDateValue;
		} catch (Exception e) {
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to format date into required format
	 *
	 * @param dateValue
	 *            : a string type value that holds date
	 * @param inputformat
	 *            : a string type value that holds given format
	 * @param outputFormat
	 *            : a string type value that holds required format
	 * @return returns a string type value that holds date with required format
	 */
	public static String formatDateAndTime(String dateValue, String inputformat, String outputFormat) {
		try {
			LoggerHelper.logInfo(log, "Format date and time method was called for given date '" + dateValue + "' ,"
					+ " given input format '" + inputformat + "' and given output format '" + outputFormat);
			SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputformat);
			SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
			String formatedDateValue = null;
			Date inputDate = null;

			inputDate = inputDateFormat.parse(dateValue);
			formatedDateValue = outputDateFormat.format(inputDate);
			return formatedDateValue;
		} catch (Exception e) {
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to change the current Date format to expected date
	 * format
	 *
	 * @param dateValue
	 *            The current date value that is supposed to change the format
	 * @param currentFormat
	 *            The current format of date value
	 * @param expFormat
	 *            The expected format that data is supposed to be
	 * @return Returns the a string type date value in expected format
	 *
	 *         <p>
	 *         Example :- convertDateFromString(13 dec 2015, "dd MM yyyy"
	 */
	public static String convertStringDateToRequiredFormat(String dateValue, String currentFormat, String expFormat) {
		try {
			LoggerHelper.logInfo(log, "Convert Date to required format method was called for given date '" + dateValue
					+ "' ," + " given format '" + currentFormat + "' and expected format '" + expFormat + "'");
			DateFormat ft = new SimpleDateFormat(currentFormat);
			DateFormat dft = new SimpleDateFormat(expFormat);
			Date formatedDateValue = (Date) ft.parse(dateValue);
			Date finalDate = (Date) dft.parse(formatedDateValue.toString());

			return finalDate.toString();

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while converting given date'" + dateValue + "' ," + "given format '"
					+ currentFormat + "' and expected format '" + expFormat + "'");
			LoggerHelper.logError(log, e);
		}
		return null;

	}

	/**
	 * This method is used to get the current time stamp
	 *
	 * @return Current Date
	 */
	public static Date getCurrentDateAndTime() {
		try {
			LoggerHelper.logInfo(log, "Getting current date and time stamp");
			Date dNow = new Date();
			return dNow;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting current date and time stamp");
			LoggerHelper.logError(log, e);
		}
		return null;

	}

	/**
	 * This method is used to get a date with required week and day
	 *
	 * @return returns a date type valueS
	 */
	public static Date getWeekDayCurrentDateAndTime() {
		try {
			LoggerHelper.logInfo(log, "Getting date with current week and day");
			Calendar cal = Calendar.getInstance();
			int day = cal.get(Calendar.DAY_OF_WEEK);
			if (day == Calendar.SUNDAY) {
				cal.add(Calendar.DATE, -2);
				return cal.getTime();
			} else if (day == Calendar.SATURDAY) {
				cal.add(Calendar.DATE, -1);
				return cal.getTime();
			} else {
				return getCurrentDateAndTime();
			}
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting date with current week and day");
			LoggerHelper.logError(log, e);
		}

		return null;
	}

	/**
	 * This method is used to get tomorrow date
	 *
	 * @return returns a date type value
	 */
	public static Date getTomorrowDate() {
		try {
			LoggerHelper.logInfo(log, "Getting tomorrow date..");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 1);
			return cal.getTime();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting tomorrow date..");
			LoggerHelper.logError(log, e);
		}

		return null;
	}
	
	public static Date getSpecificDayDate(int dayInd) {
		try {
			LoggerHelper.logInfo(log, "Getting specific day date..");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, dayInd);
			return cal.getTime();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting specific day date..");
			LoggerHelper.logError(log, e);
		}

		return null;
	}
	
	public static Date getSpecificDayDate(int dayInd , Date date) {
		try {
			LoggerHelper.logInfo(log, "Getting specific day date..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR, dayInd);
			return cal.getTime();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting specific day date..");
			LoggerHelper.logError(log, e);
		}

		return null;
	}

	/**
	 * This method is used to get current date value
	 * 
	 * @return {integer}
	 */
	public static int getCurrentDay() {
		try {
			LoggerHelper.logInfo(log, "Getting current date value..");
			LocalDate date = LocalDate.now();
			return date.getDayOfMonth();

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting current date value..");
			LoggerHelper.logError(log, e);
		}

		return -1;
	}

	/**
	 * This method is used to get current month value
	 * 
	 * @return {integer}
	 */
	public static int getCurrentMonth() {
		try {
			LoggerHelper.logInfo(log, "Getting current month value..");
			LocalDate date = LocalDate.now();
			return date.getMonthValue();

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting current month value..");
			LoggerHelper.logError(log, e);
		}

		return -1;
	}

	/**
	 * This method is used to get yesterday date
	 *
	 * @return returns a date type value
	 */
	public static Date getYesterDayDate() {
		try {
			LoggerHelper.logInfo(log, "Getting yesterday date..");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, -1);
			return cal.getTime();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting yesterday date..");
			LoggerHelper.logError(log, e);
		}

		return null;
	}

	/**
	 * This method is used to get the difference between time values
	 *
	 * @param time1
	 *            The start time value
	 * @param time2
	 *            The end time value
	 * @param formatValue
	 *            Format type of time to return
	 * @return Returns the long type time value
	 */
	public static long timeDiffInSeconds(String time1, String time2, String formatValue) {
		try {
			LoggerHelper.logInfo(log,
					"Getting time differrence in seconds for given times '" + time1 + " and '" + time2 + "'");
			SimpleDateFormat format = new SimpleDateFormat(formatValue);
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			long difference = date2.getTime() - date1.getTime();
			difference = (difference) / (1000);
			return difference;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting time differrence in seconds for given times '" + time1
					+ " and '" + time2 + "'");
			LoggerHelper.logError(log, e);
			return 0;
		}
	}

	/**
	 * This method is used to get the difference between date values
	 *
	 * @param actdate1
	 *            The date value to be compared
	 * @param actdate2
	 *            The date value to be compared
	 * @param formatValue
	 *            Format type of date to compare
	 * @return Returns the integer type value 0 - equal 1 - date1 is greater
	 *         than date2 -1 - date1 is less than date2
	 */
	public static int compareDates(String actdate1, String actdate2, String formatValue) {
		try {
			LoggerHelper.logInfo(log,
					"Getting time differrence in dates for given dates '" + actdate1 + " and '" + actdate2 + "'");
			SimpleDateFormat format = new SimpleDateFormat(formatValue);
			Date date1 = format.parse(actdate1);
			Date date2 = format.parse(actdate2);
			return date1.compareTo(date2);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting time differrence in dates for given date values '"
					+ actdate1 + " and '" + actdate2 + "'");
			LoggerHelper.logError(log, e);
			return 0;
		}
	}
	
	public static Date convertStringToDate(String date , String formatVal)
	{
		try
		{
			LoggerHelper.logInfo(log,
					"Converting given string date value '" + date + " into date format in following format '" + formatVal + "'");
			SimpleDateFormat format = new SimpleDateFormat(formatVal);
			return format.parse(date);
		}
		catch(Exception e)
		{
			LoggerHelper.logInfo(log,
					"Errored out while converting given string date value '" + date + " into date format in following format '" + formatVal + "'");
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to create the Results file
	 *
	 * @param fileTypeExtn
	 *            of String type value
	 * @param direcotryPath
	 *            of String type value
	 * @return Creates a File
	 */

	public static File createFile(String fileTypeExtn, String direcotryPath) {
		File file = null;
		String fileName = "";

		try {
			LoggerHelper.logInfo(log,
					"Creating a file with extn '" + fileTypeExtn + "' in given path '" + direcotryPath + "'");
			Date currentDate = getCurrentDateAndTime();
			String formatedCurrentDate = formatDateAndTime(currentDate, Environment("dateFormat"));
			Thread.sleep(1000);
			switch (fileTypeExtn) {
			case "xls":
				fileName = direcotryPath + File.separator + Environment("projectName") + "_" + formatedCurrentDate
						+ ".xls";
				break;
			case "txt":
				fileName = direcotryPath + File.separator + Environment("projectName") + "_" + formatedCurrentDate
						+ ".txt";
				break;
			case "json":
				fileName = direcotryPath + File.separator + Environment("projectName") + "_" + formatedCurrentDate
						+ ".json";
				break;
			default:
				fileName = direcotryPath + File.separator + Environment("projectName") + "_" + formatedCurrentDate
						+ ".xls";
				break;
			}
			file = new File(fileName);
			if (file.exists()) {
				return file;
			} else {
				file.createNewFile();
				return file;
			}
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while creating a file with extn '" + fileTypeExtn
					+ "' in given path '" + direcotryPath + "'");
			LoggerHelper.logError(log, e);
		}
		return file;
	}

	/**
	 * This method is used to create the Results file
	 *
	 * @param filePath
	 *            of String type value
	 * @return Creates a File type
	 */

	public static File createFile(String filePath) {
		File file = null;

		try {
			LoggerHelper.logInfo(log, "Creating a file in given path '" + filePath + "'");
			file = new File(filePath);
			if (file.exists()) {
				return file;
			} else {
				file.createNewFile();
				return file;
			}
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while creating a file in given path '" + filePath + "'");
			LoggerHelper.logError(log, e);
		}
		return file;
	}

	/**
	 * This method is used to create the Results file
	 *
	 * @param filePath
	 *            String type
	 * @return Creates a File
	 */

	public static File createDir(String filePath) {
		File file = null;

		try {
			LoggerHelper.logInfo(log, "Creating a directory in given path '" + filePath + "'");
			file = new File(filePath);
			if (file.exists()) {
				return file;
			} else {
				file.mkdir();
				return file;
			}
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while creating a directory in given path '" + filePath + "'");
			LoggerHelper.logError(log, e);
		}
		return file;
	}

	/**
	 * This method is used to get a file
	 *
	 * @param filePath
	 *            : a string type value that holds file path to be created
	 * @return returns a File type
	 */
	public static File getFile(String filePath) {
		LoggerHelper.logInfo(log, "Creating a file in given path '" + filePath + "'");
		File f = null;
		try {
			f = new File(filePath);
			if (f.exists()) {
				return f;
			}
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while creating a file in given path '" + filePath + "'");
			LoggerHelper.logError(log, e);
		}
		return f;
	}

	/**
	 * This method is used to get Path of the file
	 *
	 * @param file
	 *            of String type value
	 * @return It returns path of the file Example :
	 *         Seleniumhelper.getAbolutePathofFile(automation.xml)
	 */
	public static String getAbsoulteFilePath(File file) {
		try {
			LoggerHelper.logInfo(log, "Getting absolute path of given file :" + file.toString());
			return file.getAbsolutePath();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting absolute path of given file :" + file.toString());
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	/**
	 * This method is used to send text into a file
	 *
	 * @param file
	 *            String type value
	 * @param textToWrite
	 *            String type value
	 * @return text sent into a file Example :
	 *         Seleniumhelper.writeAndSaveTextFile(Automation.xls,"automation")
	 */
	public static boolean writeAndSaveTextFile(File file, String textToWrite) {
		try {
			LoggerHelper.logInfo(log,
					"Writing given content: '" + textToWrite + "' in given file: '" + file.toString() + "'");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(textToWrite);
			output.close();
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while writing given content: '" + textToWrite + "' in given file: '"
					+ file.toString() + "'");
			LoggerHelper.logError(log, e);
		}
		return false;

	}

	/**
	 * This method is used to send text into a file
	 *
	 * @param file
	 *            File type value
	 * @param content
	 *            String type value
	 * @param charSet
	 *            String type value
	 * @return text sent into a file Example :
	 *         Seleniumhelper.writeContentToFile("C:\tem.txt","hello","utf-8");
	 */
	public static boolean writeContentToFile(File file, String content, String charSet) {
		try {
			Writer writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath()), charSet));
			writer.write(content);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}

	/**
	 * This method is used to get the machine name
	 *
	 * @return Machine name of string type
	 */
	public static String getHostName() {
		String hostName = "Not found";
		try {
			LoggerHelper.logInfo(log, "Getting host name");
			hostName = InetAddress.getLocalHost().getHostName().toString();
			return hostName;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting host name");
			LoggerHelper.logError(log, e);

		}
		return hostName;
	}

	/**
	 * This method is used to get username
	 *
	 * @return Username of string type
	 */
	public static String getUserName() {
		String userName = "Not found";
		try {
			LoggerHelper.logInfo(log, "Getting user name");
			userName = System.getProperty("user.name");
			return userName;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting the User name");
			LoggerHelper.logError(log, e);

		}
		return userName;
	}

	/**
	 * This method is used to generate random string
	 *
	 * @param length
	 *            of Int type
	 * @param strType
	 *            of string type that holds 'AN' for Alpha-Numeric , 'N' for
	 *            Numeric and 'AB' for Alphabet
	 * @return Generate random string according to length and type Example:
	 *         Seleniumhelper.generateRandomString(4,"AB")
	 */
	public static String generateRandomString(int length, String strType) {
		try {
			LoggerHelper.logInfo(log,
					"Generating random string for given lenght: " + length + "and for given type: " + strType);
			StringBuffer buffer = new StringBuffer();
			String characters = "";

			if (strType.equalsIgnoreCase("AB")) {
				characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			} else if (strType.equalsIgnoreCase("N")) {
				characters = "1234567890";
			} else if (strType.equalsIgnoreCase("AN")) {
				characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			}

			int charactersLength = characters.length();

			for (int i = 0; i <= length - 1; i++) {
				double index = Math.random() * charactersLength;
				buffer.append(characters.charAt((int) index));
			}
			return buffer.toString().toUpperCase();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while generating random string for given lenght: " + length
					+ "and for given type: " + strType);
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to generate random integer
	 *
	 * @param minRange
	 *            of Int type
	 * @param maxRange
	 *            of Int type
	 * @return Generate random Int according to minRange and maxRange Example:
	 *         Seleniumhelper.generateRandomInteger(1,5)
	 */
	public static double generateRandomInteger(int minRange, int maxRange) {
		int num = -1;
		try {
			LoggerHelper.logInfo(log, "Generating random integer in a given range: " + minRange + "and " + maxRange);
			num = maxRange - minRange;
			return minRange + (Math.random() * num);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while generating random integer in a given range: " + minRange + "and " + maxRange);
			LoggerHelper.logError(log, e);
		}
		return -1;
	}

	/**
	 * This method is used to generate random integer
	 *
	 * @param maxRange
	 *            an integer value that holds a range of numbers to be returned
	 * @return returns an integer value with in a given range Eg:-
	 *         generateRandomInteger(100) , given any integer value with in 100
	 *         randomly
	 */
	public static int generateRandomInteger(int maxRange) {

		try {
			LoggerHelper.logInfo(log, "Generating random integer in a given range: " + maxRange);
			return new Double((Math.floor(Math.random() * maxRange))).intValue();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while generating random integer in a given range: " + maxRange);
			LoggerHelper.logError(log, e);
		}
		return -1;
	}

	/**
	 * This method is used to getting driver path
	 *
	 * @return returns the driver path of string type
	 */
	public static String getDriverPath() {
		String os = getOSName();
		String browser = getBrowser();
		try {

			LoggerHelper.logInfo(log,
					"Getting driver path for a given browser '" + browser + "' located in OS '" + os + "'");
			String osFolder = "";
			if (os.toLowerCase().contains("win")) {
				osFolder = "windows";
			} else if (os.toLowerCase().contains("mac")) {
				osFolder = "mac";
			}
			switch (browser.toLowerCase()) {
			case "ie":
				return Environment("ieDriverPath");
			case "chrome":
				if (osFolder.equals("windows")) {
					return Environment("chromeDriverPath").replaceAll("os", osFolder) + ".exe";
				} else if (osFolder.equals("mac")) {
					return Environment("chromeDriverPath").replaceAll("os", osFolder);
				}

			case "ff":
				return Environment("firefoxDriverPath");
			default:
				LoggerHelper.logInfo(log,
						"Given browser" + browser.toString() + " was not matching with any given case");
				throw new IllegalArgumentException();
			}

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting driver path for a given browser '" + browser
					+ "' located in OS '" + os + "'");
			return null;
		}
	}

	/**
	 * This method is used to getting driver path
	 *
	 * @return returns the driver path of string type
	 */
	public static String getChromeDriverPath() {
		String os = getOSName();
		try {

			LoggerHelper.logInfo(log,
					"Getting chrome driver path for a chrome browser  located in OS '" + os + "'");
			String osFolder = "";
			if (os.toLowerCase().contains("win")) {
				osFolder = "windows";
			} else if (os.toLowerCase().contains("mac")) {
				osFolder = "mac";
			}

			if (osFolder.equals("windows")) {
				return Environment("chromeDriverPath").replaceAll("os", osFolder) + ".exe";
			} else if (osFolder.equals("mac")) {
				return Environment("chromeDriverPath").replaceAll("os", osFolder);
			}
			return null;

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting chrome driver path for a chrome browser located in OS '" + os + "'");
			return null;
		}
	}

	/**
	 * This method is get JVM version
	 *
	 * @return JVMversion of Int type
	 */
	public static String getJVMVersion() {
		String jvmBitVersion = "";
		try {
			LoggerHelper.logInfo(log, "Getting JVM version");
			jvmBitVersion = System.getProperty("sun.arch.data.model");

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored our while getting JVM version");
			LoggerHelper.logError(log, e);
		}
		return jvmBitVersion;
	}

	/**
	 * This method is used to build an URL dynamically
	 *
	 * @return returns an URL of region in a string format
	 */
	public static String buildURL() {

		try {

			String regionValue = getRegion();

			LoggerHelper.logInfo(log, "Building dynamic URL for a given region '" + regionValue + "'");
			if (regionValue.trim().equalsIgnoreCase("local")) {
				return Environment("localURL");
			}
			String baseUrl = Environment("baseURL");
			String relUrl = regionValue + Environment("relURL");
			return baseUrl + relUrl;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log,
					"Errored out while building dynamic URL for a given region '" + getRegion() + "'");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while building dynamic URL for a given region '" + getRegion() + "'");
			LoggerHelper.logError(log, e);
		}

		return null;

	}

	/**
	 * This method is used to build an URL based on region name
	 *
	 * @param regionValue
	 *            String type
	 * @return return URL value
	 */
	public static String buildURL(String regionValue) {

		try {
			LoggerHelper.logInfo(log, "Building dynamic URL for a given region '" + regionValue + "'");
			if (regionValue.trim().equalsIgnoreCase("local")) {
				return Environment("localURL");
			}
			String baseUrl = Environment("baseURL");
			String relUrl = regionValue + Environment("relURL");
			return baseUrl + relUrl;
		} catch (NullPointerException ne) {
			LoggerHelper.logInfo(log,
					"Errored out while building dynamic URL for a given region '" + getRegion() + "'");
			LoggerHelper.logError(log, ne);
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while building dynamic URL for a given region '" + getRegion() + "'");
			LoggerHelper.logError(log, e);
		}

		return null;

	}

	/**
	 * This method is used to getting region
	 *
	 * @return returns a string type value that holds a region
	 */
	public static String getRegion() {
		try {
			LoggerHelper.logInfo(log, "Getting region details");
			return Environment("appRegion");
		} catch (NullPointerException e) {
			LoggerHelper.logInfo(log, "Errored out while getting region details");
			LoggerHelper.logError(log, e);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting region details");
			LoggerHelper.logError(log, e);
		}
		return null;

	}

	/**
	 * This method is used to get current browser name
	 *
	 * @return returns a string type value that holds browser name
	 */
	public static String getBrowser() {

		try {
			if (getJenkinsMode()) {
				return Environment("browser");
			}
			return Environment("browserName");
		} catch (NullPointerException e) {
			LoggerHelper.logInfo(log, "Errored out while getting browser details");
			LoggerHelper.logError(log, e);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting browser details");
			LoggerHelper.logError(log, e);
		}
		return null;
	}

	/**
	 * This method is used to decrypt an encrypted string value
	 *
	 * @param strEncrypted
	 *            a string type value that holds encrypted format
	 * @return returns a decrypted value
	 */
	public static String decrypt(String strEncrypted) {

		try {
			LoggerHelper.logInfo(log, "Decrypting the encrypted value");
			Base64.Decoder decoder = Base64.getMimeDecoder();
			String dStr = new String(decoder.decode(strEncrypted));
			return dStr;

		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while decrypting the encrypted value");
			LoggerHelper.logError(log, e);
			return "";
		}
	}

	/**
	 * This method is used to rename a given file
	 *
	 * @param currentFilePath
	 *            a string type value that holds current file name
	 * @param newFilePath
	 *            a string type value that holds new file name
	 */
	public static void renameFile(String currentFilePath, String newFilePath) {
		try {
			LoggerHelper.logInfo(log,
					"Renaming given file '" + currentFilePath + "' to new file '" + newFilePath + "'");
			File currentFile = getFile(currentFilePath);
			File newFile = getFile(newFilePath);
			currentFile.renameTo(newFile);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while renaming given file '" + currentFilePath + "' to new file '"
					+ newFilePath + "'");
			LoggerHelper.logError(log, e);
		}

	}

	/**
	 * This method is used to get root path
	 *
	 * @return returns user directory root path
	 */
	public static String getRootPath() {
		LoggerHelper.logInfo(log, "Getting current directory root path");
		return System.getProperty("user.dir");
	}

	/**
	 * This method is used to get OS name
	 *
	 * @return returns given OS name in a string type value
	 */
	public static String getOSName() {
		LoggerHelper.logInfo(log, "Getting current OS name");
		return System.getProperty("os.name");
	}

	/**
	 * This method is used to read file as string
	 *
	 * @param filename
	 *            file path of given file to be read as string
	 * @param charSet
	 *            Format of characters to be read.
	 * @return returns the file content in string format
	 */
	public static String readFileAsString(File file, String charSet) {
		String result = "";
		try {
			LoggerHelper.logInfo(log, "Reading file as string '" + file.toString() + "'");
			result = FileUtils.readFileToString(file, charSet);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored put while reading given file '" + file.toString() + "' as a string");
			LoggerHelper.logError(log, e);
		}
		return result;
	}

	/**
	 * This method is used to read file as string
	 *
	 * @param filename
	 *            file path of given file to be read as string
	 * @return returns the file content in string format
	 */
	public static String readFileAsString(String filename) {
		String result = "";
		try {
			LoggerHelper.logInfo(log, "Reading file as string '" + filename + "'");
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = sb.toString();
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored put while reading given file '" + filename + "' as a string");
			LoggerHelper.logError(log, e);
		}
		return result;
	}

	public static String getPlatform() {
		try {
			LoggerHelper.logInfo(log, "Getting platform details");
			return Environment("platform");
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while getting platform detais");
			LoggerHelper.logError(log, e);
			return null;
		}
	}

	public static boolean getJenkinsMode() {
		jenkinsMode = System.getenv("jenkinsMode");
		if (jenkinsMode == null) {
			return false;
		}
		if (jenkinsMode.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean copyFile(String src, String dest, String fileName) {
		try {
			LoggerHelper.logInfo(log, "Copying given file: " + fileName + " from source: " + src + "to dest: " + dest);
			FileUtils.copyFile(getFile(src + File.separator + fileName), getFile(dest + File.separator + fileName));
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while copying given file: " + fileName + " from source: " + src + "to dest: " + dest);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	public static boolean copyFile(String srcFile, String destFile) {
		try {
			LoggerHelper.logInfo(log, "Copying given file: " + srcFile + "to dest: " + destFile);
			FileUtils.copyFile(getFile(srcFile), getFile(destFile));
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while copying given file: " + srcFile + " to dest: " + destFile);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	public static boolean copyDir(String srcDir, String destDir) {
		try {
			LoggerHelper.logInfo(log, "Copy directory function was called");
			if (!getFile(srcDir).isDirectory()) {
				LoggerHelper.logInfo(log, "Given directory was not a directory: " + srcDir);
				return false;
			}
			LoggerHelper.logInfo(log, "Copying given source directory: " + srcDir + "to dest: " + destDir);
			FileUtils.copyDirectory(getFile(srcDir), getFile(destDir));
			return true;
		} catch (Exception e) {
			LoggerHelper.logInfo(log,
					"Errored out while copying given source directory: " + srcDir + "to dest: " + destDir);
			LoggerHelper.logError(log, e);
		}
		return false;
	}

	public static void setCurrentScenarioName(String name) {
		currentScenarioName = name;
	}

	public static String getCurrentScenarioName() {
		return currentScenarioName;
	}

	public static String getJenkinsRegionValue() {
		return glbregionValue;
	}

	public static void setJenkinsRegionValue(String value) {
		glbregionValue = value;
	}

	/**
	 * @param mainStr
	 * @param subStr
	 * @return {boolean} returns True or false
	 * @function
	 * @description This method is used to compare two given String using
	 *              contains method
	 * @name stringContains
	 */
	public static boolean stringContains(String mainStr, String subStr) {
		try {
			LoggerHelper.logInfo(log, "Comparing string using contains operation..");
			return mainStr.contains(subStr);
		} catch (Exception e) {
			LoggerHelper.logInfo(log, "Errored out while comparing the string using contains operation..");
			LoggerHelper.logError(log, e);
			return false;
		}
	}

}
