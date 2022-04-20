package com.shop.pageobjects;

import com.shop.BaseDriver;
import com.shop.actions.ActionsRepo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @Author - Suparna Das added on 4/9/2022
 */
public class AccountCreationPage extends BaseDriver {
    ActionsRepo ele = new ActionsRepo();

    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement formTitle;

    @FindBy(id = "uniform-id_gender1")
    private WebElement mr;

    @FindBy(id = "id_gender2")
    private WebElement mrs;

    @FindBy(name = "customer_firstname")
    private WebElement firstName;

    @FindBy(name = "customer_lastname")
    private WebElement lastName;

    @FindBy(name = "passwd")
    private WebElement passWord;

    @FindBy(name = "days")
    private WebElement days;

    @FindBy(name = "months")
    private WebElement months;

    @FindBy(name = "years")
    private WebElement years;

    @FindBy(name = "firstname")
    private WebElement customerNirstName;

    @FindBy(name = "lastname")
    private WebElement customerLastName;

    @FindBy(name = "company")
    private WebElement companyName;

    @FindBy(name = "address1")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "id_state")
    private WebElement state;

    @FindBy(name = "postcode")
    private WebElement postCode;

    @FindBy(name = "id_country")
    private WebElement country;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "phone_mobile")
    private WebElement mobile;

    @FindBy(name = "alias")
    private WebElement ref;

    @FindBy(name = "submitAccount")
    private WebElement registerBtn;

    public AccountCreationPage() {

        PageFactory.initElements(getDriver(), this);

    }

    /**
     * Validate the title of Account egistration page
     * @return
     * @throws Throwable
     */
    public boolean validateAcountCreatePage() throws Throwable {
        return ele.isDisplayed(getDriver(), formTitle);
    }

    /**
     * Create new account for user
     * @param gender
     * @param fName
     * @param lName
     * @param pswd
     * @param day
     * @param month
     * @param year
     * @param comPany
     * @param addr
     * @param cityString
     * @param stateName
     * @param zip
     * @param countryName
     * @param mobilePhone
     * @throws Throwable
     */
    public void createAccount(String gender,String fName,
                              String lName,
                              String pswd,
                              String day,
                              String month,
                              String year,
                              String comPany,
                              String addr,
                              String cityString,
                              String stateName,
                              String zip,
                              String countryName,
                              String mobilePhone) throws Throwable {

        if(gender.equalsIgnoreCase("Mr")) {
            ele.click(getDriver(), mr);
        } else {
            ele.click(getDriver(), mrs);
        }

        ele.type(firstName, fName);
        ele.type(lastName, lName);
        ele.type(passWord, pswd);
        ele.selectByValue(days, day);
        ele.selectByValue(months, month);
        ele.selectByValue(years, year);
        ele.type(companyName, comPany);
        ele.type(address, addr);
        ele.type(city, cityString);
        ele.selectByVisibleText(stateName, state);
        ele.type(postCode, zip);
        ele.selectByVisibleText(countryName, country);
        ele.type(mobile, mobilePhone);
    }

    /**
     * Validate user lands on home page once he clicks on register button
     * @return
     * @throws Throwable
     */
    public HomePage validateRegistration() throws Throwable {
        registerBtn.click();
        return new HomePage();
    }



}
