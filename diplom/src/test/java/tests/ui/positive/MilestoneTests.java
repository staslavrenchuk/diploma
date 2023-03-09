package tests.ui.positive;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.MilestoneStep;


public class MilestoneTests extends BaseTest {


    @Test(groups = "Smoke, Regression")
    public void dialogWindow() {

        driver.get("https://diploma1234.testrail.io/index.php?/milestones/add/2");

        MilestoneStep milestoneStep = new MilestoneStep(driver);
        Assert.assertTrue(milestoneStep.checkDialogWindow().isPageOpened());

    }

    @Test(groups = "Smoke, Regression")

    public void uploadFileTest() {

        MilestoneStep milestoneStep = new MilestoneStep(driver);

        driver.get("https://diploma1234.testrail.io/index.php?/milestones/add/2");

        String nameOfFile = "flower.jpg";
        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath().substring(1);

        milestoneStep.uploadFileSuccessful(pathToFile);
//
//        Assert.assertEquals(waitsService.waitForVisibilityBy(
//                        By.xpath("//*[@class='attachment-list dz-persistent']//child::div[1]")).getAttribute("title"),
//                "download.jpeg  (Click and hold to enter delete mode)");
    }
}