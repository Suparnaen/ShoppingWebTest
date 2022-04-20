package com.shop.testcases;

import com.shop.BaseDriver;
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.AddToCartPage;
import com.shop.pageobjects.IndexPage;
import com.shop.pageobjects.OrderPage;
import com.shop.pageobjects.SearchResultPage;
import com.shop.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author - Suparna Das added on 4/11/2022
 */
public class OrderPageTest extends BaseDriver {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;

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
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        Log.startTestCase("verifyTotalPrice");
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.enterQuantity(qty);
        addToCartPage.selectSize(size);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddtoCartMessage();
        Assert.assertTrue(result);
        orderPage = addToCartPage.clickOnCheckOut();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double expectedTotalPrice =(unitPrice*(Double.parseDouble(qty)))+2;
        Assert.assertEquals(totalPrice, expectedTotalPrice);
        Log.endTestCase("verifyTotalPrice");
    }

}
