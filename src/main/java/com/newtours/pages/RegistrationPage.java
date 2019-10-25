package com.newtours.pages;

import com.generic.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
    @FindBy(name ="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement userNameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    public void goToRegistrationPage()
    {
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName)
    {
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password)
    {
        userNameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
    }

    public void submit()
    {
        submitBtn.click();
    }
}
