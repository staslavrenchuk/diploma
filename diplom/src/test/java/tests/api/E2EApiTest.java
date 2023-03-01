//package tests.api;
//
//import baseEntities.BaseApiTest;
//import models.Milestone;
//import models.Project;
//import models.Suite;
//import org.testng.annotations.Test;
//
//import java.io.File;
//
//public class E2EApiTest extends BaseApiTest {
//
//    Project project = new Project();
//    Milestone milestone = new Milestone();
//    Suite suite = new Suite();
//
//    @Test
//    public void addProject() {
//        File path = new File("src/test/resources/restApiFiles/projectJson.json");
//        project.addProject(path);
//    }
//
//    @Test (priority = 1)
//    public void addMileStone() {
//        File path = new File("src/test/resources/restApiFiles/milestoneJson.json");
//        milestone.addMilestone(project.getProjectId(), path);
//    }
//
//    @Test (priority = 2)
//    public void addSuite() {
//        File path = new File("src/test/resources/restApiFiles/suiteJson.json");
//        suite.addSuite(project.getProjectId(), path);
//    }
//
//    @Test (priority = 3)
//    public void getProject() {
//        project.getProject(project.getProjectId());
//    }
//
//    @Test (priority = 4)
//    public void getMilestone() {
//        milestone.getMilestone(milestone.getMilestoneId());
//    }
//
//    @Test (priority = 5)
//    public void getSuite() {
//        suite.getSuite(suite.getSuiteId());
//    }
//
//    @Test (priority = 6)
//    public void deleteSuite() {
//        suite.deleteSuite(suite.getSuiteId());
//    }
//
//    @Test (priority = 7)
//    public void deleteMilestone() {
//        milestone.deleteMilestone(milestone.getMilestoneId());
//    }
//
//    @Test (priority = 8)
//    public void deleteProject() {
//        project.deleteProject(project.getProjectId());
//    }
//
//}
