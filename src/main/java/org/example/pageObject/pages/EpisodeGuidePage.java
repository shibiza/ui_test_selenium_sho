package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class EpisodeGuidePage extends BasePage {
    String startPageLink = "https://www.sho.com";
    String episodeGuidePage = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";
    Actions builder = new Actions(webDriver);
    String nextOnEpisode = startPageLink + "/video/38764/next-on-episode-1";

    By startYourFreeTrialNav = By.xpath("(//a[@class= 'global-nav__link'])[4]");
    By elementsInsideHamburgerMenu = By.xpath("//a[@class= 'global-nav__link' and @data-location= 'primary']");

//    @FindBy(xpath = "(//a[@class= 'global-nav__link'])[4]")
//    private WebElement startYourFreeTrialNav;


    @FindBy(xpath = "//div[@class= 'global-nav__menu-toggle']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='global-nav__menu-icon'] ")
    private WebElement closeHamburgerMenu;

//    @FindBy(xpath = "//a[@class= 'global-nav__link' and @data-location= 'primary']")
//    private WebElement elementsInsideHamburgerMenu;


    //<a class="global-nav__link" data-track="" data-location="primary" data-label="Series" href="/series">Series</a>
    //    <a class="global-nav__link" data-track="" data-location="primary" data-label="Movies" href="/movies">Movies</a>
    //    <a class="global-nav__link" data-track="" data-location="primary" data-label="Sports" href="/sports">Sports</a>
    //<a class="global-nav__link" data-track="" data-location="primary" data-label="Documentaries" href="/documentaries">Documentaries</a>
    //  <a class="global-nav__link" data-track="" data-location="primary" data-label="Free Full Episodes" href="/video/full-episodes">Free Full Episodes</a>


    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EpisodeGuidePage openEpisodeGuidePage() {
        webDriver.get(startPageLink);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public EpisodeGuidePage closeHamburgerMenu() {
        builder.moveToElement(closeHamburgerMenu).click().perform();
        return new EpisodeGuidePage(webDriver);
    }

    public boolean hamburgerMenuContainsItems(ArrayList<String> expectedItemsOnHamburgerMenu) {
        ArrayList<WebElement> actualItemsOnHamburgerMenu = new ArrayList<WebElement>();
        actualItemsOnHamburgerMenu.addAll(webDriver.findElements(elementsInsideHamburgerMenu));

        return expectedItemsOnHamburgerMenu.equals(actualItemsOnHamburgerMenu);
    }

    public String getColourOfStartYourFreeTrialNav() {
        return findElement(startYourFreeTrialNav).getCssValue("background-color");
    }

    //public boolean elementIsNotPresent(String xpath){
    //       return driver.findElements(By.xpath(xpath)).isEmpty();
    //
    //}

}
