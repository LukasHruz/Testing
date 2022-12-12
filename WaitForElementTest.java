        import org.junit.*;
        import org.openqa.selenium.*;
        import org.junit.Before;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElementTest {
    private WebDriver driver;
    private String BaseUrl;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        BaseUrl = "http://localhost/";

    }
    @Test // Page Visibility
    public void test_Wait_visibility() {

        driver.get(BaseUrl + "/zjavenie.php");
        driver.findElement(By.id("showHim")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='brano']")));

        Assert.assertTrue(driver.findElement(By.xpath("//img[@class= 'brano']")).isDisplayed());
    }
    @Test // DOM Visibility
    public void test_Wait_presence() {

        driver.get(BaseUrl + "/zjavenie.php");
        driver.findElement(By.id("showHim")).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='brano']")));

        Assert.assertTrue(driver.findElement(By.xpath("//img[@class= 'brano']")).isDisplayed());
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();


    }

}
