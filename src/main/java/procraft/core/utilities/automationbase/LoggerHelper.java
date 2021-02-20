package procraft.core.utilities.automationbase;

import org.apache.log4j.Logger;

public class LoggerHelper {
    /**
     * This method is used to log the step information
     *
     * @param logger  log object of given class
     * @param message meesage to log
     */
    public static void logInfo(Logger logger, String message) {
        logger.info(message);
    }

    /**
     * This method is used to log the step information in debug mode
     *
     * @param logger  log object of given class
     * @param message meesage to log
     */
    public static void logDebug(Logger logger, String message) {
        logger.debug(message);
    }

    /**
     * This method is used to log the step information in error mode
     *
     * @param logger  log object of given class
     * @param message meesage to log
     */
    public static void logError(Logger logger, String message) {
        logger.error(message);
    }

    /**
     * This method is used to log given info in error mode
     *
     * @param logger log object of given class
     * @param e      Exception class type
     */
    public static void logError(Logger logger, Exception e) {
        logger.error(e.getMessage());
        logger.error(getStackTrace(e.getStackTrace()));
    }


    private static String getStackTrace(StackTraceElement[] trace) {
        String err = "";
        for (StackTraceElement stackTraceElement : trace) {
            err = err + System.lineSeparator() + stackTraceElement.toString();
        }
        return err;
    }
}
