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

public class deliveryTest {
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
    void deliveryTest(){
        WebElement delivery = webDriver.findElement(By.xpath("//div/div/header/nav[1]/div[2]/div/ul/li[3]/a"));
        delivery.click();

        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(By.xpath("//div/div/main/div[3]/h1"))).build().perform();

    }

    @AfterAll
    public static void exit() {
        if (webDriver !=null)webDriver.quit();
    }
}

