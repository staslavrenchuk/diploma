package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputField {
    private final UIElement uiElement;

    public InputField(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public InputField(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void sendKeys(CharSequence... keysToSend) {
      uiElement.sendKeys(keysToSend);
    }
}
