package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class OrderConfirmationPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement confirmMessag;

    public OrderConfirmationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateConfirmMessage() {
        String confirmMsg=confirmMessag.getText();
        return confirmMsg;
    }


}
