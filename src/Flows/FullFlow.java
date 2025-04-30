package Flows;

import Tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FullFlow extends BaseTest {

    @Test
    public void testFullCheckoutFlow() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load after login");
        inventoryPage.addFirstThreeProducts();
        inventoryPage.goToCart();
        cartPage.clickCheckout();
        checkOutPage.fillInformation("צח", "אמויאל", "300");
        completePage.finishCheckout();
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "Order confirmation was not displayed");
    }
}
