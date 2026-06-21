package POM_Pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;


public class ProductPage_POM extends BasePage {


WebDriverWait wait;



public ProductPage_POM(WebDriver driver){

super(driver);

wait=new WebDriverWait(driver,Duration.ofSeconds(20));

}



@FindBy(xpath="//a[text()='FI-SW-01']")
WebElement Angelfish;



@FindBy(xpath="//a[text()='FI-SW-02']")
WebElement tigerShark;



@FindBy(xpath="//a[text()='K9-BD-01']")
WebElement Bulldog;




public void selectAngelfish(){


wait.until(
ExpectedConditions.elementToBeClickable(Angelfish)
).click();


}



public void selectTigerShark(){


wait.until(
ExpectedConditions.elementToBeClickable(tigerShark)
).click();


}



public void selectBulldog(){


wait.until(
ExpectedConditions.elementToBeClickable(Bulldog)
).click();


}


}
