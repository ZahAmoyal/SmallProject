package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.*;

public class LoginPageTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // Create a LoginPage object and perform login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Create an InventoryPage object to verify that the inventory page is loaded after login
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load after valid login");

        // Use the getFirstElement() function (inherited from BasePage) to retrieve the first product element.
        // Here, we assume that the locator for product elements is ".inventory_item".
        WebElement firstProduct = inventoryPage.getFirstElement(By.cssSelector(".inventory_item"));

        // Verify that the first product element is not null, ensuring that at least one product exists
        Assert.assertNotNull(firstProduct, "No product element was found on the inventory page");

        // Print the text of the first product for debugging purposes
        System.out.println("First product text: " + firstProduct.getText());
    }


    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "invalid_password");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "לא הוצגה הודעת שגיאה עבור התחברות שגויה");
    }
}
