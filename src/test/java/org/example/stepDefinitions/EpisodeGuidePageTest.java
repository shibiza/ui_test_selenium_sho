package org.example.stepDefinitions;

import org.example.pageobject.pages.EpisodeGuidePage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class EpisodeGuidePageTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String expectedColorRed = "#ff202c";


    //   ArrayList<WebElement> expectedItemsOnHamburgerMenu = new ArrayList<>(List.of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));

//    @Test
//    public void hamburgerMenuHasItems() {
//        ArrayList<String> expectedItemsOnHamburgerMenu;
//        Assert.assertTrue();
//    }

    @Test
    public void VerifyStartYourFreeTrialMarkRed() {
        episodeGuidePage.openEpisodeGuidePage();
        String actualRed = episodeGuidePage.getColourOfStartYourFreeTrialNav();

        Assert.assertEquals(expectedColorRed, actualRed);
    }

//    @Test
//    public void closeHamburgerMenu() {
//       episodeGuidePage.openEpisodeGuidePage()
//              .clickOnHamburgerMenu()
//              .closeHamburgerMenu();
//
//        Assert.assertTrue(true);
//    }
//    @Test
//    public void verifyHamburgerMenu() {
//        boolean isHamburgerManuClickable = episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
//        Assert.assertEquals(true, isHamburgerManuClickable);
//    }
}
