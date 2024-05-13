import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumApsUtil {
    protected static WebDriver driver;
    protected static final String username = "seleniumtestuser@mailinator.com";
    protected static final String password = "test98125!";

    protected static final String baseURL = "http://user.mackolik.com/UserPages/destek.aspx";

    protected static SeleniumApsUtil seleniumApsUtil;

        public static void main(String[] args) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--whitelisted-ips=''");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            seleniumApsUtil = new SeleniumApsUtil();
            driver.get(String.format("https://%s/login", baseURL));
            //important, otherwise elements might not be in the viewport, and you might get "element click intercepted" errors
            driver.manage().window().maximize();
//        seleniumApsUtil.clearAndEnterText("email", username);
//        seleniumApsUtil.clearAndEnterText("password", password);
            driver.findElement(By.id("loginButton")).click();

            System.setProperty("webdriver.chrome.driver", "<path/to/chromedriver>"); // Replace with your ChromeDriver path

            // Set headless mode (optional, comment out if you want to see the browser)
            ChromeOptions options1 = new ChromeOptions();
            options.addArguments("--headless");

            WebDriver driver = new ChromeDriver(options);

            try {
                String url = "http://user.mackolik.com/UserPages/destek.aspx";
                driver.get(url);

                // Check if the page title contains "Maçkolik" (can be adjusted based on expected content)
                if (driver.getTitle().contains("Maçkolik")) {
                    System.out.println("Link is working! Page title contains 'Maçkolik'");
                } else {
                    System.out.println("Link might not be working. Page title: " + driver.getTitle());
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                driver.quit();
            }
        }
    }



