package com.shop.testcases;

import com.shop.BaseDriver;
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.HomePage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.LoginPage;
import com.shop.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author - Suparna Das added on 4/10/2022
 */
public class LoginPageTest extends BaseDriver {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser){
        launchApp(browser);
        indexPage= new IndexPage();
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown(){
        getDriver().quit();
    }

    @Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void loginTest(String uname, String password) throws InterruptedException {
        Log.startTestCase("loginTest");

        Log.info("user is going to click on SignIn");
        loginPage=indexPage.clickOnSignIn();
        Log.info("Enter Username and Password");
        homePage = loginPage.loginToHomePage(uname,password);
        String actualURL = homePage.getCurrURL();
        String expectedURL="http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualURL, expectedURL);
        Log.info("Login is Sucess");
        Log.endTestCase("loginTest");
    }

}
