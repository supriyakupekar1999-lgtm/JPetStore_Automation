package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class ProductPage_POM extends BasePage {


    public ProductPage_POM(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//*[@id='Catalog']//a[text()='FI-SW-01']")
    private WebElement Angelfish;


    @FindBy(xpath = "//*[@id='Catalog']//a[text()='FI-SW-02']")
    private WebElement tigerShark;


    @FindBy(xpath = "//*[@id='Catalog']//a[text()='K9-BD-01']")
    private WebElement Bulldog;



    // method required by your JPetStoreTest
    public void clickFishProduct(){

        Angelfish.click();

    }



    public void selectAngelfish() {

        Angelfish.click();

    }



    public void selectTigerShark() {

        tigerShark.click();

    }



    public void selectBulldog() {

        Bulldog.click();

    }

}
