package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassifiedDetailPage extends BasePage
{

    public ClassifiedDetailPage(WebDriver webDriver)
    {
        super(webDriver);
    }
    @FindBy(css = ".classifiedDetailTitle h1")
    public WebElement classifiedTitle;

    @FindBy(css = "div.classifiedInfo ul li:nth-child(9) span")
    public  WebElement classifiedKM;

    @FindBy(css ="div.classifiedInfo:nth-child(5) h3:nth-child(1)" )
    public WebElement classifiedPrice;

    @FindBy(css = "#classifiedId")
    public WebElement classifiedId;


    public String getClassifiedTitle()
    {
        return classifiedTitle.getText();
    }

    public String getClassifiedKM()
    {
        return classifiedKM.getText();
    }
    public String getClassifiedPrice(){
        return classifiedPrice.getText().split("TL")[0];

    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getClassifiedId(){
        return classifiedId.getText();
    }
}