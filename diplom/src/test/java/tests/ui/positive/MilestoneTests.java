package tests.ui.positive;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;
import steps.MilestoneStep;

import java.io.File;

public class MilestoneTests extends BaseTest {


    @Test
    public void dialogWindow() {

        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());
        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/64");

        MilestoneStep milestoneStep = new MilestoneStep(driver);
        Assert.assertTrue(milestoneStep.checkDialogWindow().isPageOpened());

        logger.trace("Dialog window is checked");
    }

    @Test

    public void uploadFileTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/47");

        MilestoneStep milestoneStep = new MilestoneStep(driver);
        String nameOfFile = "flower.jpg";

        milestoneStep.uploadFileSuccessful("C:" + File.separator+ "Users" + File.separator + "User" + File.separator + "IdeaProjects" + File.separator
                + "Ultimate" + File.separator + "diploma" + File.separator + "diplom" + File.separator + "src" + File.separator + "test" + File.separator
                + "resources" + File.separator + nameOfFile);

//        Assert.assertEquals(waitsService.waitForVisibilityBy(
//                        By.xpath("//*[@class='attachment-list dz-persistent']//child::div[1]")).getAttribute("title"),
//                nameOfFile);
        logger.trace("New file is uploaded");
    }
}