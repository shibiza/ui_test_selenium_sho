package org.example.stepDefinitions;

import org.example.pageobject.pages.EpisodeGuidePage;
import org.example.pageobject.pages.StartYourFreeTrialPopupModule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EpisodeGuideTest extends BaseTest {

    private final EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    private final StartYourFreeTrialPopupModule startYourFreeTrialPopupModule = new StartYourFreeTrialPopupModule(webDriver);

    private static final String EXPECTED_COLOR_RED = "rgba(255, 32, 44, 1)";
    /*     The difference between #ff202c and rgba(255, 32, 44, 1) lies in the representation of color in CSS,
           #ff202c and rgba(255, 32, 44, 1) actually represent the same color - a bright red.
           The difference in representation arises due to the CSS color format, but they are equivalent
            in terms of the actual color they represent.    */
    private static final String STREAM_THIS_EPISODE_BUTTON = "//a[@class=\"button--primary cta--item\"]";
    private static final String WATCH_PREVIEW_BUTTON = "//a[@class=\"button--secondary cta--item button--video\"]";

    private final ArrayList<String> expectedItemsOnHamburgerMenu = new ArrayList<>(List.
            of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));
    private final ArrayList<String> expectedElementsAreHyperLinks = new ArrayList<>(List.
            of("Movies", "Sports", "Documentaries", "Free Full Episodes"));

    //  2.1
    @Test
    public void hamburgerMenuHasItems() {
        episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
        ArrayList<String> actualItemsHamburgerMenu = (ArrayList<String>) episodeGuidePage.hamburgerMenuContainsItems();
        Assert.assertEquals(actualItemsHamburgerMenu, expectedItemsOnHamburgerMenu);
    }

    //  2.1.i
    @Test
    public void itemsFromHamburgerMenuAreHyperlinksExceptSeries() {
        episodeGuidePage.openEpisodeGuidePage().clickOnHamburgerMenu();
        ArrayList<String> actualElementsAreHyperLinks = (ArrayList<String>) episodeGuidePage
                .itemsFromHamburgerMenuAreHyperlinks();
        Assert.assertTrue(actualElementsAreHyperLinks.containsAll(expectedElementsAreHyperLinks));
    }

    //  2.1.ii
    @Test
    public void closeHamburgerMenu() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu()
                .clickCloseHamburgerMenu();
        Assert.assertTrue(episodeGuidePage.isHamburgerMenuClosed());
    }

    //  2.2
    @Test
    public void verifyStartYourFreeTrialMarkRed() {
        episodeGuidePage.openEpisodeGuidePage();
        String actualRed = episodeGuidePage.getColourOfStartYourFreeTrialNav();
        Assert.assertEquals(EXPECTED_COLOR_RED, actualRed);
    }

    //  2.3
    @Test
    public void streamThisEpisodeAndWatchPreviewButtons() {
        episodeGuidePage.openEpisodeGuidePage();
        Assert.assertTrue(episodeGuidePage.elementIsPresent(STREAM_THIS_EPISODE_BUTTON));
        Assert.assertTrue(episodeGuidePage.elementIsPresent(WATCH_PREVIEW_BUTTON));
    }

    //  2.3.ii
    @Test
    public void streamThisEpisodeStartYourFreeTrialPopupIsDisplayed() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnStreamThisEpisode();
        Assert.assertTrue(startYourFreeTrialPopupModule.startYourFreeTrialPopupModuleDisplayed());
    }

    //  2.3.iii
    @Test
    public void closePopupModule() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnStreamThisEpisode()
                .visibilityOfPopupModule();
        startYourFreeTrialPopupModule.closeStartYourFreeTrialPopupModule();
        Assert.assertTrue(startYourFreeTrialPopupModule.waitToPopupDisappear());
    }
}