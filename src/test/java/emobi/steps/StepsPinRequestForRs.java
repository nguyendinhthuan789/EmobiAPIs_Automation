package emobi.steps;

import emobi.controller.PinRequestForRsController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class StepsPinRequestForRs {
    private final PinRequestForRsController pinRequestForRsController;

    public StepsPinRequestForRs() {
        pinRequestForRsController = new PinRequestForRsController();
    }

    @Given("User call the API pin request of flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        pinRequestForRsController.mobwizardPinRequestTracking(list);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin(int statusCode) {
        pinRequestForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_flow_msisdn_pin(List<List<String>> list) {
        pinRequestForRsController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API pin request of flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_invalid_campaign_credential(List<List<String>> list) {
        pinRequestForRsController.mobwizardPinRequestTracking(list);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        pinRequestForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        pinRequestForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin request of flow msisdn pin with null tpClickId")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(List<List<String>> list) {
        pinRequestForRsController.mobwizardPinRequestTracking(list);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with null tpClickId")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(int statusCode) {
        pinRequestForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with null tpClickId")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(List<List<String>> list) {
        pinRequestForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin request of flow msisdn pin with invalid msisdn")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(List<List<String>> list) {
        pinRequestForRsController.mobwizardPinRequestTracking(list);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with invalid msisdn")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(int statusCode) {
        pinRequestForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with invalid msisdn")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(List<List<String>> list) {
        pinRequestForRsController.verifyResponseWithInvalidMsisdn(list);
    }

    @Given("User call the API pin request of flow msisdn pin with null userAgent")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_null_user_agent(List<List<String>> list) {
        pinRequestForRsController.mobwizardPinRequestTracking(list);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with null userAgent")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_null_user_agent(int statusCode) {
        pinRequestForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with null userAgent")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_null_user_agent(List<List<String>> list) {
        pinRequestForRsController.verifyResponseWithInvalidMandatory(list);
    }
}