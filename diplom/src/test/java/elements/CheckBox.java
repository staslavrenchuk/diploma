package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private final UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public void setFlag() {
        if (!isSelected()) {
            click();
        }
    }

    public void removeFlag() {
        if (isSelected()) {
            click();
        }
    }

    public boolean isSelected() {
        return uiElement.isSelected();
    }

    private void click() {
        uiElement.click();
    }



}