package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // =============================
    // Attributes (private locators)
    // =============================
    // Locator for the username input field
    private By usernameField = By.id("user-name");
    // Locator for the password input field
    private By passwordField = By.id("password");
    // Locator for the login button
    private By loginButton   = By.id("login-button");
    // Locator for the error message displayed on invalid login attempts
    private By errorMessage  = By.cssSelector("h3[data-test='error']");

    // =============================
    // Constructor
    // =============================
    // Constructor that passes the WebDriver instance to the BasePage constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    // Method to perform login by entering the provided username and password,
    // then clicking the login button.
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Method to check if the error message is displayed on the page,
    // which indicates a failed login attempt.
    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
