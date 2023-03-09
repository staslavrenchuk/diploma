package adapters;

import io.restassured.response.Response;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SuitesAdapter {

    public Response add(int projectId, File file) {
        return  given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response get(int suiteId) {
        return given()
                .pathParams("suite_id", suiteId)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response update(int suiteId, File file) {
        return given()
                .pathParams("suite_id", suiteId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

    public Response delete(int suiteId) {
        return given()
                .pathParams("suite_id", suiteId)
                .when()
                .post(Endpoints.DELETE_SUITE)
                .then()
                .log().body()
                .extract().response();
    }

}
