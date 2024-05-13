import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomatedTest {
    protected static WebDriver driver;
    protected static final String username = "seleniumtestuser@mailinator.com";
    protected static final String password = "test98125!";

    protected static final String baseURL = "arsiv.mackolik.com/Default.aspx";

    protected static SeleniumApsUtil seleniumApsUtil;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        seleniumApsUtil = new SeleniumApsUtil(driver);
        try {
            // Reklam geç butonuna tıkla (örneğin, id'si "skip-ad" olan bir öğe varsayalım)
            WebElement skipAdButton = driver.findElement(By.id("percent"));
            if(skipAdButton != null) {
                skipAdButton.click();
                System.out.println("Reklam geçildi.");
            } else {
                System.out.println("Reklam geç butonu bulunamadı.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Reklam geç butonu bulunamadı.");
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
