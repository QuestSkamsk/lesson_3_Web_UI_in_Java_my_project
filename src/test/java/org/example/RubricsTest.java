package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RubricsTest extends AbstractTest {


    @Test
    void rubricsTest(){
        new MainPage(getWebDriver()).navigateAllNews();
        //Assertions.assertTrue(webDriver.findElement(By.xpath("/*[@class=\"_37QcR EPoQi bBlrx\"]")).getText().equals("Rubrics"));
        //не работает проверка, элемента на странице
        new AllNewsPage(getWebDriver()).Rubrics();//тест падает
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@style=\"width: 36px; height: 36px;\"]")).getText().equals("On the page"));


    }

}

