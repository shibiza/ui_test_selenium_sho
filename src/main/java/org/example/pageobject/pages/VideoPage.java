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
    //video-playr__video__embed video-js vjs-controls-enabled vjs-workinghover vjs-v7
    // vjs-layout-large bc-player-NzCF8EByd_default bc-player-NzCF8EByd_default-index-0 vjs-mouse vjs-dock
    // vjs-plugins-ready vjs-player-info
    // vjs-contextmenu vjs-contextmenu-ui vjs-errors vjs-has-started vjs-paused not-hover vjs-user-inactive

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

    public WebElement justTryToPrintWebElement() {
        WebElement w = videoPlayer;
        return w;
    }
}