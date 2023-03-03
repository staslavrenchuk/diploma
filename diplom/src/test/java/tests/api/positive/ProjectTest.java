package tests.api.positive;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ProjectTest extends BaseApiTest {

    private final ProjectAdapter project = new ProjectAdapter();

    @Test (groups = "Smoke")
    public void addProject() {
        File file = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addApiProject(file);
        Assert.assertEquals(project.getResponse().getBody().jsonPath().get("name"), "Project name");
    }
    @Test (groups = {"Regression", "Smoke"}, priority = 1)
    public void getProject(){
        project.getApiProject(project.getProjectId());
        Assert.assertEquals(project.getResponse().getBody().jsonPath().get("announcement"), "Project announcement");
    }

    @Test (groups = "Smoke", priority = 2)
    public void deleteProject() {
        project.deleteApiProject(project.getProjectId());
        Assert.assertEquals(project.getResponse().statusCode(), HttpStatus.SC_OK);
    }
}
