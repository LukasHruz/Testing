import javafx.scene.web.WebEngine;
import org.junit.*;
import org.openqa.selenium.*;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class DisabledTest {
    private WebDriver driver;
    private String  BaseUrl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseUrl = "http://localhost/nemenne.php";

    }
    @Test
    public void test_diesnabled() {
        driver.get(BaseUrl);
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value= 'Eva Mazikova']")).isEnabled());

        Assert.assertFalse(driver.findElement(By.id("sel1")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).isEnabled());

        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[1]")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[2]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.id("sel2")).findElement(By.xpath("./option[3]")).isEnabled());

        Assert.assertFalse(driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(@class,'btn-success')]")).isEnabled());
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();


    }

}
