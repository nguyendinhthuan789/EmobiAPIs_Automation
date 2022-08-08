package emobi.steps.adpeako;

import emobi.constants.URL;
import emobi.rest.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class C2sEronet {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;

    public C2sEronet() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API tracking request Eronet of Adpeako flow C2S with valid credential")
    public void user_call_the_api_tracking_request_eronet_of_adpeako_flow_c2s_with_valid_credential(DataTable dataTable) {

        restParams.addParam("tp_click_id", "5g043028b3010650413dg2pg");
        restParams.addParam("userAgent", "Mozilla%2F5.0%20(Macintosh%3B%20Intel%20Mac%20OS%20X%2010_15_7)%20AppleWebKit%2F537.36%20(KHTML%2C%20like%20Gecko)%20Chrome%2F91.0.4472.101%20Safari%2F537.36");

        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_C2S,"111111", RestMethod.GET);
        restHeaders.add("apikey", "e5f4a5e9-5924-413e-a8bd-f62345fbb445");
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }
//    @Then("Response successful status code is {int} after tracking request Eronet of Adpeako flow C2S")
//    public void response_successful_status_code_is_after_tracking_request_eronet_of_adpeako_flow_c2s(int  statusCode) {
//        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
//    }
//    @Then("Response successful message is <message> status is <status> keyword is <keyword> shortcode is <shortcode> after tracking request Eronet of Adpeako flow C2S")
//    public void response_successful_message_is_message_status_is_status_keyword_is_keyword_shortcode_is_shortcode_after_tracking_request_eronet_of_adpeako_flow_c2s(DataTable dataTable) {
//        throw new io.cucumber.java.PendingException();
//    }
}
