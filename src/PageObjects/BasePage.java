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
    protected WebDriver driver;
    protected WebDriverWait wait;

    // ===============================
    // Constructor
    // ===============================
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // ===============================
    // Methods
    // ===============================

    public void waitVisibility(By by) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Click on an element specified by its locator
    public void click(By elementLocation) {
        waitVisibility(elementLocation);
        driver.findElement(elementLocation).click();
    }

    // Write text into an input field or any element that accepts text
    public void writeText(By elementLocation, String text) {
        waitVisibility(elementLocation);
        WebElement field = driver.findElement(elementLocation);
        field.clear();
        field.sendKeys(text);
    }

    // Get the text from a given WebElement and print it to the console
    public String getElementText(WebElement element) {
        System.out.println(element.getText());
        return element.getText();
    }

    // Return the first element from a list of elements that match the locator
    public WebElement getFirstElement(By by) {
        List<WebElement> elements = driver.findElements(by);
        if (!elements.isEmpty()) {
            System.out.println(getElementText(elements.get(0)));
            return elements.get(0);
        } else {
            return null;
        }
    }
}
