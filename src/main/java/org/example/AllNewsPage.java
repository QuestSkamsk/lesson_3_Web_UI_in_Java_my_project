package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllNewsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/form/div/div[1]")
    private WebElement allRubrics;

    @FindBy(xpath = "//*[@value=\"auto\"]")
    private WebElement autoRubrics;

    @FindBy(xpath = "/*[@class=\"_37QcR EPoQi bBlrx\"]")
    private WebElement apply;

    public AllNewsPage(WebDriver driver) {
        super(driver);
    }

    public void Rubrics() {
        Actions rubrics = new Actions(getDriver());
        rubrics.click(allRubrics).click(autoRubrics).click(apply).build().perform();
    }
}
