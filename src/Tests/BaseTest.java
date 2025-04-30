package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
// ייבא את מחלקות העמודים כפי שהן מוגדרות אצלך, לדוגמה:
import PageObjects.LoginPage;
import PageObjects.InventoryPage;
import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.CompletePage;
import PageObjects.PaymentPage;

import java.util.HashMap;
import java.util.Map;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;

    // הגדרת אובייקטי העמודים שיהיו נגישים לכל המחלקות היורשות
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected CompletePage completePage;
    protected PaymentPage paymentPage;

    // אתחול ה-driver
    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AsusX514/IdeaProjects/SmallProject/src/Data/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();

        // ביטול הפופאפ של ניהול סיסמאות
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);

        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("disable-popup-blocking");
        // במידה ורוצים להריץ headless:
        // chromeOptions.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void setup() {
        setupBrowser();
        // ניתן לטעון עמוד ראשי כלשהו, למשל:
        driver.get("https://www.saucedemo.com/");
    }

    /**
     * פונקציה זו מאתחלת את כל עמודי הבדיקה (Page Objects)
     * והיא תופעל לפני כל טסט, כדי לוודא שאנו עובדים עם מופעים עדכניים.
     */
    public void initializing() {
        loginPage     = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage      = new CartPage(driver);
        checkOutPage  = new CheckOutPage(driver);
        completePage  = new CompletePage(driver);
        paymentPage   = new PaymentPage(driver);
    }

    @BeforeMethod
    public void initPages() {
        initializing();
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        if (driver != null) {
            driver.quit();
        }
    }
}
