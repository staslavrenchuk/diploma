package adapters;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public Response add(File file) {
        Response response = given()
                .body(file)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return response;
    }

    public Response get(int projectId) {
        return given()
                .pathParams("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public Response update(int projectId, File file) {
        return given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    public Response delete(int projectId) {
        return given()
                .pathParams("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }


}
