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

public class AlertTest {
    private WebDriver driver;
    private String  BaseUrl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseUrl = "http://localhost/redalert.php";

    }
    @Test
    public void test_alert1() {
        driver.get(BaseUrl);
        driver.findElement(By.id("alert1")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1"))
                                .getText().contains("Kirov Reporting"));
    }
    @Test
    public void test_alert2() {
        driver.get(BaseUrl);
        driver.findElement(By.id("alert2")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Negative"));
    }
    @Test
    public void test_alert3() {
        driver.get(BaseUrl);
        driver.findElement(By.id("alert3")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Done");
        alert.accept();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result']/h1")).getText().contains("Done"));
    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();


    }

}
