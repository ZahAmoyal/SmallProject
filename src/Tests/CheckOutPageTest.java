package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.CheckOutPage;

public class CheckOutPageTest extends BaseTest {

    @Test
    public void testFillCheckoutInformation() {
        // Create an instance of CheckOutPage to interact with the checkout form
        CheckOutPage checkoutPage = new CheckOutPage(driver);

        // Fill out the checkout information using the provided first name, last name, and postal code
        checkoutPage.fillInformation("צח", "אמויאל", "300");

        // After clicking Continue, verify that the URL has changed to include "checkout-step-two"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout-step-two"),
                "Navigation to the next page after filling out the checkout information failed. Current URL: " + currentUrl);
    }
}
