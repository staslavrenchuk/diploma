package tests.ui.positive;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

import java.io.File;

public class MilestoneTests extends BaseTest {

    @Test

    public void uploadFileTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/47");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//*[@class='icon-markdown-image']"));
        fileUploadElement.click();


        WebElement addFile = waitsService.waitForExists(By.xpath("//input[@type='file' and @class='dz-hidden-input'][5]"));


        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower.jpg").getPath();
        Thread.sleep(2000);

        addFile.sendKeys(pathToFile);
        Thread.sleep(2000);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("attachmentNewSubmit")).getText().trim(),
                "flower.jpg");
    }
}
