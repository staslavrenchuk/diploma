package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLogoLocator = By.className("logo-loginpage");
    private final By passwordInputLocator = By.id("password");

    @Override
    protected By getPageIdentifier() {
        return loginLogoLocator;
    }
    public Button getLogInButton() {
        return new Button(driver, By.id("button_primary"));
    }
    public InputField getEmailField() {
        return new InputField(driver, driver.findElement(By.id("name")));
    }
    public InputField getPasswordField() {
        return new InputField(driver, passwordInputLocator);
    }
}