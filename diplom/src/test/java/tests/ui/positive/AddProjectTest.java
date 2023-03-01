package tests.ui.positive;

import baseEntities.BaseTest;
import models.Project;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;

public class AddProjectTest extends BaseTest {

    @Test(description = "project is adding in this test")

    public void addNewProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.successfulLogin();
//
//        ProjectStep projectStep = new ProjectStep(driver);
//        projectStep.addProjectOnDashboardPage();
//        projectStep.addProject("NewProjectTest", "NewDescriptionTest");

        ProjectStep projectStep = new ProjectStep(driver);
        projectStep.addProjectOnDashboardPage();
        Project project = Project.builder()
                .name("NewProjectTest")
                .description("NewDescriptionTest")
        .build();

    }
}