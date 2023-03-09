package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends BasePage {

    private final By projectsLogoLocator = By.xpath("//div[contains(text(), 'Projects')]");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return projectsLogoLocator;
    }
    public CheckBox getDeleteProjectButton(){
        return new CheckBox(driver, By.xpath("//*[text()='Yes, delete this project (cannot be undone)']"));
    }
    public Button getOkButton() {
        return new Button(driver, By.xpath("(//a[@class='button button-ok button-left button-positive dialog-action-default'])[4]"));
    }
}