package org.example.pageobject.pages;

import lombok.extern.slf4j.Slf4j;
import org.example.pageobject.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Slf4j
public class VideoPage extends BasePage {


    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    private static final String startPageLink = "https://www.sho.com";
    private static final String videoPageLink = startPageLink + "/video/38764/next-on-episode-1";

    @FindBy(xpath = "//div[contains(@class, 'video-playr__video__embed')]")
    private WebElement videoPlayer;

    @FindBy(xpath = "//button[@title = 'Play']")
    private WebElement playVideoBtn;

    @FindBy(xpath = "//button[@title = 'Pause']")
    private WebElement pauseVideoBtn;

    @FindBy(xpath = "//button[@title = 'Mute']")
    private WebElement muteVideoBtn;

    @FindBy(xpath = "//button[@title = 'Unmute']")
    private WebElement unmuteVideoBtn;

    @FindBy(xpath = "//div[@class='vjs-volume-panel vjs-control vjs-volume-panel-horizontal vjs-hover']")
    private WebElement volumeBar;

    @FindBy(xpath = "//div[@class='vjs-current-time vjs-time-control vjs-control']")
    private WebElement timeControlCurrent;

    @FindBy(xpath = "//div[@class='vjs-time-control vjs-time-divider']")
    private WebElement timeControlDivider;

    @FindBy(xpath = "//div[@class='vjs-duration vjs-time-control vjs-control']")
    private WebElement timeControlDuration;

    @FindBy(xpath = "//div[@class='vjs-play-progress vjs-slider-bar']")
    private WebElement slider;

    @FindBy(xpath = "//div[@class='vjs-subs-caps-button vjs-menu-button vjs-menu-button-popup vjs-control vjs-button vjs-hidden']")
    private WebElement ccButton;

    @FindBy(xpath = "//button[@class='vjs-play-control vjs-control vjs-button vjs-paused vjs-ended']")
    private WebElement replayButton;

    @FindBy(xpath = "//button[@title='Fullscreen']")
    private WebElement fullScreenButton;

    @FindBy(xpath = "//button[@title='Exit Fullscreen']")
    private WebElement exitFullScreenButton;

    @FindBy(xpath = "//video")
    private WebElement player;


    Actions builder = new Actions(webDriver);

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
        return pauseVideoBtn.isDisplayed();
    }

    public boolean pressPauseVideo() {
        waitForClickable(pauseVideoBtn);
        pauseVideoBtn.click();
        return playVideoBtn.isDisplayed();
    }

    public boolean pressMuteVideo() {
        waitForClickable(muteVideoBtn);
        muteVideoBtn.click();
        return unmuteVideoBtn.isDisplayed();
    }

    public boolean pressUnmuteVideo() {
        waitForClickable(unmuteVideoBtn);
        unmuteVideoBtn.click();
        return muteVideoBtn.isDisplayed();
    }

    public boolean hoverOverMuteVideo() {
        waitForClickable(muteVideoBtn);
        builder.moveToElement(muteVideoBtn).build().perform();
        return volumeBar.isDisplayed();
    }

    public boolean checkTimeControlVisibility() {
        waitForVisibility(timeControlCurrent);
        waitForVisibility(timeControlDivider);
        waitForVisibility(timeControlDuration);
        return timeControlCurrent.isDisplayed() && timeControlDivider.isDisplayed() && timeControlDuration.isDisplayed();
    }

    public boolean putSliderToTheEndOfBar() {
        waitForClickable(slider);
        builder.dragAndDrop(slider, ccButton).build().perform();
        playVideoBtn.click();
        waitForVisibility(replayButton);
        return replayButton.isDisplayed();
    }

    public boolean pressFullScreenButton() {
        waitForClickable(fullScreenButton);
        fullScreenButton.click();
        waitForVisibility(exitFullScreenButton);
        return exitFullScreenButton.isDisplayed();
    }

    public boolean pressExitFullScreenButton() {
        waitForClickable(exitFullScreenButton);
        exitFullScreenButton.click();
        waitForVisibility(fullScreenButton);
        return fullScreenButton.isDisplayed();
    }

    public boolean pressEscapeToExitFullScreen() {
        waitForVisibility(exitFullScreenButton);
        waitForVisibility(player);
        player.sendKeys(Keys.ESCAPE);
        waitForVisibility(fullScreenButton);
        return fullScreenButton.isDisplayed();
    }
}