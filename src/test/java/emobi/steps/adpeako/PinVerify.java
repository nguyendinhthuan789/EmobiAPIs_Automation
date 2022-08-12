package emobi.steps.adpeako;

import emobi.constants.URL;
import emobi.rest.*;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PinVerify {
    Logger log = LoggerFactory.getLogger(PinVerify.class);
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;
    private RestParams restParams;
    private List<String> result;

    public PinVerify() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with valid credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_valid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_VERIFY + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(5));
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        log.info("verify status is: " + restResponse.getJsonPath(restResponse.extract()).getString("data.verify_status"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("data.verify_status"));
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with pin invalid credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_VERIFY + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(5));
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin with pin invalid")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin with pin invalid")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        log.info("verify status is: " + restResponse.getJsonPath(restResponse.extract()).getString("data.verify_status"));
        Assert.assertEquals(result.get(5), restResponse.getJsonPath(restResponse.extract()).getString("data.verify_status"));
    }

    @Given("User call the API pin verify of Adpeako flow msisdn pin with pin invalid mandatory credential")
    public void user_call_the_api_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory_credential(List<List<String>> list) {
        result = Utils.generateListString(list);
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.AFFILIATES_PARTNER_PIN_VERIFY + result.get(4), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam(result.get(1), result.get(5));
        restParams.addParam(result.get(2), result.get(6));
        restParams.addParam(result.get(3), result.get(7));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    @Then("Response successful status code is {int} after pin verify of Adpeako flow msisdn pin with pin invalid mandatory")
    public void response_successful_status_code_is_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory(int statusCode) {
        log.info("status code is: " + restResponse.extract().statusCode());
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response successful message status and verify status after pin verify of Adpeako flow msisdn pin with pin invalid mandatory")
    public void response_successful_message_status_and_verify_status_after_pin_verify_of_adpeako_flow_msisdn_pin_with_pin_invalid_mandatory(List<List<String>> list) {
        result = Utils.generateListString(list);
        log.info("message is: " + restResponse.getJsonPath(restResponse.extract()).getString("message"));
        Assert.assertEquals(result.get(3), restResponse.getJsonPath(restResponse.extract()).getString("message"));
        log.info("status is: " + restResponse.getJsonPath(restResponse.extract()).getString("status"));
        Assert.assertEquals(result.get(4), restResponse.getJsonPath(restResponse.extract()).getString("status"));
        log.info("verify status is: " + restResponse.getJsonPath(restResponse.extract()).getMap("data"));
        Assert.assertTrue(restResponse.getJsonPath(restResponse.extract()).getMap("data").size() == 0);
    }
}