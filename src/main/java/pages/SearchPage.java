package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//span[contains(@aria-label,'Sort by')]")
    private WebElement sortSelector;

    @FindBy(xpath = "//a[contains(@data-value,'price-asc-rank')]")
    private WebElement sortByAscendingPrice;

    @FindBy(xpath = "//a[contains(@data-value,'price-desc-rank')]")
    private WebElement sortByDescendingPrice;

    @FindBy(xpath = "//a[contains(@data-value,'review-rank')]")
    private WebElement sortByAvgCustomerReview;

    @FindBy(xpath = "//span[contains(@class,'a-price-whole')]")
    private WebElement firstSearchResult;

    public void clickFirstSearchProduct () {
        firstSearchResult.click();
    }

    public WebElement getFirstSearchResult() {
        return firstSearchResult;
    }

    public void openSortSelector() {
        sortSelector.click();
    }

    public WebElement getSortSelector() {
        return sortSelector;
    }

    public void clickSortByAscendingPrice() {
        sortByAscendingPrice.click();
    }

    public WebElement getSortByAscendingPrice() {
        return sortByAscendingPrice;
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
