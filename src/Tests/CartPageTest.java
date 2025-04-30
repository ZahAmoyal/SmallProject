package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void testNavigateToCartPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        inventoryPage.addFirstThreeProducts();
        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isCartPageLoaded(), "The 'Your Cart' page did not load properly");
    }
}
