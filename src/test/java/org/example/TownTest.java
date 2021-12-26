package org.example;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;

public class TownTest extends AbstractTest {


    @Test
    @Epic("Переход в рубрику из основного меню")
    void TownTest() {
        new MainPage(getWebDriver()).buttonMenu();
        new MenuPage(getWebDriver()).navigateTown();
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.e1.ru/text/gorod/"), "Страница не доступна");
    }
}


