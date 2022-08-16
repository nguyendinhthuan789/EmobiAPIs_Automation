package emobi.steps.adpeako;

import emobi.controller.AdpeakoMoController;
import emobi.rest.RestHeaders;
import emobi.rest.RestParams;
import emobi.rest.RestRequest;
import emobi.rest.RestResponse;
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
    private AdpeakoMoController adpeakoMoController;

    public MsisdnMoTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        adpeakoMoController =new AdpeakoMoController();
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo(int statusCode) {
        adpeakoMoController.checkStatusIs200(statusCode);
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoMoController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(5), adpeakoMoController.getJsonPathHasKey("message"));
        log.info("status is: " + adpeakoMoController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(6), adpeakoMoController.getJsonPathHasKey("status"));
        log.info("subscriptionStatus is: " + adpeakoMoController.getJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(result.get(7), adpeakoMoController.getJsonPathHasKey("data.subscriptionStatus"));
        log.info("keyword is: " + adpeakoMoController.getJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(8), adpeakoMoController.getJsonPathHasKey("data.keyword"));
        log.info("keyword is: " + adpeakoMoController.getJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(9), adpeakoMoController.getJsonPathHasKey("data.shortcode"));
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(int statusCode) {
        adpeakoMoController.checkStatusIs200(statusCode);
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoMoController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(2), adpeakoMoController.getJsonPathHasKey("message"));
        log.info("status is: " + adpeakoMoController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(3), adpeakoMoController.getJsonPathHasKey("status"));
        log.info("data is: " + adpeakoMoController.getJsonPathHasKey("data"));
        Assert.assertTrue(adpeakoMoController.checkMapIsEmpty("data"));
    }
}