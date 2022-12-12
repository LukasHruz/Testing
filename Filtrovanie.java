import org.junit.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Filtrovanie {
    private WebDriver driver;
    private String  BaseUrl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseUrl = "https://www.pantarhei.sk/";

    }
    @Test
    public void test() {
        driver.get(BaseUrl);
        driver.findElement(By.name("q")).sendKeys("Zaklínač");
        driver.findElement(By.cssSelector("div.input-group-append button")).click();
        driver.findElement(By.xpath("//div[@class='action-close']")).click();
        driver.findElement(By.xpath("//a[@id='btn-cookie-allow']")).click();




    }
    @After
    public void tearDown() {
       // driver.quit();


    }

}
