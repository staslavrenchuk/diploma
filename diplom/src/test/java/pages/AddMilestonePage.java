package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestonesLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By nameMilestoneInputLocator = By.id("name");
    private final By addMilestoneButtonLocator = By.id("accept");
    private final By checkBoxMilestoneIsCompletedLocator = By.id("is_completed"); //можно раппер на чекбокс сделать


    public WebElement getNameMilestoneInput() {
        return driver.findElement(nameMilestoneInputLocator);
    }

    public WebElement getaddMilestone() {
        return driver.findElement(addMilestoneButtonLocator);
    }

    public WebElement getCheckBoxMilestoneIsCompleted() {
        return driver.findElement(checkBoxMilestoneIsCompletedLocator);
    }


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestonesLogoLocator;
    }
}
