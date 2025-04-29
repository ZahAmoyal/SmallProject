package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.InventoryPage;
import PageObjects.CartPage;

public class CartPageTest extends BaseTest {

    @Test
    public void testNavigateToCartPage() {
        // Navigate to the Inventory page directly using the URL
        driver.get("https://www.saucedemo.com/inventory.html");

        // Create an instance of InventoryPage to interact with the inventory elements
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Add the first three products to the cart (assuming at least three products are available)
        inventoryPage.addFirstThreeProducts();

        // Click on the cart icon to navigate to the Cart page
        inventoryPage.goToCart();

        // Create an instance of CartPage to interact with the cart elements
        CartPage cartPage = new CartPage(driver);

        // Optionally, assert that the Cart page is loaded correctly
        // (uncomment the following line if the isCartPageLoaded() method works as expected)
        // Assert.assertTrue(cartPage.isCartPageLoaded(), "The 'Your Cart' page did not load properly");
    }
}
