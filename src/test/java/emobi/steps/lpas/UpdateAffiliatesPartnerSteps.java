package emobi.steps.lpas;

import emobi.constants.ServiceNames;
import emobi.constants.Status;
import emobi.constants.URL;
import emobi.models.AffiliatesPartnerCountryPayout;
import emobi.models.CreateAffiliatesPartnerEntity;
import emobi.models.UpdateAffiliatesPartnerCountryPayout;
import emobi.models.UpdateAffiliatesPartnerEntity;
import emobi.rest.*;
import emobi.utilities.Convert;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UpdateAffiliatesPartnerSteps {
    String getGetRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Cost = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Callback_payout = Convert.convertIntToString(Randoms.generateRandomInt());
    String getServiceName = Randoms.randomStringInList(ServiceNames.ALL_SERVICE_NAME);
    List<String> stringListCA = Stream.of(getGetRand_Default_pub_id, getRand_Default_pub_id, "se", getServiceName, "psms_click2sms", getRand_Cost, "se", getServiceName, "tele2", getRand_Callback_payout).collect(Collectors.toList());
    private RestRequest restRequest;
    private RestResponse restResponse;
    private RestHeaders restHeaders = new RestHeaders();
    private CreateAffiliatesPartnerEntity createAffiliatesPartnerEntity = new CreateAffiliatesPartnerEntity();
    private AffiliatesPartnerCountryPayout affiliatesPartnerCountryPayout = new AffiliatesPartnerCountryPayout();
    private UpdateAffiliatesPartnerEntity updateAffiliatesPartnerEntity = new UpdateAffiliatesPartnerEntity();
    private UpdateAffiliatesPartnerCountryPayout updateAffiliatesPartnerCountryPayout = new UpdateAffiliatesPartnerCountryPayout();
    private ArrayList arrayList;
    private State state;
    private String name = "Thuan update name affiliates SE";

    public UpdateAffiliatesPartnerSteps(State state) {
        this.state = state;
    }

    @Given("User create new affiliates partner for update affiliates partner with valid credential")
    public void user_create_new_affiliates_partner_for_update_affiliates_partner_with_valid_credential() {
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.CREATE_NEW_AFFILIATES_PARTNER, RestMethod.POST);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        createAffiliatesPartnerEntity.setName("Thuan create new affiliates SE at: " + Utils.date());
        createAffiliatesPartnerEntity.setStatus(Status.ACTIVE);
        createAffiliatesPartnerEntity.setPixelRatio(100);
        createAffiliatesPartnerEntity.setPixelRatioCounter(0);
        createAffiliatesPartnerEntity.setDescription("Thuan test create new affiliates parter");
        createAffiliatesPartnerEntity.setCreatedBy(63);
        createAffiliatesPartnerEntity.setUpdatedBy(63);
        createAffiliatesPartnerEntity.setParams(arrayList = new ArrayList());
        createAffiliatesPartnerEntity.setPixelUrl(restRequest.newHashSet("http://api.airpush.com/track/?guid=%click_id%"));
        createAffiliatesPartnerEntity.setCountries(restRequest.newHashSet("se"));
        createAffiliatesPartnerEntity.setCountryPayout(arrayList = new ArrayList());
        affiliatesPartnerCountryPayout.setPayoutAmount(10);
        affiliatesPartnerCountryPayout.setIsoCountryCode("se");
        affiliatesPartnerCountryPayout.setPayoutCurrency("usd");
        arrayList.add(affiliatesPartnerCountryPayout);
        createAffiliatesPartnerEntity.setConfig(String.format("{\"default_pub_id\":\"" + "%d" + "\",\"default_sub_id\":\"" + "%d" + "\",\"cost\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}},\"callback_payout\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}}}", Integer.parseInt(stringListCA.get(0)), Integer.parseInt(stringListCA.get(1)), stringListCA.get(2), stringListCA.get(3), stringListCA.get(4), Integer.parseInt(stringListCA.get(5)), stringListCA.get(6), stringListCA.get(7), stringListCA.get(8), Integer.parseInt(stringListCA.get(9))));
        restRequest.setBody(new RestBody(restRequest.writeValueAsString(createAffiliatesPartnerEntity)));
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
        state.setId(RestResponse.findJsonPath(restResponse.extract()).getString("id"));
    }

    @When("User update name affiliates partner for country SE with valid")
    public void user_update_name_affiliates_partner_for_country_se_with_valid() {
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.CREATE_NEW_AFFILIATES_PARTNER, RestMethod.PUT);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        updateAffiliatesPartnerEntity.setId(state.getId());
        updateAffiliatesPartnerEntity.setName(name);
        updateAffiliatesPartnerEntity.setStatus(Status.ACTIVE);
        updateAffiliatesPartnerEntity.setPixelRatio(100);
        updateAffiliatesPartnerEntity.setPixelRatioCounter(0);
        updateAffiliatesPartnerEntity.setDescription("Thuan test create new affiliates parter");
        updateAffiliatesPartnerEntity.setCreatedBy(63);
        updateAffiliatesPartnerEntity.setUpdatedBy(63);
        updateAffiliatesPartnerEntity.setParams(arrayList = new ArrayList());
        updateAffiliatesPartnerEntity.setPixelUrl(restRequest.newHashSet("http://api.airpush.com/track/?guid=%click_id%"));
        updateAffiliatesPartnerEntity.setCountries(restRequest.newHashSet("se"));
        updateAffiliatesPartnerEntity.setCountryPayout(arrayList = new ArrayList());
        updateAffiliatesPartnerCountryPayout.setPayoutAmount(10);
        updateAffiliatesPartnerCountryPayout.setIsoCountryCode("se");
        updateAffiliatesPartnerCountryPayout.setPayoutCurrency("usd");
        arrayList.add(updateAffiliatesPartnerCountryPayout);
        updateAffiliatesPartnerEntity.setConfig(String.format("{\"default_pub_id\":\"" + "%d" + "\",\"default_sub_id\":\"" + "%d" + "\",\"cost\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}},\"callback_payout\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}}}", Integer.parseInt(stringListCA.get(0)), Integer.parseInt(stringListCA.get(1)), stringListCA.get(2), stringListCA.get(3), stringListCA.get(4), Integer.parseInt(stringListCA.get(5)), stringListCA.get(6), stringListCA.get(7), stringListCA.get(8), Integer.parseInt(stringListCA.get(9))));
        restRequest.setBody(new RestBody(restRequest.writeValueAsString(updateAffiliatesPartnerEntity)));
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
        state.setValue(RestResponse.findJsonPath(restResponse.extract()).getString("name"));
    }

    @When("User update payout amount affiliates partner for country SE with valid")
    public void user_update_payout_amount_affiliates_partner_for_country_se_with_valid() {
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.CREATE_NEW_AFFILIATES_PARTNER, RestMethod.PUT);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        updateAffiliatesPartnerEntity.setId(state.getId());
        updateAffiliatesPartnerEntity.setName("Thuan update payout_amount_affiliates_partner");
        updateAffiliatesPartnerEntity.setStatus(Status.ACTIVE);
        updateAffiliatesPartnerEntity.setPixelRatio(100);
        updateAffiliatesPartnerEntity.setPixelRatioCounter(0);
        updateAffiliatesPartnerEntity.setDescription("Thuan test create new affiliates parter");
        updateAffiliatesPartnerEntity.setCreatedBy(63);
        updateAffiliatesPartnerEntity.setUpdatedBy(63);
        updateAffiliatesPartnerEntity.setParams(arrayList = new ArrayList());
        updateAffiliatesPartnerEntity.setPixelUrl(restRequest.newHashSet("http://api.airpush.com/track/?guid=%click_id%"));
        updateAffiliatesPartnerEntity.setCountries(restRequest.newHashSet("se"));
        updateAffiliatesPartnerEntity.setCountryPayout(arrayList = new ArrayList());
        updateAffiliatesPartnerCountryPayout.setPayoutAmount(20f);
        updateAffiliatesPartnerCountryPayout.setIsoCountryCode("se");
        updateAffiliatesPartnerCountryPayout.setPayoutCurrency("usd");
        arrayList.add(updateAffiliatesPartnerCountryPayout);
        updateAffiliatesPartnerEntity.setConfig(String.format("{\"default_pub_id\":\"" + "%d" + "\",\"default_sub_id\":\"" + "%d" + "\",\"cost\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}},\"callback_payout\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}}}", Integer.parseInt(stringListCA.get(0)), Integer.parseInt(stringListCA.get(1)), stringListCA.get(2), stringListCA.get(3), stringListCA.get(4), Integer.parseInt(stringListCA.get(5)), stringListCA.get(6), stringListCA.get(7), stringListCA.get(8), Integer.parseInt(stringListCA.get(9))));
        restRequest.setBody(new RestBody(restRequest.writeValueAsString(updateAffiliatesPartnerEntity)));
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
        updateAffiliatesPartnerCountryPayout.setPayoutAmount((float) RestResponse.findJsonPath(restResponse.extract()).getList("country_payout.payout_amount").get(0));
    }

    @Then("Response status code update affiliates for country SE valid equals {int}")
    public void response_status_code_update_affiliates_for_country_se_valid_equals(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response body with id of country SE")
    public void response_body_with_id_of_country_se() {
        Assert.assertEquals(state.getId(), RestResponse.findJsonPath(restResponse.extract()).getString("id"));
    }

    @Then("Response body update name successful for country SE")
    public void response_body_update_name_successful_for_country_se() {
        Assert.assertEquals(state.getValue(), name);
    }

    @Then("Response body update payout amount successful for country SE")
    public void response_body_update_payout_amount_successful_for_country_se() {
        Assert.assertEquals(updateAffiliatesPartnerCountryPayout.getPayoutAmount(), 20, 0.0);
    }
}