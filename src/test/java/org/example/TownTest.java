package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TownTest extends AbstractTest {


    @Test
    void TownTest() {
        new MainPage(getWebDriver()).buttonMenu();
        //Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"header-menu\"]/div/div[1]/div[1]/h3")).getText().equals("Rubrics"));
        //не работает проверка, элемента
        new MenuPage(getWebDriver()).navigateTown(); // нет перехода
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"left_column\"]/noindex[1]/div/section/div[1]/div[1]/a")).getText().equals("On the page"));
        //тест падает

    }
}


