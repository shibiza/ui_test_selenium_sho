package org.example.pageobject.pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(xpath = "//*[normalize-space(@class) = 'global-nav__menu-icon']")
    private WebElement closeHamburgerMenuBtn;

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

    static Logger logger = Logger.getLogger(EpisodeGuidePage.class);

    public EpisodeGuidePage(WebDriver webDriver) {
        super(webDriver);
    }

    public EpisodeGuidePage openEpisodeGuidePage() {
        log.info("load to Episode guide page" + episodeGuidePageLink);
        webDriver.get(episodeGuidePageLink);
        sleep(2_000);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        sleep(2_000);
        waitForClickable(hamburgerMenu);
        builder.moveToElement(hamburgerMenu).click().perform();
        return this;
    }

    public EpisodeGuidePage clickCloseHamburgerMenu() {
        sleep(2_000);
        waitForClickable(closeHamburgerMenuBtn);

        builder.moveToElement(closeHamburgerMenuBtn).click().perform();
        sleep(3_000);
        return this;
    }

    public boolean closeHamburgerMenu() {

        String shouldBeMenuClose = closeHamburgerMenuBtn.getAttribute("data-label");
        System.out.println(shouldBeMenuClose);

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
        log.info("Elements from hamburger menu are: " + menuTextList);

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
        sleep(2_000);
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
        sleep(3_000);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='onetrust-accept-btn-handler']")));
        waitForClickable(el);
        el.click();

        return this;
    }


}