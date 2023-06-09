package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {
    String startPage = "https://www.sho.com";

    public StartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StartPage open() {
        webDriver.get(startPage);
        return this;
    }
}

