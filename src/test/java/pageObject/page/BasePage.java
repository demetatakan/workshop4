package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage
{
    WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver =webDriver;
        PageFactory.initElements(webDriver,this);
    }
}