package org.example.stepDefinitions;

import org.example.pageobject.pages.HomelandSeriesPage;
import org.junit.Assert;
import org.junit.Test;

public class HomelandSeriesTest extends BaseTest {

   private final HomelandSeriesPage homelandSeries = new HomelandSeriesPage(webDriver);

    //  1.
    @Test
    public void pageLoadsAndLogoIsDisplayed() {
        Assert.assertTrue(homelandSeries.openHomelandSeries());
    }
}