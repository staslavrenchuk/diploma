package tests.api.positive;

import baseEntities.BaseApiTest;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class MilestoneTest extends BaseApiTest {

    private Milestone milestone;
    private final Project project = new Project();

    @Test
    public void addMilestone(){
        milestone = new Milestone();
        File file = new File("src/test/resources/restApiFiles/milestoneJson.json");
        milestone.addMilestone(project.getProjectId(), file );
        milestone.setMilestoneId();
    }
    @Test
    public void getMilestone(){
        milestone.getMilestone(milestone.getMilestoneId());
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().get("name"), "test milestone");
    }

    @Test
    public void deleteMilestone(){
        milestone.deleteMilestone(milestone.getMilestoneId());
        Assert.assertEquals(milestone.getResponse().statusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass
    public void createTestProject(){
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addProject(path);
    }
    @AfterClass
    public void deleteTestProject(){
        project.deleteProject(project.getProjectId());
    }

}
