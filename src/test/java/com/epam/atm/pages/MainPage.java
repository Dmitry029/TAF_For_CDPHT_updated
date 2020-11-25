package com.epam.atm.pages;

import com.epam.atm.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private String pageUrl = "https://www.onliner.by/";

    public MainPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public MainPage openPage() {
        log.info("*** Open page: " + pageUrl);
        openUrl(pageUrl);
        log.info("*** Page opened.");
        return this;
    }
}
