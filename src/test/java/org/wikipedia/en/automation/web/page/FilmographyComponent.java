package org.wikipedia.en.automation.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class FilmographyComponent {

    private String movieXpath = "//*[@id='Filmography' or @id='Selected_filmography']/ancestor::*[name()='h2'" +
            "or name()='h3']/following-sibling::*//a[@href='%s']";

    public SelenideElement getMovieByPartOfLink(final String movie) {
        return $x(format(movieXpath, movie));
    }
}
