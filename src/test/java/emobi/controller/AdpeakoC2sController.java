package emobi.controller;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;

public class AdpeakoC2sController {
    Logger log = LoggerFactory.getLogger(AdpeakoC2sController.class);
    private RestRequest restRequest;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

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
        log.info("Request header is: \n"+ restRequest.toString());
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

    public void verifyResponse(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info(MessageFormat.format("message is: ''{0}''", findJsonPathHasKey("message")));
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
