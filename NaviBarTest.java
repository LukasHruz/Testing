import org.junit.*;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class NaviBarTest {
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
    public void test()  {
        String expClass = "active";

        List<String> pages = new ArrayList<>();
        pages.add("clickmebaby");
        pages.add("vybersi");
        pages.add("tabulka");
        pages.add("zjavenie");
        pages.add("redalert");


    for (String page : pages) {
        driver.get(baseUrl + "/"+ page+ ".php");
        Assert.assertTrue(driver.findElement(By.xpath("//li[a/@href='" + page + ".php']"))
                .getAttribute("class").contains(expClass));
        }
    driver.navigate().back();
    driver.navigate().forward();
    driver.navigate().refresh();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}