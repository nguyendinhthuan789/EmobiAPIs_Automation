package emobi.steps;

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

public class CreateNewAffiliatesPartnerSteps {
    private RestRequest restRequest;
    private RestResponse restResponse;
    private RestHeaders restHeaders = new RestHeaders();
    private CreateAffiliatesPartnerEntity createAffiliatesPartnerEntity = new CreateAffiliatesPartnerEntity();
    private AffiliatesPartnerCountryPayout affiliatesPartnerCountryPayout = new AffiliatesPartnerCountryPayout();
    private ArrayList arrayList;

    String getGetRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Cost = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Callback_payout = Convert.convertIntToString(Randoms.generateRandomInt());
    String getServiceName = Randoms.randomStringInList(ServiceNames.ALL_SERVICE_NAME);
    List<String> stringListCA = Stream.of(getGetRand_Default_pub_id, getRand_Default_pub_id, "se", getServiceName, "psms_click2sms", getRand_Cost, "se", getServiceName, "tele2", getRand_Callback_payout).collect(Collectors.toList());

    @Given("User create new affiliates partner for country SE with valid")
    public void user_create_new_affiliates_partner_for_country_se_with_valid() {
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
        createAffiliatesPartnerEntity.setParams(arrayList);
        createAffiliatesPartnerEntity.setPixelUrl(restRequest.newHashSet("http://api.airpush.com/track/?guid=%click_id%"));
        createAffiliatesPartnerEntity.setCountries(restRequest.newHashSet("se"));
        //Set<String> set = Stream.of("ca").collect(Collectors.toCollection(HashSet::new));
        //createAffiliatesPartnerEntity.setCountries(set);
        createAffiliatesPartnerEntity.setCountryPayout(arrayList = new ArrayList());
        affiliatesPartnerCountryPayout.setPayoutAmount(10);
        affiliatesPartnerCountryPayout.setIsoCountryCode("se");
        affiliatesPartnerCountryPayout.setPayoutCurrency("usd");
        arrayList.add(affiliatesPartnerCountryPayout);
        createAffiliatesPartnerEntity.setConfig(String.format("{\"default_pub_id\":\"" + "%d" + "\",\"default_sub_id\":\"" + "%d" + "\",\"cost\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}},\"callback_payout\":{\"" + "%s" + "\":{\"" + "%s" + "\":{\"" + "%s" + "\":\"" + "%d" + "\"}}}}", Integer.parseInt(stringListCA.get(0)), Integer.parseInt(stringListCA.get(1)), stringListCA.get(2), stringListCA.get(3), stringListCA.get(4), Integer.parseInt(stringListCA.get(5)), stringListCA.get(6), stringListCA.get(7), stringListCA.get(8), Integer.parseInt(stringListCA.get(9))));
        restRequest.setBody(new RestBody(restRequest.writeValueAsString(createAffiliatesPartnerEntity)));
        restResponse = restRequest.sendWithLog();
    }

    @Then("Response status code create new affiliates partner for country SE valid equals {int}")
    public void response_status_code_create_new_affiliates_partner_for_country_se_valid_equals(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response body create new affiliates for country SE valid has param Id is not null")
    public void response_body_create_new_affiliates_for_country_se_valid_has_param_id_is_not_null() {
        Assert.assertNotNull(restResponse.rawToJson(restResponse.extract()).getString("id"));
    }
}