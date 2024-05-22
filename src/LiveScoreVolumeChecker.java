import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
public class VolumeButtonControl {
    
    public class LiveScoreChecker {
        public static void main(String[] args) {
            // ChromeDriver konumunu belirtin
            System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

            // ChromeDriver ayarlarını yapın
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Tarayıcıyı başlatmadan çalıştırmak için
            WebDriver driver = new ChromeDriver(options);

            try {
                // Canlı skor sayfasına gidin
                driver.get("URL_OF_THE_PAGE_CONTAINING_LIVE_SCORES");

                // Canlı skor listesini bulun
                WebElement liveScoreList = driver.findElement(By.xpath("//*[@id='live-score-lefttemp']"));

                // Her bir maç satırını alın
                List<WebElement> matches = liveScoreList.findElements(By.cssSelector("tr[class*='row']"));

                for (WebElement match : matches) {
                    // Maç elementinin rengini alın
                    String bgColor = match.getCssValue("background-color");

                    // Gol olup olmadığını kontrol edin (default renk rgb(199, 210, 223))
                    if (!bgColor.equals("rgb(199, 210, 223)")) {
                        System.out.println("Gol atıldı!");

                        // Ses kapama butonunu bulun ve tıklayın
                        WebElement soundOffButton = driver.findElement(By.xpath("//*[@id='aSoundOff']"));
                        soundOffButton.click();
                        System.out.println("Ses kapatıldı.");

                        // Ses açma butonunu bulun ve tıklayın
                        WebElement soundOnButton = driver.findElement(By.xpath("//*[@id='aSoundOn']"));
                        soundOnButton.click();
                        System.out.println("Ses açıldı.");

                        // Ses açma/kapama butonlarının durumunu doğrulayın
                        boolean isSoundOnVisible = soundOnButton.isDisplayed();
                        boolean isSoundOffVisible = soundOffButton.isDisplayed();

                        if (isSoundOnVisible && !isSoundOffVisible) {
                            System.out.println("Ses açma/kapama butonları düzgün çalışıyor.");
                        } else {
                            System.out.println("Ses açma/kapama butonları düzgün çalışmıyor.");
                        }

                        // Her gol için bir defa ses kontrolü yapılıyor
                        break;
                    }
                }
            } finally {
                // Tarayıcıyı kapatın
                driver.quit();
            }
        }
    }


}
