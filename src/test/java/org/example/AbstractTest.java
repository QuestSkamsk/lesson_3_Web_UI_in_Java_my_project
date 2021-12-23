package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public abstract class AbstractTest {

    static WebDriver webDriver;

    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); //режим инкогнито
        //options.addArguments("--headless"); //без запуска браузера
        options.addArguments("--kiosk"); //запуск в максимальном окне
        options.setPageLoadTimeout(Duration.ofSeconds(60));
        webDriver = new ChromeDriver(options); //определение вебдрайвера
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("https://www.e1.ru/"), "Страница не доступна");
    }

    @AfterAll
    public static void exit(){
        if(webDriver !=null) webDriver.quit();
  }
    public WebDriver getWebDriver() { return this.webDriver;}

}
