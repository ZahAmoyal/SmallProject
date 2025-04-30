package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    // =============================
    // Attributes
    // =============================
    private By finishButton = By.id("finish");

    // =============================
    // Constructor
    // =============================
    public CompletePage(WebDriver driver){
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    public void finishCheckout(){
        click(finishButton);
    }
}
