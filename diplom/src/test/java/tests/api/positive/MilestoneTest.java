package tests.api.positive;

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

    private final MilestoneStep milestone = new MilestoneStep();
    private final ProjectStep project = new ProjectStep();

    @Test(groups = "Smoke")
    public void addMilestone() {
        File file = new File("src/test/resources/restApiFiles/milestoneJson.json");
        milestone.addApiMilestone(project.getProjectId(), file);
        milestone.setMilestoneId();
    }

    @Test(dependsOnMethods = "addMilestone", groups = "Smoke")
    public void getMilestone() {
        milestone.getApiMilestone(milestone.getMilestoneId());
        Assert.assertEquals(milestone.getApiMilestone(milestone.getMilestoneId()).getBody().jsonPath().get("name"), "test milestone");
    }

    @Test(dependsOnMethods = "getMilestone", groups = "Smoke")
    public void deleteMilestone(){
        Assert.assertEquals(milestone.deleteApiMilestone(milestone.getMilestoneId()).getStatusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass
    public void createTestProject() {
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addApiProject(path);

    }

    @AfterClass
    public void deleteTestProject() {
        project.deleteApiProject(project.getProjectId());
    }

}
