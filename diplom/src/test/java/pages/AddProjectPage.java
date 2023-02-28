package pages;

import baseEntities.BasePage;
import elements.CheckBox;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final By addProjectLogoLocator = By.xpath("//div[contains(text(), 'Add Project')]");

    private final By nameInputLocator = By.id("name");
    private final By descriptionInputLocator = By.id("announcement");

    private final By addProjectButtonLocator = By.id("accept");

    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }
    public WebElement getDescriptionInput() {
        return driver.findElement(descriptionInputLocator);
    }

    public WebElement getAddNewProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectLogoLocator;
    }
    public RadioButton getType() {
        return new RadioButton(driver, "suite_mode");
    }

    public CheckBox getCheckBoxId() {
        return new CheckBox(driver, By.id("show_announcement"));
    }
}
