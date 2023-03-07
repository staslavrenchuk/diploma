package tests.ui.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;
import tests.data.StaticProvider;

public class LimitValuesTest extends BaseTest {

    @Test(dataProvider = "dataForLimitValues", dataProviderClass = StaticProvider.class, threadPoolSize = 2, groups = "Smoke, Regression")

    public void limitValuesTest(String a, String description) {

        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        ProjectStep projectStep = new ProjectStep(driver);
        Assert.assertTrue(projectStep.addProjectOnDashboard().isPageOpened());

        Assert.assertTrue(projectStep.moveToProjectPageSuccessful(a, "Description").isPageOpened());

    }
}
