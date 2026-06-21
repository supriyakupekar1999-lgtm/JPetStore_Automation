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
                By.xpath("//img[contains(@src,'sm_fish.gif')]")
        ).click();

        System.out.println("Fish clicked");
    }

}
