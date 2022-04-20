package com.shop;

import com.shop.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @Author - Suparna Das added on 4/8/2022
 * Manages the browser invocation
 */
public class BaseDriver {

    public static Properties prop;
    public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    //public static ExtentManager rep;

    @BeforeSuite(groups={"Smoke","Sanity","Regression"})
    public void loadConfig(){

        ExtentManager.setExtent();
        DOMConfigurator.configure("log4j.xml");

        try {
            prop = new Properties();
            //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
            FileInputStream fis = new FileInputStream("Configuration/Config.properties");
            prop.load(fis);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public void launchApp(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
             driver.set(new ChromeDriver());
         }else if(browserName.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }else if(browserName.equalsIgnoreCase("IE")){
            WebDriverManager.iedriver().setup();
            driver.set(new InternetExplorerDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
        getDriver().get(prop.getProperty("url"));
    }

    @AfterSuite(groups={"smoke","Sanity","Regression"})
    public void afterSuite(){
        ExtentManager.endReport();
    }

}
