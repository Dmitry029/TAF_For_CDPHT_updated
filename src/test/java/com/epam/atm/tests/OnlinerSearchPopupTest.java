package com.epam.atm.tests;

import com.epam.atm.pages.MainPage;
import com.epam.atm.pages.SearchPopup;
import com.epam.atm.utils.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerSearchPopupTest extends TestUtilities {

    @Test(priority = 1)
    public void verifyAllResultsContainSearchedText() {
        String searchText = "Amazone Дуб Престиж";

        boolean result = new MainPage(driver, log)
                .openPage()
                .enterTextIntoSearchArea(searchText)
                .ifAllResultsContainText(searchText);
        Assert.assertTrue(result);
    }

    @Test(priority = 2)
    public void verifyPopupIsClosed(){
        SearchPopup searchPopup = new SearchPopup(driver, log);

        Assert.assertTrue(searchPopup.isPopUpClosed());
        searchPopup.closePopup();
        Assert.assertFalse(searchPopup.isPopUpClosed());
     }
}
