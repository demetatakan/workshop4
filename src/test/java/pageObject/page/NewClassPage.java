package pageObject.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewClassPage extends BasePage
{
    public NewClassPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = "body > div.container > div.main-view.home > div:nth-child(2) > header > div.header-desktop.ng-scope > ul > li:nth-child(6) > a")
    public WebElement newClassifiedButton;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > div:nth-child(2) > div.category-select-wrapper > div.category-select-area.select-with-steps.modern-category-select > div.category-select-modern.ng-scope > div > div:nth-child(4) > span")
    public WebElement categoryShopping;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > form > div.add-classified-footer.footer-sicily > button")
    public WebElement firstStepPassButton;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > div.offer-draft-popup.ng-scope.ng-isolate-scope > div:nth-child(2) > div.dialog-content.dialogEffect > div > section > p > button.btn.btn-alternative")
    public WebElement draftNewClassifiedButton;

    @FindBy(name = "addClassifiedTitle")
    public WebElement classifiedTitle;

    @FindBy(name = "Açıklama")
    public WebElement description;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > style")
    public WebElement mapSelection;

    @FindBy(css ="body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > style")
    public WebElement area;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > form > div:nth-child(3) > div.add-classified-box.new-address-section.ng-scope > div.map-content > ul > li:nth-child(2) > select")
    public WebElement townSelection;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > form > div:nth-child(3) > div.add-classified-box.new-address-section.ng-scope > div.map-content > ul > li:nth-child(3) > select")
    public WebElement quarterSelection;

    @FindBy(css = ".add-classified-submit")
    public WebElement classifiedSubmit;

    @FindBy(css = "body > div.container > div.main-view > div:nth-child(3) > main > div.add-classified.ng-scope > div.ng-scope > form > h2")
    public WebElement categorySelection;

    public void Selectionarea()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", area);
    }

    public void setQuarterSelection()
    {
        Select quarter = new Select(quarterSelection);
        quarter.selectByVisibleText("Barbaros Mah.");
    }

    public void setTownSelection()
    {
        Select town = new Select(townSelection);
        town.selectByVisibleText("Ataşehir");
    }

    public void clickNewClassifiedButton()
    {
        newClassifiedButton.click();
    }

    public void clickShoppingCategoryButton()
    {
        categoryShopping.click();
    }

    public void clickFirstStepPassButton()
    {
        firstStepPassButton.click();
    }

    public void clickDraftNewClassButton()
    {
        draftNewClassifiedButton.click();
    }

    public void fillClassifiedTitle()
    {
        classifiedTitle.sendKeys("Az Kullanılmış Saat");
    }
    public void fillDescription()
    {
        description.sendKeys("Sahibinden harika X marka saat");
    }
    public void makeSelectionMap()
    {
        mapSelection.click();
    }
    public void clickClassifiedSubmit()
    {
        classifiedSubmit.click();
    }
    public String getCategorySelection()
    {
        return categorySelection.getText();
    }
}