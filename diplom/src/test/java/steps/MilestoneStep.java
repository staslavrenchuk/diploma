package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.MilestonesPage;
import tests.ui.positive.MilestoneTests;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class MilestoneStep extends BaseStep {
    private AddMilestonePage addMilestonePage;


    public MilestoneStep(WebDriver driver) {
        super(driver);
        addMilestonePage = new AddMilestonePage(driver);
    }
    public MilestoneStep(){

    }
    public void addMilestone(String name, String description) {
        addMilestonePage.getNameMilestoneInput().sendKeys(name);
        addMilestonePage.getDescriptionMilestoneInput().sendKeys(description);
        addMilestonePage.getAddMilestoneButton().click();
    }

    public void uploadFile(String nameOfFile) {
        addMilestonePage.getAddImage().click();
        addMilestonePage.getUploadFile();

        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath();
    }
    public MilestonesPage moveToMilestonesPageSuccessful(Milestone milestone) {
        addMilestone(milestone.getName(), milestone.getDescription());
        return new MilestonesPage(driver);
    }



}
