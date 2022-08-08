package emobi.steps.mobwizard;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.ConfigSettings;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class C2sTracking {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private ConfigSettings config;
    private List<String> result;

    public C2sTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        config = new ConfigSettings(System.getProperty("user.dir"));
    }

    @Given("User call the API tracking request of Mobwizard flow C2S with valid credential")
    public void user_call_the_api_tracking_request_of_mobwizard_flow_c2s_with_valid_credential(List<List<String>> list) {
        result = list.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S + result.get(3), RestMethod.GET);
        restHeaders.add("apikey", config.getApiKey());
        restParams.addParam(result.get(1), result.get(4));
        restParams.addParam(result.get(2), result.get(5));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after tracking request of Mobwizard flow C2S")
    public void response_successful_status_code_is_after_tracking_request_of_mobwizard_flow_c2s(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message is <message> status is <status> keyword is <keyword> shortcode is <shortcode> after tracking request of Mobwizard flow C2S")
    public void response_successful_message_is_message_status_is_status_keyword_is_keyword_shortcode_is_shortcode_after_tracking_request_of_mobwizard_flow_c2s(List<List<String>> list) {
        result = list.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(6), restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(7), restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertNotNull(restResponse.getJsonPath(restResponse.extract()).getString("data.tracking_code"));
    }
}