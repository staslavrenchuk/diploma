package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.InputField;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddProjectPage extends BasePage {

    private final By addProjectLogoLocator = By.xpath("//div[contains(text(), 'Add Project')]");

    private final By nameFieldLocator = By.id("name");
    private final By descriptionFieldLocator = By.id("announcement");
    private final By checkBoxIdLocator = By.id("show_announcement");
    private final By acceptButtonLocator = By.id("accept");
    private final By projectsButtonLocator = By.id("navigation-sub-projects");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectLogoLocator;
    }

    public InputField getNameField() {
        return new InputField(driver, nameFieldLocator);
    }

    public InputField getDescriptionField() {
        return new InputField(driver, descriptionFieldLocator);
    }

    public RadioButton getType() {
        return new RadioButton(driver, "suite_mode");
    }

    public CheckBox getCheckBoxId() {
        return new CheckBox(driver, checkBoxIdLocator);
    }

    public Button getAcceptButton() {
        return new Button(driver, acceptButtonLocator);
    }

    public Button getProjectsButton() {
        return new Button(driver, projectsButtonLocator);
    }
}
