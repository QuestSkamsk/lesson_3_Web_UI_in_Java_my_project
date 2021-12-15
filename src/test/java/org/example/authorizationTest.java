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

public class authorizationTest {
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
    void authorizationTest(){
        WebElement buttonEntrance = webDriver.findElement(By.xpath("//*[@id=\"header-container\"]/div[1]/div[5]/button")); // найти элемент
        buttonEntrance.click(); // кликнуть на элемент

        WebElement typePassword = webDriver.findElement(By.xpath("//*[@type=\"password\"]"));

        WebElement buttonEntrance1 = webDriver.findElement(By.xpath("//*[@class=\"btn-primary btn-block mb-3\"]"));

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.xpath("//*[@placeholder=\"+7\"]")), "9046415872").click(typePassword)
                .sendKeys(webDriver.findElement(By.xpath("//*[@type=\"password\"]")), "qwe12345")
                .click(buttonEntrance1).build().perform();

    }

    @AfterEach
    void exit(){
        webDriver.quit();
   }
}

