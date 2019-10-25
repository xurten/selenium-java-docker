package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class FlightConfirmationPage extends BasePage {

    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    public String getPrice()
    {
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        logger.logInfo("Price " + flightConfirmationHeader.getText());
        String price = prices.get(1).getText();
        logger.logInfo("Exact price " + price);
        signOffLink.click();
        return price;
    }
}
