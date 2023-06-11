package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EpisodeGuidePage extends BasePage {
    String startPageLink = "https://www.sho.com";
    String episodeGuidePage = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";
    Actions builder = new Actions(webDriver);
    String nextOnEpisode = startPageLink + "/video/38764/next-on-episode-1";

    @FindBy(xpath = "(//a[@class= 'global-nav__link'])[4]")
    private WebElement startYourFreeTrialNav;

    @FindBy(xpath = "//div[@class= 'global-nav__menu-toggle']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='global-nav__menu-icon'] ")
    private WebElement closeHamburgerMenu;

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EpisodeGuidePage openEpisodeGuidePage() {
        webDriver.get(startPageLink);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        webDriver.get(episodeGuidePage);
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public boolean openCloseHamMenu() {
        webDriver.get(episodeGuidePage);
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        builder.moveToElement(hamburgerMenu).click().perform();
        builder.moveToElement(closeHamburgerMenu).click().perform();
        return webDriver.findElement((By) closeHamburgerMenu).isEnabled();
    }

    public String getColourOfStartYourFreeTrialNav() {
        webDriver.get(episodeGuidePage);
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));

        String colourOfStartYourFreeTrialNav = startYourFreeTrialNav.getCssValue("background-color");
        return colourOfStartYourFreeTrialNav;
    }
//    String series = "Series", movies = "Movies", sports = "Sports", documentaries = "Documentaries", freeFullEpisodes = "Free Full Episodes";
//    Series
//            <a class="global-nav__link global-nav__flyout global-nav__flyout--series-drawer"data-track=""data-location="primary"data-label="Series">Series</a>
//
//    public String getMovies() {
//        <a class="global-nav__link" data - track = "" data - location = "primary" data - label = "Movies"
//        href = "/movies" > Movies </a >
//    }


    //public boolean elementIsNotPresent(String xpath){
    //       return driver.findElements(By.xpath(xpath)).isEmpty();
    //
    //}

}
