package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//Проверка успешной авторизации пользователя на сайте]

public class Login extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"auth_login\"]")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id=\"auth_password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    private WebElement submit;

    public Login(WebDriver driver) {
        super(driver);
    }


    public void loginIn(String login, String password){
       Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(this.inputLogin, login).click(this.inputPassword).sendKeys(password).click(submit).build().perform();
}
}

