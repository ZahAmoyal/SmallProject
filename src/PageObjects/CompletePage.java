package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    // =============================
    // Attributes (private locators for the Complete page)
    // =============================
    // Locator for the finish button on the checkout complete page
    private By finishButton = By.id("finish");

    // =============================
    // Constructor
    // =============================
    // Constructor that passes the WebDriver instance to the BasePage's constructor
    public CompletePage(WebDriver driver){
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    // Method to click the finish button, completing the checkout process
    public void finishCheckout(){
        click(finishButton);
    }
}
