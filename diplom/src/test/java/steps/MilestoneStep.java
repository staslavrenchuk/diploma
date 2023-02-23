package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.MilestonesPage;

public class MilestoneStep extends BaseStep {
    private AddMilestonePage addMilestonePage;

    public MilestoneStep(WebDriver driver) {
        super(driver);

        addMilestonePage = new AddMilestonePage(driver);
    }
    public void addMilestone(String name) {
        addMilestonePage.getNameMilestoneInput().sendKeys(name);
        addMilestonePage.getAddMilestone().click();
    }

    public MilestonesPage moveToMilestonesPageSuccessful(String name) {
        addMilestone(name);
        return new MilestonesPage(driver);
    }
}
