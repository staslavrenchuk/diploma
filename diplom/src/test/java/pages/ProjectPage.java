package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    private final By projectPageTitleLocator = By.xpath("//*[@class=\"content-header-title page_title\"]");
    private final By addMilestoneButtonLocator = By.id("navigation-overview-addmilestones");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return projectPageTitleLocator;
    }
    public Button getMilestoneButton() {
        return new Button(driver, addMilestoneButtonLocator);
    }
}
