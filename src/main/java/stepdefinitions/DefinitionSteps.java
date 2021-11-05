package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30  ;
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    ProductPage productPage;
    SearchPage searchPage;
    RegisterPage registerPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void userOpensHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks Sign in button")
    public void userClicksSignInButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickSignInButton();
    }

    @And("User enters {string} in the input field")
    public void userEntersDataInTheInputField(final String username) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterUsername(username);
    }

    @And("User clicks Continue button")
    public void userClicksContinueButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickContinueButton();
    }

    @And("User clicks Create your Amazon account button")
    public void userClicksCreateYourAmazonAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickCreateAccountButton();
    }

    @And("User clicks Create your Amazon account button without filling in all the fields")
    public void userClicksCreateYourAmazonAccountButtonWithoutFillingInTheFields() {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.clickRegisterButton();
    }

    @And("User checks that {string} text corresponds to the documentation")
    public void userChecksThatErrorMessageTextCorrespondsToTheDocumentation(final String expectedText) {
        assertEquals(expectedText, signInPage.getErrorMessageText());
    }

    @And("User enters {string} to Your name field")
    public void userEntersUsernameToYourNameField(final String name) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterName(name);
    }

    @And("User enters {string} to Email field")
    public void userEntersEmailToEmailField(final String email) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterEmail(email);
    }

    @And("User enters {string} to Password field")
    public void userEntersPasswordToPasswordField(final String password) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterPassword(password);
    }

    @And("User enters {string} to Re-enter Password field")
    public void userEntersConfirmPasswordToReEnterPasswordField(final String passwordCheck) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterPasswordCheck(passwordCheck);
    }

    @And("User checks that 'Enter your name' error message visible")
    public void userChecksThatEnterYourNameErrorMessageVisible() {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getNameError());
        assertTrue(registerPage.isNameErrorVisible());

    }

    @And("User checks that 'Enter your email' error message visible")
    public void userChecksThatEnterYourEmailErrorMessageVisible() {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getEmailError());
        assertTrue(registerPage.isEmailErrorVisible());
    }

    @And("User checks that 'Enter your password' error message visible")
    public void userChecksThatEnterYourPasswordErrorMessageVisible() {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getPasswordError());
        assertTrue(registerPage.isPasswordErrorVisible());
    }

    @And("User checks that 'Type your password again' error message visible")
    public void userChecksThatTypeYourPasswordAgainErrorMessageVisible() {
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getPasswordCheckError());
        assertTrue(registerPage.isPasswordCheckErrorVisible());
    }

    @And("User checks that 'Enter your email or mobile phone number' error visible")
    public void userChecksThatEnterYourEmailOrMobilePhoneNumberErrorVisible() {
        signInPage = pageFactoryManager.getSignInPage();
        assertTrue(signInPage.isEmptyFieldErrorVisible());
    }

    @And("User checks logo visibility")
    public void userChecksLogoVisibility() {
        assertTrue(homePage.isLogoVisible());
    }

    @And("User checks Sign-in button visibility")
    public void userChecksSignInButtonVisibility() {
        assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User checks main menu visibility")
    public void userChecksMainMenuVisibility() {
        assertTrue(homePage.isMainMenuVisible());
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        assertTrue(homePage.isSearchTextBoxVisible());
    }

    @And("User checks carousel visibility")
    public void userChecksCarouselVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.isCarouselVisible());
    }

    @And("User checks card layout visibility")
    public void userChecksCardLayoutVisibility() {
        assertTrue(homePage.isCardLayoutVisible());
    }

    @And("User checks Conditions of use visibility")
    public void userChecksConditionsOfUseVisibility() {
        assertTrue(homePage.isConditionsOfUseVisible());
    }

    @And("User enters {string} into the search field")
    public void userEntersKeywordIntoTheSearchField(final String keyword) {
        homePage = pageFactoryManager.getHomePage();
        homePage.enterTextToSearch(keyword);
    }

    @And("User clicks search submit button")
    public void userClicksSearchSubmitButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks Sort dropdown menu")
    public void userClicksSortDropdownMenu() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchPage.getSortSelector());
        searchPage.openSortSelector();
    }

    @And("User selects Sort Price: Low to High")
    public void userSelectsSortPriceLowToHigh() {
        searchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchPage.getSortByAscendingPrice());
        searchPage.clickSortByAscendingPrice();
    }

    @And("User clicks on first result on page")
    public void userClicksFirstResultOnPage() {
        searchPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchPage.getFirstSearchResult());
        searchPage.clickFirstSearchProduct();
    }

    @And("User adds product to cart")
    public void userAddsProductToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCart());
        productPage.clickAddToCart();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddedToCartNotice());
    }

    @And("User clicks Card button")
    public void userClicksCardButton() {
        productPage.clickGoToCart();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User returns to home page")
    public void userReturnsToHomePage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickLogo();
        driver.navigate().refresh();
    }

    @And("User checks that {string} product has been added to the cart")
    public void userChecksThatProductAmountProductHasBeenAddedToTheCart(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(expectedText, homePage.getCartCountText());
    }

    @And("User clicks Change language")
    public void userClicksChangeLanguage() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickChangeLanguageButton();
    }

    @And("User selects {string} language")
    public void userSelectsLanguageLanguage(final String language) throws IllegalStateException {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
            switch (language) {
                case "Deutsch":
                    homePage.clickDeutschLanguageOption();
                    break;
                case "Portugues":
                    homePage.clickPortuguesLanguageOption();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + language);
            }
    }

    @And("User confirm changes")
    public void userConfirmChanges() {
        homePage.clickSaveLanguageChanges();
    }

    @And("User checks that interface language was changed by {string} button text")
    public void userChecksThatInterfaceLanguageWasChangedByAllButtonText(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMenuButton());
        assertEquals(expectedText, homePage.getMenuButtonText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
