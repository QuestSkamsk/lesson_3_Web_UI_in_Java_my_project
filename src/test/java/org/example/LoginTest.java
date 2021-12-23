package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;


public class LoginTest extends AbstractTest {

    @Test
    void LoginTest(){
        new MainPage(getWebDriver()).buttonEnter();
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"auth_login\"]")).getText().equals(""));
        new Login(getWebDriver()).loginIn("266968743", "Qwer1234!");
        Assertions.assertTrue(webDriver.findElement(By.xpath("//*[@style=\"width: 36px; height: 36px;\"]")).isDisplayed());
    }
}

