package org.example.stepDefinitions;

import org.example.pageobject.pages.EpisodeGuidePage;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EpisodeGuidePageTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String expectedColorRed = "rgba(255, 32, 44, 1)";

    ArrayList<String> expectedItemsOnHamburgerMenu = new ArrayList<>(List.
            of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));

    String streamThisEpisodeButton = "//a[@class=\"button--primary cta--item\"]";
    String watchPreviewButton = "//a[@class=\"button--secondary cta--item button--video\"]";

    @Test
    public void hamburgerMenuHasItems() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu();
        ArrayList<String> actualItemsHamburgerMenu = (ArrayList<String>) episodeGuidePage.hamburgerMenuContainsItems();
        System.out.println(actualItemsHamburgerMenu);

        Assert.assertTrue(actualItemsHamburgerMenu.equals(expectedItemsOnHamburgerMenu));
    }

    @Test
    public void closeHamburgerMenu() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu()
                .closeHamburgerMenu();

        Assert.assertTrue(true);
    }

    @Test
    public void VerifyStartYourFreeTrialMarkRed() {
        episodeGuidePage.openEpisodeGuidePage();
        String actualRed = episodeGuidePage.getColourOfStartYourFreeTrialNav();

        Assert.assertEquals(expectedColorRed, actualRed);
    }

    @Test
    public void streamThisEpisodeAndWatchPreviewButtons() {
        episodeGuidePage.openEpisodeGuidePage();
        boolean actualStreamButton = episodeGuidePage.elementIsPresent(streamThisEpisodeButton);
        boolean actualWatchPreview = episodeGuidePage.elementIsPresent(watchPreviewButton);
        boolean test = false;
        if (actualWatchPreview == true && actualStreamButton == true) {
            test = true;
        }
        Assert.assertTrue(test);
    }
//
//    @Test
//    public void verifyHamburgerMenu() {
//        boolean isHamburgerManuClickable = episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
//        Assert.assertEquals(true, isHamburgerManuClickable);
//    }
}
