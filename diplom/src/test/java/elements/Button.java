package elements;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Button {
    private final UIElement uiElement;
    private final WebDriverWait wait;

    public Button(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(uiElement));
        uiElement.click();
    }
}