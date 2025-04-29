package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    // ===============================
    // Attributes
    // ===============================
    protected WebDriver driver;         // The WebDriver instance used for interacting with the browser
    protected WebDriverWait wait;       // WebDriverWait is used to wait for conditions (e.g., element visibility)

    // ===============================
    // Constructor
    // ===============================
    public BasePage(WebDriver driver) {
        // Initialize the WebDriver attribute with the passed driver
        this.driver = driver;
        // Initialize the WebDriverWait attribute with a 60-second timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // ===============================
    // Methods
    // ===============================

    // Wait until the element is visible on the page
    public void waitVisibility(By by) {
        try {
            // Introduce a short delay before waiting (beneficial for dynamic content)
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Wait until the specified element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Click on an element specified by its locator
    public void click(By elementLocation) {
        // Wait until the element is visible before clicking
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    // Write text into an input field or any element that accepts text
    public void writeText(By elementLocation, String text) {
        // Wait until the text field is visible
        waitVisibility(elementLocation);
        WebElement field = driver.findElement(elementLocation);
        field.clear();           // Clear any existing text
        field.sendKeys(text);    // Write the text into the field
    }

    // Ensure the element is selected; if not, click it to select
    public void selected(By elementLocation) {
        // Wait until the element is visible
        waitVisibility(elementLocation);
        if (!driver.findElement(elementLocation).isSelected()) {
            click(elementLocation);
        }
    }

    // Check if the element is displayed on the page
    public boolean displayed(By elementLocation) {
        // Wait until the element is visible and then check its display status
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).isDisplayed();
    }

    // Get the text from an element specified by its locator
    public String getText(By elementLocation) {
        // Wait until the element is visible and then retrieve its text
        waitVisibility(elementLocation);
        return driver.findElement(elementLocation).getText();
    }

    // Get the text from a given WebElement and print it to the console
    public String getElementText(WebElement element) {
        System.out.println(element.getText());
        return element.getText();
    }

    // Return the first element from a list of elements that match the locator
    public WebElement getFirstElement(By by) {
        // Find all elements that match the locator
        List<WebElement> elements = driver.findElements(by);
        if (!elements.isEmpty()) {
            // Print the text of the first found element (for debugging purposes)
            System.out.println(getElementText(elements.get(0)));
            // Return the first element
            return elements.get(0);
        } else {
            // Return null if no elements are found
            return null;
        }
    }
}
