package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class IndexPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInBtn;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement myStoreLogo;

    @FindBy(id="search_query_top")
    private WebElement searchProductBox;

    @FindBy(name="submit_search")
    private WebElement searchButton;

    public IndexPage(){
        PageFactory.initElements(getDriver(),this);
    }

    /**
     * Validate logo in the Index page
     * @return
     */
    public boolean validateLogo(){

    return ele.isDisplayed(getDriver(),myStoreLogo);

    }

    /**
     * Validate the title of Index page
     * @return
     */
    public String getMyStoreTitle(){
        String shoppingPageTitle =getDriver().getTitle();
        return shoppingPageTitle;
    }

    /**
     * On searching a prodcut with productName should return searchResultPage
     * @param productName
     * @return
     * @throws InterruptedException
     */
    public SearchResultPage searchProduct(String productName) throws InterruptedException {
        ele.type(searchProductBox, productName);
        ele.scrollByVisibilityOfElement(getDriver(),searchButton);
        ele.click(getDriver(),searchButton);
        Thread.sleep(4000);

        return new SearchResultPage();
    }

    /**
     * Clicking on SignIn button, returns the user login page
     * @return
     */
    public LoginPage clickOnSignIn(){
        ele.fluentWait(getDriver(),signInBtn,10);
        ele.scrollByVisibilityOfElement(getDriver(),signInBtn);
        ele.JSClick(getDriver(),signInBtn);
        return new LoginPage();
    }
}
