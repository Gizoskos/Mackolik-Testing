import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class testFilterGermanyStatistics extends AutomatedTest {
    static final String testWorkstationName = "testFilterGermanyStatisticsWorkstation";
    SeleniumApsUtil sel = new SeleniumApsUtil(AutomatedTest.driver);

    @Test
    public void testFilterGermanyStatistics() throws InterruptedException {
        sel.goToStatisticsDetails();
        // Explicit wait tanımla
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Almanya ülkesini seç
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("cboCountry")));
        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("Almanya");

        // Listele butonuna tıkla
        WebElement listButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnList")));
        listButton.click();
        Thread.sleep(2000);


        // İstatistikler tablosunun yüklenmesini bekle
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tblLeagues']/tbody/tr[2]")));
        Thread.sleep(2000);
        // İstatistikler tablosundaki tüm `tr` öğelerini bulun
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='tblLeagues']/tbody/tr"));

        // İlk satırı (başlık satırını) atla ve geri kalan satırları kontrol et
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            assertTrue("Satırda Almanya yazısı bulunmuyor: " + rowText, rowText.contains("Almanya"));
        }
    }
}