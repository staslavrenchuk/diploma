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
    private final ProjectStep project = new ProjectStep();
    private final SuitesStep suite = new SuitesStep();


    @Test(groups = "Regression")
    public void addSuiteWithLongName() {
        File file = new File("src/test/resources/restApiFiles/NegativeSuiteJson.json");
        Assert.assertEquals(suite.addApiSuite(project.getProjectId(), file).getBody().jsonPath().getString("error"),
                "Field :name is too long (250 characters at most).");
    }

    @Test(groups = "Regression")
    public void getSuiteWithIncorrectId() {
        Assert.assertEquals(suite.getApiSuite(0).getBody().jsonPath().getString("error"),
                "Field :suite_id is not a valid test suite.");
    }

    @Test(groups = "Regression")
    public void deleteSuiteWithIncorrectId() {
        Assert.assertNotEquals(suite.deleteApiSuite(0).getStatusCode(), HttpStatus.SC_OK);
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
