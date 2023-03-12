package steps;

import adapters.MilestoneAdapter;
import baseEntities.BaseStep;
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
    private WaitsService waitsService;

    public MilestoneStep(WebDriver driver) {
        super(driver);
        addMilestonePage = new AddMilestonePage(driver);
    }

    public MilestoneStep() {
        milestoneAdapter = new MilestoneAdapter();
    }

    public void uploadFile(String pathToFile) throws InterruptedException {
        addMilestonePage.getAddImageLocator().click();
        addMilestonePage.getUploadFileLocator().sendKeys(pathToFile);

        for (int i = 0; i < 10000; i++) {
            if (addMilestonePage.getDeleteButton().isDisplayed()) {
                addMilestonePage.getAttachButton().click();
                return;
            } else {
                Thread.sleep(500);
                i++;
            }
        }
    }

    public void dialogWindows() {
        addMilestonePage.getDialogWindowButtonLocator().click();
        addMilestonePage.getAddTableDialogWindowButton().click();
    }

    public AddMilestonePage uploadFileSuccessful(String pathToFile) throws InterruptedException {
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
