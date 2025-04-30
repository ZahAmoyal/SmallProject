package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    // =============================
    // Attributes
    // =============================
    private By firstNameField = By.id("first-name");
    private By lastNameField  = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton  = By.id("continue");
    // =============================
    // Constructor
    // =============================
    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    public void fillInformation(String firstName, String lastName, String postalCode){
        writeText(firstNameField, firstName);
        writeText(lastNameField, lastName);
        writeText(postalCodeField, postalCode);
        click(continueButton);
    }
}
