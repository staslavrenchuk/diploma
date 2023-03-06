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
    private Response response;

    public SuitesStep(WebDriver driver) {
        super(driver);
        suitesAndCasesPage = new SuitesAndCasesPage(driver);
        addTestSuitePage = new AddTestSuitePage(driver);
    }

    public SuitesStep() {

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


    private Response add(int projectId, File file) {
        response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .log().body()
                .extract().response();
        return response;
    }

    private Response get(int suiteId) {
        return given()
                .pathParams("suite_id", suiteId)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    private Response update(int suiteId, File file) {
        return given()
                .pathParams("suite_id", suiteId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    private Response delete(int suiteId) {
        return given()
                .pathParams("suite_id", suiteId)
                .when()
                .post(Endpoints.DELETE_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response addApiSuite(int projectId, File file) {
        return add(projectId, file);
    }

    public Response getApiSuite(int suiteId) {
        return get(suiteId);
    }

    public Response updateApiSuite(int suiteId, File file) {
        return update(suiteId, file);
    }

    public Response deleteApiSuite(int suiteId) {
        return delete(suiteId);
    }

    public void setSuiteId(){
        suiteId =  response.getBody().jsonPath().getInt("id");
    }

    public int getSuiteId() {
        return suiteId;
    }

}
