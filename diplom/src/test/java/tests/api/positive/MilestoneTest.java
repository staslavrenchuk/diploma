package tests.api.positive;

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

    private MilestoneStep milestoneStep;
    private ProjectStep projectStep;

    @Test (groups = "Smoke")
    public void addMilestone(){
        milestoneStep = new MilestoneStep();
        File file = new File("src/test/resources/restApiFiles/milestoneJson.json");
        milestoneStep.addApiMilestone(projectStep.getProjectId(), file );
        milestoneStep.setMilestoneId();
    }
    @Test (priority = 1,groups = "Smoke, Regression")
    public void getMilestone(){
        milestoneStep.getApiMilestone(milestoneStep.getMilestoneId());
        Assert.assertEquals(milestoneStep.getResponse().getBody().jsonPath().get("name"), "test milestone");
    }

    @Test (priority = 2, groups = "Smoke, Regression")
    public void deleteMilestone(){
        milestoneStep.deleteApiMilestone(milestoneStep.getMilestoneId());
        Assert.assertEquals(milestoneStep.getResponse().statusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass (groups = "Smoke, Regression")
    public void createTestProject(){
        projectStep = new ProjectStep();
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        projectStep.addApiProject(path);

    }
    @AfterClass(groups = "Smoke, Regression")
    public void deleteTestProject(){
        projectStep.deleteApiProject(projectStep.getProjectId());
    }

}
