package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    // ====================================
    // Attributes (private locators)
    // ====================================
    // Locator for the confirmation message element on the payment/confirmation page.
    private By confirmationMessage = By.cssSelector(".complete-header");

    // ====================================
    // Constructor
    // ====================================
    // Constructor that passes the WebDriver instance to the BasePage constructor.
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // ====================================
    // Methods
    // ====================================
    // Checks whether the confirmation message is displayed on the page.
    // Returns true if the element is displayed, otherwise returns false.
    public boolean isConfirmationDisplayed() {
        try {
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            // If the confirmation message is not found or any exception occurs, return false.
            return false;
        }
    }
}
