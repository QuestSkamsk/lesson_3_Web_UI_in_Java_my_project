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

public class ThemeDayTest extends AbstractTest  {

    @Test
    void clickThemeDay(){
        new MainPage(getWebDriver()).navigateToThemeDay();
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"record-header\"]/div/div[2]/p/text()")).getText().equals("To share"));
        //тест зависает и падает по таймауту
    }

}
