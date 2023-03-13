package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestoneLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By addImageLocator = By.xpath("//*[@class='icon-markdown-image']");
    private final By uploadFileLocator = By.xpath("//input[@type='file' and @class='dz-hidden-input'][3]");

    private final By attachButtonLocator = By.xpath("//button[@id='attachmentNewSubmit']");
    private final By addTableDialogWindowButtonLocator = By.id("addTableSubmit");
    private final By dialogWindowButtonLocator = By.xpath("//*[@class='icon-markdown-table']");

    private final By deleteButtonLocator = By.id("libraryDeleteAttachment");
    private final By uploadedFileLocator = By.xpath("//*[@class='attachment-list-item attachment-block attachment-picture']");

    public WebElement getAddImageLocator() {
        return driver.findElement(addImageLocator);
    }

    public WebElement getUploadFileLocator() {
        return driver.findElement(uploadFileLocator);
    }


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneLogoLocator;
    }

    public Button getAttachButton() {
        return new Button(driver, attachButtonLocator);
    }

    public Button getAddTableDialogWindowButton() {
        return new Button(driver, addTableDialogWindowButtonLocator);
    }

    public Button getDialogWindowButtonLocator() {
        return new Button(driver, dialogWindowButtonLocator);
    }
    public Button getDeleteButton(){
        return new Button(driver, deleteButtonLocator);
    }
    public WebElement uploadedFile(){
        return driver.findElement(uploadedFileLocator);
    }
}