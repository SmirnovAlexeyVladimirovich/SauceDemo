package tests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest
{

    @Test(description = "Check if user can log in")//, retryAnalyzer = Retry.class)//, invocationCount = 5)
    public void successfulLogin() {
        loginPage.openLoginPage();
        loginPage.login(USER, PASSWORD);
        String title = productsPage.getTitle();
        assertEquals(title, "Products", "User isn't logged in");

}

    @DataProvider(name = "Входящие данные для негативных тестов на логин")
    public Object[][] getDataForLogin() {
        return new Object[][]{
                {"standard_user1", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},

        };
    }

    @Test(description = "Negative Login", dataProvider = "Входящие данные для негативных тестов на логин")
    public void unsuccessfulLogin(String username, String password, String expectedError) {
        loginPage.openLoginPage();
        loginPage.login(username, password);
        String error = loginPage.getErrorMessage();
        assertEquals(error, expectedError,
                "Wrong error message");
    }
}
