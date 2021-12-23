package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

//Проверка успешной авторизации пользователя на сайте]

public class Login extends AbstractPage {

    /*@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div[6]/div/form/div[1]/div/input")
    private WebElement email;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div[6]/div/form/div[2]/div/input")
    private WebElement Password;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div[6]/div/form/div[3]/input")
    private WebElement submit1;*/


    @FindBy(xpath = "//*[@id=\"auth_login\"]")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id=\"auth_password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[3]/div/div/div[2]/div/form/button")
    private WebElement submit;

    public Login(WebDriver driver) {
        super(driver);
    }


    public void loginIn(String login, String password) {
        Actions loginIn = new Actions(getDriver());
        loginIn.sendKeys(this.inputLogin, login).click(this.inputPassword).sendKeys(password).click(submit).build().perform();
    }
}

