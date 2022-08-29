package emobi.steps;

import emobi.controller.PinVerifyForRsController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class StepsPinVerifyForRs {
    private final PinVerifyForRsController pinVerifyForRsController;

    public StepsPinVerifyForRs() {
        pinVerifyForRsController = new PinVerifyForRsController();
    }

    @Given("User call the API pin verify of flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with pin invalid credential")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_pin_invalid_credential(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with pin invalid")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_pin_invalid(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with pin invalid")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_pin_invalid(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with null tpClickId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null tpClickId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null tpClickId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with invalid tpClickId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_i(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with invalid tpClickId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_id(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with invalid tpClickId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_id(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with invalid campaign")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with null pinId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_pin_id(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null pinId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_pin_id(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null pinId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_pin_id(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithInvalidMandatory(list);
    }

    @Given("User call the API pin verify of flow msisdn pin with null pinValue")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_pin_value(List<List<String>> list) {
        pinVerifyForRsController.requestPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null pinValue")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_pin_value(int statusCode) {
        pinVerifyForRsController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null pinValue")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_pin_value(List<List<String>> list) {
        pinVerifyForRsController.verifyResponseWithInvalidMandatory(list);
    }
}