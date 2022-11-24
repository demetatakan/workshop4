package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.page.LoginPage;
import pageObject.page.MainPage;
import pageObject.page.NewClassPage;
import java.util.concurrent.TimeUnit;

public class POMNewClassifieldTest extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(POMTestClass.class);
    MainPage mainPage;
    LoginPage loginPage;
    NewClassPage newClassPage;

    @BeforeEach
    public void before()
    {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        newClassPage = new NewClassPage(driver);
    }

    @Tag("CLASSIFIELD_TESTS")
    @DisplayName("NEW CLASSIFIELD TEST")
    @Test
    public void test1() throws InterruptedException
    {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(mainPage.loginButton));
        mainPage.clickLoginButton();

        loginPage.fillUsername();
        loginPage.fillTruePassword();
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
        loginPage.clickloginButton();
        logger.info("Login success!");

        wait.until(ExpectedConditions.visibilityOf(newClassPage.newClassifiedButton));
        newClassPage.clickNewClassifiedButton();
        wait.until(ExpectedConditions.visibilityOf(newClassPage.categoryShopping));
        newClassPage.clickShoppingCategoryButton();
        logger.info("Category selection done!");

        wait.until(ExpectedConditions.visibilityOf(newClassPage.draftNewClassifiedButton));
        newClassPage.clickDraftNewClassButton();
        newClassPage.clickFirstStepPassButton();
        wait.until(ExpectedConditions.visibilityOf(newClassPage.classifiedTitle));
        newClassPage.fillClassifiedTitle();
        newClassPage.fillDescription();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(newClassPage.townSelection));
        newClassPage.setTownSelection();

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOf(newClassPage.quarterSelection));
        newClassPage.setQuarterSelection();
        Thread.sleep(4000);
        newClassPage.Selectionarea();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('postRulesCheck').click();");

        js.executeScript("arguments[0].scrollIntoView();", newClassPage.classifiedSubmit);
        wait.until(ExpectedConditions.elementToBeClickable(newClassPage.classifiedSubmit));
        newClassPage.clickClassifiedSubmit();
        Thread.sleep(5000);
        Assertions.assertEquals("Alt Kategori Seçimi", newClassPage.getCategorySelection());
    }
}