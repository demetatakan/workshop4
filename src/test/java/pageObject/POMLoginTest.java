package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.page.LoginPage;
import pageObject.page.MainPage;

public class POMLoginTest extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(POMTestClass.class);
    MainPage mainPage;
    LoginPage loginPage;

    @BeforeEach
    public void before()
    {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);

    }

    @Tag("BASIC_TESTS")
    @DisplayName("LOGIN TEST")
    @Test
    public void test1() throws InterruptedException
    {
        mainPage.clickLoginButton();
        loginPage.clickloginButton();
        Assertions.assertEquals("E-posta adresinizi veya kullanıcı adınızı girin.", loginPage.returnErrorMsg());
        logger.info("Empty input test passed.");

        Assertions.assertEquals("Şifremi Unuttum", loginPage.returnForgotPassword());
        logger.info("Forgot Password Link checked.");

        loginPage.fillUsername();
        loginPage.fillPassword();
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.clickloginButton();
        wait.until(ExpectedConditions.visibilityOf(loginPage.wrongPassword));
        Assertions.assertEquals("E-posta adresiniz, kullanıcı adınız veya şifreniz hatalı.", loginPage.returnWrongUserMsg());
        logger.info("Wrong Password checked.");

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.clickloginButton();
    }

    @Test
    public void test2() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.loginButton));
        mainPage.clickLoginButton();
        loginPage.fillUsername();
        loginPage.fillTruePassword();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.clickloginButton();
        logger.info("Login success!");
    }
}