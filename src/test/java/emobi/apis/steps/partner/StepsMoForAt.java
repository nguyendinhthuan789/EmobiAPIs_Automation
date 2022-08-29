package emobi.apis.steps.partner;

import emobi.apis.controller.MoForAtController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepsMoForAt {
    Logger log = LoggerFactory.getLogger(StepsMoForAt.class);
    private final MoForAtController objMoRequest;

    public StepsMoForAt() {
        objMoRequest = new MoForAtController();
    }

    @Given("User call the API tracking request of flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_valid_credential(DataTable table) {
        objMoRequest.moviplusRequestMoTracking(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo(int statusCode) {
        Assert.assertTrue(objMoRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_msisdn_mo(DataTable table) {
        log.info("message is: " + objMoRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objMoRequest.extractTable(table, "message"), objMoRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objMoRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objMoRequest.extractTable(table, "status"), objMoRequest.findJsonPathHasKey("status"));
        log.info("subscriptionStatus is: " + objMoRequest.findJsonPathHasKey("data.subscriptionStatus"));
        Assert.assertEquals(objMoRequest.extractTable(table, "subscriptionStatus"), objMoRequest.findJsonPathHasKey("data.subscriptionStatus"));
        log.info("keyword is: " + objMoRequest.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(objMoRequest.extractTable(table, "keyword"), objMoRequest.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + objMoRequest.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(objMoRequest.extractTable(table, "shortcode"), objMoRequest.findJsonPathHasKey("data.shortcode"));
    }

    @Given("User call the API tracking request of flow msisdn mo with with null msisdn")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_with_null_msisdn(DataTable table) {
        objMoRequest.moviplusRequestMoTracking(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo with null msisdn")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo_with_null_msisdn(int statusCode) {
        Assert.assertTrue(objMoRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message after tracking request of flow msisdn mo with null msisdn")
    public void response_successful_message_after_tracking_request_of_flow_msisdn_mo_with_null_msisdn(DataTable table) {
        log.info("message is: " + objMoRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objMoRequest.extractTable(table, "message"), objMoRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objMoRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objMoRequest.extractTable(table, "status"), objMoRequest.findJsonPathHasKey("status"));
        log.info("data is: " + objMoRequest.findJsonPathHasKey("data"));
        Assert.assertTrue(objMoRequest.checkMapIsEmpty("data"));
    }

    @Given("User call the API tracking request of flow msisdn mo with with invalid campaign")
    public void user_call_the_api_tracking_request_of_flow_msisdn_mo_with_with_invalid_campaign(DataTable table) {
        objMoRequest.moviplusRequestMoTracking(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow msisdn mo with invalid campaign")
    public void response_successful_status_code_is_after_tracking_request_of_flow_msisdn_mo_with_invalid_campaign(int statusCode) {
        Assert.assertTrue(objMoRequest.verifyStatus(statusCode));
    }

    @Then("Response successful message after tracking request of flow msisdn mo with invalid campaign")
    public void response_successful_message_after_tracking_request_of_flow_msisdn_mo_with_invalid_campaign(DataTable table) {
        log.info("message is: " + objMoRequest.findJsonPathHasKey("message"));
        Assert.assertEquals(objMoRequest.extractTable(table, "message"), objMoRequest.findJsonPathHasKey("message"));
        log.info("status is: " + objMoRequest.findJsonPathHasKey("status"));
        Assert.assertEquals(objMoRequest.extractTable(table, "status"), objMoRequest.findJsonPathHasKey("status"));
        log.info("data is: " + objMoRequest.findJsonPathHasKey("data"));
        Assert.assertTrue(objMoRequest.checkMapIsEmpty("data"));
    }
}