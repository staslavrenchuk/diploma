package helpers;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import java.util.Objects;
 public class CommonMethods {

   public static boolean checkTooltip(WebElement element, String innerText){
        return Objects.equals(element.getText(), innerText);
    }
}
