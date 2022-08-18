package emobi.steps.moviplus;

import emobi.controller.MoviplusC2sController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class C2sTracking {
    private final MoviplusC2sController moviplusC2sController;

    public C2sTracking() {
        moviplusC2sController = new MoviplusC2sController();
    }

    @Given("User call the API tracking request of Moviplus flow C2S with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_c2s_with_valid_credential(List<List<String>> list) {
        moviplusC2sController.moviplusRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow C2S")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_c2s(int statusCode) {
        moviplusC2sController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow C2S")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_c2s(List<List<String>> list) {
        moviplusC2sController.verifyResponseWithInvalidInput(list);
    }
}