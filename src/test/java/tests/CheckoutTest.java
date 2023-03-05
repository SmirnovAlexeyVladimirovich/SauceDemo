package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void successfulCheckout() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        checkoutPage.openCheckoutStepOnePage();
        checkoutPage.checkoutFillInFields("Aleksey", "Smirnov", "666666");
        checkoutPage.checkoutContinueButton();
        checkoutPage.checkoutFinishButton();
        String title = productsPage.getTitle();
        assertEquals(title, "Checkout: Complete!", "Unsuccessful checkout");
    }

    @Test
    public void firstNameIsRequired() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        checkoutPage.openCheckoutStepOnePage();
        checkoutPage.checkoutFillInFields("", "Smirnov", "666666");
        checkoutPage.checkoutContinueButton();
        String error = checkoutPage.getErrorMessage();
        assertEquals(error, "Error: First Name is required", "Wrong error message");
    }

    @Test
    public void lastNameIsRequired() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        checkoutPage.openCheckoutStepOnePage();
        checkoutPage.checkoutFillInFields("Aleksey", "", "666666");
        checkoutPage.checkoutContinueButton();
        String error = checkoutPage.getErrorMessage();
        assertEquals(error, "Error: Last Name is required", "Wrong error message");
    }

    @Test
    public void postalCodeIsRequired() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        checkoutPage.openCheckoutStepOnePage();
        checkoutPage.checkoutFillInFields("Aleksey", "Smirnov", "");
        checkoutPage.checkoutContinueButton();
        String error = checkoutPage.getErrorMessage();
        assertEquals(error, "Error: Postal Code is required", "Wrong error message");
    }
}
