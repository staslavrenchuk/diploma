package pages;

import baseEntities.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final By dashboardLogoLocator = By.xpath("//div[contains(text(), 'All Projects')]");
    private final By refineLocator = By.id("chart-refine");
    private final By addProjectButtonLocator = By.id("sidebar-projects-add");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRefineElement() {
        return driver.findElement(refineLocator);
    }

    @Override
    protected By getPageIdentifier() {
        return dashboardLogoLocator;
    }

    public Button getAddProjectButton() {
        return new Button(driver, addProjectButtonLocator);
    }
}