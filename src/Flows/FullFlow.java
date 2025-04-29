package Flows;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.*;

public class FullFlow extends BaseTest {

    @Test
    public void testFullCheckoutFlow() {
        // Step 1: Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Step 2: Log in using valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 3: On the Inventory page, verify that the page is loaded
        // and add the first three products
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load after login");
        inventoryPage.addFirstThreeProducts();
        // Navigate to the Cart page by clicking on the cart icon
        inventoryPage.goToCart();

        // Step 4: On the Cart page, click the checkout button
        // (Optionally, assert that the "Your Cart" page is loaded)
        CartPage cartPage = new CartPage(driver);
        // Assert.assertTrue(cartPage.isCartPageLoaded(), "Your Cart page did not load properly");
        cartPage.clickCheckout();

        // Step 5: On the Checkout page (Step One), fill in the personal information
        CheckOutPage checkoutPage = new CheckOutPage(driver);
        checkoutPage.fillInformation("צח", "אמויאל", "300");

        // Step 6: On the Checkout Step Two page, finish the checkout process
        CompletePage completePage = new CompletePage(driver);
        completePage.finishCheckout();

        // Step 7: On the Confirmation page, verify that the order confirmation is displayed
        PaymentPage paymentPage = new PaymentPage(driver);
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "Order confirmation was not displayed");
    }
}
