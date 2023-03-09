package tests.ui.negative;

import baseEntities.BaseTest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.ProjectStep;

public class ExceedingDataTest extends BaseTest {

    @Test(groups = "Smoke, Regression")

    public void limitDataTest() {

        ProjectStep projectStep = new ProjectStep(driver);
        Assert.assertTrue(projectStep.addProjectOnDashboard().isPageOpened());

        Project project = Project.builder()
                .name("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
                        "                        \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
                        "                        \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\" +\n" +
                        "                        \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaahere251characters")
                .description("Description")
                .build();

        Assert.assertTrue(projectStep.moveToProjectPageSuccessful(project).isPageOpened());
    }
}