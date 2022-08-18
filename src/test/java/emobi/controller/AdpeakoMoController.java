package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AdpeakoMoController {
    Logger log = LoggerFactory.getLogger(AdpeakoMoController.class);
    private RestRequest restRequest;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public AdpeakoMoController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void adpeakoRequestMoTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MO_REQUEST + result.get(7), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(9));
        restParams.addParam(result.get(3), result.get(10));
        restParams.addParam(result.get(4), result.get(11));
        restParams.addParam(result.get(5), result.get(12));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        log.info("Request header is: \n" + restRequest.toString());
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

    public boolean checkMapIsEmpty(String key){
        Map map= new JsonPath(restResponse.extract().asString()).getMap(key);
        if(RestAssuredUtil.isNullOrEmpty(map)){
            return true;
        }
        return false;
    }
}
