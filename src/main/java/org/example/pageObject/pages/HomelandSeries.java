package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends BasePage {

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    String startPageLink = "https://www.sho.com";
    String homelandSeriesSeason5Link = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

   @FindBy(xpath = "//a[@class=\"global-nav__logo\"]")
    private WebElement navigationLogo;

//    @FindBy(xpath = "/html/head")
//    private WebElement titleTag;
//
//    @FindBy(className = "head")
//    private WebElement headTagAtPage;

    public HomelandSeries openHomelandSeries() {
        webDriver.get(homelandSeriesSeason5Link);
        wait.until(ExpectedConditions.visibilityOf(navigationLogo));
        return this;
    }
}