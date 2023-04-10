package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    String addToCartXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'inventory_item')]//button";
    String removeFromCartXpath = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item')]//button";

    public static final By CART = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Check if page is opened")
    public void isPageOpened() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        wait.until(ExpectedConditions.textToBe(TITLE, "Products"));
    }

    @Step("Add product to cart")
    public void addToCart(String product) {
        By addToCartLocator = By.xpath(String.format(addToCartXpath, product));
        driver.findElement(addToCartLocator).click();
    }

    @Step("Open cart page")
    public void openCart() {
        driver.findElement(CART).click();
    }

    @Step("Remove product from cart")
    public void removeFromCart(String product) {
        By removeFromCartLocator = By.xpath(String.format(removeFromCartXpath, product));
        driver.findElement(removeFromCartLocator).click();
    }
}
