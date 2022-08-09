package emobi.steps.mobwizard;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.ConfigSettings;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PinVerify {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private ConfigSettings config;
    private List<String> result;

    public PinVerify() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        config = new ConfigSettings(System.getProperty("user.dir"));
    }

    @Given("User call the API pin verify of Mobwizard flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_mobwizard_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MSISDN_PIN_VERIFY + result.get(6), RestMethod.GET);
        restHeaders.add("apikey", config.getApiKey());
        restParams.addParam(result.get(1), result.get(5));
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after pin verify of Mobwizard flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_mobwizard_flow_msisdn_pin(int  statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and verify status after pin verify of Mobwizard flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_mobwizard_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("data.verify_status"));
    }
}