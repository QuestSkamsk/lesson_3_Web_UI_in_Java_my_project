package org.example;

import org.junit.jupiter.api.*;

public class TownTest extends AbstractTest {


    @Test
    void TownTest() {
        new MainPage(getWebDriver()).buttonMenu();
        new MenuPage(getWebDriver()).navigateTown();
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.e1.ru/text/gorod/"), "Страница не доступна");
    }
}


