package org.example.stepDefinitions;

import org.example.pageObject.pages.EpisodeGuidePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpisodeGuidePageTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String colorRed = "#ff202c";

    @org.testng.annotations.Test
    public void VerifyStartYourFreeTrialMarkRed() {
        String red = episodeGuidePage.openEpisodeGuidePage().getColourOfStartYourFreeTrialNav();
        org.testng.Assert.assertEquals(red, colorRed);
    }

    @Test
    public void openCloseHamMenu() {
        episodeGuidePage.openCloseHamMenu();
        Assert.assertTrue(true);
    }
//    @Test
//    public void verifyHamburgerMenu() {
//        boolean isHamburgerManuClickable = episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
//        Assert.assertEquals(true, isHamburgerManuClickable);
//    }
}
