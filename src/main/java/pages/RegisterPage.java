package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[contains(@name,'customerName')]")
    private WebElement nameField;

    @FindBy(xpath = "//input[contains(@name,'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[contains(@name,'passwordCheck')]")
    private WebElement passwordCheckField;

    @FindBy(xpath = "//div[contains(@id,'customerName-missing')]//div[contains(@class,'a-alert-content')]")
    private WebElement nameError;

    @FindBy(xpath = "//div[contains(@id,'email-missing')]//div[contains(text(),'Enter your email')]")
    private WebElement emailError;

    @FindBy(xpath = "//div[contains(@id,'password-missing')]//div[contains(text(),'Enter your password') or contains(text(),'6 characters required')]")
    private WebElement passwordError;

    @FindBy(xpath = "//div[contains(@id,'passwordCheck-missing')]//div[contains(text(),'Type your password again')]")
    private WebElement passwordCheckError;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement registerButton;

    public void enterName(final String username) {
        nameField.sendKeys(username);
    }

    public void enterEmail(final String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(final String password) {
        passwordField.sendKeys(password);
    }

    public void enterPasswordCheck(final String passwordCheck) {
        passwordCheckField.sendKeys(passwordCheck);
    }

    public boolean isNameErrorVisible() {
        return nameError.isDisplayed();
    }

    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public boolean isPasswordErrorVisible() {
        return passwordError.isDisplayed();
    }

    public boolean isPasswordCheckErrorVisible() {
        return passwordCheckError.isDisplayed();
    }

    public WebElement getNameError() {
        return nameError;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getPasswordError() {
        return passwordError;
    }

    public WebElement getPasswordCheckError() {
        return passwordCheckError;
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
}
