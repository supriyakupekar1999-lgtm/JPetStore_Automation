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



    @FindBy(xpath="//input[@value='Add to Cart']")
    private WebElement addCart;



    @FindBy(xpath="//input[@value='Remove']")
    private WebElement remove;



    @FindBy(xpath="//input[@value='Proceed to Checkout']")
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
