package org.example.factory;

import org.example.properties.PropertyHolder;
import org.example.properties.converters.SupportedBrowserConverter;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public WebDriver getWebDriver(){
        return SupportedBrowserConverter.valueOfWebBrowsers(
                new PropertyHolder().readProperty("browser")
        ).getWebDriver();
    }
}
