package procraft.core.utilities.api;

import java.io.FileWriter;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import procraft.core.utilities.automationbase.LoggerHelper;

public class RestAssuredHelper {
    private static Logger log = Logger.getLogger(RestAssuredHelper.class);

    private static RequestSpecification currentRequest;
    private static Response currentResponse;

    public static enum contentType {
        text, json, xml, html
    }

    /**
     * This method is used to set request instance by pointing to given end point
     *
     * @param baseURI String type value which holds end point URL
     * @return returns boolean type True or False
     */
    public static boolean setGivenRequest(String baseURI) {
        try {
            LoggerHelper.logInfo(log, "Setting request instance for given serivce URL/End point '" + baseURI + "'");
            RestAssured.baseURI = baseURI;
            currentRequest = RestAssured.given();
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while setting request instance for given service URL/end point '" + baseURI + "'");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to get current request
     *
     * @return returns Request specification type of current request
     */
    public static RequestSpecification getCurrentRequest() {
        LoggerHelper.logInfo(log, "Getting current request");
        return currentRequest;
    }

    /**
     * This method is used to get current response
     *
     * @return Response type parameter
     */
    public static Response getCurrentResponse() {
        LoggerHelper.logInfo(log, "Getting current response");
        System.out.println(currentResponse.asString());
        return currentResponse;
    }

    /**
     * This method is used to add parameters to request
     *
     * @param paramName  String type value
     * @param paramValue String type value
     * @return returns boolean type True or False
     */
    public static boolean addParameter(String paramName, String paramValue) {
        try {
            LoggerHelper.logInfo(log, "Adding parameter '" + paramName + "' and value '" + paramValue + "'  to given request");
            currentRequest.param(paramName, paramValue);
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Erroed out while adding parameter '" + paramName + "' and value '" + paramValue + "'  to given request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to add collection of parameters to a request
     *
     * @param params Map  type
     * @return returns boolean type True or False
     */
    public static boolean addParameters(Map<String, String> params) {
        try {
            LoggerHelper.logInfo(log, "Adding parameters to given request");
            currentRequest.params(params);
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Erroed out while adding parameters to given request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to add collection of Query Parameters
     *
     * @param params Map type
     * @return returns boolean True or False
     */
    public static boolean addQueryParameters(Map<String, String> params) {
        try {
            LoggerHelper.logInfo(log, "Adding query parameters to given request");
            currentRequest.queryParams(params);
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Erroed out while adding parameters to given request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to add a header to a given Request
     *
     * @param headerName  String type
     * @param headerValue String type
     * @return return boolean true or False
     */
    public static boolean addHeader(String headerName, String headerValue) {
        try {
            LoggerHelper.logInfo(log, "Adding header '" + headerName + "' and value '" + headerValue + "'  to given request");
            currentRequest.headers(headerName, headerValue);
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Erroed out while adding header '" + headerName + "' and value '" + headerValue + "'  to given request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to add collection of headers to a given request
     *
     * @param headers Map type
     * @return returns boolean true or false
     */
    public static boolean addHeaders(Map<String, String> headers) {
        try {
            LoggerHelper.logInfo(log, "Adding headers to given request");
            currentRequest.headers(headers);
            return true;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Erroed out while adding headers to given request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute GET method
     *
     * @param cont     Enum type of Content
     * @param endPoint String type
     * @param body     String type
     * @return returns boolean True or false
     */
    public static boolean getResponse(contentType cont, String endPoint, String body) {
        try {
            LoggerHelper.logInfo(log, "Getting response for a given request");
            switch (cont) {
                case text:
                    currentResponse = currentRequest.body(body).contentType(ContentType.TEXT).get(endPoint).thenReturn();
                    return true;
                case json:
                    currentResponse = currentRequest.body(body).contentType(ContentType.JSON).get(endPoint).thenReturn();
                    return true;
                case xml:
                    currentResponse = currentRequest.body(body).contentType(ContentType.XML).get(endPoint).thenReturn();
                    return true;
                case html:
                    currentResponse = currentRequest.body(body).contentType(ContentType.HTML).get(endPoint).thenReturn();
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while getting the response for a given request with content");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute GET method
     *
     * @return returns boolean type True or False
     */
    public static boolean getResponse() {
        try {
            LoggerHelper.logInfo(log, "Getting response for a given request ");
            currentResponse = currentRequest.get().thenReturn();
            return true;

        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while getting the response from the request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute GET method
     *
     * @param headers Map type headers
     * @return returns boolean True or False
     */
    public static boolean getResponse(Map<String, Object> headers) {
        try {
            LoggerHelper.logInfo(log, "Getting response for a given request with headers");
            currentResponse = currentRequest.headers(headers).get().thenReturn();
            return true;

        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while setting the response for a given request with headers");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute POST method
     *
     * @param cont     enum type of Content
     * @param endPoint String type
     * @param body     String type
     * @return return boolean True or False
     */
    public static boolean postRequest(contentType cont, String endPoint, String body) {
        try {
            LoggerHelper.logInfo(log, "Posting request with content and body");
            switch (cont) {
                case text:
                    currentResponse = currentRequest.body(body).contentType(ContentType.TEXT).post(endPoint).thenReturn();
                    return true;
                case json:
                    currentResponse = currentRequest.body(body).contentType(ContentType.JSON).post(endPoint).thenReturn();
                    return true;
                case xml:
                    currentResponse = currentRequest.body(body).contentType(ContentType.XML).post(endPoint).thenReturn();
                    return true;
                case html:
                    currentResponse = currentRequest.body(body).contentType(ContentType.HTML).post(endPoint).thenReturn();
                    return true;
                default:
                    LoggerHelper.logInfo(log, "Illegela argument was supplied for posting a request");
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while posting request with content and body");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute POST method
     *
     * @param cont enum type of Content
     * @param body String type
     * @return return boolean True or False
     */
    public static boolean postRequest(contentType cont, String body) {
        try {
            LoggerHelper.logInfo(log, "Posting request with content and body");
            switch (cont) {
                case text:
                    currentResponse = currentRequest.body(body).contentType(ContentType.TEXT).post().thenReturn();
                    return true;
                case json:
                    currentResponse = currentRequest.body(body).contentType(ContentType.JSON).post().thenReturn();
                    return true;
                case xml:
                    currentResponse = currentRequest.body(body).contentType(ContentType.XML).post().thenReturn();
                    return true;
                case html:
                    currentResponse = currentRequest.body(body).contentType(ContentType.HTML).post().thenReturn();
                    return true;
                default:
                    LoggerHelper.logInfo(log, "Illegela argument was supplied for posting a request");
                    throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while posting request with content and body");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute POST method
     *
     * @return returns boolean type True or False
     */
    public static boolean postRequest() {
        try {
            LoggerHelper.logInfo(log, "Posting request");
            currentResponse = currentRequest.post().thenReturn();
            return true;

        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while posting the request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute POST method
     *
     * @param body returns String type
     * @return returns boolean type True or False
     */
    public static boolean postRequest(String body) {
        try {
            LoggerHelper.logInfo(log, "Posting request");
            currentResponse = currentRequest.post(body).thenReturn();
            return true;

        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while posting the request");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to execute POST method
     *
     * @param headers Map type headers
     * @return Returns boolean true or False
     */
    public static boolean postResponse(Map<String, Object> headers) {
        try {
            LoggerHelper.logInfo(log, "Posting response with headers");
            currentResponse = currentRequest.headers(headers).post().thenReturn();
            return true;

        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while posting the response with headers");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to validate success code of response
     *
     * @param expStatusCode int Type
     * @return returns boolean type True or False
     */
    public static boolean validateResponse(int expStatusCode) {
        try {
            LoggerHelper.logInfo(log, "Validating the  response with StatusCode");
            if (currentResponse.then().statusCode(expStatusCode) != null) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while validating  the response with StatusCode");
            LoggerHelper.logError(log, e);
            return false;
        }
    }

    /**
     * This method is used to get JSON as Document context
     *
     * @param jsonString Strng type jsonString
     * @return returns DocumentContext type
     */
    public static DocumentContext getJsonContext(String jsonString) {
        try {
            LoggerHelper.logInfo(log, "Getting the JsonContext");
            Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                    .mappingProvider(new JacksonMappingProvider()).build();

            DocumentContext json = JsonPath.using(configuration).parse(jsonString);
            return json;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while getting the JsonContext");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to update given JSON
     *
     * @param jsonContext DocumentContext type
     * @param element     String type
     * @param value       String type
     * @return returns String type updated JSON
     */
    public static String updateJSON(DocumentContext jsonContext, String element, String value) {
        LoggerHelper.logInfo(log, "Updating the JsonContext with New Value");
        try {
            String newValue = value;
            return jsonContext.set(element, newValue).jsonString();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while updating the JsonContext with the New value");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to update JSON for multiple elements
     *
     * @param jsonContext DocumentContext type
     * @param elements    Map type json elements
     * @return returns String type updated JSON
     */
    public static String updateJSON(DocumentContext jsonContext, Map<String, String> elements) {
        DocumentContext context = jsonContext;
        String Key = "", value = "";
        try {
            LoggerHelper.logInfo(log, "Updating the JsonContext");

            for (String key : elements.keySet()) {
                Key = key;
                value = elements.get(key);
                context.set(key, elements.get(key));
            }
            return context.jsonString();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while updating the JsonContext for a given element '" + Key + " ' and value '" + value + " '");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to validate JSON for given collection of elements
     *
     * @param elements Map type elements
     * @return returns boolean type True or False
     */
    public static boolean ValidateJSON(Map<String, String> elements) {

        String Key = "", value = "", actVal = "";
        boolean result = true;
        try {
            LoggerHelper.logInfo(log, "Validating the Json");
            for (String key : elements.keySet()) {
                Key = key;
                value = elements.get(key);
                actVal = getCurrentResponse().then().extract().path(key);
                if (!actVal.equals(value)) {
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

    /**
     * This method is used to save JSON response in a file
     *
     * @param filePath String type JSON file path
     */
    public static void saveResponse(String filePath) {
        try {
            LoggerHelper.logInfo(log, "Saving current response as a file");
            FileWriter fw = new FileWriter(filePath);
            fw.write(getCurrentResponse().asString());
            fw.close();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while saving current response as a file");
            LoggerHelper.logError(log, e);
        }

    }

    /**
     * This method is used to save given JSON string as file
     *
     * @param filePath   String type JSON file path
     * @param jsonString String type JSON value
     */
    public static void saveJSONStringAsFile(String filePath, String jsonString) {
        try {
            LoggerHelper.logInfo(log, "Saving current response as a file");
            FileWriter fw = new FileWriter(filePath);
            fw.write(jsonString);
            fw.close();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while saving current response as a file");
            LoggerHelper.logError(log, e);
        }

    }

    /**
     * This method is used to get count of JSON elements
     *
     * @param jsonElement String type Element path
     * @return returns int type count
     */
    public static int jsonElementsSize(String jsonElement) {
        try {
            log.info("Getting the size of given json elements '" + jsonElement + "'");
            return getCurrentResponse().then().extract().path(jsonElement);
        } catch (Exception e) {
            log.error("Errored out while getting the size of given json elements '" + jsonElement + "'");
            log.error(e.getMessage());
        }
        return 0;
    }

    /**
     * This method is used to get response status code
     *
     * @return int type value
     */
    public static int getResponseStatusCode() {
        LoggerHelper.logInfo(log, "Getting response status code");
        return getCurrentResponse().statusCode();
    }

    /**
     * This method is used to create a JSON string with given data
     *
     * @param data Map type
     * @return returns JSON string
     */
    public static String getJSONOBJECT(Map<String, String> data) {
        try {
            LoggerHelper.logInfo(log, "Creating JSON object");
            JSONObject object = new JSONObject();
            for (String Key : data.keySet()) {
                LoggerHelper.logInfo(log, "Creating JSON object for a given Key '" + Key + "' and value '" + data.get(Key) + "'");
                object.put(Key, data.get(Key));
            }
            return object.toString();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while creating JSON object");
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    public static JSONObject parseJsonString(String jsonStr) {
        try {
            LoggerHelper.logInfo(log, "Converting json string to json obj");
            JSONObject jsnObj = new JSONObject(jsonStr);
            return jsnObj;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while converting json string to json object");
            return null;
        }
    }

    /**
     * This method is used to create a JSON string with given data
     *
     * @param data Map type
     * @return returns JSON string
     */
    public static String getJSONOBJECT(String parentKey, Map<String, String> data) {
        try {
            LoggerHelper.logInfo(log, "Creating JSON object");
            JSONObject object = new JSONObject();
            for (String Key : data.keySet()) {
                LoggerHelper.logInfo(log, "Creating JSON object for a given Key '" + Key + "' and value '" + data.get(Key) + "'");
                object.put(Key, data.get(Key));
            }
            JSONObject obj = new JSONObject();
            obj.put(parentKey, object);
            return obj.toString();
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while creating JSON object");
            LoggerHelper.logError(log, e);
            return null;
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
            String value = getCurrentResponse().then().extract().path(String.format(jsonPath, formatIndex));
            return value;
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while fetching value of given Json element " + jsonPath);
            LoggerHelper.logError(log, e);
            return null;
        }
    }

    /**
     * This method is used to get value from give dynamic JSON path by formatting
     *
     * @param jsonPath    String type
     * @param formatIndex int type
     * @return return String type value
     */
    public static String getJSONElementValue(String jsonPath, int formatIndex, int formatIndx2) {
        try {
            LoggerHelper.logInfo(log, "Fetching value of given Json element " + jsonPath);
            return getCurrentResponse().then().extract().path(String.format(jsonPath, formatIndex, formatIndx2));
        } catch (Exception e) {
            LoggerHelper.logInfo(log, "Errored out while fetching value of given Json element " + jsonPath);
            LoggerHelper.logError(log, e);
            return null;
        }
    }
}
