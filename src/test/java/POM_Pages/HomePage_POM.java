package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;


public class HomePage_POM extends BasePage {


    WebDriverWait wait;


    public HomePage_POM(WebDriver driver){

        super(driver);

        wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    }



    public void clickFish(){


        wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath("//img[contains(@src,'sm_fish.gif')]"))
        ).click();


    }



    public void clickDogs(){


        wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath("//img[contains(@src,'sm_dogs.gif')]"))
        ).click();


    }



    public void clickCats(){


        wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath("//img[contains(@src,'sm_cats.gif')]"))
        ).click();


    }



    public void clickBirds(){


        wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath("//img[contains(@src,'sm_birds.gif')]"))
        ).click();


    }



    public void clickReptiles(){


        wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath("//img[contains(@src,'sm_reptiles.gif')]"))
        ).click();


    }


}
