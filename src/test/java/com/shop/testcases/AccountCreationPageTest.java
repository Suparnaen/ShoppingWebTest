package com.shop.testcases;

import com.shop.BaseDriver;
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.AccountCreationPage;
import com.shop.pageobjects.HomePage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.LoginPage;
import com.shop.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * @Author - Suparna Das added on 4/10/2022
 */
public class AccountCreationPageTest extends BaseDriver {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private AccountCreationPage accountCreationPage;
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

    @Test(groups={"Smoke","Sanity","Regression"}, dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
    public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
        Log.startTestCase("createAccountTest");
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount(hashMapValue.get("Email"));
        accountCreationPage.createAccount(hashMapValue.get("Gender"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("SetPassword"),
                hashMapValue.get("Day"),
                hashMapValue.get("Month"),
                hashMapValue.get("Year"),
                hashMapValue.get("Company"),
                hashMapValue.get("Address"),
                hashMapValue.get("City"),
                hashMapValue.get("State"),
                hashMapValue.get("Zipcode"),
                hashMapValue.get("Country"),
                hashMapValue.get("MobilePhone"));
        homePage = accountCreationPage.validateRegistration();
        Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
        Log.endTestCase("createAccountTest");

    }

}
