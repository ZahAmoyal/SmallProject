package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.InventoryPage;

public class InventoryPageTest extends BaseTest {

    @Test
    public void testAddFirstThreeProducts() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addFirstThreeProducts();
    }
}
