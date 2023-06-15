package org.example.stepDefinitions;

import lombok.extern.slf4j.Slf4j;
import org.example.pageobject.pages.EpisodeGuidePage;
import org.example.pageobject.pages.StartYourFreeTrialPopupModule;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EpisodeGuideTest extends BaseTest {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    StartYourFreeTrialPopupModule startYourFreeTrialPopupModule = new StartYourFreeTrialPopupModule(webDriver);

    String expectedColorRed = "rgba(255, 32, 44, 1)";
    /*     The difference between #ff202c and rgba(255, 32, 44, 1) lies in the representation of color in CSS,
           #ff202c and rgba(255, 32, 44, 1) actually represent the same color - a bright red.
           The difference in representation arises due to the CSS color format, but they are equivalent
            in terms of the actual color they represent.    */
    String streamThisEpisodeButton = "//a[@class=\"button--primary cta--item\"]";
    String watchPreviewButton = "//a[@class=\"button--secondary cta--item button--video\"]";

    ArrayList<String> expectedItemsOnHamburgerMenu = new ArrayList<>(List.
            of("Series", "Movies", "Sports", "Documentaries", "Free Full Episodes"));
    ArrayList<String> expectedElementsAreHyperLinks = new ArrayList<>(List.
            of("Movies", "Sports", "Documentaries", "Free Full Episodes"));

    @Test
    public void hamburgerMenuHasItems() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu();
        ArrayList<String> actualItemsHamburgerMenu = (ArrayList<String>) episodeGuidePage.hamburgerMenuContainsItems();
        System.out.println(actualItemsHamburgerMenu);

        Assert.assertEquals(actualItemsHamburgerMenu, expectedItemsOnHamburgerMenu);
    }

    @Test
    public void itemsFromHamburgerMenuAreHyperlinksExceptSeries() {
        episodeGuidePage.openEpisodeGuidePage()
                .clickOnHamburgerMenu();
        ArrayList<String> actualElementsAreHyperLinks = (ArrayList<String>) episodeGuidePage
                .itemsFromHamburgerMenuAreHyperlinks();
        System.out.println(actualElementsAreHyperLinks);

        Assert.assertTrue(actualElementsAreHyperLinks.containsAll(expectedElementsAreHyperLinks));
    }

    @Test
    public void closeHamburgerMenu() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnHamburgerMenu()
                .clickCloseHamburgerMenu();
        boolean shouldBeTrue = episodeGuidePage.closeHamburgerMenu();
        Assert.assertTrue(shouldBeTrue);
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
        boolean test = actualWatchPreview && actualStreamButton;
        Assert.assertTrue(test);
    }

    @Test
    public void streamThisEpisodeStartYourFreeTrialPopupIsDisplayed() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnStreamThisEpisode();
        boolean openPopupModule = startYourFreeTrialPopupModule.startYourFreeTrialPopupModuleDisplayed();
        Assert.assertTrue(openPopupModule);
    }

    @Test
    public void closePopupModule() {
        episodeGuidePage.openEpisodeGuidePage()
                .acceptAllCookies()
                .clickOnStreamThisEpisode()
                .visibilityOfPopupModule();
        startYourFreeTrialPopupModule.closeStartYourFreeTrialPopupModule();

        Assert.assertTrue(startYourFreeTrialPopupModule.waitToPopupDisappear());
    }
//
//    @Test
//    public void testLog() {
//        log.info("!!!!!!!!!!!test log");
//    }

}
