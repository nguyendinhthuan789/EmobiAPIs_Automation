package emobi.steps.adpeako;

import emobi.controller.AdpeakoMoController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MsisdnMoTracking {
    Logger log = LoggerFactory.getLogger(MsisdnMoTracking.class);
    private List<String> result;
    private AdpeakoMoController adpeakoMoController;

    public MsisdnMoTracking() {
        adpeakoMoController =new AdpeakoMoController();
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo(int statusCode) {
        Assert.assertTrue(adpeakoMoController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoMoController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(5), adpeakoMoController.findJsonPathHasKey("message"));
        log.info("status is: " + adpeakoMoController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(6), adpeakoMoController.findJsonPathHasKey("status"));
        log.info("subscriptionStatus is: " + adpeakoMoController.findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(result.get(7), adpeakoMoController.findJsonPathHasKey("data.subscriptionStatus"));
        log.info("keyword is: " + adpeakoMoController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(8), adpeakoMoController.findJsonPathHasKey("data.keyword"));
        log.info("keyword is: " + adpeakoMoController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(9), adpeakoMoController.findJsonPathHasKey("data.shortcode"));
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(int statusCode) {
        Assert.assertTrue(adpeakoMoController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoMoController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(2), adpeakoMoController.findJsonPathHasKey("message"));
        log.info("status is: " + adpeakoMoController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(3), adpeakoMoController.findJsonPathHasKey("status"));
        log.info("data is: " + adpeakoMoController.findJsonPathHasKey("data"));
        Assert.assertTrue(adpeakoMoController.checkMapIsEmpty("data"));
    }
}