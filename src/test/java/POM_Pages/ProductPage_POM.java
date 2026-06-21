package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class ProductPage_POM extends BasePage {


    WebDriver driver;


    public ProductPage_POM(WebDriver wd) {
        super(wd);
        this.driver = wd;
    }



    @FindBy(xpath="//a[contains(text(),'FI-SW-01')]")
    WebElement angelfish;



    @FindBy(xpath="//a[contains(text(),'FI-SW-02')]")
    WebElement tigerShark;



    @FindBy(xpath="//a[contains(text(),'K9-BD-01')]")
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
        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        java.time.Duration.ofSeconds(20)
                );


        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

}
