package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        PageFactory.initElements(driver, this);
    }

    public String getPrice()
    {
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        String price = prices.get(1).getText();
        System.out.println(price);
        signOffLink.click();
        return price;
    }
}
