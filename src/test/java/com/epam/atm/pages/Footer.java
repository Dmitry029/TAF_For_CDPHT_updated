package com.epam.atm.pages;

import com.epam.atm.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class Footer extends BasePage {

    @FindBy(css = "[class*=button_fb]")
    WebElement facebookLink;


    public Footer(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void switchToFacebook() {
        facebookLink.click();
        switchToWindowWithTitle("Onliner - Home | Facebook");
    }
}
