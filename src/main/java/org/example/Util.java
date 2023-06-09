package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {
    public static WebDriverWait waitTenSeconds(WebDriver webDriver){
        return new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }
}
