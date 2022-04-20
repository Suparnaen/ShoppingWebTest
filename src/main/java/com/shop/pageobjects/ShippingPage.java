package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class ShippingPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(id="cgv")
    private WebElement terms;

    @FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public ShippingPage(){
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Click the terms checkbox
     */
    public void checkTheTermsCheckbox(){
        ele.click(getDriver(), terms);
    }

    /**
     * Navigate to payment page on clicking proceed to checkout button
     * @return
     */
    public PaymentPage clickOnProceedToCheckOut(){
        ele.click(getDriver(),proceedToCheckOutBtn);
        return new PaymentPage();
    }


}
