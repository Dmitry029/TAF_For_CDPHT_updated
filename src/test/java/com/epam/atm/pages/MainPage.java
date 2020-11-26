package com.epam.atm.pages;

import com.epam.atm.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    private String pageUrl = "https://www.onliner.by/";

    @FindBy(css = ".fast-search__input")
    WebElement searchArea;


    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public MainPage openPage() {
        log.info("*** Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("*** Page opened.");
        return this;
    }

    public SearchPopup enterTextIntoSearchArea(String text) {
        searchArea.sendKeys(text);
        return new SearchPopup(driver, log);
    }
}
