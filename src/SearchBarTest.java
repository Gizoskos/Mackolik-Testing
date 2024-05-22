import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SearchBarTest extends AutomatedTest{
    static final String testWorkstationName = "testFilterGermanyStatisticsWorkstation";
    SeleniumApsUtil sel = new SeleniumApsUtil(AutomatedTest.driver);

    @Test
    public void testValidShortString() {
        testSearchBar("Fenerbahçe", "Fenerbahçe");
    }

    @Test
    public void testValidLongString() {
        testSearchBar("Manchester United Football Club", "Manchester United Football Club");
    }

    @Test
    public void testValidNumericString() {
        testSearchBar("12345", "12345");
    }

    @Test
    public void testValidAlphanumericString() {
        testSearchBar("FCB123", "FCB123");
    }

    @Test
    public void testEmptyString() {
        testSearchBar("", "");
    }

    @Test
    public void testValidSpecialCharacters() {
        testSearchBar("Bayern München", "Bayern München");
    }

    @Test
    public void testValidMixedLanguageString() {
        testSearchBar("Бавария Munich", "Бавария Munich");
    }

    @Test
    public void testEmojiCharacters() {
        testSearchBar("⚽🏆", "⚽🏆");
    }

    @Test
    public void testHtmlTags() {
        testSearchBar("<script>alert('test')</script>", "<script>alert('test')</script>");
    }

    @Test
    public void testSqlInjection() {
        testSearchBar("' OR '1'='1", "' OR '1'='1");
    }

    @Test
    public void testExcessivelyLongString() {
        String longString = new String(new char[65535]).replace("\0", "a");
        testSearchBar(longString, longString);
    }

    @Test
    public void testBinaryData() {
        testSearchBar("\u0000\u0001\u0002", "\u0000\u0001\u0002");
    }

    public void testSearchBar(String input, String expected) {
        WebElement searchBar = driver.findElement(By.name("searchBarElementName")); // Update with actual element name
        searchBar.clear();
        searchBar.sendKeys(input);
        searchBar.submit();

        // Assuming search results appear in an element with id "searchResults"
        WebElement searchResults = driver.findElement(By.id("searchResults"));
        Assert.assertEquals(searchResults.getText(), expected);
    }

}
