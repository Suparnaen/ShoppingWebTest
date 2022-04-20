package com.shop.utility;

import org.apache.log4j.Logger;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class Log {

    // Initialize Log4j logs
    public static Logger log = Logger.getLogger(Log.class.getName());

    public static void startTestCase(String sTestCaseName){
    log.info("====================================="+sTestCaseName+" TEST START=========================================");
    }
    public static void endTestCase(String sTestCaseName){
        log.info("====================================="+sTestCaseName+" TEST END=========================================");
    }

    public static void info(String message){
        log.info(message);

    }
    public static void warn(String message){
        log.warn(message);

    }
    public static void error(String message){
        log.error(message);

    }
    public static void fatal(String message){
     log.fatal(message);

    }
    public static void debug(String message){
     log.debug(message);

    }

}
