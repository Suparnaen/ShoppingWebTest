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
public class HomePageTest extends BaseDriver {
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
    public void validateWishListTest(String uname, String password) throws InterruptedException {
        Log.startTestCase("validateWishListTest");
        loginPage=indexPage.clickOnSignIn();
        homePage = loginPage.loginToHomePage(uname,password);
        boolean result = homePage.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("validateWishListTest");
    }

    @Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void validateOrderHistoryDetailsTest(String uname, String password) throws InterruptedException {
        Log.startTestCase("validateOrderHistoryDetailsTest");
        loginPage=indexPage.clickOnSignIn();
        homePage = loginPage.loginToHomePage(uname,password);
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("validateOrderHistoryDetailsTest");
    }

}
