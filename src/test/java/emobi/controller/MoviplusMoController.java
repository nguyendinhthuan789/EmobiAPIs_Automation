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
import java.util.Map;

public class MoviplusMoController {
    Logger log = LoggerFactory.getLogger(MoviplusMoController.class);
    private RestRequest restRequest;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public MoviplusMoController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void moviplusRequestMoTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MO_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        log.info("Request header is: \n" + restRequest.toString());
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public boolean verifyStatus(int status) {
        boolean bol = (status == status);
        log.info("status code is: " + restResponse.validate().extract().response().getStatusCode());
        if (RestAssuredUtil.checkStatusCode(restResponse.validate().extract().response(), status)) {
            Assert.assertTrue(bol);
            return true;
        }
        Assert.assertFalse(bol);
        return false;
    }

    public String findJsonPathHasKey(String key) {
        return RestAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }

    public boolean checkMapIsEmpty(String key) {
        Map map = new JsonPath(restResponse.extract().asString()).getMap(key);
        return RestAssuredUtil.isNullOrEmpty(map);
    }

    public void verifyResponseWithValidInput(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), findJsonPathHasKey("status"));
        log.info("keyword is: " + findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(findJsonPathHasKey("data.tracking_code"));
    }
}
