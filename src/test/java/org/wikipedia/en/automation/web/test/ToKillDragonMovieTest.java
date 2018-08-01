package org.wikipedia.en.automation.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.wikipedia.en.automation.web.page.ArticlePage;
import org.wikipedia.en.automation.web.page.FilmographyComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class ToKillDragonMovieTest extends BaseTest {

    private static final String TO_KILL_A_DRAGON = "/wiki/To_Kill_a_Dragon";

    @Parameter
    public String actorLink;

    @Parameters(name = "{index}: actor link {0}")
    public static Iterable<String> prepareData() {
        ArticlePage articlePage = new ArticlePage();
        articlePage.openWikipediaArticlePageByPartOfLink(TO_KILL_A_DRAGON);
        return articlePage.getListLinksOfActorsLinkForCurrentMovie();
    }

    @Test
    public void checkMovieInActorFilmography() {
        open(actorLink);
        FilmographyComponent filmographyComponent = new FilmographyComponent();
        assertThat(filmographyComponent
                .getMovieByPartOfLink(TO_KILL_A_DRAGON)
                .should(visible)
                .isDisplayed(), is(true))
        ;
    }

}
