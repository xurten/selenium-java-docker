package com.searchmodule.tests;

import com.database.MySqlRepository;
import com.logging.IMyLogger;
import com.logging.MyLogger;
import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private IMyLogger logger;

    @BeforeTest
    public void setupParameters()
    {
        logger = new MyLogger(new MySqlRepository());
    }

    @Test
    @Parameters({"keyword"})
    public void search(String keyword)
    {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
        logger.logSuccess("SearchPage test passed");
    }
}
