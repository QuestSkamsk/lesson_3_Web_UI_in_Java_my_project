package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends AbstractPage {
    @FindBy(xpath = "//*[@id=\"header-menu\"]/div/div[1]/div[1]/ul/li[4]/a")
    private WebElement town;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTown() {
        this.town.click();

    }

}

