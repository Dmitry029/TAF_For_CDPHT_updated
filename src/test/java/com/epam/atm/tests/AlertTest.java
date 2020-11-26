package com.epam.atm.tests;

import com.epam.atm.pages.AlertWithTip;
import com.epam.atm.pages.MainPage;
import com.epam.atm.utils.TestUtilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AlertTest extends TestUtilities {

    @Test(priority = 1)
    public void verifyAlertWithTheGivenTextIsDisplayed() {
        String searchProduct = "Amazone Дуб Престиж";
        String searchTipForDescription = "Класс нагрузки";
        String expectedTipTitle = "Класс нагрузки";

        String actualTipTitle = new MainPage(driver, log)
                .openPage()
                .enterTextIntoSearchArea(searchProduct)
                .selectSearchResultByNumber(1)
                .openProductTip(searchTipForDescription)
                .getTipTitle(searchTipForDescription);
        assertTrue(actualTipTitle.contains(expectedTipTitle));
    }

    @Test(priority = 2)
    public void verifyPopupIsClosed() {
        AlertWithTip alertWithTip = new AlertWithTip(driver, log);
        assertTrue(alertWithTip.isAlertWithTipDisplayed());
        alertWithTip.closeAlert();
        assertFalse(alertWithTip.isAlertWithTipDisplayed());
    }
}
