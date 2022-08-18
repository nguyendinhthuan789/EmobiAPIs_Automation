package emobi.steps.moviplus;

import emobi.controller.MoviplusMoController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class MsisdnMoTracking {
    private final MoviplusMoController moviplusMoController;

    public MsisdnMoTracking() {
        moviplusMoController = new MoviplusMoController();
    }

    @Given("User call the API tracking request of Moviplus flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        moviplusMoController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_msisdn_mo(int statusCode) {
        moviplusMoController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_msisdn_mo(List<List<String>> list) {
        moviplusMoController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API tracking request of Moviplus flow msisdn mo with invalid mandatory credentials")
    public void user_call_the_api_tracking_request_of_moviplus_flow_msisdn_mo_with_invalid_mandatory_credentials(List<List<String>> list) {
        moviplusMoController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow msisdn mo invalid mandatory credentials")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_msisdn_mo_invalid_mandatory_credentials(int statusCode) {
        moviplusMoController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow msisdn mo invalid mandatory credentials")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_msisdn_mo_invalid_mandatory_credentials(List<List<String>> list) {
        moviplusMoController.verifyResponseWithInvalidMandatory(list);
    }
}