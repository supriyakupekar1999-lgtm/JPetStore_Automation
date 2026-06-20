package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.BasePage;

public class HomePage_POM extends BasePage {

    public HomePage_POM(WebDriver driver) {
        super(driver);
    }

    public void clickFish() {

        System.out.println("Inside clickFish");

        driver.findElement(
                By.xpath("//img[contains(@src,'sm_fish.gif')]"))
                .click();

        System.out.println("Fish clicked");
    }

    public void clickDogs() {

        System.out.println("Inside clickDogs");

        driver.findElement(
                By.xpath("//img[contains(@src,'sm_dogs.gif')]"))
                .click();

        System.out.println("Dogs clicked");
    }

    public void clickReptiles() {

        System.out.println("Inside clickReptiles");

        driver.findElement(
                By.xpath("//img[contains(@src,'sm_reptiles.gif')]"))
                .click();

        System.out.println("Reptiles clicked");
    }

    public void clickCats() {

        System.out.println("Inside clickCats");

        driver.findElement(
                By.xpath("//img[contains(@src,'sm_cats.gif')]"))
                .click();

        System.out.println("Cats clicked");
    }

    public void clickBirds() {

        System.out.println("Inside clickBirds");

        driver.findElement(
                By.xpath("//img[contains(@src,'sm_birds.gif')]"))
                .click();

        System.out.println("Birds clicked");
    }
}