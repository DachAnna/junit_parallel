package com.annadach.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {

    public static final String URL = "https://ya.ru/";

    private SelenideElement searchInput = $("#text");
    private SelenideElement searchButton = $("button[type='submit']");

    public YandexResultsPage doSearch(String searchQuery) {
        searchInput.setValue(searchQuery);
        searchButton.click();
        return new YandexResultsPage();
    }
}
