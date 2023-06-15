package org.example.pageobject.pages;


import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class EpisodeGuidePage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(EpisodeGuidePage.class);
    private static final String EPISODE_GUIDE_PAGE_LINK = START_PAGE_LINK + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class= 'global-nav__link' and @data-location= 'primary']")
    private WebElement elementsInsideHamburgerMenu;

    @FindBy(xpath = "//div[@class='global-nav__menu-icon']") //!!!!!!!
    private WebElement hamburgerMenuButton;

    @FindBy(xpath = "//body[@class='episode-detail has-menu-open']")/////!!!!!!!!!!!
    private WebElement openedHamburgerMenu;

    @FindBy(xpath = "//a[@data-label= 'Start Your Free Trial']")
    private WebElement startYourFreeTrialNav;

    @FindBy(xpath = "//a[@class=\"button--primary cta--item\"]")
    private WebElement streamThisEpisodeBtn;

    @FindBy(xpath = "//a[@class=\"button--secondary cta--item button--video\"]")
    private WebElement watchPreviewBtn;

    @FindBy(xpath = "//h2[@class= 'streaming-modal__headline']")
    private WebElement startFreeTrialPopupHeadline;

    @FindBy(xpath = "//a[@class= 'modal__close']")
    private WebElement closeStartFreeTrialPopupModule;

    @FindBy(xpath = "//a[@class= 'streaming-modal__button']")
    private WebElement onPopupModuleBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    private final Actions builder = new Actions(webDriver);


    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EpisodeGuidePage openEpisodeGuidePage() {
        LOGGER.info("load to Episode guide page " + EPISODE_GUIDE_PAGE_LINK);
        webDriver.get(EPISODE_GUIDE_PAGE_LINK);
        acceptAllCookies();
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        waitForClickable(hamburgerMenuButton);
        builder.moveToElement(hamburgerMenuButton).click().perform();
        WebElement openedMenu = webDriver.findElement(By.xpath("//body[@class='episode-detail has-menu-open']"));
        waitForVisibility(openedMenu);
        return this;
    }

    public EpisodeGuidePage clickCloseHamburgerMenu() {
        waitForClickable(hamburgerMenuButton);
        builder.moveToElement(hamburgerMenuButton).click().perform();
        WebElement closedMenu = webDriver.findElement(By.xpath("//body[@class='episode-detail']"));
        waitForVisibility(closedMenu);
        return this;
    }

    public boolean isHamburgerMenuClosed() {
        WebElement closedMenu = webDriver.findElement(By.xpath("//body[@class='episode-detail']"));
        return closedMenu.isDisplayed();
    }

    public List<String> hamburgerMenuContainsItems() {
        List<WebElement> actualItemsOnHamburgerMenu = webDriver
                .findElements(By.xpath("//a[@class='global-nav__link' and @data-location= 'primary']"));

        List<String> menuTextList = actualItemsOnHamburgerMenu.stream()
                .map(e -> e.getAttribute("data-label")).collect(Collectors.toList());
        LOGGER.info("Elements from hamburger menu are: " + menuTextList);

        return menuTextList;
    }

    public List<String> itemsFromHamburgerMenuAreHyperlinks() {
        List<WebElement> actualItemsOnHamburgerMenu = webDriver
                .findElements(By.xpath("//a[@class='global-nav__link' and @data-location= 'primary']"));

        return actualItemsOnHamburgerMenu.stream()
                .filter(e -> e.getAttribute("href") != null && !e.getAttribute("href").isEmpty())
                .map(e -> e.getAttribute("data-label"))
                .collect(Collectors.toList());
    }

    public String getColourOfStartYourFreeTrialNav() {
        waitForVisibility(startYourFreeTrialNav);
        String colorOfStartYourFreeTrialBtn = startYourFreeTrialNav.getCssValue("background-color");
        LOGGER.info("color of 'Start Your Free Trial' button is " + colorOfStartYourFreeTrialBtn);

        return colorOfStartYourFreeTrialBtn;
    }

    public boolean elementIsPresent(String xPath) {
        return webDriver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public EpisodeGuidePage clickOnStreamThisEpisode() {
        waitForClickable(streamThisEpisodeBtn);
        builder.moveToElement(streamThisEpisodeBtn).click().perform();
        return this;
    }

    public VideoPage clickOnWatchPreview() {
        waitForClickable(watchPreviewBtn);
        builder.moveToElement(watchPreviewBtn).click().perform();
        return new VideoPage(webDriver);
    }

    public boolean visibilityOfPopupModule() {
        waitForClickable(onPopupModuleBtn);
        return onPopupModuleBtn.isDisplayed();
    }
}