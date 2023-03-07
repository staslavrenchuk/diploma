package tests.ui.negative;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

public class IncorrectDataTest extends BaseTest {

    @Test(groups = "smoke")

    public void incorrectDataTest() {
        LoginStep loginStep = new LoginStep(driver);

        loginStep.unsuccessfulLogin("nastyamyshko123@gmail.co", "Password_123");

        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());
    }
}