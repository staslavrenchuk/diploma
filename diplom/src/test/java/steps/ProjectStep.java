package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProjectStep extends BaseStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    private MilestonesPage milestonesPage;

    private int projectId;


    public ProjectStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectPage = new ProjectPage(driver);
        milestonesPage = new MilestonesPage(driver);
    }
    public ProjectStep(){

    }

    public void addProjectOnDashboardPage() {
        dashboardPage.getAddProjectButton().click();
    }

    public AddProjectPage addProjectOnDashboard() {
        addProjectOnDashboardPage();
        return new AddProjectPage(driver);
    }

    public void addProject(String name, String description) {
        addProjectPage.getNameField().sendKeys(name);
        addProjectPage.getDescriptionField().sendKeys(description);
        addProjectPage.getCheckBoxId().setFlag();
        addProjectPage.getType().selectByValue("1");
        addProjectPage.getAcceptButton().click();

        logger.trace("Name for project - " + name + " ,description - " + description);

    }

    public void delete(String projectName){
        driver.findElement(By
                .xpath("//a[text()='"+projectName+"']/parent::td/following-sibling::td[2]/child::a/child::div"))
                .click();
        projectsPage.getDeleteProjectButton().setFlag();
        projectsPage.getOkButton().click();

        logger.trace("A project - " + projectName + " is deleted");
    }

    public void selectProject(String projectName){
        driver.findElement(By
                .xpath("//a[text()='"+projectName+"']"))
                .click();
        projectPage.getMilestoneButton().click();


        logger.trace("A project - " + projectName + " is selected");
    }
    public void moveToProjects(){
        addProjectPage.getProjectsButton().click();


        logger.trace("Moving to all projects");
    }

    public ProjectsPage projectDeleteSuccessful(String projectName) {
        delete(projectName);
        return new ProjectsPage(driver);
    }

    public ProjectsPage moveToProjectPageSuccessful(String name, String description) {
        addProject(name, description);
        return new ProjectsPage(driver);
    }

    public ProjectsPage moveToProjectPageSuccessful(Project project)  {
        return moveToProjectPageSuccessful(project.getName(), project.getDescription());
    }
    public ProjectsPage moveToProjectPageSuccessful(String projectName)  {
        selectProject(projectName);
        return new ProjectsPage(driver);
    }
    public ProjectsPage moveToAllProjects()  {
        moveToProjects();
        return new ProjectsPage(driver);
    }


    //API

    private Response add(File file) {
        Response response = given()
                .body(file)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return response;
    }

    private Response get(int projectId) {
        return given()
                .pathParams("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    private Response update(int projectId, File file) {
        return given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    private Response delete(int projectId) {
        return given()
                .pathParams("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public Response addApiProject(File file) {
        Response response = add(file);
        projectId = response.getBody().jsonPath().getInt("id");
        return response;
    }

    public Response getApiProject(int projectId) {
        return get(projectId);
    }

    public Response updateApiProject(int projectId, File file) {
        return update(projectId, file);
    }

    public Response deleteApiProject(int projectId) {
        return delete(projectId);
    }

    public int getProjectId() {
        return projectId;
    }
}