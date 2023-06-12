package org.example.stepDefinitions;

import org.example.pageObject.pages.EpisodeGuidePage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class EpisodeGuidePageTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String colorRed = "#ff202c";
    ArrayList<String> expectedItemsOnHamburgerMenu = new ArrayList<>(List.of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));

//    @Test
//    public void hamburgerMenuHasItems(){
//        ArrayList<String> expectedItemsOnHamburgerMenu;
//        Assert.assertTrue();
//    }

    @Test
    public void VerifyStartYourFreeTrialMarkRed() {
        String red = episodeGuidePage.openEpisodeGuidePage().getColourOfStartYourFreeTrialNav();
        Assert.assertEquals(red, colorRed);
    }

    @Test
    public void closeHamburgerMenu() {
       episodeGuidePage.openEpisodeGuidePage()
              .clickOnHamburgerMenu()
              .closeHamburgerMenu();

        Assert.assertTrue(true);
    }
//    @Test
//    public void verifyHamburgerMenu() {
//        boolean isHamburgerManuClickable = episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
//        Assert.assertEquals(true, isHamburgerManuClickable);
//    }
}
