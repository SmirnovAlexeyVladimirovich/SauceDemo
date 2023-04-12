package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public static String CHECKOUT_STEP_ONE = BASE_URL + "/checkout-step-one.html";
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By FINISH_BUTTON = By.id("finish");

    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        wait.until(ExpectedConditions.textToBe(TITLE, "Checkout: Your Information"));
    }

    @Step("Open checkout Page")
    public void openCheckoutPage() {
        driver.get(CHECKOUT_STEP_ONE);
    }

        public void checkoutFillInFields(String firstName, String lastName, String zipCode) {
            driver.findElement(FIRST_NAME).sendKeys(firstName);
            driver.findElement(LAST_NAME).sendKeys(lastName);
            driver.findElement(ZIP_CODE).sendKeys(zipCode);
            //driver.findElement(CONTINUE_BUTTON).click();
            //driver.findElement(FINISH_BUTTON).click();
        }

        public void checkoutContinueButton() {
            driver.findElement(CONTINUE_BUTTON).click();
        }

        public void checkoutFinishButton() {
            driver.findElement(FINISH_BUTTON).click();
        }

}
