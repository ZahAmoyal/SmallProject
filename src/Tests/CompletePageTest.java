package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.CompletePage;
import PageObjects.PaymentPage;

public class CompletePageTest extends BaseTest {

    @Test
    public void testFinishCheckoutAndShowConfirmation() {
        CompletePage completePage = new CompletePage(driver);
        completePage.finishCheckout();

        PaymentPage paymentPage = new PaymentPage(driver);
        Assert.assertTrue(paymentPage.isConfirmationDisplayed(), "אישור סיום ההזמנה לא הוצג");
    }
}
