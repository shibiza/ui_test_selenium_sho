package org.example.pageobject.pages;

import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends BasePage {

    private static final String HOMELAND_SERIES_SEASON_5_LINK = START_PAGE_LINK + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class=\"global-nav__logo\"]")
    private WebElement navigationLogo;

    static Logger logger = Logger.getLogger(HomelandSeries.class);

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean openHomelandSeries() {
        logger.info("load to 'Homeland' series season 5 page" + HOMELAND_SERIES_SEASON_5_LINK);
        webDriver.get(HOMELAND_SERIES_SEASON_5_LINK);
        acceptAllCookies();
        wait.until(ExpectedConditions.visibilityOf(navigationLogo));
        return navigationLogo.isDisplayed();
    }
}