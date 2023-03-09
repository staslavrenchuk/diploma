package steps;

import baseEntities.BaseStep;
import io.restassured.response.Response;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SuitesStep extends BaseStep {
    private int suiteId;
    private Response response;

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
