package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // =============================
    // Attributes (private locators)
    // =============================
    private By checkoutButton = By.id("checkout");

    // =============================
    // Constructor
    // =============================
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    public boolean isCartPageLoaded() {
        try {
            return driver.findElement(By.xpath("//span[text()='Your Cart']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCheckout(){
        click(checkoutButton);
    }
}
