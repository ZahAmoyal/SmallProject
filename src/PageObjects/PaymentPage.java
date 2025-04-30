package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

    // ====================================
    // Attributes (private locators)
    // ====================================
    private By confirmationMessage = By.cssSelector(".complete-header");

    // ====================================
    // Constructor
    // ====================================
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // ====================================
    // Methods
    // ====================================

    public boolean isConfirmationDisplayed() {
        try {
            return driver.findElement(confirmationMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
