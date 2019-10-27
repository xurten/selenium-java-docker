package com.newtours.tests;

import com.database.MongoRepository;
import com.logging.IMyLogger;
import com.logging.MyLogger;
import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    private String noOfPassengers;
    private String expectedPrice;
    private IMyLogger logger;

    @DataProvider(name = "bookFlightDataProvider")
    public Object[][] bookFlightDataProvider() {
        return new Object[][] { {"2", "$1169 USD"}, {"3","$1753 USD"}, {"4", "$2338 USD"} };
    }

    @BeforeTest
    @Test(dataProvider = "bookFlightDataProvider")
    public void setupParameters(String noOfPassengers, String expectedPrice)
    {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
        logger = new MyLogger(new MongoRepository());
    }

    @Test
    public void registrationPage()
    {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String actualPrice =
        registrationPage
                .goToRegistrationPage()
                .enterUserDetails("selenium","docker")
                .enterUserCredentials("selenium","docker")
                .submitCredentials()
                .goToFlightDetailsPage()
                .selectPassengers(noOfPassengers)
                .goToFindFlightsPage()
                .submitFindFlightPage()
                .goToFlightConfirmationPage()
                .getPrice();

        Assert.assertEquals(actualPrice, expectedPrice);
        logger.logSuccess("BookFlightTest test passed");
    }
}
