import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

@Tag("ARAMA_TESTS")
@DisplayName("SEARCH RESULT TEST")
public class searchResult
{
    private static final Logger logger = LogManager.getLogger(searchResult.class);

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

    @Test
    public void searchResult() throws InterruptedException
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get("https://www.sahibinden.com//");

            // Close cookie and Set TB
            closeCookie(driver);
            closeCookieAd(driver);
            setCookieTb(driver);
            logger.info("TB set cookie yapıldı.");

            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Otomobil"))).click();
            logger.info("Otomobil kategori sayfasına geçiş yapıldı.");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("all-classifieds-link"))).click();

            List<WebElement> listeIlan = driver.findElements(By.cssSelector(".searchResultsRowClass tr"));
            Assertions.assertTrue(listeIlan.size() > 0);

            // PAGE 1(search result page)
            String titleValue1 = findValue("tr:nth-child(1) td.searchResultsTitleValue.mini-column a.classifiedTitle", "getAttribute", driver);
            logger.info("Arama sonuç- ilan başlığı alındı.");
            String priceValue1 = findValue("tr:nth-child(1) td.searchResultsPriceValue div span", "getText", driver).split("TL")[0];
            logger.info("Arama sonuç-İlan fiyatı alındı.");
            String kmValue1 = findValue("tbody tr:nth-child(1) td:nth-child(7)", "getText", driver);
            logger.info("Arama sonuç-İlan km değeri alındı.");
            driver.findElement(By.cssSelector(".searchResultsRowClass tr:nth-child(1) td:nth-child(7) ")).click();

            //Close cookie and wait
            closeCookieClassfied(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='classifiedDetail']/div/div[1]/h1")));

            // PAGE 2(classifield detail)
            String titleValue2 = findValue("div.classifiedDetailTitle h1", "getText", driver);
            logger.info("İlan detay başlığı alındı.");
            String priceValue2 = findValue("div.classifiedInfo:nth-child(5) h3:nth-child(1)", "getText", driver).split("TL")[0];
            logger.info("İlan detay- ilan ücreti alındı.");
            String kmValue2 = findValue("div.classifiedInfo ul li:nth-child(9) span", "getText", driver);
            logger.info("İlan detay- ilan km değeri alındı.");

            Assertions.assertAll
            (
                () -> Assertions.assertEquals(titleValue1, titleValue2),
                () -> Assertions.assertEquals(priceValue2, priceValue1),
                () -> Assertions.assertEquals(kmValue1, kmValue2)
            );

            logger.info("karşılaştırma adımı tamamlandı.");

            String URL = driver.getCurrentUrl();
            String classifieldId = findValue("#classifiedId", "getText", driver);
            Assertions.assertTrue(URL.contains(classifieldId));
            logger.info("ilan id karşılaştırma işlemi OK.");
        }
        catch (Exception exception)
        {
            logger.error("Test fail etti");
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }

    private static String findValue(String css, String type, WebDriver driver)
    {
        WebElement e = driver.findElement(By.cssSelector(css));

        if (type == "getText")
        {
            return (e.getText());
        }

        return (e.getAttribute("title"));

    }

    private static void closeCookie(WebDriver driver)
    {
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("OptanonConsent", "true"));
        cookieList.add(new Cookie("OptanonAlertBoxClosed", "true"));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));
    }

    private static void closeCookieAd(WebDriver driver)
    {

        driver.manage().addCookie(new Cookie("VISITOR_INFO1_LIVE", "true"));

        driver.navigate().refresh();
    }

    private static void closeCookieClassfied(WebDriver driver)
    {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("feature_discovery_data",
                "{\"add-to-favorites\":{\"count\":1,\"displayedAt\":1666694107010},\"extended\":true}");

        SessionStorage sessionStorage = ((WebStorage) driver).getSessionStorage();
        sessionStorage.setItem("feature_discovery_displayed", "true");
    }

    private static void setCookieTb(WebDriver driver)
    {

        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("testBox", "186", ".sahibinden.com", "/", null));
        cookieList.add(new Cookie("tbSite", "x", ".sahibinden.com", "/", null));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));

        driver.navigate().refresh();
    }

}

