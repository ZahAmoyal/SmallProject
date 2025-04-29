package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {

    // =============================
    // Attributes (private locators for page elements)
    // =============================
    // Locator for locating the "Add to Cart" buttons for inventory items
    private By addToCartButtons = By.cssSelector(".inventory_item button.btn_inventory");
    // Locator for the shopping cart icon, used for navigating to the Cart page
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    // Locator for the inventory list (assumed to represent the list of product items)
    private By inventoryList = By.className("inventory_list");

    // =============================
    // Constructor
    // =============================
    // Constructor passes the WebDriver instance to the BasePage constructor
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    // =============================
    // Methods
    // =============================
    // Method to add the first three products from the inventory
    public void addFirstThreeProducts(){
        // Retrieve all buttons matching the "add to cart" locator
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        // Loop through the first three buttons (or less if not enough products)
        for (int i = 0; i < 3 && i < buttons.size(); i++){
            buttons.get(i).click();  // Click each button to add the corresponding product to the cart
        }
    }

    // Method to navigate to the Cart page by clicking on the cart icon
    public void goToCart(){
        click(cartIcon);
    }

    // Method to verify that the inventory page has loaded successfully
    public boolean isPageLoaded(){
        try {
            // Check if the inventory list element is displayed on the page
            return driver.findElement(inventoryList).isDisplayed();
        } catch (Exception e) {
            // Return false if the element is not found or any exception occurs
            return false;
        }
    }
}
