package org.example.stepDefinitions;

import org.example.pageObject.pages.HomelandSeries;
import org.junit.Assert;
import org.junit.Test;

public class HomelandSeriesTest extends BaseTest {

    HomelandSeries homelandSeries = new HomelandSeries(webDriver);
    String titleTag = "title";

    @Test
    public void waitForHomelandSeriesPageLoadAndTitleContains() {
        homelandSeries.openHomelandSeriesPage().waitForHomelandSeriesPageLoadAndTitleContains();
        Assert.assertTrue(true);
    }

}

