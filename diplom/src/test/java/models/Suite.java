package models;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;


public class Suite {
    private int suiteId;


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

    public void addSuite(int projectId, File file) {
        add(projectId, file);
    }

    public void getSuite(int suiteId) {
        get(suiteId);
    }

    public void updateSuite(int suiteId, File file) {
        update(suiteId, file);
    }

    public void deleteSuite(int suiteId) {
        delete(suiteId);
    }


    public int getSuiteId() {
        return suiteId;
    }


}
