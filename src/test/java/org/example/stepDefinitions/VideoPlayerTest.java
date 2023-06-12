package org.example.stepDefinitions;

import org.example.pageobject.pages.VideoPage;
import org.junit.Assert;
import org.junit.Test;

public class VideoPlayerTest extends BaseTest {

    VideoPage videoPage = new VideoPage(webDriver);

    @Test
    public void openVideoPageAndVideoPreview() {
        Assert.assertTrue(videoPage.openVideoPage().openVideoPageAndVideoPreview());
    }

    @Test
    public void videoAutoPlays() {
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.videoPlayerAutoPlay());
    }
}
