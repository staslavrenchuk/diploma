package steps;

import adapters.SuitesAdapter;
import baseEntities.BaseStep;
import io.restassured.response.Response;
import utils.Endpoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SuitesStep extends BaseStep {
    private int suiteId;
    private Response response;
    private final SuitesAdapter suitesAdapter;
    public SuitesStep(){
        suitesAdapter = new SuitesAdapter();
    }


    public Response addApiSuite(int projectId, File file) {
        return suitesAdapter.add(projectId, file);
    }

    public Response getApiSuite(int suiteId) {
        return suitesAdapter.get(suiteId);
    }

    public Response updateApiSuite(int suiteId, File file) {
        return suitesAdapter.update(suiteId, file);
    }

    public Response deleteApiSuite(int suiteId) {
        return suitesAdapter.delete(suiteId);
    }

    public void setSuiteId(){
        suiteId =  response.getBody().jsonPath().getInt("id");
    }

    public int getSuiteId() {
        return suiteId;
    }

}
