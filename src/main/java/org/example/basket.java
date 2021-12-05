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

//Проверка, что заказ добавляется в карзиру.

public class basket {
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
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(buttonEntrance)); //ожидание поялвения элемента
        buttonEntrance.click(); //кликнуть по кнопке входа

        WebElement typePhone = driver.findElement(By.xpath("//*[@placeholder=\"+7\"]")); //найти поле телефон
        typePhone.click(); //кликнуть на поле телефон
        typePhone.sendKeys("9046415872"); //ввести в поле телеон

        WebElement typePassword = driver.findElement(By.xpath("//*[@type=\"password\"]")); //найти поле пароль
        typePassword.click(); //кликнуть на поле пароль
        typePassword.sendKeys("qwe12345"); //ввести в поле пароль

        WebElement buttonEntrance1 = driver.findElement(By.xpath("//*[@class=\"btn-primary btn-block mb-3\"]")); //найти кнопку войти
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(buttonEntrance1)); //ожидание поялвения элемента
        buttonEntrance1.click(); //кликнуть по кнопке входа

        WebElement buttonClose = driver.findElement(By.xpath("//*[@class=\"btn-close\"]")); //найти кнопку закрыть
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(buttonClose)); //ожидание поялвения элемента
        buttonClose.click(); //кликнуть по кнопке закрыть

        WebElement pizza = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/header/nav[2]/div/div/div[1]/div/ul/li[3]/a")); //найти ссылку пицца
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(pizza)); //ожидание поялвения элемента
        pizza.click(); //кликнуть по ссылке пицца

        WebElement pizzaMargarita = driver.findElement(By.xpath("//*[@href=\"/product/101784631\"]")); //найти ссылку на маргариту
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(pizzaMargarita)); //ожидание поялвения элемента
        pizzaMargarita.click(); //кликнуть по ссылке на маргариту

        WebElement addToCart = driver.findElement(By.xpath("//*[@class=\"btn-add px-5\"]")); //найти кнопку в корзину
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(addToCart)); //ожидание поялвения элемента
        addToCart.click(); //кликнуть по кнопке в корзину

        WebElement basket = driver.findElement(By.xpath("//*[@class=\"basket\"]")); //найти кнопку корзина
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(basket)); //ожидание поялвения элемента
        basket.click(); //кликнуть по корзине
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__layout\"]/div/div/main/div[3]/div/div[1]/div/div/div[1]/div/div[2]/div[1]"))); //в корзине пицца маргарита


        //driver.quit(); //закрыть
    }
}

