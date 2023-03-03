package tests.api.positive;

import adapters.MilestoneAdapter;
import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class MilestoneTest extends BaseApiTest {

    private MilestoneAdapter milestone;
    private ProjectAdapter project;

    @Test (groups = "Smoke")
    public void addMilestone(){
        milestone = new MilestoneAdapter();
        File file = new File("src/test/resources/restApiFiles/milestoneJson.json");
        milestone.addApiMilestone(project.getProjectId(), file );
        milestone.setMilestoneId();
    }
    @Test (priority = 1,groups = "Smoke, Regression")
    public void getMilestone(){
        milestone.getApiMilestone(milestone.getMilestoneId());
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().get("name"), "test milestone");
    }

    @Test (priority = 2, groups = "Smoke, Regression")
    public void deleteMilestone(){
        milestone.deleteApiMilestone(milestone.getMilestoneId());
        Assert.assertEquals(milestone.getResponse().statusCode(), HttpStatus.SC_OK);
    }

    @BeforeClass (groups = "Smoke, Regression")
    public void createTestProject(){
        project = new ProjectAdapter();
        File path = new File("src/test/resources/restApiFiles/projectJson.json");
        project.addApiProject(path);

    }
    @AfterClass(groups = "Smoke, Regression")
    public void deleteTestProject(){
        project.deleteApiProject(project.getProjectId());
    }

}
