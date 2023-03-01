package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddTestSuitePage extends BasePage {

    private final By addTestSuiteLogoLocator = By.xpath("//div[contains(text(), 'Add Test Suite')]");
    private final By nameInputLocator = By.id("name");
    private final By addTestSuiteButtonLocator = By.id("accept");

    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }

    public WebElement getAddTestSuiteButton() {
        return driver.findElement(addTestSuiteButtonLocator);
    }


    public AddTestSuitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addTestSuiteLogoLocator;
    }
}
