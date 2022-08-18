package emobi.steps.edan;

import emobi.controller.EdanC2sController;
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
    private final EdanC2sController edanC2sController;

    public C2sTracking() {
        edanC2sController = new EdanC2sController();
    }

    @Given("User call the API tracking request of Edgar Zakaryan flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_edgar_zakaryan_flow_c2s_ba_eronet_with_valid_credential(List<List<String>> list) {
        edanC2sController.edanRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Edgar Zakaryan flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_edgar_zakaryan_flow_c2s_ba_eronet(int statusCode) {
        Assert.assertTrue(edanC2sController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Edgar Zakaryan flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_edgar_zakaryan_flow_c2s_ba_eronet(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + edanC2sController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), edanC2sController.findJsonPathHasKey("message"));
        log.info("status is: " + edanC2sController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), edanC2sController.findJsonPathHasKey("status"));
        log.info("keyword is: " + edanC2sController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), edanC2sController.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + edanC2sController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), edanC2sController.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + edanC2sController.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(edanC2sController.findJsonPathHasKey("data.tracking_code"));
    }

    @Given("User call the API tracking request of Edgar Zakaryan flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_edgar_zakaryan_flow_c2s_ba_mtel_with_valid_credential(List<List<String>> list) {
        edanC2sController.edanRequestC2STracking(list);
    }
    @Then("Response successful status code is {int} after tracking request of Edgar Zakaryan flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_edgar_zakaryan_flow_c2s_ba_mtel(int statusCode) {
        Assert.assertTrue(edanC2sController.checkStatusIs200(statusCode));
    }
    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Edgar Zakaryan flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_edgar_zakaryan_flow_c2s_ba_mtel(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + edanC2sController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), edanC2sController.findJsonPathHasKey("message"));
        log.info("status is: " + edanC2sController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), edanC2sController.findJsonPathHasKey("status"));
        log.info("keyword is: " + edanC2sController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), edanC2sController.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + edanC2sController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), edanC2sController.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + edanC2sController.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(edanC2sController.findJsonPathHasKey("data.tracking_code"));
    }
}