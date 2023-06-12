package org.example.pageObject.pages;

import org.example.pageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPage extends BasePage {

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    String startPageLink = "https://www.sho.com";
    String videoPageLink = startPageLink + "/video/38764/next-on-episode-1";

    @FindBy(xpath = "//div[@class=\"vjs-poster\"]")
    private WebElement videoPlayer;

    public VideoPage openVideoPage() {
        webDriver.get(videoPageLink);
        wait.until(ExpectedConditions.visibilityOf(videoPlayer));
        return this;
    }
}
