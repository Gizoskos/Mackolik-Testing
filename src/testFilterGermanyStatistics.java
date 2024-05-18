import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static org.junit.Assert.assertTrue;

public class testFilterGermanyStatistics extends AutomatedTest {
    static final String testWorkstationName = "testFilterGermanyStatisticsWorkstation";
    SeleniumApsUtil sel = new SeleniumApsUtil(AutomatedTest.driver);
    @Test
    public void testFilterGermanyStatistics() {
        sel.goToStatisticsDetails();
    // Maçkolik istatistikler sayfasına git
    //AutomatedTest.driver.get("https://arsiv.mackolik.com/Statistics/Default.aspx");

    // Futbol -> İstatistikler e tıkla
    //WebElement futbolMenu = AutomatedTest.driver.findElement(By.xpath("//*[@id=\"menu-temp\"]/div[1]/a[1]"));
    //futbolMenu.click();
    //WebElement istatistiklerLink = AutomatedTest.driver.findElement(By.xpath("İstatistikler"));
    //istatistiklerLink.click();

    // Ülke filtresi açılır menüsünü bulun ve Almanya'yı seçin
    WebElement countryDropdown = AutomatedTest.driver.findElement(By.xpath("//*[@id=\"cboCountry\"]"));
    countryDropdown.click();
    List<WebElement> options = driver.findElements(By.xpath("//*[@id='cboCountry']/option"));
        // "Almanya" seçeneğini bulun ve tıklayın
        for (WebElement option : options) {
            if (option.getText().equals("Almanya")) {
                option.click();
                break;
            }
        }

    // Filtrenin doğru şekilde uygulandığını kontrol et
    WebElement filterButton = AutomatedTest.driver.findElement(By.id("btnList"));
    filterButton.click();

    // Filtrelenen liste öğelerini kontrol et
    List<WebElement> countryElements = AutomatedTest.driver.findElements(By.xpath("//td[@class='countryColumn']"));

    // Listedeki tüm öğelerin Almanya olduğunu kontrol et
    for (WebElement element : countryElements) {
        assertTrue("Liste öğesi Almanya değil: " + element.getText(), element.getText().contains("Almanya"));
    }
}
}