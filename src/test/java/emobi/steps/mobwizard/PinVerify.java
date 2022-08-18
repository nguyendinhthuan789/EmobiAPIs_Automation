package emobi.steps.mobwizard;

import emobi.controller.MobwizardPinVerifyController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class PinVerify {
    private final MobwizardPinVerifyController mobwizardPinVerifyController;

    public PinVerify() {
        mobwizardPinVerifyController = new MobwizardPinVerifyController();
    }

    @Given("User call the API pin verify of Mobwizard flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_mobwizard_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        mobwizardPinVerifyController.mobwizardPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Mobwizard flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_mobwizard_flow_msisdn_pin(int  statusCode) {
        mobwizardPinVerifyController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_mobwizard_flow_msisdn_pin(List<List<String>> list) {
        mobwizardPinVerifyController.verifyResponseWithValidInput(list);
    }

    @Given("User call the API pin verify of Mobwizard flow msisdn pin with pin invalid credential")
    public void user_call_the_api_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid_credential(List<List<String>> list) {
        mobwizardPinVerifyController.mobwizardPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Mobwizard flow msisdn pin with pin invalid")
    public void response_successful_status_code_is_after_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid(int statusCode) {
        mobwizardPinVerifyController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin with pin invalid")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid(List<List<String>> list) {
        mobwizardPinVerifyController.verifyResponseWithInvalidPin(list);
    }

    @Given("User call the API pin verify of Mobwizard flow msisdn pin with pin invalid mandatory credential")
    public void user_call_the_api_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid_mandatory_credential(List<List<String>> list) {
        mobwizardPinVerifyController.mobwizardPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Mobwizard flow msisdn pin with pin invalid mandatory")
    public void response_successful_status_code_is_after_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid_mandatory(int statusCode) {
        mobwizardPinVerifyController.verifyStatus(statusCode);
    }

    @Then("Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin with pin invalid mandatory")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_mobwizard_flow_msisdn_pin_with_pin_invalid_mandatory(List<List<String>> list) {
        mobwizardPinVerifyController.verifyResponseWithInvalidMandatory(list);
    }
}