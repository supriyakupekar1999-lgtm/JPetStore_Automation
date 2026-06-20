package POM_Pages;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class LoginPage_POM extends BasePage {

    WebDriverWait wait;

    public LoginPage_POM(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "signon")
    private WebElement loginBtn;

    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOf(username));

        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        loginBtn.click();

    }
}

    