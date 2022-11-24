package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BaseClass
{
    WebDriver driver;
    WebDriverWait wait;

    @BeforeAll
    public static void beforeall()
    {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void beforeTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,40);

        driver.manage().window().maximize();
        driver.get("http://sahibinden.com/");


        closeCookieClassfied(driver);
        closeCookie(driver);
        setCookieTb(driver);
        closeCookie(driver);

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
    private static void closeCookie(WebDriver driver)
    {
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("OptanonConsent", "true"));
        cookieList.add(new Cookie("OptanonAlertBoxClosed", "true"));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));
    }

    @AfterEach
    public void afterEach()
    {
        driver.quit();
    }
}
