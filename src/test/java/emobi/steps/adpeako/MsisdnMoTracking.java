package emobi.steps.adpeako;

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

public class MsisdnMoTracking {
    Logger log = LoggerFactory.getLogger(MsisdnMoTracking.class);
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private List<String> result;

    public MsisdnMoTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
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

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(6), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        log.info("subscriptionStatus is: " + restResponse.getJsonPath(restResponse.extract()).getString("data.subscriptionStatus"));
        Assert.assertEquals(result.get(7), restResponse.getJsonPath(restResponse.extract()).getString("data.subscriptionStatus"));
        log.info("keyword is: " + restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(8), restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        log.info("shortcode is: " + restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertEquals(result.get(9), restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
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

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(2), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        log.info("data is: " + restResponse.getJsonPath(restResponse.extract()).getMap("data"));
        Assert.assertTrue(restResponse.getJsonPath(restResponse.extract()).getMap("data").size() == 0);
    }
}