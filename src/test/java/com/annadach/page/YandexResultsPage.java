package com.annadach.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class YandexResultsPage {

    private ElementsCollection results = $$(".serp-item");

    public void checkResults(String searchQuery) {
        $$(".serp-item").shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(Condition.text(searchQuery));
    }
}