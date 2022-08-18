package emobi.steps.adpeako;

import emobi.controller.AdpeakoC2sController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class C2sTracking {
    private final AdpeakoC2sController c2sController;

    public C2sTracking() {
        c2sController = new AdpeakoC2sController();
    }

    @Given("User call the API tracking request of Adpeako flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_eronet_with_valid_credential(List<List<String>> list) {
        c2sController.adpeakoRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(List<List<String>> list) {
        c2sController.verifyResponse(list);
    }

    @Given("User call the API tracking request of Adpeako flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_mtel_with_valid_credential(List<List<String>> list) {
        c2sController.adpeakoRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(List<List<String>> list) {
        c2sController.verifyResponse(list);
    }
}