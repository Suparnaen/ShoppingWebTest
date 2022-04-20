package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class AddToCartPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(id="quantity_wanted")
    private WebElement quantity;

    @FindBy(name="group_1")
    private WebElement itemSize;

    @FindBy(xpath="//span[text()='Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id='layer_cart']//h2/i")
    private WebElement addToCartMessage;

    @FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }


    /**
     * Enter quantity in add to cart page
     * @param qty
     */
        public void enterQuantity(String qty){
          ele.type(quantity,qty);
        }

    /**
     * Enter size in add to cart page
     * @param size
     */
    public void selectSize(String size){
         ele.click(getDriver(),itemSize);
        }

    /**
     * Click on Add to cart button
     */
      public void clickOnAddToCart(){
            ele.click(getDriver(),addToCartBtn);

        }

    /**
     * Validate Add to cart button is visible
     * @return
     */
    public boolean validateAddtoCartMessage(){
        ele.fluentWait(getDriver(),addToCartMessage, 10);
        return ele.isDisplayed(getDriver(),addToCartMessage);
        }

    /**
     * Clicking on proceed to checkout button will navigate to Order page
     * @return
     */
    public OrderPage clickOnCheckOut(){
            ele.fluentWait(getDriver(),proceedToCheckOutBtn, 10);
            ele.JSClick(getDriver(),proceedToCheckOutBtn);
            return new OrderPage();
        }
}
