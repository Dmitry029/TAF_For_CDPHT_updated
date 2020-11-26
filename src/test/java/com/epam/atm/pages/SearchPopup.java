package com.epam.atm.pages;

import com.epam.atm.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPopup extends BasePage {

    @FindBy(css = ".modal-iframe")
    WebElement searchFrame;

    @FindBy(css = "a.product__title-link")
    List<WebElement> searchResults;

    @FindBy(css = ".search__close")
    WebElement closeSearch;

    @FindBy(css = "#search-page")
    List<WebElement> searchPage;


    public SearchPopup(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public boolean ifAllResultsContainText(String text) {
        switchToFrame(searchFrame);
        return searchResults
                .stream().map(WebElement::getText)
                .allMatch(element -> element.contains(text));
    }

    public void closePopup() {
        closeSearch.click();
        switchToTop();
    }

    public boolean isPopUpClosed() {
        return searchPage.size() > 0 && searchPage.get(0).isDisplayed();
    }
}
