package steps;

import adapters.SuitesAdapter;
import baseEntities.BaseStep;
import io.restassured.response.Response;

import java.io.File;


public class SuitesStep extends BaseStep {

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


    public Response deleteApiSuite(int suiteId) {
        return suitesAdapter.delete(suiteId);
    }


}
