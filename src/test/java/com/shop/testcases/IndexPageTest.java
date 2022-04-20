package com.shop.testcases;

import com.aventstack.extentreports.ExtentTest;
import com.shop.BaseDriver;
import com.shop.pageobjects.IndexPage;
import com.shop.utility.ExtentManager;
import com.shop.utility.ListenerClass;
import com.shop.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author - Suparna Das added on 4/10/2022
 */
public class IndexPageTest extends BaseDriver {

    private IndexPage indexPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){

        launchApp(browser);


    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void verifyLogo(){
        Log.startTestCase("verifyLogo");
        indexPage = new IndexPage();
        boolean result =indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");
    }

    @Test(groups = "Smoke")
    public void verifyTitle(){
        Log.startTestCase("verifyTitle");
        String actTitle =indexPage.getMyStoreTitle();
        Assert.assertEquals(actTitle,"My Store");
        Log.endTestCase("verifyTitle");

    }



}
