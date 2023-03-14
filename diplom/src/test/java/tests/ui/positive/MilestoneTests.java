package tests.ui.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddMilestonePage;
import steps.MilestoneStep;
import steps.ProjectStep;


public class MilestoneTests extends BaseTest {


    @Test(groups = "Regression")
    public void dialogWindowTest() {

        ProjectStep projectStep = new ProjectStep(driver);
        MilestoneStep milestoneStep = new MilestoneStep(driver);
        projectStep.selectProject("Test");

        Assert.assertTrue(milestoneStep.checkDialogWindow().isPageOpened());

    }

    @Test(groups = "Regression")

    public void uploadFileTest() {

        ProjectStep projectStep = new ProjectStep(driver);
        MilestoneStep milestoneStep = new MilestoneStep(driver);
        AddMilestonePage addMilestonePage = new AddMilestonePage(driver);

        projectStep.selectProject("Test");


        String nameOfFile = "flower.jpg";
        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath().substring(1);

        milestoneStep.uploadFileSuccessful(pathToFile);

        Assert.assertEquals(
                addMilestonePage.uploadedFile()
                        .getAttribute("title"),
                nameOfFile + "\t(Click and hold to enter delete mode)");
    }
}