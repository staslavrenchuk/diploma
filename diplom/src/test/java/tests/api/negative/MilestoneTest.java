package tests.api.negative;

import baseEntities.BaseApiTest;
import models.Milestone;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.MilestoneStep;
import steps.ProjectStep;

import java.io.File;

public class MilestoneTest extends BaseApiTest {
    private final ProjectStep projectStep = new ProjectStep();
    private final MilestoneStep milestoneStep = new MilestoneStep();


    @Test
    public void addMilestoneWithLongName(){
        File file = new File("src/test/resources/restApiFiles/negativeMilestoneJson.json");
        milestoneStep.addApiMilestone(projectStep.getProjectId(), file);
        Assert.assertEquals(milestoneStep.getResponse().getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");

    }

    @Test
    public void getMilestoneWithIncorrectId(){
        milestoneStep.getApiMilestone(0);
        Assert.assertEquals(milestoneStep.getResponse().getBody().jsonPath().getString("error"),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test
    public void deleteMilestoneWithIncorrectId(){
        milestoneStep.deleteApiMilestone(0);
        Assert.assertNotEquals(milestoneStep.getResponse().getStatusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass
    public void createTestProject(){
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        projectStep.addApiProject(path);
    }
    @AfterClass
    public void deleteTestProject(){
        projectStep.deleteApiProject(projectStep.getProjectId());
    }
}
