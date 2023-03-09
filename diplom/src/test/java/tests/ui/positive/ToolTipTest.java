package tests.ui.positive;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import helpers.CommonMethods;

public class ToolTipTest extends BaseTest {
    private final Logger logger= LogManager.getLogger();

    @Test (groups = "Smoke, Regression")

    public void tooltipTest() {

        DashboardPage page  = new DashboardPage(driver);
        Assert.assertTrue(CommonMethods.checkTooltip(page.getRefineElement(), "Refine"));

        logger.trace("Tooltip is checked");
    }
}