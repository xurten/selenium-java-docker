package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindFlightPage extends BasePage {
    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name="buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmitBtn));
        this.firstSubmitBtn.click();
    }

    public void goToFlightConfirmationPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmitBtn));
        this.secondSubmitBtn.click();
    }
}

