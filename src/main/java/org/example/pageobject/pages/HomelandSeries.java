package org.example.pageobject.pages;

import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends BasePage {

    private static final String startPageLink = "https://www.sho.com";
    private static final String homelandSeriesSeason5Link = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class=\"global-nav__logo\"]")
    private WebElement navigationLogo;

    static Logger logger = Logger.getLogger(HomelandSeries.class);

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean openHomelandSeries() {
        logger.info("load to 'Homeland' series season 5 page" + homelandSeriesSeason5Link);
        webDriver.get(homelandSeriesSeason5Link);
        wait.until(ExpectedConditions.visibilityOf(navigationLogo));
        return navigationLogo.isDisplayed();
    }
}