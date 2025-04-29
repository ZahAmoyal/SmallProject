package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.PaymentPage;

public class PaymentPageTest extends BaseTest {

    @Test
    public void testPaymentConfirmationDisplayed() {
        // Direct navigation to the confirmation page is assumed (e.g., the URL "checkout-complete.html" is used in the test setup)
        // Create an instance of PaymentPage to interact with the confirmation elements
        PaymentPage paymentPage = new PaymentPage(driver);

        // Assert that the confirmation message is displayed on the page
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "הודעת האישור לא הוצגה");
    }
}
