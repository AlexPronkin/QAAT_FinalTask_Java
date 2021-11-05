package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@id,'nav-logo')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Conditions of Use')]")
    private WebElement conditionsOfUse;

    @FindBy(xpath = "//a[contains(@data-csa-c-slot-id,'HamburgerMenuDesktop')]")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[contains(@class,'nav-a nav-a-2   nav-progressive-attribute') and contains(@data-nav-role,'signin')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class,'a-carousel-row-inner')]")
    private WebElement carousel;

    @FindBy(xpath = "//input[contains(@id,'searchtextbox')]")
    private WebElement searchTextBox;

    @FindBy(xpath = "//input[contains(@id,'nav-search-submit-button')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@id,'gw-card-layout')]")
    private WebElement cardLayout;

    @FindBy(xpath = "//span[contains(@class,'nav-cart-count nav-cart-1 nav-progressive-attribute')]")
    private WebElement cartCount;

    @FindBy(xpath = "//a[contains(@aria-label,'Choose a language for shopping.')]")
    private WebElement changeLanguage;

    @FindBy(xpath = "//span[contains(@class,'label') and contains(text(),'Deutsch')]")
    private WebElement deutschLanguageOption;

    @FindBy(xpath = "//span[contains(@class,'label') and contains(text(),'Português')]")
    private WebElement portuguesLanguageOption;

    @FindBy(xpath = "//input[contains(@class,'button-input')]")
    private  WebElement saveLanguageChanges;

    @FindBy(xpath = "//span[@class='hm-icon-label']")
    private WebElement menuButtonText;


    public String getCartCountText() {
        return cartCount.getText();
    }

    public String getMenuButtonText() {
        return menuButtonText.getText();
    }

    public WebElement getMenuButton() {
        return menuButtonText;
    }

    public void clickChangeLanguageButton() {
        changeLanguage.click();
    }

    public void clickDeutschLanguageOption() {
        deutschLanguageOption.click();
    }

    public void clickPortuguesLanguageOption() {
        portuguesLanguageOption.click();
    }

    public void clickSaveLanguageChanges() {
        saveLanguageChanges.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public void enterTextToSearch(final String searchText) {
        searchTextBox.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isCarouselVisible() {
        return carousel.isDisplayed();
    }

    public boolean isMainMenuVisible() {
        return mainMenu.isDisplayed();
    }

    public boolean isConditionsOfUseVisible() {
        return conditionsOfUse.isDisplayed();
    }

    public boolean isCardLayoutVisible() {
        return cardLayout.isDisplayed();
    }

    public boolean isSearchTextBoxVisible() {
        return searchTextBox.isDisplayed();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
