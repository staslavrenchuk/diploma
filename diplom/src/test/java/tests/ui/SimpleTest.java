package tests.ui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import steps.LoginStep;

public class SimpleTest extends BaseTest {

    @org.testng.annotations.Test
    public void simpleTest(){
        driver.get(ReadProperties.getUrl());
        LoginStep step = new LoginStep(driver);
        step.successfulLogin();
        driver.get("https://diploma123.testrail.io/index.php?/admin/projects/add/1");
        RadioButton button = new RadioButton(driver, "suite_mode");
        button.selectByIndex(2);
    }


}
