package tests.ui.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;
import steps.ToolTipStep;

public class ToolTipTest extends BaseTest {

    @Test

    public void getText() {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        String expectedToolTip = "Refine";

        ToolTipStep toolTipStep = new ToolTipStep(driver);

        Assert.assertTrue(toolTipStep.campare(expectedToolTip).isPageOpened());

    }
}
