package models;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.restassured.response.Response;
import lombok.*;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Milestone {
    private int milestoneId;


    private void add(int projectId, File file) {
        Response response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        milestoneId = response.getBody().jsonPath().getInt("id");
    }

    private void get(int milestoneId) {
        Response response = given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println("This is response: \n" + response.asPrettyString());
    }

    private void update(int milestoneId, File file) {
        given()
                .pathParams("milestone_id", milestoneId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    private void delete(int milestoneId) {
        given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void addMilestone(int projectId, File file) {
        add(projectId, file);
    }

    public void getMilestone(int milestoneId) {
        get(milestoneId);
    }

    public void updateMilestone(int milestoneId, File file) {
        update(milestoneId, file);
    }

    public void deleteMilestone(int projectId) {
        delete(projectId);
    }


    public int getMilestoneId() {
        return milestoneId;
    }


}
