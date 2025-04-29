package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    // =============================
    // Attributes
    // =============================
    private By firstNameField = By.id("first-name");  // Locator for the first name input field
    private By lastNameField  = By.id("last-name");   // Locator for the last name input field
    private By postalCodeField = By.id("postal-code"); // Locator for the postal code input field
    private By continueButton  = By.id("continue");    // Locator for the continue button on the checkout page

    // =============================
    // Constructor
    // =============================
    // Constructor passes the WebDriver instance to the BasePage constructor
    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    // Fills in the checkout information (first name, last name, postal code)
    // and clicks the continue button to proceed to the next step
    public void fillInformation(String firstName, String lastName, String postalCode){
        writeText(firstNameField, firstName);   // Enter the first name in the corresponding field
        writeText(lastNameField, lastName);       // Enter the last name in the corresponding field
        writeText(postalCodeField, postalCode);   // Enter the postal code in the corresponding field
        click(continueButton);                    // Click the continue button to proceed
    }
}
