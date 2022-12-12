import org.junit.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TableVerifyTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://localhost";
    }

    @Test
    public void test() throws Exception {
        driver.get(baseUrl + "/tabulka.php");

        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));

        for (int i = 1; i < rows.size()+1; i++) {

           try {
                assertEquals(String.valueOf(i), driver.findElement(By.xpath("//tr["+i+"]/td")).getText());
            }
            catch (Error er) {
                verificationErrors.append(er.toString());
            }
        }

}
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}