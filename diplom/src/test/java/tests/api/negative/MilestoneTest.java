package tests.api.negative;

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
    private final ProjectAdapter project = new ProjectAdapter();
    private final MilestoneAdapter milestone = new MilestoneAdapter();


    @Test
    public void addMilestoneWithLongName(){
        File file = new File("src/test/resources/restApiFiles/negativeMilestoneJson.json");
        milestone.addApiMilestone(project.getProjectId(), file);
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");

    }

    @Test
    public void getMilestoneWithIncorrectId(){
        milestone.getApiMilestone(0);
        Assert.assertEquals(milestone.getResponse().getBody().jsonPath().getString("error"),
                "Field :milestone_id is not a valid milestone.");
    }

    @Test
    public void deleteMilestoneWithIncorrectId(){
        milestone.deleteApiMilestone(0);
        Assert.assertNotEquals(milestone.getResponse().getStatusCode(), HttpStatus.SC_OK);
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
