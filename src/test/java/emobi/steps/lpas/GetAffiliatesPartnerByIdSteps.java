package emobi.steps.lpas;

import emobi.constants.ServiceNames;
import emobi.constants.Status;
import emobi.constants.URL;
import emobi.model.AffiliatesPartnerCountryPayout;
import emobi.model.CreateAffiliatesPartnerEntity;
import emobi.rest.*;
import emobi.utilities.Convert;
import emobi.utilities.Randoms;
import emobi.utilities.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetAffiliatesPartnerByIdSteps {
    String getGetRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Cost = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Callback_payout = Convert.convertIntToString(Randoms.generateRandomInt());
    String getServiceName = Randoms.randomStringInList(ServiceNames.ALL_SERVICE_NAME);
    List<String> stringListCA = Stream.of(getGetRand_Default_pub_id, getRand_Default_pub_id, "se", getServiceName, "psms_click2sms", getRand_Cost, "se", getServiceName, "tele2", getRand_Callback_payout).collect(Collectors.toList());
    private RestRequest restRequest;
    private RestResponse restResponse;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private ArrayList arrayList;
    private CreateAffiliatesPartnerEntity createAffiliatesPartnerEntity;
    private AffiliatesPartnerCountryPayout affiliatesPartnerCountryPayout;
    private State state;

    public GetAffiliatesPartnerByIdSteps(State state) {
        this.state = state;
        restHeaders = new RestHeaders();
        createAffiliatesPartnerEntity = new CreateAffiliatesPartnerEntity();
        affiliatesPartnerCountryPayout = new AffiliatesPartnerCountryPayout();
    }

    @Given("User create new affiliates partner after that get affiliates by id with valid credential")
    public void user_create_new_affiliates_partner_after_that_get_affiliates_by_id_with_valid_credential() {
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

    @Given("Get affiliates partner by id with id valid credential")
    public void get_affiliates_partner_by_id_with_id_valid_credential() {
        restRequest = new RestRequest(URL.BASE_URL_HAS_PORT_8091, URL.CREATE_NEW_AFFILIATES_PARTNER + "/" + state.getId(), RestMethod.GET);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response status code get affiliates partner by id valid is equals {int}")
    public void response_status_code_get_affiliates_partner_by_id_valid_is_equals(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }
}