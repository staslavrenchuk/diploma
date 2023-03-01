package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {

    private final By milestonesLogoLocator = By.xpath("//div[contains(text(), 'Milestones')]");

    private final By addMilestoneButtonLocator = By.xpath("//*[contains(text(), 'Add Milestone')]");


    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneButtonLocator);
    }


    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return milestonesLogoLocator;
    }
}
