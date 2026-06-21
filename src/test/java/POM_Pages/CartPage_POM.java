package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helper.BasePage;

public class CartPage_POM extends BasePage {

    public CartPage_POM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
    private WebElement addToCart;

    @FindBy(xpath = "//a[contains(text(),'Proceed to Checkout')]")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//a[contains(text(),'Remove')]")
    private WebElement removeItemBtn;

    public void addItem() {
        addToCart.click();
    }

    public void goToCheckout() {
        checkoutBtn.click();
    }

    public void removeItem() {
        removeItemBtn.click();
    }
}
