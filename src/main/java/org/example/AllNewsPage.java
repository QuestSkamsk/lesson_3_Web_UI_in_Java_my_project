package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AllNewsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[2]/form/div/div[1]/div/select")
    private WebElement allRubrics;


    @FindBy(xpath = "//*[@class=\"_37QcR EPoQi bBlrx\"]")
    private WebElement apply;

    public AllNewsPage(WebDriver driver) {
        super(driver);
    }

    public void Rubrics() {
        Actions rubrics = new Actions(getDriver());
        Select selectRubrucs = new Select(allRubrics);
        rubrics.click(allRubrics);
        selectRubrucs.selectByValue("auto");
                rubrics.click(apply)
                .build().perform();
    }

}
