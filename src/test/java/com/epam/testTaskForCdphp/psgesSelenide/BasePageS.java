package com.epam.testTaskForCdphp.psgesSelenide;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePageS {
    public Logger log;

    public BasePageS(Logger log) {
        this.log = log;
    }

    /**
     * Switch to iFrame using it's locator
     */
    protected void switchToFrame(WebElement element) {
        getWebDriver().switchTo().frame(element);
    }

    /**
     * Switch to top (default content)
     */
    protected void switchToTop() {
        getWebDriver().switchTo().defaultContent();
    }

    public void switchToWindowWithTitle(String expectedTitle) {
        WebDriver driver = getWebDriver();
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (title().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }

    /**
     * Perform scroll to the bottom
     */
    public void scrollToBottom() {
        log.info("*** Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getWebDriver();
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
