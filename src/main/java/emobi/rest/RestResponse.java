package emobi.rest;

import emobi.filter.log.ErrorLoggingFilter;
import emobi.filter.log.Log;
import emobi.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

/**
 * RestResponse is returned when sending request
 */
public class RestResponse {
    private Log requestLog = new Log(RestRequest.class);
    private Response response;
    private ResponseLoggingFilter responseLoggingFilter;
    private ErrorLoggingFilter errorLoggingFilter;
    public static String saveRest;

    /**
     * Init Response
     *
     * @param response Response
     */
    public RestResponse(Response response) {
        this.response = response;
        responseLoggingFilter = new ResponseLoggingFilter();
        errorLoggingFilter = new ErrorLoggingFilter();
    }

    /**
     * Return ValidatableResponse object of rest-assured
     *
     * @return ValidatableResponse
     */
    public ValidatableResponse validate() {
        return response.then().log().all();
    }

    /**
     * Return Response object of rest-assured
     *
     * @return Response
     */
    public Response extract() {
        return this.response;
    }

    public ResponseBody getBody() {
        return response.getBody();
    }

    public ResponseBody printPeek() {
        return getBody().peek();
    }

    public ResponseBody printPrettyPeek() {
        return getBody().prettyPeek();
    }

    public String printPrettyPrint() {
        //System.out.println("==================== " + "Start Response body" + " ========================");
        String res = getBody().prettyPrint();
        //saveRest=res;
        //System.out.println("==================== " + "End Response body" + " ========================");
        return res;
    }

    public static JsonPath getJsonPath(Response response) {
        JsonPath js = new JsonPath(response.body().asString());
        return js;
    }

    public static String getJsonPathHasKey(Response response, String key) {
        String complete = response.asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }
}