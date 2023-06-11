package org.example.stepDefinitions;

import org.example.pageObject.pages.EpisodeGuidePage;
import org.example.pageObject.pages.HomelandSeries;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomelandSeriesTest extends BaseTest {

    HomelandSeries homelandSeries = new HomelandSeries(webDriver);

//    @Test
//    public void waitForHomelandSeriesPageLoadAndTitleContains() {
//      boolean is = homelandSeries.openHomelandSeries();
//
//        Assert.assertTrue(is);
//    }


    @Test
    public void pageIsLoaded(){
        boolean isLoaded = homelandSeries.elementIsNotPresent("/html/head");
        Assert.assertFalse(isLoaded);
    }

}

