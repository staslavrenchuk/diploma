package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final By addProjectLogoLocator = By.xpath("//div[contains(text(), 'Add Project')]");

    private final By nameInputLocator = By.id("name");

    private final By addProjectButtonLocator = By.id("accept");

    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }

    public WebElement getAddNewProject() {
        return driver.findElement(addProjectButtonLocator);
    }

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectLogoLocator;
    }
}