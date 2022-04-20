package com.shop.testcases;

import com.shop.BaseDriver;
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.*;
import com.shop.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author - Suparna Das added on 4/11/2022
 */
public class EndToEndTest extends BaseDriver {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private LoginPage loginPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    private OrderSummary orderSummary;
    private OrderConfirmationPage orderConfirmationPage;

    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
        launchApp(browser);
        indexPage = new IndexPage();
    }

    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }


    @Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void endToEndTest(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("endToEndTest");
        searchResultPage=indexPage.searchProduct(productName);
        addToCartPage=searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        orderPage=addToCartPage.clickOnCheckOut();
        loginPage=orderPage.clickOnCheckOut();
        addressPage=loginPage.loginToAddressPage(prop.getProperty("username"), prop.getProperty("password"));
        shippingPage=addressPage.clickOnCheckOut();
        shippingPage.checkTheTermsCheckbox();
        paymentPage=shippingPage.clickOnProceedToCheckOut();
        orderSummary=paymentPage.clickOnPaymentMethod();
        orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
        String actualMessage=orderConfirmationPage.validateConfirmMessage();
        String expectedMsg="Your order on My Store is complete.";
        Assert.assertEquals(actualMessage, expectedMsg);
        Log.endTestCase("endToEndTest");

    }
}
