import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestingReachAtUsLink extends AutomatedTest {
    @ParameterizedTest
    @ValueSource(strings = {"http://user.mackolik.com/UserPages/destek.aspx"})
    public void testLink(String url) {
        driver.get(url);
        System.out.println("testing link");
        assertTrue(driver.getTitle().contains("user.mackolik.com"));
    }
    //Mackolik.com - iddaa,canlı maç,iddaa sonuçları,sahadan,futbol @ Mackolik.com  olması gereken
}
