package emobi.steps.mobwizard;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.ConfigSettings;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PinRequest {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private ConfigSettings config;
    private List<String> result;

    public PinRequest() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        config = new ConfigSettings(System.getProperty("user.dir"));
    }

    @Given("User call the API pin request of Mobwizard flow msisdn pin with valid credential")
    public void user_call_the_api_pin_request_of_mobwizard_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MSISDN_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add("apikey", config.getApiKey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after pin request of Mobwizard flow msisdn pin")
    public void response_successful_status_code_is_after_pin_request_of_mobwizard_flow_msisdn_pin(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status subscriptionStatus and pinid not null after pin request of Mobwizard flow msisdn pin")
    public void response_successful_message_status_subscription_status_and_pinid_not_null_after_pin_request_of_mobwizard_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("data.subscriptionStatus"));
        Assert.assertNotNull(restResponse.getJsonPath(restResponse.extract()).getString("data.pinId"));
    }

    @Given("User call the API pin request of Mobwizard flow msisdn pin with invalid campaign credential")
    public void user_call_the_api_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MSISDN_PIN_REQUEST + result.get(6), RestMethod.GET);
        restHeaders.add("apikey", config.getApiKey());
        restParams.addParam(result.get(1), result.get(7));
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after pin request of Mobwizard flow msisdn pin with invalid campaign")
    public void response_successful_status_code_is_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and data null after pin request of Mobwizard flow msisdn pin with invalid campaign")
    public void response_successful_message_status_and_data_null_after_pin_request_of_mobwizard_flow_msisdn_pin_with_invalid_campaign(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(2), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertTrue(restResponse.getJsonPath(restResponse.extract()).getMap("data").size() == 0);
    }
}