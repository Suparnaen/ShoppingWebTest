package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class PaymentPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
    private WebElement bankWireMethod;

    @FindBy(xpath = "//a[contains(text(),'Pay by check')]")
    private WebElement payByCheckMethod;


    public PaymentPage(){
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Navigates to Order Summary page on clicking payment method
     * @return
     */
    public OrderSummary clickOnPaymentMethod(){
        ele.click(getDriver(),bankWireMethod);
        return new OrderSummary();
    }

}
