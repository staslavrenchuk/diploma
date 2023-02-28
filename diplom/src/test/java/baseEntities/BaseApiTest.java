package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import models.Project;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    @BeforeTest
    public void setupApi() {
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.email(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

    }
    @AfterTest
    public void tearDown(){

    }


}
