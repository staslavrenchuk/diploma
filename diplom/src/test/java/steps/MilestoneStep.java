package steps;

import adapters.MilestoneAdapter;
import baseEntities.BaseStep;
import elements.Button;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import services.WaitsService;

import java.io.File;

public class MilestoneStep extends BaseStep {
    private AddMilestonePage addMilestonePage;
    private int milestoneId;
    private Response response;
    private MilestoneAdapter milestoneAdapter;

    public MilestoneStep(WebDriver driver) {
        super(driver);
        addMilestonePage = new AddMilestonePage(driver);
    }

    public MilestoneStep() {
        milestoneAdapter = new MilestoneAdapter();
    }

    public void uploadFile(String pathToFile) {
        addMilestonePage.getAddImageLocator().click();
        addMilestonePage.getUploadFileLocator().sendKeys(pathToFile);
        WaitsService waitsService = new WaitsService(driver);

        waitsService.waitForElementVisible(addMilestonePage.getDeleteButton());
        addMilestonePage.getAttachButton().click();

    }

    public void dialogWindows() {
        addMilestonePage.getDialogWindowButtonLocator().click();
        addMilestonePage.getAddTableDialogWindowButton().click();
    }

    public AddMilestonePage uploadFileSuccessful(String pathToFile) {
        uploadFile(pathToFile);
        return new AddMilestonePage(driver);
    }

    public AddMilestonePage checkDialogWindow() {
        dialogWindows();
        return new AddMilestonePage(driver);
    }

    public Response addApiMilestone(int projectId, File file) {
        response = milestoneAdapter.add(projectId, file);
        return response;
    }

    public Response getApiMilestone(int milestoneId) {
        return milestoneAdapter.get(milestoneId);
    }

    public Response deleteApiMilestone(int projectId) {
        return milestoneAdapter.delete(projectId);
    }

    public void setMilestoneId() {
        milestoneId = response.getBody().jsonPath().getInt("id");
    }

    public int getMilestoneId() {
        return milestoneId;
    }
}