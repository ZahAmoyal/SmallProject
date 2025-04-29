package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.HashMap;
import java.util.Map;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver;

    public static void setupBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AsusX514/IdeaProjects/SmallProject/src/Data/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // Disable the Chrome Password Manager popup
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--remote-allow-origins=*");
        // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();

    }

    @BeforeClass
    public void setup() {
        setupBrowser();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
