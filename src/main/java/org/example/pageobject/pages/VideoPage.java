package org.example.pageobject.pages;

import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPage extends BasePage {

    static Logger logger = Logger.getLogger(VideoPage.class);


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
    private WebElement ccBtn;

    @FindBy(xpath = "//button[@class='vjs-play-control vjs-control vjs-button vjs-paused vjs-ended']")
    private WebElement replayBtn;

    @FindBy(xpath = "//button[@title='Fullscreen']")
    private WebElement fullScreenBtn;

    @FindBy(xpath = "//button[@title='Exit Fullscreen']")
    private WebElement exitFullScreenBtn;

    @FindBy(xpath = "//video")
    private WebElement player;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesBtn;

    Actions builder = new Actions(webDriver);

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage openVideoPage() {
        logger.info("load to Video page " + videoPageLink);
        webDriver.get(videoPageLink);
        wait.until(ExpectedConditions.visibilityOf(videoPlayer));
        return this;
    }

    public boolean openVideoPageAndVideoPreview() {
        return videoPlayer.isDisplayed();
    }

    public boolean videoPlayerAutoPlay() {
        waitForClickable(videoPlayer);
        logger.info("video player AutoPlays");
        return videoPlayer.getText().contains("vjs-playing");
    }

    public boolean pressPlayVideo() {
        waitForClickable(playVideoBtn);
        logger.info("click on 'play' button");
        playVideoBtn.click();
        return pauseVideoBtn.isDisplayed();
    }

    public boolean pressPauseVideo() {
        waitForClickable(pauseVideoBtn);
        logger.info("click on 'pause' button");
        pauseVideoBtn.click();
        return playVideoBtn.isDisplayed();
    }

    public boolean pressMuteVideo() {
        waitForClickable(muteVideoBtn);
        logger.info("click on 'mute' button");
        muteVideoBtn.click();
        return unmuteVideoBtn.isDisplayed();
    }

    public boolean pressUnmuteVideo() {
        waitForClickable(unmuteVideoBtn);
        logger.info("click on 'unmute' button");
        unmuteVideoBtn.click();
        return muteVideoBtn.isDisplayed();
    }

    public boolean hoverOverMuteVideo() {
        waitForClickable(muteVideoBtn);
        logger.info("hover over 'mute' button");
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
        builder.dragAndDrop(slider, ccBtn).build().perform();
        playVideoBtn.click();
        waitForVisibility(replayBtn);
        return replayBtn.isDisplayed();
    }

    public boolean pressFullScreenButton() {
        waitForClickable(fullScreenBtn);
        fullScreenBtn.click();
        waitForVisibility(exitFullScreenBtn);
        return exitFullScreenBtn.isDisplayed();
    }

    public boolean pressExitFullScreenButton() {
        waitForClickable(exitFullScreenBtn);
        exitFullScreenBtn.click();
        waitForVisibility(fullScreenBtn);
        return fullScreenBtn.isDisplayed();
    }

    public boolean pressEscapeToExitFullScreen() {
        waitForVisibility(exitFullScreenBtn);
        waitForVisibility(player);
        player.sendKeys(Keys.ESCAPE);
        waitForVisibility(fullScreenBtn);
        return fullScreenBtn.isDisplayed();
    }

   public void acceptAllCookies() {
        sleep(1_000);
        waitForClickable(acceptAllCookiesBtn);
        logger.info("press on 'accept all cookies button' ");
        acceptAllCookiesBtn.click();
        sleep(1_000);
    }
}