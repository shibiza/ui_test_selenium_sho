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

    //  @FindBy(xpath = "//div[@class='global-nav__menu-icon' and @data-label='menu close']")
    @FindBy(css = ".global-nav--open .global-nav__inner .global-nav__menu-toggle span:nth-child(3)")
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
        webDriver.get(episodeGuidePageLink);
        return this;
    }

    public EpisodeGuidePage clickOnHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
        builder.moveToElement(hamburgerMenu).click().perform();
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
        boolean isClickable = closeHamburgerMenu.isEnabled();

        if (isClickable) {
            return false;
        } else {
            return true;
        }
    }

    public String getColourOfStartYourFreeTrialNav() {
        waitForVisibility(startYourFreeTrialNav);
        return startYourFreeTrialNav.getCssValue("background-color");
    }

    public boolean elementIsPresent(String xPath) {
        return webDriver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public EpisodeGuidePage clickOnStreamThisEpisode() {
        waitForClickable(streamThisEpisodeButton);
        builder.moveToElement(streamThisEpisodeButton).click().perform();
        return this;
    }

    public boolean visibilityOfPopupModule() {
        wait.until(ExpectedConditions.visibilityOf(onPopupModuleButton));
        boolean isPopupDisplayed = onPopupModuleButton.isDisplayed();
        return isPopupDisplayed;
    }

    public EpisodeGuidePage acceptAllCookies() {
        wait.until(ExpectedConditions.visibilityOf(acceptCookiesBtn));
        waitForClickable(acceptCookiesBtn);
        acceptCookiesBtn.click();
        webDriver.navigate().refresh();
        return new EpisodeGuidePage(webDriver);
    }

}