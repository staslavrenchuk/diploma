package tests.ui.negative;

import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.LoginStep;

public class ShouldBeFailedTest {
    private WebDriver driver;

    @Test(groups = "Regression")

    public void incorrectDataTest() {
        LoginStep loginStep = new LoginStep(driver);

        loginStep.unsuccessfulLogin("nastyamyshko123@gmail.co", "Password_123");

        Assert.assertFalse(loginStep.successfulLogin().isPageOpened());

    }

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
        iTestContext.setAttribute("driver", driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}