package org.example.stepDefinitions;

import org.example.pageobject.pages.VideoPage;
import org.junit.Assert;
import org.junit.Test;

public class VideoPlayerTest extends BaseTest {

   private final VideoPage videoPage = new VideoPage(webDriver);

    //  3.
    @Test
    public void openVideoPageFromVideoPreview() {
        Assert.assertTrue(videoPage.navigateToVideoPageFromWatchPreview().isVideoPageDisplayed());
    }

    //  4.a
    @Test
    public void videoAutoPlays() {
        videoPage.navigateToVideoPageFromWatchPreview();
        Assert.assertTrue(videoPage.isVideoPlayerAutoPlay());
    }

    //  4.b.i
    @Test
    public void pressPlayAndPauseVideo() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressPlayVideo());
        Assert.assertTrue(videoPage.pressPauseVideo());
    }

    //  4.b.ii
    @Test
    public void pressMuteAndUnmuteVideo() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressMuteVideo());
        Assert.assertTrue(videoPage.pressUnmuteVideo());
    }

    //  4.b.iii
    @Test
    public void expandVolumeSlider() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.hoverOverMuteVideo());
    }

    //  4.b.iv
    @Test
    public void videoTimeControlIsVisible() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.checkTimeControlVisibility());
    }

    //  4.b.v
    @Test
    public void timeLineScrubbingControl() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.putSliderToTheEndOfBar());
    }

    //  4.b.vi && 4.2
    @Test
    public void pressFullScreenAndExitFullScreenButtons() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressFullScreenButton());
        Assert.assertTrue(videoPage.pressExitFullScreenButton());
    }

    //  4.b.vii
    @Test
    public void checkControlsInFullScreenMode() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressFullScreenButton());
        Assert.assertTrue(videoPage.pressPlayVideo());
        Assert.assertTrue(videoPage.pressPauseVideo());
        Assert.assertTrue(videoPage.pressMuteVideo());
        Assert.assertTrue(videoPage.pressUnmuteVideo());
        Assert.assertTrue(videoPage.hoverOverMuteVideo());
        Assert.assertTrue(videoPage.checkTimeControlVisibility());
        Assert.assertTrue(videoPage.putSliderToTheEndOfBar());
    }

    //  4.3
    @Test
    // NOTE: below test do not work due to chromedriver issue https://bugs.chromium.org/p/chromedriver/issues/detail?id=3466&q=ESC&can=1
    // https://github.com/SeleniumHQ/selenium/issues/8292
    public void pressFullScreenAndEscapeButtons() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressFullScreenButton());
        Assert.assertTrue(videoPage.pressEscapeToExitFullScreen());
    }
}
