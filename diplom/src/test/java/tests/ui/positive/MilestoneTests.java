package tests.ui.positive;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.MilestoneStep;


public class MilestoneTests extends BaseTest {


    @Test
    public void dialogWindow() {

        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());
        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/64");

        MilestoneStep milestoneStep = new MilestoneStep(driver);
        Assert.assertTrue(milestoneStep.checkDialogWindow().isPageOpened());

//        logger.trace("Dialog window is checked");
    }

    @Test

    public void uploadFileTest() {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/47");

        MilestoneStep milestoneStep = new MilestoneStep(driver);
        String nameOfFile = "flower.jpg";
        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath().substring(1);

        milestoneStep.uploadFileSuccessful(pathToFile);

        Assert.assertEquals(waitsService.waitForVisibilityBy(
                        By.xpath("//*[@class='attachment-list dz-persistent']//child::div[1]")).getAttribute("title"),
                nameOfFile);
//        logger.trace("New file is uploaded");
    }
}