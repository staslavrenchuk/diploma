package baseEntities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class BaseStep {
    protected WebDriver driver;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
    }
    public BaseStep(){

    }
}
