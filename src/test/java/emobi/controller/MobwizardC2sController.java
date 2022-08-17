package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MobwizardC2sController {
    Logger log = LoggerFactory.getLogger(MobwizardC2sController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;
    private final RestAssuredUtil restAssuredUtil = new RestAssuredUtil();

    public MobwizardC2sController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void mobwizardRequestC2STracking(List<List<String>> list) {
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
        if(restAssuredUtil.checkStatusIs200(restResponse.validate().extract().response(),statusCode)){
            return true;
        }
        return false;
    }

    public String getJsonPathHasKey(String key) {
        return restAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }
}
