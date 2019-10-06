package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightDetailsPage extends BasePage {
    @FindBy(name="passCount")
    private WebElement passengers;

    @FindBy(name="findFlights")
    private WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String noOfPassengers)
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select = new Select(passengers);
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage()
    {
        this.submitBtn.click();
    }
}
