package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMilestonePage extends BasePage {

    private final By addMilestoneLogoLocator = By.xpath("//div[contains(text(), 'Add Milestone')]");
    private final By addImage = By.xpath("//*[@class='icon-markdown-image']");
    private final By uploadFile = By.xpath("//input[@type='file' and @class='dz-hidden-input'][3]");


    public WebElement getAddImage() {
        return driver.findElement(addImage);
    }
    public WebElement getUploadFile() {
        return driver.findElement(uploadFile);
    }


    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneLogoLocator;
    }
    public Button getAttachButton() {
        return new Button(driver, By.xpath("//button[@id='attachmentNewSubmit']"));
    }
    public Button getAddTableDialogWindowButton() {
        return new Button(driver, By.id("addTableSubmit"));
    }
    public Button getDialogWindowButtonLocator() {
        return new Button(driver, By.xpath("//*[@class='icon-markdown-table']"));
    }
}