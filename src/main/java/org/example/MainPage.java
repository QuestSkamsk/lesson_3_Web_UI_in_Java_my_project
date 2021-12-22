package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@class=\"_2C6ph _2SEMU _1F48C\"]")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/noindex[1]/div/a/div/span[1]")
    private WebElement themeDay;

    @FindBy(xpath = "//*[@id=\"left_column\"]/noindex[1]/div/section/div[1]/div[1]/a/div")
    private WebElement allNews;

    @FindBy(xpath = "//*[@data-test=\"menu-btn-open\"]")
    private WebElement buttonMenu;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public void buttonEnter() {
        buttonEnter.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(buttonEnter));
   }
    public void navigateToThemeDay() {
        this.themeDay.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(themeDay));
    }

    public void navigateAllNews() {
        this.allNews.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.urlContains("https://www.e1.ru/text/"));
    }

    public void buttonMenu() {
        buttonMenu.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(buttonMenu));
    }
}
