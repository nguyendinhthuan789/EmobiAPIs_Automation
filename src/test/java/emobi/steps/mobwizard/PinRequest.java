package emobi.steps.mobwizard;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PinRequest {
    Logger log = LoggerFactory.getLogger(PinRequest.class);
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private List<String> result;

    public PinRequest() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API pin request of Mobwizard flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_mobwizard_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    @Then("Response successful status code is {int} after pin request of Mobwizard flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_mobwizard_flow_msisdn_pin(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of Mobwizard flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_mobwizard_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.findJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(3), restResponse.findJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.findJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(4), restResponse.findJsonPath(restResponse.extract()).getString("status"));
        log.info("status subscriptionStatus is: " + restResponse.findJsonPath(restResponse.extract()).getString("data.subscriptionStatus"));
        Assert.assertEquals(result.get(5), restResponse.findJsonPath(restResponse.extract()).getString("data.subscriptionStatus"));
        log.info("pin is: " + restResponse.findJsonPath(restResponse.extract()).getString("data.pinId"));
        Assert.assertNotNull(restResponse.findJsonPath(restResponse.extract()).getString("data.pinId"));
    }

    @Given("User call the API pin request of Mobwizard flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    @Then("Response successful status code is {int} after pin request of Mobwizard flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and data null after pin request of Mobwizard flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.findJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(2), restResponse.findJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.findJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(3), restResponse.findJsonPath(restResponse.extract()).getString("status"));
        log.info("data is: " + restResponse.findJsonPath(restResponse.extract()).getMap("data"));
        Assert.assertTrue(restResponse.findJsonPath(restResponse.extract()).getMap("data").size() == 0);
    }

    @Given("User call the API pin request of Mobwizard flow msisdn pin with invalid mandatory credential")
    public void user_call_the_api_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_mandatory_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }
    @Then("Response successful status code is {int} after pin request of Mobwizard flow msisdn pin with invalid mandatory")
    public void response_successful_status_code_is_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_mandatory(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }
    @Then("Response successful message status and data null after pin request of Mobwizard flow msisdn pin with invalid mandatory")
    public void response_successful_message_status_and_data_null_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.findJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(2), restResponse.findJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.findJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(3), restResponse.findJsonPath(restResponse.extract()).getString("status"));
        log.info("data is: " + restResponse.findJsonPath(restResponse.extract()).getMap("data"));
        Assert.assertTrue(restResponse.findJsonPath(restResponse.extract()).getMap("data").size() == 0);
    }
}