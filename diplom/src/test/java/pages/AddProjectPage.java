package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import elements.InputField;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final By addProjectLogoLocator = By.xpath("//div[contains(text(), 'Add Project')]");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addProjectLogoLocator;
    }
    public InputField getNameField() {
        return new InputField(driver, driver.findElement(By.id("name")));
    }public InputField getDescriptionField() {
        return new InputField(driver, driver.findElement(By.id("announcement")));
    }
    public RadioButton getType() {
        return new RadioButton(driver, "suite_mode");
    }

    public CheckBox getCheckBoxId() {
        return new CheckBox(driver, By.id("show_announcement"));
    }

    public Button getAcceptButton() {
        return new Button(driver, By.id("accept"));
    }
    public Button getProjectsButton() {
        return new Button(driver, By.id("navigation-sub-projects"));
    }
}
