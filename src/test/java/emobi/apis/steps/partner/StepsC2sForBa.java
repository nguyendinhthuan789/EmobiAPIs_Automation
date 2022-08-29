package emobi.apis.steps.partner;

import emobi.apis.controller.C2sForBaController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepsC2sForBa {
    Logger log = LoggerFactory.getLogger(StepsC2sForBa.class);
    private final C2sForBaController objC2s;

    public StepsC2sForBa() {
        objC2s = new C2sForBaController();
    }

    @Given("User call the API tracking request of flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_flow_c2s_ba_eronet_with_valid_credential(DataTable table) {
        objC2s.c2sRequestTrackingOfBaCountry(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_ba_eronet(int statusCode) {
        Assert.assertTrue(objC2s.verifyStatus(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_c2s_ba_eronet(DataTable table) {
        log.info("message is: " + objC2s.findJsonPathHasKey("message"));
        Assert.assertEquals(objC2s.extractTable(table, "message"), objC2s.findJsonPathHasKey("message"));
        log.info("status is: " + objC2s.findJsonPathHasKey("status"));
        Assert.assertEquals(objC2s.extractTable(table, "status"), objC2s.findJsonPathHasKey("status"));
        log.info("keyword is: " + objC2s.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(objC2s.extractTable(table, "keyword"), objC2s.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + objC2s.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(objC2s.extractTable(table, "shortcode"), objC2s.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + objC2s.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(objC2s.findJsonPathHasKey("data.tracking_code"));
    }

    @Given("User call the API tracking request of flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_flow_c2s_ba_mtel_with_valid_credential(DataTable table) {
        objC2s.c2sRequestTrackingOfBaCountry(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_ba_mtel(int statusCode) {
        Assert.assertTrue(objC2s.verifyStatus(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_flow_c2s_ba_mtel(DataTable table) {
        log.info("message is: " + objC2s.findJsonPathHasKey("message"));
        Assert.assertEquals(objC2s.extractTable(table, "message"), objC2s.findJsonPathHasKey("message"));
        log.info("status is: " + objC2s.findJsonPathHasKey("status"));
        Assert.assertEquals(objC2s.extractTable(table, "status"), objC2s.findJsonPathHasKey("status"));
        log.info("keyword is: " + objC2s.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(objC2s.extractTable(table, "keyword"), objC2s.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + objC2s.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(objC2s.extractTable(table, "shortcode"), objC2s.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + objC2s.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(objC2s.findJsonPathHasKey("data.tracking_code"));
    }

    @Given("User call the API tracking request of flow C2S with null tpClickId")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_null_tp_click_id(DataTable table) {
        objC2s.c2sRequestTrackingOfBaCountryWithNullTpClickId(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with null tpClickId")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_null_tp_click_id(int statusCode) {
        Assert.assertTrue(objC2s.verifyStatus(statusCode));
    }

    @Then("Response message successful after tracking request of flow with null tpClickId")
    public void response_message_successful_after_tracking_request_of_flow_with_null_tp_click_id(DataTable table) {
        log.info("message is: " + objC2s.findJsonPathHasKey("message"));
        Assert.assertEquals(objC2s.extractTable(table, "message"), objC2s.findJsonPathHasKey("message"));
        log.info("status is: " + objC2s.findJsonPathHasKey("status"));
        Assert.assertEquals(objC2s.extractTable(table, "status"), objC2s.findJsonPathHasKey("status"));
        log.info("data is: " + objC2s.findJsonPathHasKey("data"));
        Assert.assertTrue(objC2s.checkMapIsEmpty("data"));
    }

    @Given("User call the API tracking request of flow C2S with null userAgent")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_null_user_agent(DataTable table) {
        objC2s.c2sRequestTrackingOfBaCountry(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with null userAgent")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_null_user_agent(int statusCode) {
        Assert.assertTrue(objC2s.verifyStatus(statusCode));
    }

    @Then("Response message successful after tracking request of flow with null userAgent")
    public void response_message_successful_after_tracking_request_of_flow_with_null_user_agent(DataTable table) {
        log.info("message is: " + objC2s.findJsonPathHasKey("message"));
        Assert.assertEquals(objC2s.extractTable(table, "message"), objC2s.findJsonPathHasKey("message"));
        log.info("status is: " + objC2s.findJsonPathHasKey("status"));
        Assert.assertEquals(objC2s.extractTable(table, "status"), objC2s.findJsonPathHasKey("status"));
        log.info("data is: " + objC2s.findJsonPathHasKey("data"));
        Assert.assertTrue(objC2s.checkMapIsEmpty("data"));
    }

    @Given("User call the API tracking request of flow C2S with invalid campaign")
    public void user_call_the_api_tracking_request_of_flow_c2s_with_invalid_campaign(DataTable table) {
        objC2s.c2sRequestTrackingOfBaCountry(table);
    }

    @Then("Response successful status code is {int} after tracking request of flow C2S with invalid campaign")
    public void response_successful_status_code_is_after_tracking_request_of_flow_c2s_with_invalid_campaign(int statusCode) {
        Assert.assertTrue(objC2s.verifyStatus(statusCode));
    }

    @Then("Response message successful after tracking request of flow with invalid campaign")
    public void response_message_successful_after_tracking_request_of_flow_with_invalid_campaign(DataTable table) {
        log.info("message is: " + objC2s.findJsonPathHasKey("message"));
        Assert.assertEquals(objC2s.extractTable(table, "message"), objC2s.findJsonPathHasKey("message"));
        log.info("status is: " + objC2s.findJsonPathHasKey("status"));
        Assert.assertEquals(objC2s.extractTable(table, "status"), objC2s.findJsonPathHasKey("status"));
        log.info("data is: " + objC2s.findJsonPathHasKey("data"));
        Assert.assertTrue(objC2s.checkMapIsEmpty("data"));
    }
}