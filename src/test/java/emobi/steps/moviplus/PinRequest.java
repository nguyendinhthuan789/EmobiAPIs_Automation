package emobi.steps.moviplus;

import emobi.controller.MoviplusPinRequestController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class PinRequest {
    private final MoviplusPinRequestController moviplusPinRequestController;

    public PinRequest(){
        moviplusPinRequestController= new MoviplusPinRequestController();
    }

    @Given("User call the API pin request of Moviplus flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_moviplus_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        moviplusPinRequestController.mobwizardPinRequestTracking(list);
    }
    @Then("Response successful status code is {int} after pin request of Moviplus flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_moviplus_flow_msisdn_pin(int statusCode) {
        moviplusPinRequestController.verifyStatus(statusCode);
    }
    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of Moviplus flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_moviplus_flow_msisdn_pin(List<List<String>> list) {
        moviplusPinRequestController.verifyResponseWithValidInput(list);
    }
}
