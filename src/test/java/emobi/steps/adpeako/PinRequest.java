package emobi.steps.adpeako;

import emobi.controller.AdpeakoPinRequestController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PinRequest {
    Logger log = LoggerFactory.getLogger(PinRequest.class);
    private List<String> result;
    private final AdpeakoPinRequestController adpeakoPinRequestController;

    public PinRequest() {
        adpeakoPinRequestController = new AdpeakoPinRequestController();
    }

    @Given("User call the API pin request of Adpeako flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_adpeako_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        adpeakoPinRequestController.adpeakoPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Adpeako flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_adpeako_flow_msisdn_pin(int statusCode) {
        Assert.assertTrue(adpeakoPinRequestController.checkStatusIs200(statusCode));
    }
    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of Adpeako flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_adpeako_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinRequestController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), adpeakoPinRequestController.getJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinRequestController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), adpeakoPinRequestController.getJsonPathHasKey("status"));
        log.info("status subscriptionStatus is: " + adpeakoPinRequestController.getJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(result.get(5), adpeakoPinRequestController.getJsonPathHasKey("data.subscriptionStatus"));
        log.info("pinId is: " + adpeakoPinRequestController.getJsonPathHasKey("data.pinId"));
        Assert.assertNotNull(adpeakoPinRequestController.getJsonPathHasKey("data.pinId"));
    }

    @Given("User call the API pin request of Adpeako flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign_credential(List<List<String>> list) {
        adpeakoPinRequestController.adpeakoPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Adpeako flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        Assert.assertTrue(adpeakoPinRequestController.checkStatusIs200(statusCode));
    }
    @Then("Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinRequestController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(2), adpeakoPinRequestController.getJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinRequestController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(3), adpeakoPinRequestController.getJsonPathHasKey("status"));
        log.info("data is: " + adpeakoPinRequestController.getJsonPathHasKey("data"));
        Assert.assertTrue(adpeakoPinRequestController.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin request of Adpeako flow msisdn pin with invalid mandatory credential")
    public void user_call_the_api_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory_credential(List<List<String>> list) {
        adpeakoPinRequestController.adpeakoPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Adpeako flow msisdn pin with invalid mandatory")
    public void response_successful_status_code_is_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory(int statusCode) {
        Assert.assertTrue(adpeakoPinRequestController.checkStatusIs200(statusCode));
    }
    @Then("Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid mandatory")
    public void response_successful_message_status_and_data_null_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinRequestController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(2), adpeakoPinRequestController.getJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinRequestController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(3), adpeakoPinRequestController.getJsonPathHasKey("status"));
        log.info("data is: " + adpeakoPinRequestController.getJsonPathHasKey("data"));
        Assert.assertTrue(adpeakoPinRequestController.checkMapIsEmpty("data"));
    }
}