package org.example.pageObject;

import org.example.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver webDriver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = Util.waitTenSeconds(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    protected WebElement waitForVisibility(WebElement element) throws Error {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element) throws Error {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement waitToBePresent(WebElement element) throws Error{
        return new WebDriverWait(webDriver,Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated((By) element));
    }
    protected WebElement findElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}