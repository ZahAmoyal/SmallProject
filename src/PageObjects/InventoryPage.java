package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {

    // =============================
    // Attributes (private locators for page elements)
    // =============================
    private By addToCartButtons = By.cssSelector(".inventory_item button.btn_inventory");
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    private By inventoryList = By.className("inventory_list");

    // =============================
    // Constructor
    // =============================
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    public void addFirstThreeProducts(){
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < 3 && i < buttons.size(); i++){
            buttons.get(i).click();
        }
    }

    public void goToCart(){
        click(cartIcon);
    }

    public boolean isPageLoaded(){
        try {
            return driver.findElement(inventoryList).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
