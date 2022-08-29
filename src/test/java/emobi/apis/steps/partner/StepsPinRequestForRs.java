package emobi.apis.steps.partner;

import emobi.apis.controller.PinRequestForRsController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepsPinRequestForRs {
    Logger log = LoggerFactory.getLogger(StepsPinRequestForRs.class);
    private final PinRequestForRsController objPinRequest;

    public StepsPinRequestForRs() {
        objPinRequest = new PinRequestForRsController();
    }

    @Given("User call the API pin request of flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_valid_credential(DataTable table) {
        objPinRequest.mobwizardPinRequestTracking(table);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin(int statusCode) {
        Assert.assertTrue(objPinRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_flow_msisdn_pin(DataTable table) {
        log.info("message is: " + objPinRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinRequest.extractTable(table, "message"), objPinRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objPinRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinRequest.extractTable(table, "status"), objPinRequest.findJsonPathHasKey("status"));
        log.info("status subscriptionStatus is: " + objPinRequest.findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(objPinRequest.extractTable(table, "subscriptionStatus"), objPinRequest.findJsonPathHasKey("data.subscriptionStatus"));
        log.info("pin is: " + objPinRequest.findJsonPathHasKey("data.pinId"));
        Assert.assertNotNull(objPinRequest.findJsonPathHasKey("data.pinId"));
    }

    @Given("User call the API pin request of flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_invalid_campaign_credential(DataTable table) {
        objPinRequest.mobwizardPinRequestTracking(table);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        Assert.assertTrue(objPinRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_invalid_campaign(DataTable table) {
        log.info("message is: " + objPinRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinRequest.extractTable(table, "message"), objPinRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objPinRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinRequest.extractTable(table, "status"), objPinRequest.findJsonPathHasKey("status"));
        log.info("data is: " + objPinRequest.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinRequest.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin request of flow msisdn pin with null tpClickId")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(DataTable table) {
        objPinRequest.mobwizardPinRequestTracking(table);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with null tpClickId")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(int statusCode) {
        Assert.assertTrue(objPinRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with null tpClickId")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_null_tp_click_id(DataTable table) {
        log.info("message is: " + objPinRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinRequest.extractTable(table, "message"), objPinRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objPinRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinRequest.extractTable(table, "status"), objPinRequest.findJsonPathHasKey("status"));
        log.info("data is: " + objPinRequest.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinRequest.checkMapIsEmpty("data"));
    }

    @Given("User call the API pin request of flow msisdn pin with invalid msisdn")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(DataTable table) {
        objPinRequest.mobwizardPinRequestTracking(table);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with invalid msisdn")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(int statusCode) {
        Assert.assertTrue(objPinRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with invalid msisdn")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_invalid_msisdn(DataTable table) {
        log.info("message is: " + objPinRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinRequest.extractTable(table, "message"), objPinRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objPinRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinRequest.extractTable(table, "status"), objPinRequest.findJsonPathHasKey("status"));
        log.info("status subscriptionStatus is: " + objPinRequest.findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(objPinRequest.extractTable(table, "subscriptionStatus"), objPinRequest.findJsonPathHasKey("data.subscriptionStatus"));
    }

    @Given("User call the API pin request of flow msisdn pin with null userAgent")
    public void user_call_the_api_pin_request_of_flow_msisdn_pin_with_null_user_agent(DataTable table) {
        objPinRequest.mobwizardPinRequestTracking(table);
    }

    @Then("Response successful status code is {int} after pin request of flow msisdn pin with null userAgent")
    public void response_successful_status_code_is_after_pin_request_of_flow_msisdn_pin_with_null_user_agent(int statusCode) {
        Assert.assertTrue(objPinRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status and data null after pin request of flow msisdn pin with null userAgent")
    public void response_successful_message_status_and_data_null_after_pin_request_of_flow_msisdn_pin_with_null_user_agent(DataTable table) {
        log.info("message is: " + objPinRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objPinRequest.extractTable(table, "message"), objPinRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objPinRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objPinRequest.extractTable(table, "status"), objPinRequest.findJsonPathHasKey("status"));
        log.info("data is: " + objPinRequest.findJsonPathHasKey("data"));
        Assert.assertTrue(objPinRequest.checkMapIsEmpty("data"));
    }
}