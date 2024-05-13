import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomatedTest {
    protected static WebDriver driver;
    protected static final String baseURL = "https://www.mackolik.com/destek.aspx"; // Try the full URL

    protected static SeleniumApsUtil seleniumApsUtil;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--whitelisted-ips=''");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        seleniumApsUtil = new SeleniumApsUtil();
        driver.get(String.format("%s", baseURL));
        driver.manage().window().maximize();

        if (driver.getTitle().contains("Bize Ulaşın")) {
            System.out.println("Page loaded successfully. Assuming link is working.");
        } else {
            System.out.println("Warning: Page title does not contain 'Bize Ulaşın'. Link might have issues.");
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    public static void main(String[] args) {
        setUp();
    }
}
