package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestonesLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By nameMilestoneInputLocator = By.id("name");
    private final By addMilestoneButtonLocator = By.id("accept");
    private final By checkBoxMilestoneIsCompletedLocator = By.id("is_completed");
    private final By uploadImageLocator = By.xpath("//*[@class=\"icon-markdown-image\"]");



    public WebElement getNameMilestoneInput() {
        return driver.findElement(nameMilestoneInputLocator);
    }

    public WebElement getAddMilestone() {
        return driver.findElement(addMilestoneButtonLocator);
    }
    public WebElement getUploadImage() {
        return driver.findElement(uploadImageLocator);
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
