package org.example.pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends StartPage {

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    String homelandSeriesSeason5Link = startPage + "/homeland/season/5/episode/1/separation-anxiety";
    String nextOnEpisode = startPage + "/video/38764/next-on-episode-1";
    Actions builder = new Actions(webDriver);

    @FindBy(tagName = "title")
    private WebElement titleTag;

    public HomelandSeries openHomelandSeriesPage(){
        webDriver.get(homelandSeriesSeason5Link);
        waitToBePresent(titleTag);
        return this;
    }

    public boolean waitForHomelandSeriesPageLoadAndTitleContains() {
        webDriver.get(homelandSeriesSeason5Link);
        waitToBePresent(titleTag);
        return (boolean) wait.until(ExpectedConditions.titleContains(String.valueOf(titleTag)));
    }
}
