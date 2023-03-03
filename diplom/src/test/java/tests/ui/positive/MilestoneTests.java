package tests.ui.positive;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginStep;

public class MilestoneTests extends BaseTest {

    @Test

    public void uploadFileTest() {
        LoginStep loginStep = new LoginStep(driver);
        Assert.assertTrue(loginStep.successfulLogin().isPageOpened());

        driver.get("https://diploma123.testrail.io/index.php?/milestones/add/47");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//*[@class='icon-markdown-image']"));
        fileUploadElement.click();
        WebElement addFile = waitsService.waitForExists(By.id("libraryAddAttachment"));

        String pathToFile = MilestoneTests.class.getClassLoader().getResource("flower").getPath();
        System.out.println(pathToFile);

        addFile.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("attachmentNewSubmit")).getText().trim(),
                "flower");

    }
}
