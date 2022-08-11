package emobi.steps.adpeako;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class C2sTracking {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private List<String> result;

    public C2sTracking() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API tracking request of Adpeako flow C2S ba eronet with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_eronet_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba eronet")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_eronet(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(6), restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(7), restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertNotNull(restResponse.getJsonPath(restResponse.extract()).getString("data.tracking_code"));
    }

    @Given("User call the API tracking request of Adpeako flow C2S ba mtel with valid credential")
    public void user_call_the_api_tracking_request_of_adpeako_flow_c2s_ba_mtel_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), Randoms.randomString());
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        restResponse.printPrettyPrint();
    }

    @Then("Response successful status code is {int} after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_status_code_is_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status keyword shortcode and trackingcode not null after tracking request of Adpeako flow C2S ba mtel")
    public void response_successful_message_status_keyword_shortcode_and_trackingcode_not_null_after_tracking_request_of_adpeako_flow_c2s_ba_mtel(List<List<String>> list) {
        result = Utils.generateListString(list);
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(6), restResponse.getJsonPath(restResponse.extract()).getString("data.keyword"));
        Assert.assertEquals(result.get(7), restResponse.getJsonPath(restResponse.extract()).getString("data.shortcode"));
        Assert.assertNotNull(restResponse.getJsonPath(restResponse.extract()).getString("data.tracking_code"));
    }
}