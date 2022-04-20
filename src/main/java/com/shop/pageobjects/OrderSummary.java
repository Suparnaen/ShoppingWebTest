package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class OrderSummary extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrderBtn;


    public OrderSummary(){
        PageFactory.initElements(getDriver(), this);
    }

    public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
        ele.click(getDriver(), confirmOrderBtn);
        return new OrderConfirmationPage();
    }

}
