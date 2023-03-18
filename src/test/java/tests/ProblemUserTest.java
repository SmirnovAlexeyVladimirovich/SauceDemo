package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProblemUserTest extends BaseTest {

    @Test(description = "Check if user can log in")
    public void successfulLogin() {
        loginPage.openLoginPage();
        loginPage.login(System.getProperty("user"), PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title, "Products", "User isn't logged in");
    }
}
