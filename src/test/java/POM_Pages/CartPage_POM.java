package POM_Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;



public class CartPage_POM extends BasePage {


    WebDriverWait wait;



    public CartPage_POM(WebDriver driver) {

        super(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }




    public void addItem() {


        wait.until(

            ExpectedConditions.elementToBeClickable(

                By.xpath("//input[@value='Add to Cart']")

            )

        ).click();


    }




    public void removeItem() {


        wait.until(

            ExpectedConditions.elementToBeClickable(

                By.xpath("//input[@value='Remove']")

            )

        ).click();


    }




    public void goToCheckout() {


        wait.until(

            ExpectedConditions.elementToBeClickable(

                By.xpath("//input[@value='Proceed to Checkout']")

            )

        ).click();


    }


}
