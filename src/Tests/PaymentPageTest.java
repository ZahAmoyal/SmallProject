package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentPageTest extends BaseTest {

    @Test
    public void testPaymentConfirmationDisplayed() {
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "הודעת האישור לא הוצגה");
    }
}
