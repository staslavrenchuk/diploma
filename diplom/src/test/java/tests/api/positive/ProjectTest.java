package tests.api.positive;

import baseEntities.BaseApiTest;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;

import java.io.File;

public class ProjectTest extends BaseApiTest {

    private final ProjectStep projectStep = new ProjectStep();

    @Test (groups = "Smoke")
    public void addProject() {
        File file = new File("src/test/resources/restApiFiles/projectJson.json");
        projectStep.addApiProject(file);
        Assert.assertEquals(projectStep.getResponse().getBody().jsonPath().get("name"), "Project name");
    }
    @Test (groups = {"Regression", "Smoke"}, priority = 1)
    public void getProject(){
        projectStep.getApiProject(projectStep.getProjectId());
        Assert.assertEquals(projectStep.getResponse().getBody().jsonPath().get("announcement"), "Project announcement");
    }

    @Test (groups = "Smoke", priority = 2)
    public void deleteProject() {
        projectStep.deleteApiProject(projectStep.getProjectId());
        Assert.assertEquals(projectStep.getResponse().statusCode(), HttpStatus.SC_OK);
    }
}
