package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.AddMilestonePage;
import pages.MilestonesPage;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class MilestoneStep extends BaseStep {
    private AddMilestonePage addMilestonePage;

    private int milestoneId;
    private Response response;


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
    public MilestonesPage moveToMilestonesPageSuccessful(Milestone milestone) {
        addMilestone(milestone.getName(), milestone.getDescription());
        return new MilestonesPage(driver);
    }


    private void add(int projectId, File file) {
        response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .extract().response();
        setMilestoneId();
    }

    private void get(int milestoneId) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    private void update(int milestoneId, File file) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
        ;
    }

    private void delete(int milestoneId) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
        ;
    }

    public void addApiMilestone(int projectId, File file) {
        add(projectId, file);
    }

    public void getApiMilestone(int milestoneId) {
        get(milestoneId);
    }

    public void updateApiMilestone(int milestoneId, File file) {
        update(milestoneId, file);
    }

    public void deleteApiMilestone(int projectId) {
        delete(projectId);
    }


    public int getMilestoneId() {
        return milestoneId;
    }

    public Response getResponse() {
        return response;
    }
    public void setMilestoneId() {
        milestoneId =  response.getBody().jsonPath().getInt("id");
    }
}
