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

    //4.b.i
    @Test
    public void pressPlayAndPauseVideo(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressPlayVideo());
        Assert.assertTrue(videoPage.pressPauseVideo());
    }

    //4.b.ii
    @Test
    public void pressMuteAndUnmuteVideo(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressMuteVideo());
        Assert.assertTrue(videoPage.pressUnmuteVideo());
    }

    //4.b.iii
    @Test
    public void expandVolumeSlider(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.hoverOverMuteVideo());
    }

    //4.b.iv
    @Test
    public void videoTimeControlIsVisible(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.checkTimeControlVisibility());
    }

    //4.b.v
    @Test
    public void timeLineControl(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.putSliderToTheEndOfBar());
    }

    //4.b.vi && 4.2
    @Test
    public void pressFullScreenAndExitFullScreenButtons(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressFullScreenButton());
        Assert.assertTrue(videoPage.pressExitFullScreenButton());
    }

    //4.b.vii
    @Test
    public void checkControlsInFullScreenMode(){
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

    //4.3
    @Test
    // NOTE: below test do not work due to chromedriver issue https://bugs.chromium.org/p/chromedriver/issues/detail?id=3466&q=ESC&can=1
    public void pressFullScreenAndEscapeButtons(){
        videoPage.openVideoPage();
        Assert.assertTrue(videoPage.pressFullScreenButton());
        Assert.assertTrue(videoPage.pressEscapeToExitFullScreen());
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
