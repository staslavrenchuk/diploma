package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;

public class SimpleTest extends BaseTest {

    @org.testng.annotations.Test
    public void simpleTest(){
        driver.get(ReadProperties.getUrl());
    }


}
