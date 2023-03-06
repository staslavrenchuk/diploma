package tests.api.negative;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.ProjectStep;
import steps.SuitesStep;

import java.io.File;

public class SuiteTest extends BaseApiTest {
    private ProjectStep project = new ProjectStep();
    private final SuitesStep suite = new SuitesStep();


    @Test
    public void addMilestoneWithLongName(){
        File file = new File("src/test/resources/restApiFiles/NegativeSuiteJson.json");
        Assert.assertEquals(suite.addApiSuite(project.getProjectId(), file).getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");
    }

    @Test
    public void getMilestoneWithIncorrectId(){
        Assert.assertEquals(suite.getApiSuite(0).getBody().jsonPath().getString("error"),
                "Field :suite_id is not a valid test suite.");
    }

    @Test
    public void deleteMilestoneWithIncorrectId(){
        Assert.assertNotEquals(suite.deleteApiSuite(0).getStatusCode(), HttpStatus.SC_OK);
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
