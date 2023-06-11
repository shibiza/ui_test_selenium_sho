package org.example.stepDefinitions;

import org.example.pageObject.pages.HomelandSeries;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;


public class HomelandSeriesTest extends BaseTest {

    HomelandSeries homelandSeries = new HomelandSeries(webDriver);
    String logo = "//a[@class=\"global-nav__logo\"]";

    @Test
    public void pageLoadsAndLogoIsDisplayed() {
        homelandSeries.openHomelandSeries();
        Assert.assertTrue(webDriver.findElement(By.xpath(logo)).isDisplayed());
    }
}