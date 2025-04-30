package Tests;

import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    @Test
    public void testAddFirstThreeProducts() {
        inventoryPage.addFirstThreeProducts();
    }
}
