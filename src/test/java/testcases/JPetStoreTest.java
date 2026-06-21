package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPage_POM;
import POM_Pages.HomePage_POM;
import POM_Pages.LoginPage_POM;
import POM_Pages.ProductPage_POM;
import POM_Pages.RegistrationPage_POM;
import Utility_Files.Excel_Utility;
import helper.BaseTest;

public class JPetStoreTest extends BaseTest {

    @Test(priority = 1)
    public void verifyRegistration() throws Exception {

        wd.findElement(By.linkText("Register Now!")).click();

        RegistrationPage_POM reg =
                new RegistrationPage_POM(wd);

        String path = System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData.xlsx";

        String userId =
                Excel_Utility.getCellData(path,"RegistrationData",1,0);

        String password =
                Excel_Utility.getCellData(path,"RegistrationData",1,1);

        String firstName =
                Excel_Utility.getCellData(path,"RegistrationData",1,2);

        String lastName =
                Excel_Utility.getCellData(path,"RegistrationData",1,3);

        String email =
                Excel_Utility.getCellData(path,"RegistrationData",1,4);

        String phone =
                Excel_Utility.getCellData(path,"RegistrationData",1,5);

        String address1 =
                Excel_Utility.getCellData(path,"RegistrationData",1,6);

        String address2 =
                Excel_Utility.getCellData(path,"RegistrationData",1,7);

        String city =
                Excel_Utility.getCellData(path,"RegistrationData",1,8);

        String state =
                Excel_Utility.getCellData(path,"RegistrationData",1,9);

        String zip =
                Excel_Utility.getCellData(path,"RegistrationData",1,10);

        String country =
                Excel_Utility.getCellData(path,"RegistrationData",1,11);

        reg.registerUser(
                userId,
                password,
                firstName,
                lastName,
                email,
                phone,
                address1,
                address2,
                city,
                state,
                zip,
                country);
        Thread.sleep(2000);
    }
    
    @Test(priority = 2)
    public void verifyLogin() throws Exception {

        String excelPath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData.xlsx";

        String username =
                Excel_Utility.getCellData(excelPath, "LoginData", 1, 0);

        String password =
                Excel_Utility.getCellData(excelPath, "LoginData", 1, 1);

        LoginPage_POM login = new LoginPage_POM(wd);

        login.login(username, password);
        Thread.sleep(2000);
        Assert.assertTrue(wd.getPageSource().contains("Welcome"));
    }
    
    @Test(priority = 3)
    public void verifyFishCategory() throws Exception {

    	String excelPath =
    	        System.getProperty("user.dir")
    	        + "\\src\\test\\resources\\TestData.xlsx";

    	String username =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 0);

    	String password =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 1);

    	LoginPage_POM login = new LoginPage_POM(wd);
    	
    	login.login(username, password);

        HomePage_POM home = new HomePage_POM(wd);
               home.clickFish();
        Thread.sleep(2000);

        System.out.println("Fish Category Opened");
    }
    @Test(priority = 4)
    public void verifyAddToCart() throws Exception {

    	String excelPath =
    	        System.getProperty("user.dir")
    	        + "\\src\\test\\resources\\TestData.xlsx";

    	String username =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 0);

    	String password =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 1);

    	LoginPage_POM login = new LoginPage_POM(wd);
    	
    	login.login(username, password);

        HomePage_POM home = new HomePage_POM(wd);
               home.clickFish();
               Thread.sleep(2000);

        ProductPage_POM product = new ProductPage_POM(wd);
               product.selectAngelfish();
               Thread.sleep(2000);

        CartPage_POM cart = new CartPage_POM(wd);
                cart.addItem();
                Thread.sleep(2000);

        System.out.println("Product Added To Cart");
    }
    @Test(priority = 5)
    public void verifyRemoveFromCart() throws Exception {

    	String excelPath =
    	        System.getProperty("user.dir")
    	        + "\\src\\test\\resources\\TestData.xlsx";

    	String username =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 0);

    	String password =
    	        Excel_Utility.getCellData(excelPath, "LoginData", 1, 1);

    	LoginPage_POM login = new LoginPage_POM(wd);
    	 Thread.sleep(1000);
    	login.login(username, password);

        HomePage_POM home = new HomePage_POM(wd);
        
        home.clickFish();
        Thread.sleep(1000);

        ProductPage_POM product = new ProductPage_POM(wd);
                product.selectAngelfish();
        Thread.sleep(1000);

        CartPage_POM cart = new CartPage_POM(wd);
        Thread.sleep(1000);
        cart.addItem();
                cart.removeItem(); 
        Thread.sleep(1000);
        System.out.println("Item Removed");
    }

    @Test(priority = 6)
    public void endToEndFlow() throws Exception {

        String excelPath =
                System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData.xlsx";

        String username =
                Excel_Utility.getCellData(excelPath, "ProductData", 1, 0);

        String password =
                Excel_Utility.getCellData(excelPath, "ProductData", 1, 1);

        String category =
                Excel_Utility.getCellData(excelPath, "ProductData", 1, 2);

        String productId =
                Excel_Utility.getCellData(excelPath, "ProductData", 1, 3);

        LoginPage_POM login = new LoginPage_POM(wd);
        Thread.sleep(1000);
        login.login(username, password);

        HomePage_POM home = new HomePage_POM(wd);
        Thread.sleep(1000);
        if (category.equalsIgnoreCase("Fish")) {
        	
            home.clickFish();
        } else if (category.equalsIgnoreCase("Dogs")) {
            home.clickDogs();
        } else if (category.equalsIgnoreCase("Cats")) {
            home.clickCats();
        } else if (category.equalsIgnoreCase("Birds")) {
            home.clickBirds();
        } else if (category.equalsIgnoreCase("Reptiles")) {
            home.clickReptiles();
        }

        ProductPage_POM product = new ProductPage_POM(wd);
        Thread.sleep(1000);
        if (productId.equalsIgnoreCase("FI-SW-01")) {
            product.selectAngelfish();
        } else if (productId.equalsIgnoreCase("FI-SW-02")) {
            product.selectTigerShark();
        } else if (productId.equalsIgnoreCase("K9-BD-01")) {
            product.selectBulldog();
        }

        CartPage_POM cart = new CartPage_POM(wd);
        Thread.sleep(1000);
        cart.addItem();
        Thread.sleep(1000);
        cart.goToCheckout();

        CheckoutPage_POM checkout = new CheckoutPage_POM(wd);
        Thread.sleep(1000);
        checkout.continueCheckout();
        Thread.sleep(1000);
        checkout.confirmOrder();
        Thread.sleep(1000);
        String msg = checkout.getSuccessMessage();
       
        Assert.assertTrue(msg.contains("Thank you"));

        System.out.println("===== TEST PASSED =====");
    }
}
