package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class HomePage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath="//span[text()='My wishlists']")
    private WebElement myWishList;

    @FindBy(xpath = "//span[text()='Order history and details']")
    private WebElement orderHistory;

    public HomePage() {

        PageFactory.initElements(getDriver(), this);

    }

    /**
     * Get current url of home page
     * @return
     */
    public String getCurrURL(){
    String homePageurl = ele.getCurrentURL(getDriver());
    return homePageurl;
    }

    /**
     * Validate Wishlist element once in home page
     * @return
     */
    public boolean validateMyWishList(){
        return ele.isDisplayed(getDriver(),myWishList);
    }

    /**
     * Validate Order history element once in home page
     * @return
     */
    public boolean validateOrderHistory(){
        return ele.isDisplayed(getDriver(),orderHistory);
    }

}
