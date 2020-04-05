package com.weborders.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class AbstractBaseTest {
    protected WebDriver driver = Driver.getDriver();

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    public void beforeTest(){

    }
    @AfterTest
    public void afterTest(){

    }

    @BeforeMethod
    public void setup(){
        driver.get(ConfigurationReader.getProperty("ur"));
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(ITestResult testResult){
        if(testResult.getStatus()==ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtilities.getScreenshot(testResult.getName());

        }
        BrowserUtilities.wait(3);
        Driver.closeDriver();
    }
}
