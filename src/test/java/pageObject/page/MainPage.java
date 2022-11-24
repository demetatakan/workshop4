package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage
{
    public MainPage(WebDriver webDriver){
        super(webDriver);
    }
    @FindBy(css = "[title='Otomobil']")
    public WebElement otomobil;

    @FindBy(css ="[title='iphone 12 mini']")
    public WebElement mainPageItem;

    @FindBy(css = "#secure-login")
    public WebElement loginButton;

    @FindBy(css ="#post-new-classified")
    public WebElement newClassifiedButton;

    public void clickOtomobil()
    {
        otomobil.click();
    }
    public void clickMainPageItem() {
        mainPageItem.click();
        }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void clickNewClassifiedButton(){
        newClassifiedButton.click();
    }
    }