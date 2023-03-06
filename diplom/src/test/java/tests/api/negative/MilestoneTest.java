package tests.api.negative;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MilestoneStep;
import steps.ProjectStep;

import java.io.File;

public class MilestoneTest extends BaseApiTest {
    private ProjectStep project = new ProjectStep();
    private final MilestoneStep milestone = new MilestoneStep();


    @Test
    public void addMilestoneWithLongName(){
        File file = new File("src/test/resources/restApiFiles/negativeMilestoneJson.json");
        Assert.assertEquals(milestone.addApiMilestone(project.getProjectId(), file).getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");

    }

    @Test
    public void getMilestoneWithIncorrectId(){
        Assert.assertEquals(milestone.getApiMilestone(0).getBody().jsonPath().getString("error"),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test
    public void deleteMilestoneWithIncorrectId(){
        Assert.assertNotEquals(milestone.deleteApiMilestone(0).getStatusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass
    public void createTestProject(){
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addApiProject(path);

    }
    @AfterClass
    public void deleteTestProject(){
        project.deleteApiProject(project.getProjectId());
    }
}
