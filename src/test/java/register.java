import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class register
{
    @Test
    public void pageFromMainPage() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sahibinden.com/");
        driver.findElement(By.linkText("Hesap Aç")).click();
        Thread.sleep(1000);
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Hesap Aç";
        Assertions.assertEquals(ExpectedTitle,ActualTitle);
    }

    @Test
    public void registerFunctionality() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "/Users/demet.atakan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 25);

        driver.navigate().to("https://secure.sahibinden.com/kayit");
        driver.findElement(By.id("name")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("#surname")).sendKeys("Test");
        driver.findElement(By.cssSelector("#email")).sendKeys("xyz7sahibinden@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("Password123");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('endUserLicenceAgreement').click();");
        driver.findElement(By.id("signUpButton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmSubmit")));
        driver.findElement(By.id("confirmSubmit")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email")));
        System.out.println(driver.findElement(By.className("email")).getText());

        driver.quit();
    }
}
