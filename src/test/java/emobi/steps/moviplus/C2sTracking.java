package emobi.steps.moviplus;

import emobi.controller.MoviplusC2sController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class C2sTracking {
    Logger log = LoggerFactory.getLogger(C2sTracking.class);
    private List<String> result;
    private final MoviplusC2sController moviplusC2sController;

    public C2sTracking() {
        moviplusC2sController = new MoviplusC2sController();
    }

    @Given("User call the API tracking request of Moviplus flow C2S with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_c2s_with_valid_credential(List<List<String>> list) {
        moviplusC2sController.moviplusRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow C2S")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_c2s(int statusCode) {
        moviplusC2sController.checkStatusIs200(statusCode);
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow C2S")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_c2s(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + moviplusC2sController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), moviplusC2sController.findJsonPathHasKey("message"));
        log.info("status is: " + moviplusC2sController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), moviplusC2sController.findJsonPathHasKey("status"));
        log.info("keyword is: " + moviplusC2sController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), moviplusC2sController.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + moviplusC2sController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), moviplusC2sController.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + moviplusC2sController.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(moviplusC2sController.findJsonPathHasKey("data.tracking_code"));
    }
}