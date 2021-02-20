package procraft.core.utilities.api;

import java.util.Map;

import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import procraft.core.utilities.automationbase.LoggerHelper;

public class IOJsonPath {
    private static Logger log = Logger.getLogger(IOJsonPath.class);
    private static JsonPath path = null;


    /**
     * This method is used to setting up given json string format to IO rest assured
     * json path
     *
     * @param jsonString String type value which holds JSON string to be converted to json
     *                   path
     */
    public static void setJSONPath(String jsonString) {
        try {
            LoggerHelper.logInfo(log, "Setting given json string " + jsonString + " as IO Json path");
            path = new JsonPath(jsonString);
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while setting given json string " + jsonString + " as IO json path");
            LoggerHelper.logError(log, e);
        }

    }

    /**
     * This method is used to get current json path
     *
     * @return returns json path
     */

    public static JsonPath getcurrentJsonPath() {
        try {
            LoggerHelper.logInfo(log, "Getting current json path");
            return path;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while getting current json path");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to get size of json elements
     *
     * @param jsonElement String format json path
     * @return return size of given json elements by using current json path
     */

    public static int jsonElementsSize(String jsonElement) {
        try {
            LoggerHelper.logInfo(log, "Getting json elments count..");
            return getcurrentJsonPath().getInt(jsonElement);
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while getting json elements count");
            LoggerHelper.logError(log, e);
            return 0;
        }
    }

    /**
     * This method is used to get value from give dynamic JSON path by formatting
     *
     * @param jsonPath    String type
     * @param formatIndex int type
     * @return return String type value
     */
    public static String getJSONElementValue(String jsonPath, int formatIndex) {
        try {
            LoggerHelper.logInfo(log, "Fetching value of given Json element " + String.format(jsonPath, formatIndex));
            String value = getcurrentJsonPath().getString((String.format(jsonPath, formatIndex)));
            return value;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while fetching value of given Json element " + jsonPath);
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to validate JSON path of IO rest assured
     *
     * @param elements Map
     * @return returns boolean true or false
     */
    public static boolean ValidateJSONPath(Map<String, String> elements) {

        String Key = "", value = "", actVal = "";
        boolean result = true;
        try {
            LoggerHelper.logInfo(log, "Validating the Json");
            for (String key : elements.keySet()) {
                Key = key;
                value = elements.get(key);
                actVal = getcurrentJsonPath().getString(key);
                if (actVal == null && (!value.equals("null"))) {
                    LoggerHelper.logInfo(log, "Given element " + Key + " was null");
                    throw new NullPointerException();
                } else if (actVal != null && (value.equals("null"))) {
                    return false;
                } else if (actVal == null && (value.equals("null"))) {
                    continue;
                }
                if (!actVal.trim().equals(value)) {
                    LoggerHelper.logInfo(log, "Given element '" + Key + " ' was having an unexpected value '" + actVal + "'"
                            + " and the expected value was '" + value + " '");
                    result = false;
                }
            }
            return result;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while validating the Json for a given element '" + Key + " ' and value '" + value + " '");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

}
