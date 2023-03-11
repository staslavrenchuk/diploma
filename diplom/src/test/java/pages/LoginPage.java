package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLogoLocator = By.className("logo-loginpage");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By emailInputFieldLocator = By.id("name");

    @Override
    protected By getPageIdentifier() {
        return loginLogoLocator;
    }
    public Button getLogInButton() {
        return new Button(driver, logInButtonLocator);
    }
    public InputField getEmailField() {
        return new InputField(driver, emailInputFieldLocator);
    }
    public InputField getPasswordField() {
        return new InputField(driver, passwordInputLocator);
    }
}