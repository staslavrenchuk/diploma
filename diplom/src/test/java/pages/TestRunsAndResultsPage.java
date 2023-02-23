package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRunsAndResultsPage extends BasePage {

    private final By testRunsResultsLogoLocator = By.id("navigation-runs");
    private final By addTestRunLocator = By.xpath("//*[contains(text(), 'Add Test Run')]");

    public WebElement getAddTestRun() {
        return driver.findElement(addTestRunLocator);
    }

    public TestRunsAndResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return testRunsResultsLogoLocator;
    }
}
