package emobi.controller;

import emobi.constants.URLs;
import emobi.rest.*;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PinRequestForRsController {
    Logger log = LoggerFactory.getLogger(PinRequestForRsController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public PinRequestForRsController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void mobwizardPinRequestTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URLs.BASE_URL_HAS_PORT_8091, URLs.AFFILIATES_PARTNER_PIN_REQUEST + result.get(6), RestMethod.GET);
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
        Map map = new JsonPath(findJsonPathHasKey(key)).getMap(key);
        return RestAssuredUtil.isNullOrEmpty(map);
    }

    public void verifyResponseWithValidInput(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("status"));
        log.info("status subscriptionStatus is: " + findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(result.get(5), findJsonPathHasKey("data.subscriptionStatus"));
        log.info("pin is: " + findJsonPathHasKey("data.pinId"));
        Assert.assertNotNull(findJsonPathHasKey("data.pinId"));
    }

    public void verifyResponseWithInvalidMandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(2), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("status"));
        log.info("data is: " + findJsonPathHasKey("data"));
        Assert.assertTrue(checkMapIsEmpty("data"));
    }

    public void verifyResponseWithInvalidMsisdn(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("status"));
        log.info("status subscriptionStatus is: " + findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(result.get(5), findJsonPathHasKey("data.subscriptionStatus"));
    }
}
