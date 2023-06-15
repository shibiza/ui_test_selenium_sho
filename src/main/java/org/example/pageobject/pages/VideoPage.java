package org.example.pageobject.pages;

import org.apache.log4j.Logger;
import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VideoPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(VideoPage.class);
    private static final String VIDEO_PAGE_LINK = START_PAGE_LINK + "/video/38764/next-on-episode-1";

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

    private final Actions builder = new Actions(webDriver);

    public VideoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public VideoPage openVideoPage() {
        LOGGER.info("load to Video page " + VIDEO_PAGE_LINK);
        webDriver.get(VIDEO_PAGE_LINK);
        acceptAllCookies();
        wait.until(ExpectedConditions.visibilityOf(videoPlayer));
        return this;
    }

    public boolean isVideoPageDisplayed() {
        waitForVisibility(videoPlayer);
        LOGGER.info("video player on video page ");
        return videoPlayer.isDisplayed();
    }

    public VideoPage navigateToVideoPageFromWatchPreview() {
        EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
        return episodeGuidePage.openEpisodeGuidePage().clickOnWatchPreview();
    }

    public boolean isVideoPlayerAutoPlay() {
        waitForClickable(pauseVideoBtn);
        LOGGER.info("video player AutoPlays");
        return pauseVideoBtn.isDisplayed();
    }

    public boolean pressPlayVideo() {
        waitForClickable(playVideoBtn);
        LOGGER.info("click on 'play' button");
        playVideoBtn.click();
        return pauseVideoBtn.isDisplayed();
    }

    public boolean pressPauseVideo() {
        waitForClickable(pauseVideoBtn);
        LOGGER.info("click on 'pause' button");
        pauseVideoBtn.click();
        return playVideoBtn.isDisplayed();
    }

    public boolean pressMuteVideo() {
        waitForClickable(muteVideoBtn);
        LOGGER.info("click on 'mute' button");
        muteVideoBtn.click();
        return unmuteVideoBtn.isDisplayed();
    }

    public boolean pressUnmuteVideo() {
        waitForClickable(unmuteVideoBtn);
        LOGGER.info("click on 'unmute' button");
        unmuteVideoBtn.click();
        return muteVideoBtn.isDisplayed();
    }

    public boolean hoverOverMuteVideo() {
        waitForClickable(muteVideoBtn);
        LOGGER.info("hover over 'mute' button");
        builder.clickAndHold(muteVideoBtn).build().perform();
        By volumeBarXpath = By.xpath("//div[@class='vjs-volume-panel vjs-control vjs-volume-panel-horizontal vjs-hover']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(volumeBarXpath));
        WebElement volumeBar = webDriver.findElement(volumeBarXpath);
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
        LOGGER.info("put slider to the end of bar");
        builder.dragAndDrop(slider, ccBtn).build().perform();
        playVideoBtn.click();
        waitForVisibility(replayBtn);
        return replayBtn.isDisplayed();
    }

    public boolean pressFullScreenButton() {
        waitForClickable(fullScreenBtn);
        LOGGER.info("press on 'full screen' button");
        fullScreenBtn.click();
        waitForClickable(exitFullScreenBtn);
        return exitFullScreenBtn.isDisplayed();
    }

    public boolean pressExitFullScreenButton() {
        waitForClickable(exitFullScreenBtn);
        LOGGER.info("press on exit from 'full screen' button");
        exitFullScreenBtn.click();
        waitForVisibility(fullScreenBtn);
        return fullScreenBtn.isDisplayed();
    }

    public boolean pressEscapeToExitFullScreen() {
        waitForVisibility(exitFullScreenBtn);
        waitForVisibility(player);
        LOGGER.info("now I will press 'ESC' button... And the test should fall((((");
        player.sendKeys(Keys.ESCAPE);
        waitForVisibility(fullScreenBtn);
        return fullScreenBtn.isDisplayed();
    }
}