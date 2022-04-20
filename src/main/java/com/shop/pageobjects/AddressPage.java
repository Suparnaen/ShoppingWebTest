package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class AddressPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    public AddressPage(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;


    /**
     * Navigate to Shipping page on clicking proceed to checkout
     * @return
     */
    public ShippingPage clickOnCheckOut(){
        ele.click(getDriver(),proceedToCheckOut);
        return new ShippingPage();
    }

}
