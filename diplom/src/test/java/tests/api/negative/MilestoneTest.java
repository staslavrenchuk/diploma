package tests.api.negative;

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
    private final Project project = new Project();
    private final Milestone milestone = new Milestone();


    @Test
    public void addMilestoneWithLongName(){
        File file = new File("src/test/resources/restApiFiles/negativeMilestoneJson.json");
        milestone.addMilestone(project.getProjectId(), file);
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");

    }

    @Test
    public void getMilestoneWithIncorrectId(){
        milestone.getMilestone(0);
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().getString("error"),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test
    public void deleteMilestoneWithIncorrectId(){
        milestone.deleteMilestone(0);
        Assert.assertNotEquals(milestone.getResponse().getStatusCode(), HttpStatus.SC_OK);
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
