package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends BasePage {
    @FindBy(linkText = "Flights")
    private WebElement flightsLink;

    public RegistrationConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    public FlightDetailsPage goToFlightDetailsPage()
    {
        wait.until(ExpectedConditions.visibilityOf(flightsLink));
        flightsLink.click();
        return new FlightDetailsPage(driver);
    }
}
