package com.epam.testTaskForCdphp.psgesSelenide;

import com.epam.testTaskForCdphp.base.BasePage;
import com.epam.testTaskForCdphp.pages.AlertWithTip;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class DescriptionPageS extends BasePageS {

    public DescriptionPageS(Logger log) {
        super(log);
    }

    public AlertWithTipS openProductTip(String text) {
        String locator = String.format("//td[contains(text(),'%s')]/div/span", text);
        $(By.xpath(locator)).click();
        log.info("*** Product tip is opened");
        return new AlertWithTipS(log);
    }
}
