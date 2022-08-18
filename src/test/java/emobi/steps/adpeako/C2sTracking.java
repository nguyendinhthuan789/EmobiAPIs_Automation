package emobi.steps.adpeako;

import emobi.controller.AdpeakoC2sController;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class C2sTracking {
    Logger log = LoggerFactory.getLogger(C2sTracking.class);
    private AdpeakoC2sController c2sController;
    private List<String> result;

    public C2sTracking() {
        c2sController = new AdpeakoC2sController();

    }

    @Given("User call the API tracking request of Adpeako flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_eronet_with_valid_credential(List<List<String>> list) {
        c2sController.adpeakoRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(int statusCode) {
        Assert.assertTrue(c2sController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + c2sController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), c2sController.findJsonPathHasKey("message"));
        log.info("status is: " + c2sController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), c2sController.findJsonPathHasKey("status"));
        log.info("keyword is: " + c2sController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), c2sController.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + c2sController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), c2sController.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + c2sController.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(c2sController.findJsonPathHasKey("data.tracking_code"));
    }

    @Given("User call the API tracking request of Adpeako flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_mtel_with_valid_credential(List<List<String>> list) {
        c2sController.adpeakoRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(int statusCode) {
        Assert.assertTrue(c2sController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + c2sController.findJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), c2sController.findJsonPathHasKey("message"));
        log.info("status is: " + c2sController.findJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), c2sController.findJsonPathHasKey("status"));
        log.info("keyword is: " + c2sController.findJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), c2sController.findJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + c2sController.findJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), c2sController.findJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + c2sController.findJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(c2sController.findJsonPathHasKey("data.tracking_code"));
    }
}