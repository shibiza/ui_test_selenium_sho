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

    @FindBy(xpath = "//div[contains(@class, 'video-playr__video__embed')]")
    private WebElement videoPlayer;

    @FindBy(partialLinkText = "vjs-play-control vjs-control vjs-button vjs-paused")
    private WebElement playVideoBtn;

    public VideoPage openVideoPage() {
        webDriver.get(videoPageLink);
        wait.until(ExpectedConditions.visibilityOf(videoPlayer));
        return this;
    }

    public boolean openVideoPageAndVideoPreview() {
        return videoPlayer.isDisplayed();
    }

    public boolean videoPlayerAutoPlay() {
        waitForClickable(videoPlayer);
        System.out.println(videoPlayer.getText());
        return videoPlayer.getText().contains("vjs-playing");
    }

    public boolean pressPlayVideo() {
        waitForClickable(playVideoBtn);
        playVideoBtn.click();
        return playVideoBtn.isDisplayed();
    }
}