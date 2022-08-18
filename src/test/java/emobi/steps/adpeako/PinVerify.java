package emobi.steps.adpeako;

import emobi.controller.AdpeakoPinVerifyController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PinVerify {
    Logger log = LoggerFactory.getLogger(PinVerify.class);
    private List<String> result;
    private AdpeakoPinVerifyController adpeakoPinVerifyController;

    public PinVerify() {
        adpeakoPinVerifyController = new AdpeakoPinVerifyController();
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        adpeakoPinVerifyController.adpeakoPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin(int statusCode) {
        Assert.assertTrue(adpeakoPinVerifyController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinVerifyController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), adpeakoPinVerifyController.findJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinVerifyController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), adpeakoPinVerifyController.findJsonPathHasKey("status"));
        log.info("verify status is: " + adpeakoPinVerifyController.findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(result.get(5), adpeakoPinVerifyController.findJsonPathHasKey("data.verify_status"));
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with pin invalid credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_credential(List<List<String>> list) {
        adpeakoPinVerifyController.adpeakoPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin with pin invalid")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid(int statusCode) {
        Assert.assertTrue(adpeakoPinVerifyController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin with pin invalid")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinVerifyController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), adpeakoPinVerifyController.findJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinVerifyController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), adpeakoPinVerifyController.findJsonPathHasKey("status"));
        log.info("verify status is: " + adpeakoPinVerifyController.findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(result.get(5), adpeakoPinVerifyController.findJsonPathHasKey("data.verify_status"));
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with pin invalid mandatory credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory_credential(List<List<String>> list) {
        adpeakoPinVerifyController.adpeakoPinVerifyTracking(list);
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin with pin invalid mandatory")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory(int statusCode) {
        Assert.assertTrue(adpeakoPinVerifyController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin with pin invalid mandatory")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + adpeakoPinVerifyController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(3), adpeakoPinVerifyController.findJsonPathHasKey("message"));
        log.info("status is: " + adpeakoPinVerifyController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(4), adpeakoPinVerifyController.findJsonPathHasKey("status"));
        log.info("verify status is: " + adpeakoPinVerifyController.findJsonPathHasKey("data"));
        Assert.assertTrue(adpeakoPinVerifyController.checkMapIsEmpty("data"));
    }
}