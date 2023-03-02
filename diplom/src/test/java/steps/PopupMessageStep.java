package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class PopupMessageStep extends BaseStep {

    private DashboardPage dashboardPage;

    public PopupMessageStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
    }

    public void checkPopupMessage() {
    }
}
