package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTestSuitePage;
import pages.SuitePage;
import pages.SuitesAndCasesPage;

public class SuitesStep extends BaseStep {

    private SuitesAndCasesPage suitesAndCasesPage;
    private AddTestSuitePage addTestSuitePage;

    public SuitesStep(WebDriver driver) {
        super(driver);
        suitesAndCasesPage = new SuitesAndCasesPage(driver);
        addTestSuitePage = new AddTestSuitePage(driver);
    }

    public void addTestSuiteOnTestSuitesPage() {
        suitesAndCasesPage.getAddSuiteLocator().click();
    }

    public AddTestSuitePage moveToAddTestSuitesPageSuccessful() {
        return new AddTestSuitePage(driver);
    }

    private void addTestSuite(String name) {
        addTestSuitePage.getNameInput().sendKeys(name);
        addTestSuitePage.getAddTestSuiteButton().click();
    }

    public SuitePage addTestSuiteSuccessful(String name) {
        addTestSuite(name);
        return new SuitePage(driver);
    }
}
