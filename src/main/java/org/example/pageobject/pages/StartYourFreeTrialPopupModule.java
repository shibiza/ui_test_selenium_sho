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
    private WebElement closeStartFreeTrialPopupModuleBtn;

    @FindBy(xpath = "//div[@class= 'streaming-modal__image-container__shim']")
    private WebElement popupWindowOpens;

    public boolean startYourFreeTrialPopupModuleDisplayed() {
        waitForVisibility(popupWindowOpens);
        return waitForVisibility(popupWindowOpens).isDisplayed();
    }

    public boolean waitToPopupDisappear() {
        return waitForElementNotDisplayed(popupWindowOpens);
    }

    public boolean closeStartYourFreeTrialPopupModule() {
        waitForClickable(closeStartFreeTrialPopupModuleBtn).click();
        closeStartFreeTrialPopupModuleBtn.click();
        sleep(2_000);
        return waitForElementNotDisplayed(closeStartFreeTrialPopupModuleBtn);
    }
}
