package steps;

import adapters.ProjectAdapter;
import baseEntities.BaseStep;
import configuration.ReadProperties;
import io.restassured.response.Response;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import services.WaitsService;

import java.io.File;
import java.time.Duration;

public class ProjectStep extends BaseStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    private MilestonesPage milestonesPage;
    private ProjectAdapter projectAdapter;
    private WebDriverWait wait;

    private int projectId;


    public ProjectStep(WebDriver driver) {
        super(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectPage = new ProjectPage(driver);
        milestonesPage = new MilestonesPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }
    public ProjectStep(){
        projectAdapter = new ProjectAdapter();
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

    public void delete(String projectName) throws InterruptedException {
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

    public ProjectsPage projectDeleteSuccessful(String projectName) throws InterruptedException {
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

    public Response addApiProject(File file) {
        Response response = projectAdapter.add(file);
        projectId = response.getBody().jsonPath().getInt("id");
        return response;
    }

    public Response getApiProject(int projectId) {
        return projectAdapter.get(projectId);
    }

    public Response updateApiProject(int projectId, File file) {
        return projectAdapter.update(projectId, file);
    }

    public Response deleteApiProject(int projectId) {
        return projectAdapter.delete(projectId);
    }

    public int getProjectId() {
        return projectId;
    }
}