package emobi.rest;

import emobi.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RestResponse is returned when sending request
 */
public class RestResponse {
    private static final Logger reponsetLog = LoggerFactory.getLogger(RestResponse.class);

    private RestResponse() {
    }

    private Response response;
    private ResponseLoggingFilter responseLoggingFilter;

    /**
     * Init Response
     * @param response Response
     */
    public RestResponse(Response response) {
        this.response = response;
        reponsetLog.info("RESPONSE BODY: \n"+ response);
    }

    /**
     * Return ValidatableResponse object of rest-assured
     * @return ValidatableResponse
     */
    public ValidatableResponse validate() {
        return response.then().log().all();
    }

    /**
     * Return Response object of rest-assured
     * @return Response
     */
    public Response extract() {
        return this.response;
    }

    public ResponseBody getBody(){
        return response.getBody();
    }

    public static JsonPath rawToJson(Response response) {
        JsonPath js = new JsonPath(response.body().asString());
        return js;
    }
}