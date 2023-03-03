package steps;

import baseEntities.BaseStep;
import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.ProjectsPage;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProjectStep extends BaseStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private ProjectsPage projectsPage;

    private Response response;
    private int projectId;


    public ProjectStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    public ProjectStep() {
    }

    public void addProjectOnDashboardPage() {
        dashboardPage.getAddProjectButton().click();
    }

    public AddProjectPage addProjectOnDashboard() {
        addProjectOnDashboardPage();
        return new AddProjectPage(driver);
    }

    public void addProject(String name, String description) {
        addProjectPage.getNameInput().sendKeys(name);
        addProjectPage.getDescriptionInput().sendKeys(description);
        addProjectPage.getCheckBoxId().setFlag();
        addProjectPage.getType().selectByValue("1");
        addProjectPage.getAddNewProjectButton().click();
    }

    public void delete(String projectName){
        driver.findElement(By.xpath("//a[text()='"+projectName+"']/parent::td/following-sibling::td[2]/child::a/child::div")).click();
        projectsPage.deleteThisProject.setFlag();
        projectsPage.okButton.click();
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