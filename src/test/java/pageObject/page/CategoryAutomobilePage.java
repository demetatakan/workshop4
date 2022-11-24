package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryAutomobilePage extends BasePage
{

    public CategoryAutomobilePage(WebDriver webDriver)
    {
        super(webDriver);
    }
    @FindBy(className = "all-classifieds-link")
    private WebElement allClassifieldLink;

    public void clickAllClassifieldLink(){
        allClassifieldLink.click();
    }
}