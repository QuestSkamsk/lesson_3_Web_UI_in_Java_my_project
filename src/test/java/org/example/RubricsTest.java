package org.example;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;


public class RubricsTest extends AbstractTest {


    @Test
    @Epic("Переход в рубрику")
    void rubricsTest(){
        new MainPage(getWebDriver()).navigateAllNews();
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.e1.ru/text/"), "Страница не доступна");
        new AllNewsPage(getWebDriver()).Rubrics();
        Assertions.assertTrue(webDriver.getCurrentUrl().equals("https://www.e1.ru/text/?rubric=auto"), "Страница не доступна");
    }

}

