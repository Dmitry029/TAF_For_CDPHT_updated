package com.epam.atm.tests;

import com.epam.atm.pages.MainPage;
import com.epam.atm.pages.SearchPopup;
import com.epam.atm.utils.TestUtilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SearchPopupTest extends TestUtilities {

    @Test(priority = 1)
    public void verifyAllResultsContainSearchedText() {
        String searchProduct = "Amazone Дуб Престиж";
        boolean result = new MainPage(driver, log)
                .openPage()
                .enterTextIntoSearchArea(searchProduct)
                .ifAllResultsContainText(searchProduct);
        assertTrue(result);
    }

    @Test(priority = 2)
    public void verifyPopupIsClosed() {
        SearchPopup searchPopup = new SearchPopup(driver, log);
        assertTrue(searchPopup.isPopUpClosed());
        searchPopup.closePopup();
        assertFalse(searchPopup.isPopUpClosed());
    }
}