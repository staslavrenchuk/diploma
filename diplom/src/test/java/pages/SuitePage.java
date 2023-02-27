package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuitePage extends BasePage {

    private final By suitePageLogoLocator = By.xpath("//*[@class=\"content-header-title page_title\"]");


    public SuitePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return suitePageLogoLocator;
    }
}
