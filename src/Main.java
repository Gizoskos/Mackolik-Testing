import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Test sınıfınızı oluşturun
        AutomatedTest automatedTest = new AutomatedTest();
        automatedTest.setUp();
        SeleniumApsUtil sel = new SeleniumApsUtil(AutomatedTest.driver);
        // Test senaryosunu başlatmak için setUp() metodunu çağırın
        boolean test1Passed = true;
        boolean test2Passed = true;

        // Test senaryosunu çalıştırın

        try {
        TestingReachAtUsLink testingReachAtUsLink = new TestingReachAtUsLink();
        testingReachAtUsLink.testLink("user.mackolik.com/UserPages/destek.aspx");
        } catch (AssertionError e) {
            test1Passed = false;
            System.out.println("Test failed: " + e.getMessage());
        }
        catch (Exception e) {
            test1Passed = false;
            e.printStackTrace();
            // Örnek bir test senaryos
        }
        try{
            testFilterGermanyStatistics testFilterGermanyStatistics = new testFilterGermanyStatistics();
            testFilterGermanyStatistics.testFilterGermanyStatistics();
        } catch (AssertionError e) {
            test2Passed = false;
            System.out.println("Test failed: " + e.getMessage());
        }
        catch (Exception e) {
            test2Passed = false;
            e.printStackTrace();
            // Örnek bir test senaryos
        } finally {
            // Test senaryosunu sonlandırmak için tearDown() metodunu çağırın
            automatedTest.tearDown();
        }
        if (test1Passed) {
            System.out.println("test 1 passed successfully.");
        } else {
            System.out.println("test 1 tests failed.");
        }
        if (test2Passed) {
            System.out.println("test 2 passed successfully.");
        } else {
            System.out.println("test 2 tests failed.");
        }

    }
}
