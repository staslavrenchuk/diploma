package tests.api.positive;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;

import java.io.File;

public class ProjectTest extends BaseApiTest {

    private final ProjectStep project = new ProjectStep();

    @Test(groups = "Smoke")
    public void addProject() {
        File file = new File("src/test/resources/restApiFiles/projectJson.json");
        Assert.assertEquals(project.addApiProject(file).getBody().jsonPath().get("name"), "Project name");
    }

    @Test(groups = "Smoke", priority = 1)
    public void getProject() {
        Assert.assertEquals(project.getApiProject(project.getProjectId())
                .getBody().jsonPath().get("announcement"), "Project announcement");
    }

    @Test(groups = "Smoke", priority = 2)
    public void deleteProject() {
        Assert.assertEquals(project.deleteApiProject(project.getProjectId()).statusCode(), HttpStatus.SC_OK);
    }
}
