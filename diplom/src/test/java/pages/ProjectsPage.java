package pages;

import baseEntities.BasePage;
import elements.Button;
import elements.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

    private final By projectsLogoLocator = By.xpath("//div[contains(text(), 'Projects')]");
    private final By addProjectButtonLocator = By.xpath("//*[contains(text(), 'Add Project')]");
    private final By deleteProjectButtonLocator = By.xpath("//input[@type='checkbox']");
    private final By okButtonLocator = By.xpath("//div[@id='deleteDialog']//a[@class='button button-ok button-left button-positive dialog-action-default']");

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return projectsLogoLocator;
    }
    public CheckBox deleteThisProject = new CheckBox(driver, deleteProjectButtonLocator);
    public Button okButton = new Button(driver, okButtonLocator);

}
