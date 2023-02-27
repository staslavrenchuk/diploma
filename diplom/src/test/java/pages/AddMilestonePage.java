package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestoneLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By inputMilestoneNameLocator = By.id("name");
    private final By addMilestoneButtonLocator = By.id("accept");
    private final By checkBoxMilestoneIsCompletedLocator = By.id("is_completed");
    private final By uploadImageToDescriptionLocator = By.xpath("//*[@class='icon-markdown-image']");
    private final By uploadImageLocator = By.xpath("//*[@class='attachment-library-add-icon dz-clickable']");



    public WebElement getNameMilestoneInput() {
        return driver.findElement(inputMilestoneNameLocator);
    }
    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneLogoLocator);
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
        return addMilestoneLogoLocator ;
    }
}
