package tests.ui.positive;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
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

    public void uploadFileTest() throws InterruptedException {

        ProjectStep projectStep = new ProjectStep(driver);
        MilestoneStep milestoneStep = new MilestoneStep(driver);

        projectStep.selectProject("Test");


        String nameOfFile = "flower.jpg";
        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath().substring(1);

        milestoneStep.uploadFileSuccessful(pathToFile);

        Assert.assertEquals(
                driver.findElement(By
                                .xpath("//*[@class='attachment-list-item attachment-block attachment-picture']"))
                        .getAttribute("title"),
                nameOfFile + "\t(Click and hold to enter delete mode)");
    }
}