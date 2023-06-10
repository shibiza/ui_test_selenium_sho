package org.example.stepDefinitions;

import org.example.pageObject.pages.EpisodeGuidePage;
import org.junit.Assert;
import org.junit.Test;

public class EpisodeGuidePageTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String colorRed = "#ff202c";

    @Test
    public void VerifyStartYourFreeTrialMarkRed() {
        String red = episodeGuidePage.getColourOfStartYourFreeTrialNav();
        Assert.assertEquals(red, colorRed);
    }

//    @Test
//    public void verifyHamburgerMenu() {
//        boolean isHamburgerManuClickable = episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
//        Assert.assertEquals(true, isHamburgerManuClickable);
//    }
}
