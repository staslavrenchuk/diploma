package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestonesPage extends BasePage {

    private final By milestonesPageTitleLocator = By.xpath("//*[@class=\"content-header-title page_title\"]");
    private final By addMilestoneButtonLocator = By.xpath("//*[@class=\"button button-left button-add\"]");
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesPageTitleLocator;
    }

    public Button getAddMilestoneButton() {
        return new Button(driver, addMilestoneButtonLocator);
    }
}
