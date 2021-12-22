package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MenuPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"header-menu\"]/div/div[1]/div[1]/ul/li[4]/a")
    private WebElement town;

    public MenuPage(WebDriver driver) {
        super(driver);
    }


    public void navigateTown() {
        this.town.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.urlContains("https://www.e1.ru/text/gorod/"));
    }

}

