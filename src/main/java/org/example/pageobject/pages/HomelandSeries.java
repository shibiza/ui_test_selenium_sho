package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends BasePage {

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    private static final String startPageLink = "https://www.sho.com";
    private static final String homelandSeriesSeason5Link = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class=\"global-nav__logo\"]")
    private WebElement navigationLogo;

    public boolean openHomelandSeries() {
        //log.info("load to Episode guide page" + homelandSeriesSeason5Link);
        webDriver.get(homelandSeriesSeason5Link);
        wait.until(ExpectedConditions.visibilityOf(navigationLogo));
        return navigationLogo.isDisplayed();
    }
}