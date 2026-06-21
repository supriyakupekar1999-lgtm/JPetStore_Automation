package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class CheckoutPage_POM extends BasePage {


    WebDriverWait wait;


    public CheckoutPage_POM(WebDriver driver) {

        super(driver);

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }



    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueBtn;



    @FindBy(xpath = "//a[contains(text(),'Confirm')]")
    private WebElement confirmBtn;



    @FindBy(xpath = "//*[contains(text(),'Thank you')]")
    private WebElement successMsg;




    public void continueCheckout() {


        wait.until(
                ExpectedConditions.elementToBeClickable(continueBtn)
        ).click();


    }





    public void confirmOrder() {


        WebElement confirm = wait.until(

                ExpectedConditions.elementToBeClickable(confirmBtn)

        );


        try {


            confirm.click();


        } catch (Exception e) {


            JavascriptExecutor js =
                    (JavascriptExecutor) driver;


            js.executeScript(
                    "arguments[0].click();",
                    confirm
            );


        }


    }





    // method required by your JPetStoreTest
    public void clickConfirm() {


        confirmOrder();


    }






    public String getSuccessMessage() {


        return wait.until(

                ExpectedConditions.visibilityOf(successMsg)

        ).getText();


    }



}
