package org.wikipedia.en.automation.web.page;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.wikipedia.en.automation.web.Constant.ENV_URL;

public class ArticlePage {

    private static final int EMPTY_SIZE = 0;
    private static final String ATTRIBUTE_LINK = "href";
    private final String castXpath = "//*[@id='Cast']/ancestor::*/following-sibling::*[1]/self::ul//li/a";

    public void openWikipediaArticlePageByPartOfLink(final String partOfLink) {
        open(format("%s%s", ENV_URL, partOfLink));
    }

    public List<String> getListLinksOfActorsLinkForCurrentMovie() {

        return $$x(castXpath)
                .shouldHave(sizeGreaterThan(EMPTY_SIZE))
                .stream().map(e -> e.attr(ATTRIBUTE_LINK))
                .collect(toList())
                ;
    }
}
