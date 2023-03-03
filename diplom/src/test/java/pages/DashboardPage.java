package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final By dashboardLogoLocator = By.xpath("//div[contains(text(), 'All Projects')]");

    private final By addProjectButtonLocator = By.id("sidebar-projects-add");
    private final By refineLocator = By.id("chart-refine");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }
    public WebElement getRefineElement() {
        return driver.findElement(refineLocator);
    }

    @Override
    protected By getPageIdentifier() {
        return dashboardLogoLocator;
    }
}
