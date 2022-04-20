package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class OrderPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath="//td[@class='cart_unit']/span/span")
    private WebElement itemUnitPrice;

    @FindBy(id="total_price")
    private WebElement itemTotalPrice;

    @FindBy(xpath="//span[text()='Proceed to checkout']")
    private WebElement proceedToCheckOut;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    /**
     * Get the unit price from order page
     * @return
     */
    public double getUnitPrice(){
        String unitPrice =itemUnitPrice.getText();
        String parsedUnit = unitPrice.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice = Double.parseDouble(parsedUnit);
        return finalUnitPrice/100;
    }

    /**
     * Get Total price from order page
     * @return
     */
    public double getTotalPrice(){
        String totalPrice =itemTotalPrice.getText();
        String parsedUnit = totalPrice.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice = Double.parseDouble(parsedUnit);
        return finalTotalPrice/100;
    }

    /**
     * Click on Proceed to checkout button
     * @return
     */
    public LoginPage clickOnCheckOut(){
        ele.click(getDriver(),proceedToCheckOut);
        return new LoginPage();
    }

}
