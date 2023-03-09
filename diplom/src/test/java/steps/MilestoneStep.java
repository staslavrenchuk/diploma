package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.MilestonesPage;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class MilestoneStep extends BaseStep {
    private AddMilestonePage addMilestonePage;
    private MilestonesPage milestonesPage;
    private int milestoneId;
    private Response response;

    public MilestoneStep(WebDriver driver) {
        super(driver);
        addMilestonePage = new AddMilestonePage(driver);
    }

    public MilestoneStep() {

    }

    public void uploadFile(String pathToFile) throws InterruptedException {
        addMilestonePage.getAddImage().click();
        addMilestonePage.getUploadFile().sendKeys(pathToFile);
        for (int i = 0; i < 10000; i++){
            if (driver.findElement(By.id("libraryDeleteAttachment")).isDisplayed()){
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


    // API private
    public Response add(int projectId, File file) {
        return given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .extract().response();

    }

    public Response get(int milestoneId) {
        return given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response update(int milestoneId, File file) {
        return given()
                .pathParams("milestone_id", milestoneId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response delete(int milestoneId) {
        return given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    //API public

    public Response addApiMilestone(int projectId, File file) {
        response = add(projectId, file);
        return response;
    }

    public Response getApiMilestone(int milestoneId) {
        return get(milestoneId);
    }

    public Response updateApiMilestone(int milestoneId, File file) {
        return update(milestoneId, file);
    }

    public Response deleteApiMilestone(int projectId) {
        return delete(projectId);
    }

    public void setMilestoneId() {
        milestoneId = response.getBody().jsonPath().getInt("id");
    }

    public int getMilestoneId() {
        return milestoneId;
    }
}
