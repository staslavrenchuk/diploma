package models;

import io.restassured.response.Response;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Milestone {


    private int milestoneId;

    private Response response;


    private void add(int projectId, File file) {
        response = given()
                .pathParams("project_id", projectId)
                .body(file)
                .when()
                .post(Endpoints.ADD_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    private void get(int milestoneId) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .get(Endpoints.GET_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    private void update(int milestoneId, File file) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .body(file)
                .when()
                .post(Endpoints.UPDATE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
        ;
    }

    private void delete(int milestoneId) {
        response = given()
                .pathParams("milestone_id", milestoneId)
                .when()
                .post(Endpoints.DELETE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
        ;
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

    public Response getResponse() {
        return response;
    }
    public void setMilestoneId() {
        milestoneId =  response.getBody().jsonPath().getInt("id");
    }


}
