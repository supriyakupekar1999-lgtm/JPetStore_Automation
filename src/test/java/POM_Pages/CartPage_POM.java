package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;


public class CartPage_POM extends BasePage {


    WebDriverWait wait;


    public CartPage_POM(WebDriver driver) {

        super(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }



    @FindBy(name = "addToCart")
    private WebElement addCart;



    @FindBy(name = "remove")
    private WebElement remove;



    @FindBy(name = "checkout")
    private WebElement checkout;



    public void addItem() {


        wait.until(
                ExpectedConditions.elementToBeClickable(addCart)
        ).click();


    }



    public void removeItem() {


        wait.until(
                ExpectedConditions.elementToBeClickable(remove)
        ).click();


    }



    public void goToCheckout() {


        wait.until(
                ExpectedConditions.elementToBeClickable(checkout)
        ).click();


    }


}
