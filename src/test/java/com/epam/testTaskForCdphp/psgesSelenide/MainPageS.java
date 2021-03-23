package com.epam.testTaskForCdphp.psgesSelenide;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageS extends BasePageS {

    private String pageUrl = "https://www.onliner.by/";

    public MainPageS(Logger log) {
        super(log);
    }


    public MainPageS openPage() {
        log.info("*** Open page: " + pageUrl);
        open(pageUrl);
        log.info("*** Main page is opened");
        return this;
    }

    public SearchPopupS enterTextIntoSearchArea(String text) {
        $(".fast-search__input").setValue(text);
        return new SearchPopupS(log);
    }
}
