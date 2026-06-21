package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
        wait.until(
            org.openqa.selenium.support.ui.ExpectedConditions
            .elementToBeClickable(angelfish)
        );

        angelfish.click();
    }



    public void selectTigerShark()
    {
        wait.until(
            org.openqa.selenium.support.ui.ExpectedConditions
            .elementToBeClickable(tigerShark)
        );

        tigerShark.click();
    }



    public void selectBulldog()
    {
        wait.until(
            org.openqa.selenium.support.ui.ExpectedConditions
            .elementToBeClickable(bulldog)
        );

        bulldog.click();
    }

}
