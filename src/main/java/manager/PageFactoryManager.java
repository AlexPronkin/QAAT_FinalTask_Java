package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() { return new SignInPage(driver); }

    public RegisterPage getRegisterPage() { return new RegisterPage(driver); }

    public SearchPage getSearchPage() { return new SearchPage(driver); }

    public ProductPage getProductPage() { return new ProductPage(driver); }

}
