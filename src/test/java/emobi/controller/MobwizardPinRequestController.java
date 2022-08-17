package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MobwizardPinRequestController {
    Logger log = LoggerFactory.getLogger(MobwizardPinRequestController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;
    private final RestAssuredUtil restAssuredUtil = new RestAssuredUtil();

    public MobwizardPinRequestController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void mobwizardPinRequestTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public boolean checkStatusIs200(int statusCode) {
        log.info("status code is: " + restResponse.validate().extract().response().getStatusCode());
        if(restAssuredUtil.checkStatusCode(restResponse.validate().extract().response(),statusCode)){
            return true;
        }
        return false;
    }

    public String getJsonPathHasKey(String key) {
        return restAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }

    public boolean checkMapIsEmpty(String key) {
        Map map= new JsonPath(restResponse.extract().asString()).getMap(key);
        if(restAssuredUtil.isNullOrEmpty(map)){
            return true;
        }
        return false;
    }
}
