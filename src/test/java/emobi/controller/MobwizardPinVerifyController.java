package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Utils;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MobwizardPinVerifyController {
    Logger log = LoggerFactory.getLogger(MobwizardPinVerifyController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public MobwizardPinVerifyController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void mobwizardPinVerifyTracking(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_VERIFY + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(5));
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
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
        Map map = new JsonPath(restResponse.extract().asString()).getMap(key);
        return RestAssuredUtil.isNullOrEmpty(map);
    }

    public void verifyResponseWithValidInput(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("status"));
        log.info("verify status is: " + findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(result.get(5), findJsonPathHasKey("data.verify_status"));
    }

    public void verifyResponseWithInvalidPin(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("status"));
        log.info("verify status is: " + findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(result.get(5), findJsonPathHasKey("data.verify_status"));
    }

    public void verifyResponseWithInvalidMandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), findJsonPathHasKey("message"));
        log.info("status is: " + findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), findJsonPathHasKey("status"));
        log.info("verify status is: " + findJsonPathHasKey("data"));
        Assert.assertTrue(checkMapIsEmpty("data"));
    }
}
