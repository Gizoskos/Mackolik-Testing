import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Test sınıfınızı oluşturun
        AutomatedTest automatedTest = new AutomatedTest();
        SeleniumApsUtil sel = new SeleniumApsUtil(AutomatedTest.driver);

        // Test senaryosunu başlatmak için setUp() metodunu çağırın
        automatedTest.setUp();

        // Test senaryosunu çalıştırın
        try {
            sel.goToStatisticsList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Test senaryosunu sonlandırmak için tearDown() metodunu çağırın
            automatedTest.tearDown();
        }
    }
}
