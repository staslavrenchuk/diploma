package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class ToolTipStep extends BaseStep {
    private DashboardPage dashboardPage = new DashboardPage(driver);

    public ToolTipStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public void compareExpectedActualToolTip(String actualToolTip) {
        dashboardPage.getRefine().equals(actualToolTip);
    }

    public DashboardPage campare(String actualToolTip) {
        compareExpectedActualToolTip(actualToolTip);
        return new DashboardPage(driver);
    }
}
