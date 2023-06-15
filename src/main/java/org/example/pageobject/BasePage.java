package org.example.pageobject;

import org.apache.log4j.Logger;
import org.example.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static final String START_PAGE_LINK = "https://www.sho.com";
    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    protected WebDriver webDriver;
    protected WebDriverWait wait;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = Util.waitTenSeconds(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement waitForVisibility(WebElement element) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean waitForElementNotDisplayed(WebElement element) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected void acceptAllCookies() {
        sleep(1_000);
        waitForClickable(acceptAllCookiesBtn);
        LOGGER.info("press on 'accept all cookies button' ");
        acceptAllCookiesBtn.click();
        sleep(1_000);
    }
}