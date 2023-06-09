package org.example.pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EpisodeGuidePage extends StartPage {

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    String episodeGuidePageLink =  startPage + "/homeland/season/5/episode/1/separation-anxiety";
    String episodeTitle = "Homeland - Season 5 Episode 1, Separation Anxiety | SHOWTIME";

    @FindBy(xpath = "//*[contains(@class, 'global-nav__menu-toggle')]")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//*[contains(@class, 'global-nav__link')]");
    private WebElement startYourFreeTrialButton;

    public EpisodeGuidePage episodeGuidePage() {
        webDriver.get(episodeGuidePageLink);
        return this;
    }

//    public EpisodeGuidePage waitForPageLoadAndTitleContains() {
//        webDriver.get(episodeGuidePageLink);
//        waitForPageLoadAndTitleContains(episodeGuidePageLink);
//        return this;
//    }

    public void waitForPageLoadAndTitleContains(String pageLink) {
        wait.until(ExpectedConditions.titleContains(episodeTitle));
    }

//public void waitForPageLoadAndTitleContains(int timeout, String pageTitle) {
//    wait.until(ExpectedConditions.titleContains(pageTitle));
//}

}
