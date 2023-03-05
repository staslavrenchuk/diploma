package baseEntities;
import configuration.ReadProperties;
import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.InvokedListener;
import services.WaitsService;

import java.util.Objects;

@Listeners(InvokedListener.class)

public class BaseTest {
    protected WebDriver driver;
    protected WaitsService waitsService;
    protected Logger logger;


    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
        Logger logger = LogManager.getLogger();

        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
