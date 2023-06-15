package org.example.stepDefinitions;

import org.apache.log4j.Logger;
import org.example.pageobject.pages.EpisodeGuidePage;
import org.example.pageobject.pages.StartYourFreeTrialPopupModule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EpisodeGuideTest extends BaseTest {

    static Logger logger = Logger.getLogger(EpisodeGuideTest.class);

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    StartYourFreeTrialPopupModule startYourFreeTrialPopupModule = new StartYourFreeTrialPopupModule(webDriver);

    String expectedColorRed = "rgba(255, 32, 44, 1)";
    String streamThisEpisodeButton = "//a[@class=\"button--primary cta--item\"]";
    String watchPreviewButton = "//a[@class=\"button--secondary cta--item button--video\"]";

    ArrayList<String> expectedItemsOnHamburgerMenu = new ArrayList<>(List.
            of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));
    ArrayList<String> expectedElementsAreHyperLinks = new ArrayList<>(List.
            of("Movies", "Sports", "Documentaries", "Free Full Episodes"));

    //  2.1
    @Test
    public void hamburgerMenuHasItems() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu();
        ArrayList<String> actualItemsHamburgerMenu = (ArrayList<String>) episodeGuidePage.hamburgerMenuContainsItems();
        Assert.assertEquals(actualItemsHamburgerMenu, expectedItemsOnHamburgerMenu);
    }

    //  2.1.i
    @Test
    public void itemsFromHamburgerMenuAreHyperlinksExceptSeries() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu();
        ArrayList<String> actualElementsAreHyperLinks = (ArrayList<String>) episodeGuidePage
                .itemsFromHamburgerMenuAreHyperlinks();
        Assert.assertTrue(actualElementsAreHyperLinks.containsAll(expectedElementsAreHyperLinks));
    }

    //  2.1.ii
    @Test
    public void closeHamburgerMenu() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnHamburgerMenu()
                .clickCloseHamburgerMenu();
        Assert.assertTrue(episodeGuidePage.closeHamburgerMenu());
    }

    //  2.2
    @Test
    public void VerifyStartYourFreeTrialMarkRed() {
        episodeGuidePage.openEpisodeGuidePage();
        String actualRed = episodeGuidePage.getColourOfStartYourFreeTrialNav();
        Assert.assertEquals(expectedColorRed, actualRed);
    }

    //  2.3
    @Test
    public void streamThisEpisodeAndWatchPreviewButtons() {
        episodeGuidePage.openEpisodeGuidePage();
        Assert.assertTrue(episodeGuidePage.elementIsPresent(streamThisEpisodeButton));
        Assert.assertTrue(episodeGuidePage.elementIsPresent(watchPreviewButton));
    }

    //  2.3.ii
    @Test
    public void streamThisEpisodeStartYourFreeTrialPopupIsDisplayed() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnStreamThisEpisode();
        Assert.assertTrue(startYourFreeTrialPopupModule.startYourFreeTrialPopupModuleDisplayed());
    }

    //  2.3.iii
    @Test
    public void closePopupModule() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnStreamThisEpisode()
                .visibilityOfPopupModule();
        startYourFreeTrialPopupModule.closeStartYourFreeTrialPopupModule();
        Assert.assertTrue(startYourFreeTrialPopupModule.waitToPopupDisappear());
    }
}