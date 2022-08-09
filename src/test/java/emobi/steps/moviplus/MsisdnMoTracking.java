package emobi.steps.moviplus;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.ConfigSettings;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class MsisdnMoTracking {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private ConfigSettings config;
    private List<String> result;

    public MsisdnMoTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
        config = new ConfigSettings(System.getProperty("user.dir"));
    }

    @Given("User call the API tracking request of Moviplus flow msisdn mo with valid credential")
    public void user_call_the_api_tracking_request_of_moviplus_flow_msisdn_mo_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_MSISDN_MSISDN_MO + result.get(6), RestMethod.GET);
        restHeaders.add("apikey", config.getApiKey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(8));
        restParams.addParam(result.get(3), result.get(9));
        restParams.addParam(result.get(4), result.get(10));
        restParams.addParam(result.get(5), result.get(11));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after tracking request of Moviplus flow msisdn mo")
    public void response_successful_status_code_is_after_tracking_request_of_moviplus_flow_msisdn_mo(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Moviplus flow msisdn mo")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_moviplus_flow_msisdn_mo(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(6), restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(7), restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertNotNull(restResponse.getJsonPath(restResponse.extract()).getString("data.tracking_code"));
    }
}