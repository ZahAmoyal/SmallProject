package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CompletePageTest extends BaseTest {

    @Test
    public void testFinishCheckoutAndShowConfirmation() {
        completePage.finishCheckout();
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "אישור סיום ההזמנה לא הוצג");
    }
}
