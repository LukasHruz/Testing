import org.junit.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class Vyhladavanie {
    private WebDriver driver;
    private String baseUrl;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.pantarhei.sk/";

    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[@class='action-close']")).click();
        driver.findElement(By.xpath("//a[@id='btn-cookie-allow']")).click();
        driver.findElement(By.name("q")).sendKeys("Zaklínač");
        driver.findElement(By.cssSelector("div.input-group-append button")).click();
        System.out.println(driver.findElements(By.xpath("//div[@class=\"col-12 col-lg-6\"]")).size());
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class=\"col-12 col-lg-6\"]"));
        Assert.assertEquals(rows.size(), 19);

    }


    @After
    public void tearDown() {
   //driver.quit();
    }

}
