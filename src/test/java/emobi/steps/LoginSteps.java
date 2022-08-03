package emobi.steps;

import emobi.constants.URL;
import emobi.map.Login;
import emobi.rest.RestHeaders;
import emobi.rest.RestMethod;
import emobi.rest.RestRequest;
import emobi.rest.RestResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {
    private RestRequest restRequest;
    private RestHeaders restHeaders;
    private RestResponse restResponse;

    @Given("User perform login with Valid Credential")
    public void user_perform_login_with_valid_credential() {
        restRequest = new RestRequest(URL.BASE_URL, URL.LOGIN, RestMethod.POST);
        restHeaders = new RestHeaders();
        restHeaders.add(Login.loginMap());
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
    }

    @Then("Response Status code Login valid equals {int}")
    public void response_status_code_login_equals(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }
}