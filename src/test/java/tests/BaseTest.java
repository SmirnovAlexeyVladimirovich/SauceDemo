package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            if(System.getProperty("headless", "true").equals("true"));
            options.addArguments("--start-maximized");
            //System.setProperty("web-driver.chrome.driver", "src/test/resources/chromedriver");
            //driver = new RemoteWebDriver(options);
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            driver = new EdgeDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    { if (driver != null) {
        driver.quit();
        }
    }
}
