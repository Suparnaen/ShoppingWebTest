package com.shop.utility;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @Author - Suparna Das added on 4/9/2022
 */

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest test;

    public static void setExtent(){
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/"+"MyReport.html");
        //htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml");
        htmlReporter = new ExtentHtmlReporter("reports/ExtentReport/"+"MyReport.html");
        htmlReporter.loadXMLConfig("extent-config.xml");

        extentReports  = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("HostName", "MyHost");
        extentReports.setSystemInfo("ProjectName", "ShoppingWebTest");
        extentReports.setSystemInfo("Tester", "Suparna");
        extentReports.setSystemInfo("OS", "Win10");
        extentReports.setSystemInfo("Browser", "Chrome");

    }

    public static void endReport(){
        extentReports.flush();
    }

}
