package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // =============================
    // Attributes (private locators)
    // =============================
    // Locator for the checkout button on the Cart page
    private By checkoutButton = By.id("checkout");

    // =============================
    // Constructor
    // =============================
    // Constructor that passes the WebDriver instance to the BasePage constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    // Method to click the checkout button, initiating the checkout process
    public void clickCheckout(){
        click(checkoutButton);
    }
}
