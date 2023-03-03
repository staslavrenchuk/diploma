package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.openqa.selenium.WebDriver;
import pages.AddTestSuitePage;
import pages.SuitePage;
import pages.SuitesAndCasesPage;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SuitesStep extends BaseStep {

    private SuitesAndCasesPage suitesAndCasesPage;
    private AddTestSuitePage addTestSuitePage;
    private int suiteId;

    public SuitesStep(WebDriver driver) {
        super(driver);
        suitesAndCasesPage = new SuitesAndCasesPage(driver);
        addTestSuitePage = new AddTestSuitePage(driver);
    }

    public void addTestSuiteOnTestSuitesPage() {
        suitesAndCasesPage.getAddSuiteButton().click();
    }

    public AddTestSuitePage moveToAddTestSuitesPageSuccessful() {
        return new AddTestSuitePage(driver);
    }

    private void addTestSuite(String name) {
        addTestSuitePage.getNameInput().sendKeys(name);
        addTestSuitePage.getAddTestSuiteButton().click();
    }

    public SuitePage addTestSuiteSuccessful(String name) {
        addTestSuite(name);
        return new SuitePage(driver);
    }

    private void add(int projectId, File file) {
        Response response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        suiteId = response.getBody().jsonPath().getInt("id");
    }

    private void get(int suiteId) {
        Response response = given()
                .pathParams("suite_id", suiteId)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println("This is response: \n" + response.asPrettyString());
    }

    private void update(int suiteId, File file) {
        given()
                .pathParams("suite_id", suiteId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    private void delete(int suiteId) {
        given()
                .pathParams("suite_id", suiteId)
                .when()
                .post(Endpoints.DELETE_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void addApiSuite(int projectId, File file) {
        add(projectId, file);
    }

    public void getApiSuite(int suiteId) {
        get(suiteId);
    }

    public void updateApiSuite(int suiteId, File file) {
        update(suiteId, file);
    }

    public void deleteApiSuite(int suiteId) {
        delete(suiteId);
    }


    public int getSuiteId() {
        return suiteId;
    }

}
