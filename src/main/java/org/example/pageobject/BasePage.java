package org.example.pageobject;

import org.example.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait wait;

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
}