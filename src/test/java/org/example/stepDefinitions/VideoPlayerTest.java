package org.example.stepDefinitions;

import org.example.pageobject.pages.VideoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VideoPlayerTest extends BaseTest {

    VideoPage videoPage = new VideoPage(webDriver);
    String videoPlayer = "//div[@class=\"vjs-poster\"]";

    @Test
    public void openVideoPlayer() {
        videoPage.openVideoPage();
        Assert.assertTrue(webDriver.findElement(By.xpath(videoPlayer)).isDisplayed());
    }

    @Test
    public void videoAutoPlays() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.videoPlayerAutoPlay());
    }
}
