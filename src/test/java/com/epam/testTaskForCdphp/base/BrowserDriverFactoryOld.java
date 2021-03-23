package com.epam.testTaskForCdphp.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

public class BrowserDriverFactoryOld {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;

    public BrowserDriverFactoryOld(Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver getDriver() {
        if (null == driver.get()) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    public WebDriver createDriver() {
        log.info("*** Create driver: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
        }
        return driver.get();
    }
}
