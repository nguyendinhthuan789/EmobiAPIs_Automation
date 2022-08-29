package emobi.apis.steps.partner;

import emobi.apis.controller.PinVerifyForRsController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepsPinVerifyForRs {
    Logger log = LoggerFactory.getLogger(StepsPinVerifyForRs.class);
    private final PinVerifyForRsController objPinVerify;

    public StepsPinVerifyForRs() {
        objPinVerify = new PinVerifyForRsController();
    }

    @Given("User call the API pin verify of flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_valid_credential(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "verify_status"), objPinVerify.findJsonPathHasKey("data.verify_status"));
    }

    @Given("User call the API pin verify of flow msisdn pin with pin invalid credential")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_pin_invalid_credential(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with pin invalid")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_pin_invalid(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with pin invalid")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_pin_invalid(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data.verify_status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "verify_status"), objPinVerify.findJsonPathHasKey("data.verify_status"));
    }

    @Given("User call the API pin verify of flow msisdn pin with null tpClickId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null tpClickId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null tpClickId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_tp_click_id(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinVerify.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin verify of flow msisdn pin with invalid tpClickId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_i(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with invalid tpClickId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_id(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with invalid tpClickId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_invalid_tp_click_id(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinVerify.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin verify of flow msisdn pin with invalid campaign")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_invalid_campaign(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinVerify.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin verify of flow msisdn pin with null pinId")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_pin_id(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null pinId")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_pin_id(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null pinId")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_pin_id(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinVerify.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin verify of flow msisdn pin with null pinValue")
    public void user_call_the_api_pin_verify_of_flow_msisdn_pin_with_null_pin_value(DataTable table) {
        objPinVerify.requestPinVerifyTracking(table);
    }

    @Then("Response successful status code is {int} after pin verify of flow msisdn pin with null pinValue")
    public void response_successful_status_code_is_after_pin_verify_of_flow_msisdn_pin_with_null_pin_value(int statusCode) {
        Assert.assertTrue(objPinVerify.verifyStatus(statusCode));
    }

    @Then("Response successful message status and verify status after pin verify of flow msisdn pin with null pinValue")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_flow_msisdn_pin_with_null_pin_value(DataTable table) {
        log.info("message is: " + objPinVerify.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinVerify.extractTable(table, "message"), objPinVerify.findJsonPathHasKey("message"));
        log.info("status is: " + objPinVerify.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinVerify.extractTable(table, "status"), objPinVerify.findJsonPathHasKey("status"));
        log.info("verify status is: " + objPinVerify.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinVerify.checkMapIsEmpty("data"));
    }
}