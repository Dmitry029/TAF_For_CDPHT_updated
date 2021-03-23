package com.epam.testTaskForCdphp.psgesSelenide;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AlertWithTipS extends BasePageS {

    public AlertWithTipS(Logger log) {
        super(log);
    }

    public String getTipTitle(String text) {
        String locator = String.format("//td[contains(text(),'%s')]//p[@class='product-tip__term']", text);
        return $(By.xpath(locator)).getText();
    }

    public boolean isAlertWithTipDisplayed() {
        return $$(".product-tip__term").stream().anyMatch(WebElement::isDisplayed);
    }

    public AlertWithTipS closeAlert() {
        $(".product-specs__title").click();
        return this;
    }
}
