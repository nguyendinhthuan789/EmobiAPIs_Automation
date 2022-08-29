package emobi.steps;

import emobi.controller.MoForAtController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class StepsMoForAt {
    private final MoForAtController moForAtController;

    public StepsMoForAt() {
        moForAtController = new MoForAtController();
    }

    @Given("User call the API tracking request of flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        moForAtController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo(int statusCode) {
        moForAtController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_msisdn_mo(List<List<String>> list) {
        moForAtController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API tracking request of flow msisdn mo with with null msisdn")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_with_null_msisdn(List<List<String>> list) {
        moForAtController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo with null msisdn")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo_with_null_msisdn(int statusCode) {
        moForAtController.verifyStatus(statusCode);
    }

    @Then("Response successful message after tracking request of flow msisdn mo with null msisdn")
    public void response_successful_message_after_tracking_request_of_flow_msisdn_mo_with_null_msisdn(List<List<String>> list) {
        moForAtController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API tracking request of flow msisdn mo with with invalid campaign")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_with_invalid_campaign(List<List<String>> list) {
        moForAtController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo with invalid campaign")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo_with_invalid_campaign(int statusCode) {
        moForAtController.verifyStatus(statusCode);
    }

    @Then("Response successful message after tracking request of flow msisdn mo with invalid campaign")
    public void response_successful_message_after_tracking_request_of_flow_msisdn_mo_with_invalid_campaign(List<List<String>> list) {
        moForAtController.verifyResponseWithInvalidMandatory(list);
    }
}