package com.searchmodule.tests;

import com.database.SqlRepository;
import com.logging.IMyLogger;
import com.logging.MyLogger;
import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    private IMyLogger logger;

    @BeforeTest
    public void setupParameters()
    {
        logger = new MyLogger(new SqlRepository());
    }

    @DataProvider(name = "searchTestProvider")
    public Object[][] searchTestProvider() {
        return new Object[][] { {"java"}, {"qa"}, {"school"}, {"world"}, {"sun"}};
    }

    @Test(dataProvider = "searchTestProvider")
    @Parameters({"keyword"})
    public void search(String keyword)
    {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.goToSearchPage();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.getResult();

        Assert.assertTrue(size > 0);
        logger.logSuccess("SearchPage test passed");
    }
}
