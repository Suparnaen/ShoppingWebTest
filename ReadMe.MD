![Java CI with Maven](https://github.com/Suparnaen/ShoppingWebTest/actions/workflows/maven.yml)](https://github.com/Suparnaen/ShoppingWebTest/actions/workflows/maven.yml/badge.svg)
![example workflow](https://github.com/Suparnaen/ShoppingWebTest/actions/workflows/maven.yml/badge.svg)

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


Project Architecture

    Config
    Data
    Driver
    Page
    Report
    Test
    Workflow

Config

The project uses Config.properties file to map all the global parameters such as browser and base url. All the relevant classes to read the parameters are provided in the config package.
Data

The project reads test data from xls files. "NewExcelLibrary" Utility is used to read the worksheet. Dataprovider is designed to read each of the worksheets. These dataprovider supplies the test data to each of the test case

Driver

The project uses Selenium WebDriver to automate user workflows for web-based applications as part of automated testing. The driver package contains all the necessary initialization logic for WebDriver.

Page

The project uses Page Object Model to capture all the relevant UI components and functionalities of a web page. The page package provides all the classes to achieve this. For convenience, there is an example class - LoginPage.java to demonstrate the usage.

Report

The project uses Extent Reports to provide test reporting functionalities. The report package contains the relevant class.

Test

Test created for smoke, regression, system.

Workflow

The project uses GitHub Actions to run the selenium tests.
