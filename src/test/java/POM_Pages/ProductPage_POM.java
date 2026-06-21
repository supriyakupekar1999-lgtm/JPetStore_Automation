package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import helper.BasePage;

public class ProductPage_POM extends BasePage {


    public ProductPage_POM(WebDriver wd) {
        super(wd);
    }


    @FindBy(linkText="Angelfish")
    WebElement angelfish;


    @FindBy(linkText="Tiger Shark")
    WebElement tigerShark;


    @FindBy(linkText="Bulldog")
    WebElement bulldog;



    public void selectAngelfish()
    {
        waitForElement(angelfish);
        angelfish.click();
    }



    public void selectTigerShark()
    {
        waitForElement(tigerShark);
        tigerShark.click();
    }



    public void selectBulldog()
    {
        waitForElement(bulldog);
        bulldog.click();
    }



    public void waitForElement(WebElement element)
    {
        new org.openqa.selenium.support.ui.WebDriverWait(
                wd,
                java.time.Duration.ofSeconds(20)
        ).until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

}
