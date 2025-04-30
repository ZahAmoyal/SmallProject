package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.CheckOutPage;

public class CheckOutPageTest extends BaseTest {

    @Test
    public void testFillCheckoutInformation() {
        checkOutPage.fillInformation("צח", "אמויאל", "300");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two"),
                "Navigation to the next page after filling out the checkout information failed. Current URL: " + currentUrl);
    }
}
