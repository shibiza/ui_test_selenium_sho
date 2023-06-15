package org.example.stepDefinitions;

import org.example.pageobject.pages.HomelandSeries;
import org.junit.Assert;
import org.junit.Test;

public class HomelandSeriesTest extends BaseTest {

    HomelandSeries homelandSeries = new HomelandSeries(webDriver);

    //  1.
    @Test
    public void pageLoadsAndLogoIsDisplayed() {
        Assert.assertTrue(homelandSeries.openHomelandSeries());
    }
}