package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartYourFreeTrialPopupModule extends BasePage {

    public StartYourFreeTrialPopupModule(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//h2[@class= 'streaming-modal__headline']")
    private WebElement startFreeTrialPopupHeadline;

    @FindBy(xpath = "//a[@class= 'modal__close']")
    private WebElement closeStartFreeTrialPopupModule;

    @FindBy(xpath = "//div[@class= 'streaming-modal__image-container__shim']")
    private WebElement popupWindowOpens;

    public boolean startYourFreeTrialPopupModuleDisplayed() {
        return waitForVisibility(popupWindowOpens).isDisplayed();
    }

    public EpisodeGuidePage closeStartYourFreeTrialPopupModule() {
        waitForClickable(closeStartFreeTrialPopupModule).click();
        return new EpisodeGuidePage(webDriver);
    }
}
