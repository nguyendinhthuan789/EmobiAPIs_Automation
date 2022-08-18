package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MoviplusC2sController {
    Logger log = LoggerFactory.getLogger(MoviplusC2sController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public MoviplusC2sController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void moviplusRequestC2STracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S + result.get(3), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(5));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public boolean checkStatusIs200(int statusCode) {
        log.info("status code is: " + restResponse.validate().extract().response().getStatusCode());
        if(RestAssuredUtil.checkStatusCode(restResponse.validate().extract().response(),statusCode)){
            return true;
        }
        return false;
    }

    public String findJsonPathHasKey(String key) {
        return RestAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }
}
