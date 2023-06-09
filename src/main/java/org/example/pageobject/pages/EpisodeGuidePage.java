package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class EpisodeGuidePage extends BasePage {

    private static final String EPISODE_GUIDE_PAGE_LINK = START_PAGE_LINK + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//div[@class='global-nav__menu-icon']")
    private WebElement hamburgerMenuBtn;

    @FindBy(xpath = "//*[normalize-space(@class) = 'global-nav__menu-icon']")
    private WebElement closeHamburgerMenuBtn;

    @FindBy(xpath = "//body[@class='episode-detail has-menu-open']")
    private WebElement openedMenu;

    @FindBy(xpath = "//body[@class='episode-detail']")
    private WebElement closedMenu;

    @FindBy(xpath = "//a[@data-label= 'Start Your Free Trial']")
    private WebElement startYourFreeTrialNav;

    @FindBy(xpath = "//a[@class=\"button--primary cta--item\"]")
    private WebElement streamThisEpisodeBtn;

    @FindBy(xpath = "//a[@class=\"button--secondary cta--item button--video\"]")
    private WebElement watchPreviewBtn;

    @FindBy(xpath = "//a[@class= 'streaming-modal__button']")
    private WebElement onPopupModuleBtn;

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
        waitForClickable(hamburgerMenuBtn);
        LOGGER.info("open 'hamburger' menu ");
        builder.moveToElement(hamburgerMenuBtn).click().perform();
        waitForVisibility(openedMenu);
        return this;
    }

    public EpisodeGuidePage clickCloseHamburgerMenu() {
        waitForClickable(closeHamburgerMenuBtn);
        builder.moveToElement(closeHamburgerMenuBtn).click().perform();
        sleep(3_000);
        return this;
    }

    public boolean closeHamburgerMenu() {
        String shouldBeMenuClose = closeHamburgerMenuBtn.getAttribute("data-label");
        LOGGER.info(" attribute 'menu close' means we're out of hamburger menu " + shouldBeMenuClose);

        if (shouldBeMenuClose.contains("menu close")) {
            return true;
        } else {
            return false;
        }
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
        LOGGER.info("click on 'Stream this episode' button");
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