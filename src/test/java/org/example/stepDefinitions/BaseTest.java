package org.example.stepDefinitions;

import org.example.factory.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    @Before
    public void setWebDriver() {
        webDriver.manage().window().maximize();
    }

    @After
    public void quite() {
        webDriver.close();
        webDriver.quit();
    }
}