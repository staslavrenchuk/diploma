package tests.ui.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginStep;

public class ToolTipTest extends BaseTest {



    @Test

    public void tooltipTest() {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        DashboardPage page  = new DashboardPage(driver);

        Assert.assertTrue(checkTooltip(page.getRefineElement(), "Refine"));
    }
}
