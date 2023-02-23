package steps;

import baseEntities.BaseStep;
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
        dashboardPage.getAddProgectDashboardPage().click();
    }

    public AddProjectPage moveToAddProjectPageSuccessful() {
        return new AddProjectPage(driver);
    }

    public void addProject(String name) {
        addProjectPage.getNameInput().sendKeys(name);
        addProjectPage.getAddNewProject().click();
    }

    public ProjectsPage moveToProjectPageSuccessful(String name) {
        addProject(name);
        return new ProjectsPage(driver);
    }
}
