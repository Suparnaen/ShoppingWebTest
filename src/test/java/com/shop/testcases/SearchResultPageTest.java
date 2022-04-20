package com.shop.testcases;

import com.shop.BaseDriver;
import com.shop.dataprovider.DataProviders;
import com.shop.pageobjects.IndexPage;
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
public class SearchResultPageTest extends BaseDriver {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
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

    @Test(groups = {"Smoke","Sanity"},dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName) throws InterruptedException {
        Log.startTestCase("productAvailabilityTest");
        searchResultPage = indexPage.searchProduct(productName);
        boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
        Log.endTestCase("productAvailabilityTest");
    }

}
