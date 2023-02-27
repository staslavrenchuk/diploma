package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

    private final By projectsLogoLocator = By.xpath("//div[contains(text(), 'Projects')]");
    private final By addProjectButtonLocator = By.xpath("//*[contains(text(), 'Add Project')]");

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
}
