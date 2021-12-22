package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginTest extends AbstractTest {

    @Test
    void LoginTest(){
        new MainPage(getWebDriver()).buttonEnter();
        //Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@type=\"submit\"]")).getText().equals("Sing in"));
        //не работает проверка, что открыта модалка для входа
        new Login(getWebDriver()).loginIn("266968743", "Qwer1234!");
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@style=\"width: 36px; height: 36px;\"]")).getText().equals("Your account"));
        //тест падает


    }


}

