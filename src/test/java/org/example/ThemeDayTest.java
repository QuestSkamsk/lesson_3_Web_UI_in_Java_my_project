package org.example;

import org.junit.jupiter.api.*;

public class ThemeDayTest extends AbstractTest  {

    @Test
    void clickThemeDay(){
        new MainPage(getWebDriver()).navigateToThemeDay();
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.e1.ru/text/criminal/2021/12/23/70336136/"), "Страница не доступна");
    }

}
