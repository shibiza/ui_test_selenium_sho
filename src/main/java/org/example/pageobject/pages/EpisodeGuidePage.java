package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class EpisodeGuidePage extends BasePage {
    private static final String startPageLink = "https://www.sho.com";
    private static final String episodeGuidePageLink = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class= 'global-nav__link' and @data-location= 'primary']")
    private WebElement elementsInsideHamburgerMenu;

    @FindBy(xpath = "//div[@class= 'global-nav__menu-toggle']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@class='global-nav__menu-icon']")
    private WebElement closeHamburgerMenu;

    @FindBy(xpath = "//a[@data-label= 'Start Your Free Trial']")
    private WebElement startYourFreeTrialNav;

    @FindBy(xpath = "//a[@class=\"button--primary cta--item\"]")
    private WebElement streamThisEpisodeButton;

    @FindBy(xpath = "//a[@class=\"button--secondary cta--item button--video\"]")
    private WebElement watchPreviewButton;

    Actions builder = new Actions(webDriver);

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EpisodeGuidePage openEpisodeGuidePage() {
        webDriver.get(episodeGuidePageLink);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public EpisodeGuidePage closeHamburgerMenu() {
        builder.moveToElement(closeHamburgerMenu).click();
        return new EpisodeGuidePage(webDriver);
    }

    public boolean elementIsPresent(String xPath) {
        return webDriver.findElement(By.xpath(xPath)).isDisplayed();
    }
    //"//div[@class='global-nav__menu-icon']")).isDisplayed();


    public List<String> hamburgerMenuContainsItems() {
        List<WebElement> actualItemsOnHamburgerMenu =  webDriver
                .findElements(By.xpath("//a[contains(@class, 'global-nav__link') and @data-location= 'primary']"));
        List<String> menuTextList =
                actualItemsOnHamburgerMenu.stream()
                        .map(e -> e.getText()).collect(Collectors.toList());
        //   System.out.println(menuTextList);
        return menuTextList;
    }

    public String getColourOfStartYourFreeTrialNav() {
        waitForVisibility(startYourFreeTrialNav);
        return startYourFreeTrialNav.getCssValue("background-color");
    }
}

