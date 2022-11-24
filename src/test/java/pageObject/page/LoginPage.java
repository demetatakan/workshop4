package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "#username")
    public WebElement username;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "#userLoginSubmitButton")
    public WebElement loginButton;

    @FindBy(css = "#loginForm > dl > dd:nth-child(1) > label")
    public WebElement errorMessage;

    @FindBy(css = "#loginForm > ul > li:nth-child(2) > a")
    public WebElement forgotPassword;

    @FindBy(css = "#loginForm > dl > dt > span")
    public WebElement wrongPassword;

    public void fillUsername()
    {
        username.sendKeys("savasavcuu");
    }

    public void fillPassword()
    {
        password.sendKeys("xxxxxx");
    }
    public void fillTruePassword()
    {
        password.sendKeys("password");

    }

    public void clickloginButton()
    {
        loginButton.click();
    }

    public String returnErrorMsg()
    {
        return errorMessage.getText();
    }

    public String returnForgotPassword()
    {
        return forgotPassword.getText();
    }
    public String returnWrongUserMsg()
    {
        return wrongPassword.getText();
    }
}