package com.epam.testTaskForCdphp.psgesSelenide;

import com.epam.testTaskForCdphp.base.BasePage;
import com.epam.testTaskForCdphp.pages.DescriptionPage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPopupS extends BasePageS {
    private String searchFrame = ".modal-iframe";
    private String searchResults = "a.product__title-link";
    private String searchPage = "#search-page";


    public SearchPopupS(Logger log) {
        super(log);
    }

    public boolean ifAllResultsContainText(String text) {
        switchToFrame($(searchFrame));
        log.info("*** Search popup is opened");

        return $$(searchResults).stream().map(WebElement::getText)
                .allMatch(element -> element.contains(text));
    }

    public void closePopup() {
        $(".search__close").click();
        switchToTop();
        log.info("*** Search popup is closed");
    }

    public boolean isPopUpClosed() {

        return $$(searchPage).size() > 0 && $(searchPage, 0).isDisplayed();
    }

    public DescriptionPageS selectSearchResultByNumber(int number) {
        switchToFrame($(searchFrame));
        $(searchResults, number - 1).click();
        switchToTop();
        return new DescriptionPageS(log);
    }
}
