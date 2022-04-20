package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class SearchResultPage extends BaseDriver {

    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath="//*[@id='center_column']//img")
    private WebElement productResult;

    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable(){

        return ele.isDisplayed(getDriver(),productResult);
    }

    public AddToCartPage clickOnProduct(){
        ele.click(getDriver(),productResult);
        return new AddToCartPage();
    }

}
