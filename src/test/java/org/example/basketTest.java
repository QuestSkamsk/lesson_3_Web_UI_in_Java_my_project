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

public class basketTest {
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
    void basketTest(){
        WebElement sets = webDriver.findElement(By.xpath("//div[@class=\"menu-wrapper\"]/ul/li/a[@href=\"/catalog/seti/\"]"));
        sets.click();
        WebElement inBasket = webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/div/div/div[2]/a"));
        inBasket.click();
        WebElement inBasket1 = webDriver.findElement(By.xpath("//*[@class=\"btn-add px-5\"]"));
        inBasket1.click();
        WebElement inBasket2 = webDriver.findElement(By.xpath("//*[@class=\"icon-cart flaticon-shopping-cart\"]"));
        inBasket2.click();
        WebElement checkout = webDriver.findElement(By.xpath("//*[@class=\"btn-primary px-5\"]"));
        checkout.click();

        Actions actions = new Actions(webDriver);
        actions.sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[1]/div/div[1]/label/input")), "Иван")
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[1]/div/div[2]/label/input")), "9046415872")
                .sendKeys(webDriver.findElement(By.xpath("//*[@placeholder=\"Улица\"]")), "Соликамск, Кузнецова В.И.")
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[3]/div/div[2]/label/input")), "4")
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[3]/div/div[5]/label/input")), "5")
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[3]/div/div[4]/label/input")), "6")
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[3]/div/div[6]/label/input")), "7")
                .click(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[6]/textarea")))
                .sendKeys(webDriver.findElement(By.xpath("//div/div/main/div[3]/div[2]/div[1]/form/section[6]/textarea")), "Тест")
                .moveToElement(webDriver.findElement(By.xpath("//*[@class=\"btn-primary btn-block\"]")))
                .build().perform();

    }

    @AfterEach
    void exit(){
        webDriver.quit();
    }
}
