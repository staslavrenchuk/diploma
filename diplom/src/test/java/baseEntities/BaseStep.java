package baseEntities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class BaseStep {
    protected WebDriver driver;
    protected Logger logger;


    public BaseStep(WebDriver driver) {
        this.driver = driver;
        logger = LogManager.getLogger();
    }

    public BaseStep() {

    }
}
