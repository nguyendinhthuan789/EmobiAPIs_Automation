package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Convert;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AdpeakoPinRequestController {
    Logger log = LoggerFactory.getLogger(AdpeakoPinRequestController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;
    private final RestAssuredUtil restAssuredUtil;
    private final Convert convert;

    public AdpeakoPinRequestController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        restAssuredUtil = new RestAssuredUtil();
        convert = new Convert();
    }

    public void adpeakoPinRequestTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_REQUEST + result.get(7), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(9));
        restParams.addParam(result.get(3), result.get(10));
        restParams.addParam(result.get(4), result.get(11));
        restParams.addParam(result.get(5), result.get(12));
        restParams.addParam(result.get(6), result.get(13));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public boolean checkStatusIs200(int status) {
        log.info("status code is: " + restResponse.validate().extract().response().getStatusCode());
        return restAssuredUtil.checkStatusCode(restResponse.validate().extract().response(), status);
    }

    public String getJsonPathHasKey(String key) {
        return RestAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }

    public boolean checkMapIsEmpty(String key) {
        Map map = new JsonPath(restResponse.extract().asString()).getMap(key);
        return RestAssuredUtil.isNullOrEmpty(map);
    }
}
