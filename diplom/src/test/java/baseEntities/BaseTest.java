package baseEntities;
import configuration.ReadProperties;
import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.LoginStep;
import utils.InvokedListener;
import services.WaitsService;


@Listeners(InvokedListener.class)

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;

    protected LoginStep loginStep;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
        iTestContext.setAttribute("driver", driver);

        loginStep = new LoginStep(driver);
        loginStep.successfulLogin().isPageOpened();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
