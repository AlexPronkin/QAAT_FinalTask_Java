package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[contains(@type,'email')]")
    private WebElement usernameField;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(@id,'auth-error-message')]//*[contains(@class,'a-list-item')]")
    private WebElement usernameError;

    @FindBy(xpath = "//a[contains(@id,'createAccountSubmit')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class,'row')]//div[contains(@class,'alert-content')]")
    private WebElement emptyFieldError;

    public String getErrorMessageText() {
        return usernameError.getText();
    }

    public void enterUsername(final String username) {
        usernameField.sendKeys(username);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isEmptyFieldErrorVisible() {
        return emptyFieldError.isDisplayed();
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}
