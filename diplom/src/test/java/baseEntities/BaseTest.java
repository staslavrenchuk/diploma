package baseEntities;
import configuration.ReadProperties;
import factory.BrowserFactory;
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

    private boolean compare(WebElement element, String innerText){
        return Objects.equals(element.getText(), innerText);
    }
    public boolean checkTooltip(WebElement element, String innerText){
        return compare(element, innerText);
    }

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
        waitsService = new WaitsService(driver);

        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
