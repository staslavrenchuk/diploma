package tests.ui;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import org.testng.Assert;
import steps.LoginStep;
import steps.ProjectStep;

public class SimpleTest extends BaseTest {

    @org.testng.annotations.Test
    public void simpleTest(){
        driver.get(ReadProperties.getUrl());
        LoginStep step = new LoginStep(driver);
        step.successfulLogin();


        ProjectStep step1 = new ProjectStep(driver);
        step1.addProjectOnDashboardPage();
    }
}
