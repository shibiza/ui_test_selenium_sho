package org.example.stepDefinitions;

import org.example.pageobject.pages.VideoPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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

//    @Test
//    public void justTryTest(){
//        videoPage.openVideoPage().openVideoPageAndVideoPreview();
//
//        String r = videoPage.justTryToPrintWebElement().getAttribute();
//        System.out.println("//div[@class=\"vjs-poster\"]    это элемент  r" + r);
//
//      //  String i = webDriver.findElement(By.xpath("//div[@class=\"vjs-big-play-button\"] ")).getText();
//     //   System.out.println("//div[@class=\"vjs-big-play-button\"]    это элемент i " + i);
//
//       // String u =webDriver.findElement(By.xpath("//div[contains(@title, 'Play Video')]")).getText();
//     //   System.out.println("//div[contains(@title, 'Play Video')]  это элемент u " + u);
//
//
//        Assert.assertTrue(true);
//    }
}
