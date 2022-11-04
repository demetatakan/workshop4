import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertTrue;

public class parameterizedTest
{
    ChromeDriver driver;

    @BeforeEach
    public void beforeEach()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach()
    {
        driver.quit();
    }


    @Tag("ARAMA_TESTS")
    @DisplayName("CATEGORY MATCHING TEST")
    @ParameterizedTest
    @CsvSource({
        "iPhone 12 Mini,#search_cats ul li.cl4,1",
        "PlayStation 5,#search_cats ul li.cl3 div a h2,2",
        "Koşu Bandı,#search_cats ul li.cl3 div a h2,3",
        "Elektrikli Isıtıcı,#search_cats ul li.cl3 div a h2,4",
        "Toyota,#search_cats ul li.cl2 div a h2,5",
    })
    public void parameterizedTestCsvSource(String categoryTitle, String cssSelector, int index)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.get("https://www.sahibinden.com/");

        closeCookieAd(driver);

        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("OptanonConsent", "true"));
        cookieList.add(new Cookie("OptanonAlertBoxClosed", "true"));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));

        driver.navigate().refresh();

        WebElement mainPageItem = driver.findElement(By.cssSelector("#container > div.homepage > div > div.homepage-content > div:nth-child(12) > ul > li:nth-child(" + index + ") > a"));
        mainPageItem.click();

        WebElement category = driver.findElement(By.cssSelector(cssSelector));
        String SearchResItem = category.getText();

        assertTrue(SearchResItem.contains(categoryTitle));
    }

    private static void closeCookieAd(WebDriver driver)
    {
        driver.manage().addCookie(new Cookie("VISITOR_INFO1_LIVE", "true"));
        driver.navigate().refresh();
    }
}

