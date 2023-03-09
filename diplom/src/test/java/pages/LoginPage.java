package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginLogoLocator = By.className("logo-loginpage");
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");

    @Override
    protected By getPageIdentifier() {
        return loginLogoLocator;
    }
    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public Button getLogInButton() {
        return new Button(driver, By.id("button_primary"));
    }
}
