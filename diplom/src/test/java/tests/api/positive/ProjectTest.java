package tests.api.positive;

import baseEntities.BaseApiTest;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ProjectTest extends BaseApiTest {

    private final Project project = new Project();

    @Test
    public void addProject() {
        File file = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addProject(file);
        Assert.assertEquals(project.getResponse().getBody().jsonPath().get("name"), "Project name");
    }
    @Test (priority = 1)
    public void getProject(){
        project.getProject(project.getProjectId());
        Assert.assertEquals(project.getResponse().getBody().jsonPath().get("announcement"), "Project announcement");
    }

    @Test (priority = 2)
    public void deleteProject() {
        project.deleteProject(project.getProjectId());
        Assert.assertEquals(project.getResponse().statusCode(), HttpStatus.SC_OK);
    }
}
