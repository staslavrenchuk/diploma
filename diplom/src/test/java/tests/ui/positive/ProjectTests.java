package tests.ui.positive;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;


public class ProjectTests extends BaseTest {

    private Project project;

    @Test(description = "project is adding in this test", groups = "Smoke")

    public void addNewProjectTest()  {

        ProjectStep projectStep = new ProjectStep(driver);
        Assert.assertTrue(projectStep.addProjectOnDashboard().isPageOpened());

        project = Project.builder()
                .name("ProjectTest")
                .description("DescriptionTest")
                .build();

        Assert.assertTrue(projectStep.moveToProjectPageSuccessful(project).isPageOpened());

    }
    @Test(groups = "Smoke")
    public void deleteProject() {
         driver.get("https://diploma123.testrail.io/index.php?/admin/projects/overview");

        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.projectDeleteSuccessful(project.getName());
    }
}