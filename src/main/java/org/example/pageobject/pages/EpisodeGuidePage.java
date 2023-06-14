package org.example.pageobject.pages;

import lombok.extern.slf4j.Slf4j;
import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EpisodeGuidePage extends BasePage {
    private static final String startPageLink = "https://www.sho.com";
    private static final String episodeGuidePageLink = startPageLink + "/homeland/season/5/episode/1/separation-anxiety";

    @FindBy(xpath = "//a[@class= 'global-nav__link' and @data-location= 'primary']")
    private WebElement elementsInsideHamburgerMenu;

    @FindBy(xpath = "//div[@class= 'global-nav__menu-toggle']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//*[normalize-space(@class) = 'global-nav__menu-icon'][@data-track and @data-label='menu open']")
    private WebElement closeHamburgerMenu;

    @FindBy(xpath = "//a[@data-label= 'Start Your Free Trial']")
    private WebElement startYourFreeTrialNav;

    @FindBy(xpath = "//a[@class=\"button--primary cta--item\"]")
    private WebElement streamThisEpisodeButton;

    @FindBy(xpath = "//a[@class=\"button--secondary cta--item button--video\"]")
    private WebElement watchPreviewButton;

    @FindBy(xpath = "//h2[@class= 'streaming-modal__headline']")
    private WebElement startFreeTrialPopupHeadline;

    @FindBy(xpath = "//a[@class= 'modal__close']")
    private WebElement closeStartFreeTrialPopupModule;

    @FindBy(xpath = "//a[@class= 'streaming-modal__button']")
    private WebElement onPopupModuleButton;

    @FindBy(id = "ot-sdk-btn")
    private WebElement manageCookiesBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesBtn;

    Actions builder = new Actions(webDriver);

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }


    public EpisodeGuidePage openEpisodeGuidePage() {
        log.info("load to Episode guide page" + episodeGuidePageLink);
        webDriver.get(episodeGuidePageLink);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        waitForClickable(hamburgerMenu);
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public EpisodeGuidePage clickCloseHamburgerMenu() {
        waitForClickable(closeHamburgerMenu);
        builder.moveToElement(closeHamburgerMenu).click().perform();
        return this;
    }

    public List<String> hamburgerMenuContainsItems() {
        List<WebElement> actualItemsOnHamburgerMenu = webDriver
                .findElements(By.xpath("//a[@class='global-nav__link' and @data-location= 'primary']"));

        List<String> menuTextList = actualItemsOnHamburgerMenu.stream()
                .map(e -> e.getAttribute("data-label")).collect(Collectors.toList());

        return menuTextList;
    }

    public List<String> itemsFromHamburgerMenuAreHyperlinks() {
        List<WebElement> actualItemsOnHamburgerMenu = webDriver
                .findElements(By.xpath("//a[@class='global-nav__link' and @data-location= 'primary']"));

        List<String> elementsAreHyperlinks = actualItemsOnHamburgerMenu.stream()
                .filter(e -> e.getAttribute("href") != null && !e.getAttribute("href").isEmpty())
                .map(e -> e.getAttribute("data-label"))
                .collect(Collectors.toList());

        return elementsAreHyperlinks;
    }

    public boolean closeHamburgerMenu() {
        builder.moveToElement(closeHamburgerMenu).click().perform();
        boolean shouldNotBeDisplayed = closeHamburgerMenu.isEnabled();

        if (shouldNotBeDisplayed) {
            return true;
        } else {
            return false;
        }
    }

    public String getColourOfStartYourFreeTrialNav() {
        waitForVisibility(startYourFreeTrialNav);
        String colorOfStartYourFreeTrialBtn = startYourFreeTrialNav.getCssValue("background-color");
        log.info("color of 'Start Your Free Trial' button is " + colorOfStartYourFreeTrialBtn);
        return colorOfStartYourFreeTrialBtn;
    }

    public boolean elementIsPresent(String xPath) {
        return webDriver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public EpisodeGuidePage clickOnStreamThisEpisode() {
        waitToBePresent(streamThisEpisodeButton);
        waitForClickable(streamThisEpisodeButton);
        builder.moveToElement(streamThisEpisodeButton).click().perform();
        return this;
    }

    public boolean visibilityOfPopupModule() {
        waitForClickable(onPopupModuleButton);
        boolean isPopupDisplayed = onPopupModuleButton.isDisplayed();
        return isPopupDisplayed;
    }

    public EpisodeGuidePage acceptAllCookies() {
        waitForClickable(acceptCookiesBtn);
        acceptCookiesBtn.click();
        webDriver.navigate().refresh();
        return new EpisodeGuidePage(webDriver);
    }

}