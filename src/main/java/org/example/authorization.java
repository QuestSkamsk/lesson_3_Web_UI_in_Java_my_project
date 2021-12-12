package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Проверка успешной авторизации пользователя на сайте]

public class authorization {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito"); //режим инкогнито
        //options.addArguments("--headless"); //без запуска браузера
        options.addArguments("start-maximized"); //запуск в максимальном окне


        WebDriver driver = new ChromeDriver(options); //определение вебдрайвера

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //ожидание

        driver.get("https://meatfish.cafe");
        WebElement buttonEntrance = driver.findElement(By.xpath("//*[@id=\"header-container\"]/div[1]/div[5]/button")); //найти кнопку войти
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(buttonEntrance)); //ожидание появления элемента
        buttonEntrance.click(); //кликнуть по кнопке входа

        WebElement typePhone = driver.findElement(By.xpath("//*[@placeholder=\"+7\"]")); //найти поле телефон
        typePhone.click(); //кликнуть на поле телефон
        typePhone.sendKeys("9046415872"); //ввести в поле телеон

        WebElement typePassword = driver.findElement(By.xpath("//*[@type=\"password\"]")); //найти поле пароль
        typePassword.click(); //кликнуть на поле пароль
        typePassword.sendKeys("qwe12345"); //ввести в поле пароль

        WebElement buttonEntrance1= driver.findElement(By.xpath("//*[@class=\"btn-primary btn-block mb-3\"]")); //найти кнопку войти
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(buttonEntrance1)); //ожидание появления элемента
        buttonEntrance1.click(); //кликнуть по кнопке входа


        driver.quit(); //закрыть
    }
}
