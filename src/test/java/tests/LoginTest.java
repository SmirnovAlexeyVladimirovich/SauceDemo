package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest
{

    @Test
    public void successfulLogin() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title, "Products", "User isn't logged in");

}

    @Test
    public void userNameIsRequired() {
        loginPage.openLoginPage();
        loginPage.login("", "");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username is required", "Wrong error message");
    }

    @Test
    public void passwordIsRequired() {
        loginPage.openLoginPage();
        loginPage.login("standard_user", "");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Password is required", "Wrong error message");
    }

    @Test
    public void lockedOutUser() {
        loginPage.openLoginPage();
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Sorry, this user has been locked out.",
                "Wrong error message");
    }
}
