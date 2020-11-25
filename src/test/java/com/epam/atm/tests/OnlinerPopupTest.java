package com.epam.atm.tests;

import com.epam.atm.pages.MainPage;
import com.epam.atm.utils.TestUtilities;
import org.testng.annotations.Test;

public class OnlinerPopupTest extends TestUtilities {

    @Test
    public void popupTest(){
        new MainPage(driver, log).openPage();
    }
}
