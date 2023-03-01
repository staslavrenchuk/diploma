package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.ProjectsPage;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProjectStep extends BaseStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;


    private Response response;
    private int projectId;


    public ProjectStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);

    }
    public ProjectStep(){
    }

    public void addProjectOnDashboardPage() {
        dashboardPage.getAddProjectButton().click();
    }

    public AddProjectPage moveToAddProjectPageSuccessful() {
        return new AddProjectPage(driver);
    }

    public void addProject(String name, String description) {
        addProjectPage.getNameInput().sendKeys(name);
        addProjectPage.getDescriptionInput().sendKeys(description);
        addProjectPage.getCheckBoxId();
        addProjectPage.getType();
        addProjectPage.getAddNewProjectButton().click();
    }

    public ProjectsPage moveToProjectPageSuccessful(String name, String description) {
        addProject(name, description);
        return new ProjectsPage(driver);
    }

    // API
    private void add(File file) {
        response = given()
                .body(file)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        projectId = response.getBody().jsonPath().getInt("id");
    }

    private void get(int projectId) {
        response = given()
                .pathParams("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    private void update(int projectId, File file) {
        response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        ;
    }

    private void delete(int projectId) {
        response = given()
                .pathParams("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public void addApiProject(File file) {
        add(file);
    }

    public void getApiProject(int projectId) {
        get(projectId);
    }

    public void updateApiProject(int projectId, File file) {
        update(projectId, file);
    }

    public void deleteApiProject(int projectId) {
        delete(projectId);
    }
    public Response getResponse() {
        return response;
    }

    public int getProjectId() {
        return projectId;
    }

}