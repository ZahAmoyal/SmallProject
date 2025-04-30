package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // =============================
    // Attributes (private locators)
    // =============================
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton   = By.id("login-button");
    private By errorMessage  = By.cssSelector("h3[data-test='error']");

    // =============================
    // Constructor
    // =============================
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
