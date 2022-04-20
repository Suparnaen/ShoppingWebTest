package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class LoginPage extends BaseDriver {
    ActionsRepo ele = new ActionsRepo();

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="passwd")
    private WebElement password;

    @FindBy(id="SubmitLogin")
    private WebElement signInBtn;

    @FindBy(name="email_create")
    private WebElement emailForNewAccount;

    @FindBy(name="SubmitCreate")
    private WebElement createNewAccountBtn;

    HomePage homePage = new HomePage();
    AddressPage addressPage = new AddressPage();

    public LoginPage(){
        PageFactory.initElements(getDriver(),this);
    }

    /**
     * Create new Account if user is a new user
     * @param email
     * @return
     */
    public AccountCreationPage createNewAccount(String email){
        ele.type(emailForNewAccount, email);
        ele.click(getDriver(),createNewAccountBtn);
        return new AccountCreationPage();
    }

    /**
     * Login navigates to Home Page
     * @param uname
     * @param pswd
     * @return
     * @throws InterruptedException
     */
    public HomePage loginToHomePage(String uname, String pswd) throws InterruptedException {
        ele.scrollByVisibilityOfElement(getDriver(), userName);
        ele.type(userName, uname);
        ele.type(password, pswd);
        ele.JSClick(getDriver(), signInBtn);
        Thread.sleep(2000);
        return homePage;
    }

    /**
     * LoginPage navigates to Address Page after login for checkout to proceed
     * @param uname
     * @param pswd
     * @return
     * @throws InterruptedException
     */
    public AddressPage loginToAddressPage(String uname, String pswd) throws InterruptedException {
        ele.scrollByVisibilityOfElement(getDriver(), userName);
        ele.type(userName, uname);
        ele.type(password, pswd);
        ele.JSClick(getDriver(), signInBtn);
        Thread.sleep(2000);
        return addressPage;
    }


}
