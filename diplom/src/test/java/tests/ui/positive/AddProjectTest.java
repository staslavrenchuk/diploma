package tests.ui.positive;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;

public class AddProjectTest extends BaseTest {

    @Test(description = "project is adding in this test")

    public void addNewProjectTest()  {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());


        ProjectStep projectStep = new ProjectStep(driver);
        Assert.assertTrue(projectStep.addProjectOnDashboard().isPageOpened());

        Project project = Project.builder()
                .name("ProjectTest")
                .description("DescriptionTest")
                .build();

        Assert.assertTrue(projectStep.moveToProjectPageSuccessful(project).isPageOpened());

    }
}