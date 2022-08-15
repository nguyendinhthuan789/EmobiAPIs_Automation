package emobi.steps.moviplus;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class C2sTracking {
    Logger log = LoggerFactory.getLogger(C2sTracking.class);
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private List<String> result;

    public C2sTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API tracking request of Moviplus flow C2S with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_c2s_with_valid_credential(List<List<String>> list) {
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

    @Then("Response successful status code is {int} after tracking request of Moviplus flow C2S")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_c2s(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow C2S")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_c2s(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.findJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(4), restResponse.findJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.findJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(5), restResponse.findJsonPath(restResponse.extract()).getString("status"));
        log.info("keyword is: " + restResponse.findJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(6), restResponse.findJsonPath(restResponse.extract()).getString("data.keyword"));
        log.info("shortcode is: " + restResponse.findJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertEquals(result.get(7), restResponse.findJsonPath(restResponse.extract()).getString("data.shortcode"));
        log.info("tracking_code is: " + restResponse.findJsonPath(restResponse.extract()).getString("data.tracking_code"));
        Assert.assertNotNull(restResponse.findJsonPath(restResponse.extract()).getString("data.tracking_code"));
    }
}