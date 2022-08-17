package emobi.steps.moviplus;

import emobi.controller.MoviplusMoController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MsisdnMoTracking {
    Logger log = LoggerFactory.getLogger(MsisdnMoTracking.class);
    private List<String> result;
    private MoviplusMoController moviplusMoController;

    public MsisdnMoTracking() {
        moviplusMoController = new MoviplusMoController();
    }

    @Given("User call the API tracking request of Moviplus flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        moviplusMoController.moviplusRequestMoTracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_msisdn_mo(int statusCode) {
      moviplusMoController.checkStatusIs200(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_msisdn_mo(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + moviplusMoController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), moviplusMoController.getJsonPathHasKey("message"));
        log.info("status is: " + moviplusMoController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), moviplusMoController.getJsonPathHasKey("status"));
        log.info("keyword is: " + moviplusMoController.getJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), moviplusMoController.getJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + moviplusMoController.getJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), moviplusMoController.getJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + moviplusMoController.getJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(moviplusMoController.getJsonPathHasKey("data.tracking_code"));
    }
}