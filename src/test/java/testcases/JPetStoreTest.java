package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPage_POM;
import POM_Pages.HomePage_POM;
import POM_Pages.LoginPage_POM;
import POM_Pages.ProductPage_POM;
import POM_Pages.RegistrationPage_POM;
import helper.BaseTest;



public class JPetStoreTest extends BaseTest {


    @Test
    public void verifyLogin() {


        LoginPage_POM login = new LoginPage_POM(wd);


        login.enterUsername("j2ee");

        login.enterPassword("j2ee");

        login.clickLogin();



        Assert.assertTrue(
                wd.getTitle().contains("JPetStore")
        );

    }



    @Test
    public void verifyFishCategory() {


        HomePage_POM home = new HomePage_POM(wd);


        home.clickFish();



        Assert.assertTrue(
                wd.getTitle().contains("JPetStore")
        );


    }



    @Test
    public void verifyAddToCart() {


        HomePage_POM home = new HomePage_POM(wd);

        ProductPage_POM product =
                new ProductPage_POM(wd);

        CartPage_POM cart =
                new CartPage_POM(wd);



        home.clickFish();


        product.clickAngelfish();


        cart.addItem();



    }




    @Test
    public void verifyRemoveFromCart() {


        HomePage_POM home = new HomePage_POM(wd);


        ProductPage_POM product =
                new ProductPage_POM(wd);


        CartPage_POM cart =
                new CartPage_POM(wd);



        home.clickFish();


        product.clickAngelfish();


        cart.addItem();


        cart.removeItem();



    }





    @Test
    public void endToEndFlow() {



        LoginPage_POM login =
                new LoginPage_POM(wd);



        HomePage_POM home =
                new HomePage_POM(wd);



        ProductPage_POM product =
                new ProductPage_POM(wd);



        CartPage_POM cart =
                new CartPage_POM(wd);



        CheckoutPage_POM checkout =
                new CheckoutPage_POM(wd);




        // Login

        login.enterUsername("j2ee");

        login.enterPassword("j2ee");

        login.clickLogin();




        // Select Fish

        home.clickFish();



        // Select Product

        product.clickAngelfish();




        // Add Cart

        cart.addItem();




        // Checkout

        checkout.clickCheckout();



    }

}
