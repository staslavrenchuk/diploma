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
//    public void addMilestone(String name, String description) {
//        addMilestonePage.getNameMilestoneInput().sendKeys(name);
//        addMilestonePage.getDescriptionMilestoneInput().sendKeys(description);
//        addMilestonePage.getAddMilestoneButton().click();
//    }

    public void uploadFile(String pathToFile) {
        addMilestonePage.getAddImage().click();
        addMilestonePage.getUploadFile().sendKeys(pathToFile);
        addMilestonePage.getAttachButton().click();

    }
    public void dialogWindows() {
        addMilestonePage.getDialogWindow().click();
        addMilestonePage.getAddTableDialogWindow().click();
    }
    public AddMilestonePage uploadFileSuccessful(String pathToFile){
        uploadFile(pathToFile);
        return new AddMilestonePage(driver);
    }
//    public MilestonesPage moveToMilestonesPageSuccessful(Milestone milestone) {
//        addMilestone(milestone.getName(), milestone.getDescription());
//        return new MilestonesPage(driver);
//    }

    public AddMilestonePage checkDialogWindow() {
        dialogWindows();
        return new AddMilestonePage(driver);
    }
}
