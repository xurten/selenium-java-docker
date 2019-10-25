package com.searchmodule.pages;

import com.database.SqlRepository;
import com.generic.pages.BasePage;
import com.logging.IMyLogger;
import com.logging.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(id="search_form_input_homepage")
    private WebElement searchTxt;

    @FindBy(id="search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;
    private IMyLogger logger;

    public SearchPage(WebDriver driver)
    {
        super(driver);
        logger = new MyLogger(new SqlRepository());
    }

    public void goTo()
    {
        driver.get("https://duckduckgo.com");
    }

    public void doSearch(String keyword)
    {
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.sendKeys(keyword);
        searchBtn.click();
    }

    public void goToVideos()
    {
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int getResult()
    {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@class='tile__media']"), 0));
        logger.logInfo("Videos size = " + allVideos.size());
        return allVideos.size();
    }
}
