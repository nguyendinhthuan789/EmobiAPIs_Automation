package emobi.steps.adpeako;

import emobi.controller.AdpeakoMoController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class MsisdnMoTracking {
    private final AdpeakoMoController adpeakoMoController;

    public MsisdnMoTracking() {
        adpeakoMoController =new AdpeakoMoController();
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo(int statusCode) {
        adpeakoMoController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo(List<List<String>> list) {
        adpeakoMoController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void user_call_the_api_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        adpeakoMoController.adpeakoRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(int statusCode) {
        adpeakoMoController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and new subscriptionStatus after tracking request of Adpeako flow msisdn mo with invalid mandatory")
    public void response_successful_message_status_keyword_shortcode_and_new_subscription_status_after_tracking_request_of_adpeako_flow_msisdn_mo_with_invalid_mandatory(List<List<String>> list) {
        adpeakoMoController.verifyResponseWithInvalidMandatory(list);
    }
}