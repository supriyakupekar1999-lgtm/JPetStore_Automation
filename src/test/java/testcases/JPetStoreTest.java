package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPage_POM;
import POM_Pages.HomePage_POM;
import POM_Pages.LoginPage_POM;
import POM_Pages.ProductPage_POM;
import helper.BaseTest;



public class JPetStoreTest extends BaseTest {


    @Test
    public void verifyLogin() {


        LoginPage_POM login = new LoginPage_POM(wd);


        login.setUsername("j2ee");


        login.setPassword("j2ee");


        login.clickSignOn();



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



        HomePage_POM home =
                new HomePage_POM(wd);



        ProductPage_POM product =
                new ProductPage_POM(wd);



        CartPage_POM cart =
                new CartPage_POM(wd);




        home.clickFish();



        product.clickFishProduct();



        cart.addItem();



    }





    @Test
    public void verifyRemoveFromCart() {



        HomePage_POM home =
                new HomePage_POM(wd);



        ProductPage_POM product =
                new ProductPage_POM(wd);



        CartPage_POM cart =
                new CartPage_POM(wd);




        home.clickFish();



        product.clickFishProduct();



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

        login.setUsername("j2ee");


        login.setPassword("j2ee");


        login.clickSignOn();





        // Select Fish

        home.clickFish();





        // Select Product

        product.clickFishProduct();





        // Add to cart

        cart.addItem();





        // Checkout

        checkout.clickConfirm();



    }


}
