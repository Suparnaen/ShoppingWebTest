Reference:
https://github.com/hverma22/MyProject/tree/master/MyStoreProject
Selenium Test Automation Boilerplate

Ready-to-use UI Test Automation Architecture using Java and Selenium WebDriver.
Languages and Frameworks

The project uses the following:

    Java 11 as the programming language.
    Selenium WebDriver as the web browser automation framework using the Java binding.
    WebDriverManager as the browser driver management library.
    TestNG as the testing framework.
    TestNG DataProvider for Data driven Test
    TestNG Assertion as the assertion library.
    Page Object Factory and Page Object design.
    Extent Reports as the test reporting strategy.
    Extentreports.MediaEntityBuilder for capturing screenshots.
    Apache Log4j for capturing test logs.
    Maven as the Java build tool.
    IntelliJ IDEA as the IDE.

Project Structure

selenium-test-automation-boilerplate/
├─ .github/
│  ├─ workflows/
│  │  ├─ test-execution.yml
├─ Configuration/
│  ├─Config.properties
├─ Logo/
│  ├─MyStore.png
├─ Screenshots/
│  ├─
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  ├─ com/
│  │  │  │  ├─ shop/
│  │  │  │  │  ├─ 
│  │  │  │  │  │  ├─ actions/
│  │  │  │  │  │  │  ├─ ActionsRepo.java
│  │  │  │  │  │  │  ├─ ElementActions.java
│  │  │  │  │  │  ├─ dataprovider/
│  │  │  │  │  │  │  ├─ DataProviders/        
│  │  │  │  │  │  ├─ pageobjects/
│  │  │  │  │  │  │  ├─ AccountCreationPage.java
│  │  │  │  │  │  │  ├─ AddressPage.java
│  │  │  │  │  │  │  ├─ AddToCartPage.java
│  │  │  │  │  │  │  ├─ HomePage.java
│  │  │  │  │  │  │  ├─ IndexPage.java
│  │  │  │  │  │  │  ├─ LoginPage.java
│  │  │  │  │  │  │  ├─ OrderConfirmationPage.java
│  │  │  │  │  │  │  ├─ OrderPage.java
│  │  │  │  │  │  │  ├─ OrderSummary.java
│  │  │  │  │  │  │  ├─ PaymentPage.java
│  │  │  │  │  │  │  ├─ SearchResultPage.java
│  │  │  │  │  │  │  ├─ ShippingPage.java
│  │  │  │  │  │  ├─ utility/
│  │  │  │  │  │  │  ├─ ExtentManager/
│  │  │  │  │  │  │  ├─ ListenerClass/
│  │  │  │  │  │  │  ├─ Log/
│  │  │  │  │  │  │  ├─ NewExcelLibrary/
│  │  │  │  ├─ BaseDriver.java
│  ├─ test/
│  │  ├─ java/
│  │  │  ├─ com/
│  │  │  │  ├─ shop/
│  │  │  │  │  ├─ testcases/
│  │  │  │  │  │  ├─ AccountCreationPageTest/
│  │  │  │  │  │  ├─ AddToCartPageTest/
│  │  │  │  │  │  ├─ EndToEndTest/
│  │  │  │  │  │  ├─ HomePageTest/
│  │  │  │  │  │  ├─ IndexPageTest/
│  │  │  │  │  │  ├─ LoginPageTest/
│  │  │  │  │  │  ├─ OrderPageTest/
│  │  │  │  │  │  ├─ SearchResultPageTest/
│  │  ├─ resources/
│  │  │  ├─ testData/
│  │  │  │  ├─ TestData.xlsx/
├─test-output
   ├─ExtentReport
├─ .extent-config.xml
├─ log4j.xml
├─ pom.xml
├─ testng_crossbrowser.xml
├─ testng_regression.xml
├─ testng_smoke.xml
├─ testng_all.xml
├─ README.md


Project Architecture

    Config
    Data
    Driver
    Page
    Report
    Test
    Workflow

Config

The project uses general.properties file to map all the global parameters such as browser and base url. All the relevant classes to read the parameters are provided in the config package.
Data

The project reads test data from csv files. The test data properties are modeled in terms of entities and the data package handles this. For convenience, there is an example class - LoginData.java to demonstrate the usage.
Driver

The project uses Selenium WebDriver to automate user workflows for web-based applications as part of automated testing. The driver package contains all the necessary initialization logic for WebDriver.
Page

The project uses Page Object Model to capture all the relevant UI components and functionalities of a web page. The page package provides all the classes to achieve this. For convenience, there is an example class - LoginPage.java to demonstrate the usage.
Report

The project uses Extent Reports to provide test reporting functionalities. The report package contains the relevant class.
Test

LoginTest.java demonstrates an example test script.
Workflow

The project uses GitHub Actions to run the selenium tests when an update is made to the main branch of the repo in GitHub.