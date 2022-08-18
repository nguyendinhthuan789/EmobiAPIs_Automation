package emobi.steps.adpeako;

import emobi.controller.AdpeakoPinRequestController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class PinRequest {
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
       adpeakoPinRequestController.verifyStatus(statusCode);
    }
    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of Adpeako flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_adpeako_flow_msisdn_pin(List<List<String>> list) {
        adpeakoPinRequestController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API pin request of Adpeako flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign_credential(List<List<String>> list) {
        adpeakoPinRequestController.adpeakoPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Adpeako flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        adpeakoPinRequestController.verifyStatus(statusCode);
    }
    @Then("Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        adpeakoPinRequestController.verifyResponseWithInvalidCampaign(list);
    }

    @Given("User call the API pin request of Adpeako flow msisdn pin with invalid mandatory credential")
    public void user_call_the_api_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory_credential(List<List<String>> list) {
        adpeakoPinRequestController.adpeakoPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Adpeako flow msisdn pin with invalid mandatory")
    public void response_successful_status_code_is_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory(int statusCode) {
        adpeakoPinRequestController.verifyStatus(statusCode);
    }
    @Then("Response successful message status and data null after pin request of Adpeako flow msisdn pin with invalid mandatory")
    public void response_successful_message_status_and_data_null_after_pin_request_of_adpeako_flow_msisdn_pin_with_invalid_mandatory(List<List<String>> list) {
        adpeakoPinRequestController.verifyResponseWithInvalidMandatory(list);
    }
}