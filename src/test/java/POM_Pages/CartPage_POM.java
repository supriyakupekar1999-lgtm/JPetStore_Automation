package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;


public class CartPage_POM extends BasePage {


    public CartPage_POM(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//input[@name='submit'][@value='Add to Cart']")
    private WebElement addCart;


    @FindBy(xpath="//input[@value='Remove']")
    private WebElement remove;


    public void addItem() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));


        wait.until(
                ExpectedConditions.elementToBeClickable(addCart)
        ).click();

    }



    public void removeItem() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));


        wait.until(
                ExpectedConditions.elementToBeClickable(remove)
        ).click();

    }

}
