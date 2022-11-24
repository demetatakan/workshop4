
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.concurrent.TimeUnit;

public class corporate
{
    ChromeDriver driver;

    @BeforeEach
    public void beforeEach()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach()
    {

        driver.quit();
    }


    @Test
    public void cssRegister()
    {
       System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://secure.sahibinden.com/kayit");
        driver.findElement(By.cssSelector("#name")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("#surname")).sendKeys("Test");
        driver.findElement(By.cssSelector("#email")).sendKeys("xyz8sahibinden@mailinator.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Password123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('endUserLicenceAgreement').click();");
        driver.findElement(By.cssSelector("#signUpButton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#confirmSubmit")));
        driver.findElement(By.cssSelector("#confirmSubmit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".email")));
        System.out.println(driver.findElement(By.cssSelector(".email")).getText());

        driver.quit();
    }

    @Test
    public void corparateRegister() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://secure.sahibinden.com/kayit/kurumsal/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Selenium");
        System.out.println("İsim alanı girildi, " + " İsim alanı attribute: " + name.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surname")));
        WebElement surname = driver.findElement(By.id("surname"));
        surname.sendKeys("Education");
        System.out.println("Soyisim alanı girildi, " + "Soyisim alanı attribute: " + surname.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("demet@mailinator.com");
        System.out.println("Email alanı girildi, " + "Email alanı attribute: " + email.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password1*");
        System.out.println("Password alanı girildi, " + "Password alanı attribute: " + password.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("12345678950");
        System.out.println("Telefon alanı girildi, " + "Telefon alanı attribute: " + phone.getAttribute("placeholder"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category")));
        Select category = new Select(driver.findElement(By.id("category")));
        category.selectByValue(String.valueOf(200002));
        System.out.println("Faaliyet alanı girildi. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        Select city = new Select(driver.findElement(By.id("city")));
        city.selectByValue("34");
        System.out.println("Şehir seçildi. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("town")));
        Select town = new Select(driver.findElement(By.id("town")));
        Thread.sleep(2000);
        town.selectByValue("447");
        System.out.println("İlçe alanı seçildi. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("quarter")));
        Select quarter = new Select(driver.findElement(By.id("quarter")));
        Thread.sleep(2000);
        quarter.selectByValue(String.valueOf("51415"));
        System.out.println("Mahalle alanı girildi. ");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('limitedCompany').click()");
        System.out.println("Şirket tipi seçimi yapıldı. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxOfficeCity")));
        Select taxOfficeCity = new Select(driver.findElement(By.id("taxOfficeCity")));
        Thread.sleep(2000);
        taxOfficeCity.selectByValue(String.valueOf("34"));
        System.out.println("Vergi dairesi şehir seçimi yapıldı. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("taxOffice")));
        Select taxOffice = new Select(driver.findElement(By.id("taxOffice")));
        Thread.sleep(2000);
        taxOffice.selectByValue(String.valueOf("461"));
        System.out.println("Vergi dairesi seçimi yapıldı. ");

        driver.findElement(By.id("taxNumber")).sendKeys("1600776991");
        System.out.println("Vergi numarası girişi yapıldı. ");

        JavascriptExecutor xs = (JavascriptExecutor) driver;
        xs.executeScript("document.getElementById('endUserLicenceAgreement').click()");
        System.out.println("Sözleşme checkboxı tıklandı. ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpButton")));
        driver.findElement(By.id("signUpButton")).click();
    }
}


