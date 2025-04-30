package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.*;

public class LoginPageTest extends BaseTest {

    @Test
    public void testValidLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load after valid login");
        WebElement firstProduct = inventoryPage.getFirstElement(By.cssSelector(".inventory_item"));
        Assert.assertNotNull(firstProduct, "No product element was found on the inventory page");
        System.out.println("First product text: " + firstProduct.getText());
    }

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("invalid_user", "invalid_password");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "לא הוצגה הודעת שגיאה עבור התחברות שגויה");
    }
}
