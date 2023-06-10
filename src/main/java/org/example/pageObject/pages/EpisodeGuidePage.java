package org.example.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EpisodeGuidePage extends StartPage {

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

 //   WebElement startYourFreeTrialNav = webDriver.findElement(By.xpath("(//*[contains(@data-label,'Start Your Free Trial')])[1]"));
    WebElement startYourFreeTrialNav = webDriver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul[3]/li/a"));
    WebElement hamburgerMenu = webDriver.findElement(By.xpath("//div[@class= 'global-nav__menu-toggle']"));

    String series = "Series", movies = "Movies", sports = "Sports", documentaries = "Documentaries", freeFullEpisodes = "Free Full Episodes";

    String episodeGuidePage = startPage + "/homeland/season/5/episode/1/separation-anxiety";
    Actions builder = new Actions(webDriver);

    public EpisodeGuidePage openEpisodeGuidePage(){
        webDriver.get(episodeGuidePage);
        waitForVisibility(hamburgerMenu);
        return this; //!!
    }

    public EpisodeGuidePage clickOnHamburgerMenu(){
        webDriver.get(episodeGuidePage);
        waitForVisibility(hamburgerMenu);
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public String getColourOfStartYourFreeTrialNav() {
        String colourOfStartYourFreeTrialNav = waitToBePresent(startYourFreeTrialNav).getCssValue("background-color");
        return colourOfStartYourFreeTrialNav;
    }
/*
    public boolean verifyHamburgerMenuContainsItems(String brandName) {
        boolean everyTitleContainsInputWord;

        while (true) {
            waitForElementPresence(titleXpath);

            everyTitleContainsInputWord = titlesList
                    .stream()
                    .map(WebElement::getText)
                    .map(String::toLowerCase)
                    .allMatch(e -> e.contains(brandName.toLowerCase()));

            if(stopGoingThroughPages(everyTitleContainsInputWord, paginationNextBtn)){
                break;
            }

            paginationNextBtn.click();
        }
        return everyTitleContainsInputWord;
    }
*/



}
