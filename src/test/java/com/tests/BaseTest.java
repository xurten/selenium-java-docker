package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        String host ="localhost";

        host = getHost(host);
        String testName = ctx.getCurrentXmlTest().getName();
        String completeUrl = getFormatedHostUrl(host);
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities(testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), desiredCapabilities);
    }

    private String getFormatedHostUrl(String host) {
        return "http://" + host + ":4444/wd/hub";
    }

    private String getHost(String host) {
        if(System.getProperty("HUB_HOST")!= null){
            host = System.getProperty("HUB_HOST");
        }
        return host;
    }

    private DesiredCapabilities getDesiredCapabilities(String testName) {
        DesiredCapabilities desiredCapabilities;
        if(System.getProperty("BROWSER")!= null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            desiredCapabilities = DesiredCapabilities.firefox();
        }else
        {
            desiredCapabilities = DesiredCapabilities.chrome();
        }
        desiredCapabilities.setCapability("name", testName);
        return desiredCapabilities;
    }

    @AfterTest
    public void quitDriver()
    {
        this.driver.quit();
    }
}
