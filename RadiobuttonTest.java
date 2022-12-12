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

public class RadiobuttonTest {
    private WebDriver driver;
    private String  BaseUrl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseUrl = "http://localhost/zenaalebomuz.php";
    }

    @Test
    public void test_btn_conchita() {
        driver.get(BaseUrl);
        driver.findElement(By.xpath("//input[@value=\"conchita\"]")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class=\"description text-center\"]")).getText());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value=\"wurst\"]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value=\"conchita\"]")).isSelected());

    }
    @Test
    public void test_btn_wurst() {
        driver.get(BaseUrl);
        driver.findElement(By.xpath("//input[@value=\"wurst\"]")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class=\"description text-center\"]")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value=\"wurst\"]")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@value=\"conchita\"]")).isSelected());

    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
        }
    }