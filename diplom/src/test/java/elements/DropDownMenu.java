package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import services.WaitsService;


public class DropDownMenu {
    private final UIElement dropDown;
    private final WaitsService wait;


    public DropDownMenu(WebDriver driver, By by) {
        this.dropDown = new UIElement(driver, by);
        wait = new WaitsService(driver);
    }

    private void showMenu() {
        dropDown.click();
    }

    public void selectByName(String name) {
        showMenu();
        wait.waitForElementVisible(dropDown.findUIElement
                (By.xpath("//*[@class = 'active-result' and text() = '" + name + "']"))).click();

    }


    public void search(String text) {
        showMenu();
        wait.waitForElementVisible(dropDown.findUIElement(By.tagName("input"))).sendKeys(text + Keys.ENTER);

    }    public void filterByText(String text) {
        showMenu();
        wait.waitForElementVisible(dropDown.findUIElement(By.tagName("input"))).sendKeys(text);

    }
}
