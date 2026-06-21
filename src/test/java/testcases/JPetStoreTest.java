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
                country
        );

        Thread.sleep(2000);
    }



    @Test(priority = 2, dependsOnMethods="verifyRegistration")
    public void verifyLogin() throws Exception {


        String excelPath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\TestData.xlsx";


        String username =
                Excel_Utility.getCellData(excelPath, "LoginData", 1, 0);


        String password =
                Excel_Utility.getCellData(excelPath, "LoginData", 1, 1);


        LoginPage_POM login =
                new LoginPage_POM(wd);


        login.login(username, password);


        Thread.sleep(2000);


        Assert.assertTrue(
                wd.getPageSource().contains("Welcome")
        );
    }



    @Test(priority = 3, dependsOnMethods="verifyLogin")
    public void verifyFishCategory() throws Exception {


        HomePage_POM home =
                new HomePage_POM(wd);


        home.clickFish();


        Thread.sleep(2000);


        System.out.println("Fish Category Opened");
    }



    @Test(priority = 4, dependsOnMethods="verifyFishCategory")
    public void verifyAddToCart() throws Exception {


        ProductPage_POM product =
                new ProductPage_POM(wd);


        product.selectAngelfish();


        Thread.sleep(2000);


        CartPage_POM cart =
                new CartPage_POM(wd);


        cart.addItem();


        Thread.sleep(2000);


        System.out.println("Product Added To Cart");
    }



    @Test(priority = 5, dependsOnMethods="verifyAddToCart")
    public void verifyRemoveFromCart() throws Exception {


        CartPage_POM cart =
                new CartPage_POM(wd);


        cart.removeItem();


        Thread.sleep(1000);


        System.out.println("Item Removed");
    }



    @Test(priority = 6, dependsOnMethods="verifyRemoveFromCart")
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



        LoginPage_POM login =
                new LoginPage_POM(wd);


        login.login(username, password);



        HomePage_POM home =
                new HomePage_POM(wd);



        if(category.equalsIgnoreCase("Fish")) {

            home.clickFish();

        }



        ProductPage_POM product =
                new ProductPage_POM(wd);



        if(productId.equalsIgnoreCase("FI-SW-01")) {

            product.selectAngelfish();

        }



        CartPage_POM cart =
                new CartPage_POM(wd);


        cart.addItem();


        cart.goToCheckout();



        CheckoutPage_POM checkout =
                new CheckoutPage_POM(wd);



        checkout.continueCheckout();


        checkout.confirmOrder();



        String msg =
                checkout.getSuccessMessage();



        Assert.assertTrue(
                msg.contains("Thank you")
        );


        System.out.println("===== TEST PASSED =====");

    }

}
