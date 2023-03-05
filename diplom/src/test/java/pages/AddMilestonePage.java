package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestoneLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By inputMilestoneNameLocator = By.id("name");
    private final By inputMilestoneDescriptionLocator = By.id("description_display");
    private final By addMilestoneButtonLocator = By.id("accept");
    private final By checkBoxMilestoneIsCompletedLocator = By.id("is_completed");
    private final By addImage = By.xpath("//*[@class='icon-markdown-image']");
    private final By uploadFile = By.xpath("is_completed");


    public WebElement getNameMilestoneInput() {
        return driver.findElement(inputMilestoneNameLocator);
    }

    public WebElement getDescriptionMilestoneInput() {
        return driver.findElement(inputMilestoneDescriptionLocator);
    }

    public WebElement getAddMilestoneButton() {
        return driver.findElement(addMilestoneLogoLocator);
    }
    public WebElement getAddImage() {
        return driver.findElement(addImage);
    }
    public WebElement getUploadFile() {
        return driver.findElement(uploadFile);
    }

    public WebElement getCheckBoxMilestoneIsCompleted() {
        return driver.findElement(checkBoxMilestoneIsCompletedLocator);
    }


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneLogoLocator;
    }
}
