package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdpeakoC2sController {
    Logger log = LoggerFactory.getLogger(AdpeakoC2sController.class);
    private RestRequest restRequest;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;
    private RestAssuredUtil restAssuredUtil= new RestAssuredUtil();

    public AdpeakoC2sController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void adpeakoRequestC2STracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public void checkStatusIs200(int statusCode) {
        log.info("status code is: " + restResponse.extract().getStatusCode());
        Assert.assertEquals(restResponse.extract().getStatusCode(), statusCode);
    }

    public String getJsonPathHasKey(String key) {
        String complete = restResponse.extract().asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }
}