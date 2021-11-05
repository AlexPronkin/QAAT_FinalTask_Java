package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id,'add-to-cart-button')]")
    private WebElement addToCart;

    @FindBy(xpath = "//div[contains(@id,'attachDisplayAddBaseAlert')]")
    private  WebElement addedToCartNotice;

    @FindBy(xpath = "//input[contains(@aria-labelledby,'cart-button-announce')]")
    private WebElement goToCart;

    public void clickAddToCart() {
        addToCart.click();
    }

    public void clickGoToCart() {
        goToCart.click();
    }

    public WebElement getAddedToCartNotice() {
        return addedToCartNotice;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
