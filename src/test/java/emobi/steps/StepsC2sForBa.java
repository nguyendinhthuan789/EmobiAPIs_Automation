package emobi.steps;

import emobi.controller.C2sForBaController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class StepsC2sForBa {
    private final C2sForBaController c2sController;

    public StepsC2sForBa() {
        c2sController = new C2sForBaController();
    }

    @Given("User call the API tracking request of flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_flow_c2s_ba_eronet_with_valid_credential(List<List<String>> list) {
        c2sController.c2sRequestTrackingOfBaCountry(list);
    }

//    @Given("User call the API tracking request of flow C2S ba eronet with valid credential")
//    public void user_call_the_api_tracking_request_of_flow_c2s_ba_eronet_with_valid_credential(DataTable dataTable) {
//        c2sController.c2sRequestTrackingOfBaCountry1(dataTable);
//    }

    @Then("Response successful status code is {int} after tracking request of flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_ba_eronet(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_c2s_ba_eronet(List<List<String>> list) {
        c2sController.verifyResponse(list);
    }

    @Given("User call the API tracking request of flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_flow_c2s_ba_mtel_with_valid_credential(List<List<String>> list) {
        c2sController.c2sRequestTrackingOfBaCountry(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_ba_mtel(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_c2s_ba_mtel(List<List<String>> list) {
        c2sController.verifyResponse(list);
    }

    @Given("User call the API tracking request of flow C2S with null tpClickId")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_null_tp_click_id(List<List<String>> list) {
        c2sController.c2sRequestTrackingOfBaCountryWithNullTpClickId(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with null tpClickId")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_null_tp_click_id(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response message successful after tracking request of flow with null tpClickId")
    public void response_message_successful_after_tracking_request_of_flow_with_null_tp_click_id(List<List<String>> list) {
        c2sController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API tracking request of flow C2S with null userAgent")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_null_user_agent(List<List<String>> list) {
        c2sController.c2sRequestTrackingOfBaCountry(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with null userAgent")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_null_user_agent(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response message successful after tracking request of flow with null userAgent")
    public void response_message_successful_after_tracking_request_of_flow_with_null_user_agent(List<List<String>> list) {
        c2sController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API tracking request of flow C2S with invalid campaign")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_invalid_campaign(List<List<String>> list) {
        c2sController.c2sRequestTrackingOfBaCountry(list);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with invalid campaign")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_invalid_campaign(int statusCode) {
        c2sController.verifyStatus(statusCode);
    }

    @Then("Response message successful after tracking request of flow with invalid campaign")
    public void response_message_successful_after_tracking_request_of_flow_with_invalid_campaign(List<List<String>> list) {
        c2sController.verifyResponseWithInvalidMandatory(list);
    }
}