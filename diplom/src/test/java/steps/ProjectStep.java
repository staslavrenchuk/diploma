package steps;

import baseEntities.BaseStep;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.ProjectsPage;

public class ProjectStep extends BaseStep {

    private DashboardPage dashboardPage;
    private AddProjectPage addProjectPage;


    public ProjectStep(WebDriver driver) {
        super(driver);

        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);

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
}