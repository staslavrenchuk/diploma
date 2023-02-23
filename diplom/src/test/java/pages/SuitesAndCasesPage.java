package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuitesAndCasesPage extends BasePage {

    private final By suitesAndCasesLogoLocator = By.xpath("//div[contains(text(), 'Test Suites & Cases')]");
    private final By addTestSuiteButtonLocator = By.xpath("//*[contains(text(), 'Add Test Suite')]");

    public WebElement getAddSuiteLocator() {
        return driver.findElement(addTestSuiteButtonLocator);
    }


    public SuitesAndCasesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return suitesAndCasesLogoLocator;
    }
}
