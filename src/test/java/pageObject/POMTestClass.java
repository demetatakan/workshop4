package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.page.CategoryAutomobilePage;
import pageObject.page.ClassifiedDetailPage;
import pageObject.page.MainPage;
import pageObject.page.SearchResultPage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class POMTestClass extends BaseClass
{
    private static final Logger logger = LogManager.getLogger(POMTestClass.class);
    MainPage mainPage;
    CategoryAutomobilePage categoryAutomobilePage;
    SearchResultPage searchResultPage;
    ClassifiedDetailPage classifiedDetailPage;

    @BeforeEach
    public void before()
    {
        mainPage = new MainPage(driver);
        categoryAutomobilePage = new CategoryAutomobilePage(driver);
        searchResultPage = new SearchResultPage(driver);
        classifiedDetailPage = new ClassifiedDetailPage(driver);
    }

    @Tag("ARAMA_TESTS")
    @DisplayName("SEARCH RESULT TEST")
    @Test
    public void test1()
    {
        try
        {
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

            logger.info("Main page is opened.");
            mainPage.clickOtomobil();
            logger.info("Switched to automobile category page.");

            categoryAutomobilePage.clickAllClassifieldLink();
            Assertions.assertTrue(searchResultPage.getClassifieldSize() > 0);

            String title = searchResultPage.getFirstClassifiedTitle();
            String KM = searchResultPage.getFirstClassifiedKM();
            String price = searchResultPage.getFirstClassifiedPrice();

            searchResultPage.clickFirstClassifield();

            String classifiedTitle = classifiedDetailPage.getClassifiedTitle();
            String classifiedKM = classifiedDetailPage.getClassifiedKM();
            String classifiedPrice = classifiedDetailPage.getClassifiedPrice();
            Assertions.assertAll
                    (
                            () -> Assertions.assertEquals(title, classifiedTitle),
                            () -> Assertions.assertEquals(KM, classifiedKM),
                            () -> Assertions.assertEquals(price, classifiedPrice),
                            () -> Assertions.assertTrue(classifiedDetailPage.getUrl().contains(classifiedDetailPage.getClassifiedId()))
                    );
        }

        catch (Exception e)
        {
            logger.error("Test failed : " + e.getMessage());
            File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            logger.info(imageFile.getPath());
        }
    }
}