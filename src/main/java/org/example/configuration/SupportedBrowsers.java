package org.example.configuration;

import org.example.invoker.WebDriverInvoker;
import org.example.invoker.implementation.LocalChromeInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {

    LOCAL_CHROME(new LocalChromeInvoker());
    private final WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(LocalChromeInvoker webDriverInvoker) {
        this.webDriverInvoker = (WebDriverInvoker) webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}