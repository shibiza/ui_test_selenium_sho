package org.example.stepDefinitions;

import org.example.pageObject.pages.EpisodeGuidePage;
import org.junit.Assert;
import org.junit.Test;

public class EpisodeGuidePageTest extends BaseSteps {

    EpisodeGuidePage episodeGuidePage = new EpisodeGuidePage(webDriver);
    String episodeTitle = "Homeland - Season 5 Episode 1, Separation Anxiety | SHOWTIME";

    @Test
    public void episodePageIsLoaded() {
        EpisodeGuidePage episodeGuidePageActual = episodeGuidePage.waitForPageLoadAndTitleContains();
        Assert.assertEquals(episodeTitle, episodeGuidePageActual);
    }

    @Test
    public void episodePageIsLoadedAndTitleContains(){
        episodeGuidePage.waitForPageLoadAndTitleContains(episodeTitle);
    }
}
