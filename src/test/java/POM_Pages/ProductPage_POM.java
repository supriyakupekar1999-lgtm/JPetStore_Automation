package POM_Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;



public class ProductPage_POM extends BasePage {


    WebDriverWait wait;


    public ProductPage_POM(WebDriver driver) {

        super(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }



    public void selectAngelfish() {


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'FI-SW-01')]")
            )
        ).click();


    }




    public void selectTigerShark() {


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'FI-SW-02')]")
            )
        ).click();


    }





    public void selectBulldog() {


        wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'K9-BD-01')]")
            )
        ).click();


    }



}
