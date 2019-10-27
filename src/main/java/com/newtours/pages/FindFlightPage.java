package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFlightPage extends BasePage {
    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name="buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        super(driver);
    }

    public FindFlightPage submitFindFlightPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        firstSubmitBtn.click();
        return this;
    }

    public FlightConfirmationPage goToFlightConfirmationPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        secondSubmitBtn.click();
        return new FlightConfirmationPage(driver);
    }
}

