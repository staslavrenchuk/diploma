package models;

import io.restassured.response.Response;
import lombok.*;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Project {


    private int projectId;


    private void add(File file) {
        Response response = given()
                .body(file)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        projectId = response.getBody().jsonPath().getInt("id");
    }

    private void get(int projectId) {
       Response response = given()
                .pathParams("project_id", projectId)
                .when()
                .get(Endpoints.GET_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println("This is response: \n" + response.asPrettyString());
    }

    private void update(int projectId, File file) {
        given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    private void delete(int projectId) {
        given()
                .pathParams("project_id", projectId)
                .when()
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void addProject(File file) {
        add(file);
    }

    public void getProject(int projectId) {
        get(projectId);
    }

    public void updateProject(int projectId, File file) {
        update(projectId, file);
    }

    public void deleteProject(int projectId) {
        delete(projectId);
    }


    public int getProjectId() {
        return projectId;
    }


}
