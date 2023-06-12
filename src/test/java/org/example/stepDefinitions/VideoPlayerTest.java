package org.example.stepDefinitions;

import org.example.pageobject.pages.VideoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class VideoPlayerTest extends BaseTest {

    VideoPage videoPage = new VideoPage(webDriver);

    String logo = "//div[@class=\"vjs-poster\"]";

    @Test
    public void ope() {
        videoPage.openVideoPage();
        Assert.assertTrue(webDriver.findElement(By.xpath(logo)).isDisplayed());
    }
}
