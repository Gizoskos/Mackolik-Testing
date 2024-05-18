import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CheckIfPuanDurumuHaftaTarihleriUyuyorMu {
    @Test
    public void testTimelineFits() {
        // Set up ChromeDriver (ensure the path is correct for your environment)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the page
            driver.get("https://arsiv.mackolik.com/Puan-Durumu");

            // Locate the "Hafta" component by id
            WebElement haftaElement = driver.findElement(By.id("cboWeek"));
            String haftaText = haftaElement.getText();

            // Extract the start and end dates from the first option of the "Hafta" component
            String firstOptionDateRange = haftaText.split("\\(")[1].split("\\)")[0];
            String[] dateParts = firstOptionDateRange.split(" - ");
            LocalDate startDate = LocalDate.parse(dateParts[0], DateTimeFormatter.ofPattern("d.MM.yyyy"));
            LocalDate endDate = LocalDate.parse(dateParts[1], DateTimeFormatter.ofPattern("d.MM.yyyy"));

            // Locate the date element you want to check (update the XPath accordingly)
            WebElement dateElement = driver.findElement(By.xpath("//*[@id='dvFixtureInner']/table/tbody/tr[2]/td[1]"));
            String dateText = dateElement.getText();
            LocalDate dateToCheck = LocalDate.parse(dateText, DateTimeFormatter.ofPattern("dd/MM"));

            // Verify that the date of the element is within the date range of the first option of "Hafta" component
            Assert.assertTrue("Timeline does not fit", !dateToCheck.isBefore(endDate) && !dateToCheck.isAfter(startDate));

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}