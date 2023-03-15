package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        cartPage.checkout();
    }

    @Test
    public void removeProduct() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.openCart();
        productsPage.removeFromCart("Sauce Labs Backpack");
    }
}
