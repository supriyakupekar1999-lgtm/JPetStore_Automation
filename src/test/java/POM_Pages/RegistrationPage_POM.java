package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class RegistrationPage_POM extends BasePage {

    public RegistrationPage_POM(WebDriver driver) {
        super(driver);
    }

    @FindBy(name="username")
    WebElement userId;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="repeatedPassword")
    WebElement repeatPassword;

    @FindBy(name="account.firstName")
    WebElement firstName;

    @FindBy(name="account.lastName")
    WebElement lastName;

    @FindBy(name="account.email")
    WebElement email;

    @FindBy(name="account.phone")
    WebElement phone;

    @FindBy(name="account.address1")
    WebElement address1;

    @FindBy(name="account.address2")
    WebElement address2;

    @FindBy(name="account.city")
    WebElement city;

    @FindBy(name="account.state")
    WebElement state;

    @FindBy(name="account.zip")
    WebElement zip;

    @FindBy(name="account.country")
    WebElement country;

    @FindBy(name="newAccount")
    WebElement saveAccount;

    public void registerUser(
            String uid,
            String pwd,
            String fname,
            String lname,
            String mail,
            String ph,
            String add1,
            String add2,
            String cty,
            String st,
            String zp,
            String cntry) {

        userId.sendKeys(uid);
        password.sendKeys(pwd);
        repeatPassword.sendKeys(pwd);

        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        email.sendKeys(mail);
        phone.sendKeys(ph);

        address1.sendKeys(add1);
        address2.sendKeys(add2);

        city.sendKeys(cty);
        state.sendKeys(st);
        zip.sendKeys(zp);
        country.sendKeys(cntry);

        saveAccount.click();
    }
}
