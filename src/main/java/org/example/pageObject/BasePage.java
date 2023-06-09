package org.example.pageObject;

import org.example.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver webDriver;
    protected WebDriverWait wait;
    public static final int PAGE_LOAD_TIMEOUT_SECONDS = 500;

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

    public void waitForPageLoadAndTitleContains(String pageTitle) {
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    //public void waitForPageLoadAndTitleContains(int timeout, String pageTitle) {
    //    WebDriverWait wait = new WebDriverWait(driver, timeout, 1000);
    //    wait.until(ExpectedConditions.titleContains(pageTitle));
    //}


    /*    protected static void waitForPageToLoad(String pageLink) {
               waitForPageToLoad(PAGE_LOAD_TIMEOUT_SECONDS);       }      }


    public static void waitForPageToLoad(int PAGE_LOAD_TIMEOUT_SECONDS) throws InterruptedException {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            @Override
            public @Nullable Boolean apply(@Nullable WebDriver webDriver) {
                return ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete");
            }
        };
        webDriver.wait(PAGE_LOAD_TIMEOUT_SECONDS).until(pageLoadCondition);
    }

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
 */
}