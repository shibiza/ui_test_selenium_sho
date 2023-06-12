package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPage extends BasePage {

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    private static final String startPageLink = "https://www.sho.com";
    private static final String videoPageLink = startPageLink + "/video/38764/next-on-episode-1";

    @FindBy(xpath = "//div[@class=\"vjs-poster\"]")
    private WebElement videoPlayer;

    public void openVideoPage() {
        webDriver.get(videoPageLink);
        wait.until(ExpectedConditions.visibilityOf(videoPlayer));
    }

    public boolean videoPlayerAutoPlay() {
        waitForClickable(videoPlayer);
        return videoPlayer.getText().contains("vjs-playing");
    }
}
