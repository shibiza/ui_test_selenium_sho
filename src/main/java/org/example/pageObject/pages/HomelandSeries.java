package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomelandSeries extends BasePage {

    String startPageLink = "https://www.sho.com";
    String homelandSeriesSeason5Link = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "/html/head")
    private WebElement titleTag;

    @FindBy(className = "head")
    private WebElement headTagAtPage;
//
//    protected HomelandSeries(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    protected boolean openHomelandSeries() {
//        webDriver.get(homelandSeriesSeason5Link);
//        wait.until(ExpectedConditions.visibilityOf(titleTag));
//        return true;
//    }

    public HomelandSeries(WebDriver webDriver) {
        super(webDriver);
    }

    public String openHomelandSeriesAndFindHeadTitle() {
        webDriver.get(homelandSeriesSeason5Link);
        wait.until(ExpectedConditions.visibilityOf(titleTag));

        String headTag = titleTag.getCssValue("background-color");
        return headTag;
    }

//    public boolean elementIsPresent() {
//        webDriver.get(homelandSeriesSeason5Link);
//        wait.until(ExpectedConditions.visibilityOf(titleTag));
//
//        return webDriver.findElement(By.tagName("body")).isEmpty();
//    }

    public boolean elementIsNotPresent(String xpath) {
        return webDriver.findElements(By.xpath(xpath)).isEmpty();
    }
}