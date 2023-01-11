package com.annadach;

import com.annadach.page.YandexMainPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.annadach.page.YandexMainPage.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SimpleCallBack.class)
public class ParallelTest {

    private YandexMainPage page = new YandexMainPage();

    @ValueSource(strings = {
            "simbirsoft",
            "selenide",
            "qameta",
            "allure"
    })
    @ParameterizedTest(name = "{0} test")
    void yandexSearchTest(String searchQuery, TestInfo testInfo) {
        Configuration.startMaximized = true;
        open(URL);
        page.doSearch(searchQuery).checkResults(searchQuery);
        System.out.println("Config for test: " + testInfo.getDisplayName() + " " + Configuration.startMaximized);
    }

    @DisplayName("JDI test")
    @Test
    void minimizedWindowTest(TestInfo testInfo) {
        Configuration.startMaximized = false;
        open(URL);
        page.doSearch("JDI").checkResults("JDI");
        System.out.println("Config for test: " + testInfo.getDisplayName() + " " + Configuration.startMaximized);
    }
}
