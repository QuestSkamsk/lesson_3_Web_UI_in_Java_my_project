package org.example;

import ch.qos.logback.classic.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class lesson4AppTest {

    static WebDriver webDriver;

    @BeforeAll
            static void setDriver(){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito"); //режим инкогнито
            //options.addArguments("--headless"); //без запуска браузера
            options.addArguments("--kiosk"); //запуск в максимальном окне
            options.setPageLoadTimeout(Duration.ofSeconds(10));
            webDriver = new ChromeDriver(options); //определение вебдрайвера
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://meatfish.cafe"), "Страница не доступна");
    }

    @Test
    void test1(){
        WebElement webElement = webDriver.findElement(By.xpath("")); // найти элемент
        webElement.click(); // кликнуть на элемент
        webDriver.findElement(By.xpath("")).click(); // найти элемент и кликнуть на него

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.xpath("1 элемент"))).click(webElement)
                .sendKeys(webDriver.findElement(By.xpath("2 элемент"))).sendKeys(webElement, "23123").build().perform();

    }

    @AfterEach
    void exit(){
        webDriver.quit();
    }




}
