package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void isPageOpened() {
        wait.until(ExpectedConditions.textToBe(TITLE, "Your Cart"));
    }

    public void checkout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

}
