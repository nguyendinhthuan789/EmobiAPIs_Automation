package emobi.steps.mobwizard;

import emobi.controller.MobwizardC2sController;
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
    private final MobwizardC2sController mobwizardC2sController;

    public C2sTracking() {
        mobwizardC2sController = new MobwizardC2sController();
    }

    @Given("User call the API tracking request of Mobwizard flow C2S with valid credential")
    public void user_call_the_api_tracking_request_of_mobwizard_flow_c2s_with_valid_credential(List<List<String>> list) {
        mobwizardC2sController.mobwizardRequestC2STracking(list);
    }

    @Then("Response successful status code is {int} after tracking request of Mobwizard flow C2S")
    public void response_successful_status_code_is_after_tracking_request_of_mobwizard_flow_c2s(int statusCode) {
        Assert.assertTrue(mobwizardC2sController.checkStatusIs200(statusCode));
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Mobwizard flow C2S")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_mobwizard_flow_c2s(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + mobwizardC2sController.getJsonPathHasKey("message"));
        Assert.assertEquals(result.get(4), mobwizardC2sController.getJsonPathHasKey("message"));
        log.info("status is: " + mobwizardC2sController.getJsonPathHasKey("status"));
        Assert.assertEquals(result.get(5), mobwizardC2sController.getJsonPathHasKey("status"));
        log.info("keyword is: " + mobwizardC2sController.getJsonPathHasKey("data.keyword"));
        Assert.assertEquals(result.get(6), mobwizardC2sController.getJsonPathHasKey("data.keyword"));
        log.info("shortcode is: " + mobwizardC2sController.getJsonPathHasKey("data.shortcode"));
        Assert.assertEquals(result.get(7), mobwizardC2sController.getJsonPathHasKey("data.shortcode"));
        log.info("tracking_code is: " + mobwizardC2sController.getJsonPathHasKey("data.tracking_code"));
        Assert.assertNotNull(mobwizardC2sController.getJsonPathHasKey("data.tracking_code"));
    }
}