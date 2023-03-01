package baseEntities;
import configuration.ReadProperties;
import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.InvokedListener;

@Listeners(InvokedListener.class)
public class BaseTest {
    protected WebDriver driver;

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
