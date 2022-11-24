package pageObject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchResultPage extends BasePage
{
    public SearchResultPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(css = ".searchResultsRowClass > tr > td:nth-child(1)")
    public List<WebElement> searchResultClassifields;

    @FindBy(css = ".searchResultsRowClass > tr > td.searchResultsTitleValue")
    public List<WebElement> classifiedsTitle;

    @FindBy(css = ".searchResultsRowClass > tr > td:nth-child(7)")
    public List<WebElement> classifiedsKM;

    @FindBy(css = ".searchResultsRowClass > tr > td.searchResultsPriceValue")
    public List<WebElement> classifiedsPrice;

    public Integer getClassifieldSize()
    {
        return searchResultClassifields.size();
    }

    public void clickFirstClassifield()
    {
        searchResultClassifields.get(0).click();
    }

    public String getFirstClassifiedTitle()
    {
        return classifiedsTitle.get(0).getText();
    }

    public String getFirstClassifiedKM()
    {
        return classifiedsKM.get(0).getText();
    }

    public String getFirstClassifiedPrice()
    {
        return classifiedsPrice.get(0).getText().split("TL")[0];
    }
}