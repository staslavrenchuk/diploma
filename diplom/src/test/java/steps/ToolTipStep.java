package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class ToolTipStep extends BaseStep {
    private DashboardPage dashboardPage;

    public ToolTipStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public void compareExpectedActualToolTip(String attribute) {
        dashboardPage.toolTip().getAttribute(attribute);
    }

    public DashboardPage campare(String attribute) {
        compareExpectedActualToolTip(attribute);
        return new DashboardPage(driver);
    }
}
