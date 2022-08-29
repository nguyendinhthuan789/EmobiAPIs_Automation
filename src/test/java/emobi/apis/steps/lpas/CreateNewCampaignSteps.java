package emobi.apis.steps.lpas;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import emobi.apis.constants.*;
import emobi.apis.models.*;
import emobi.apis.rest.*;
import emobi.apis.utilities.Convert;
import emobi.apis.utilities.Helper;
import emobi.apis.utilities.Randoms;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateNewCampaignSteps {
    String getGetRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Default_pub_id = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Cost = Convert.convertIntToString(Randoms.generateRandomInt());
    String getRand_Callback_payout = Convert.convertIntToString(Randoms.generateRandomInt());
    String getServiceName = Randoms.randomStringInList(ServiceNames.ALL_SERVICE_NAME);
    List<String> stringListCA = Stream.of(getGetRand_Default_pub_id, getRand_Default_pub_id, "se", getServiceName, "psms_click2sms", getRand_Cost, "se", getServiceName, "tele2", getRand_Callback_payout).collect(Collectors.toList());
    private RestRequest restRequest;
    private RestResponse restResponse;
    private RestHeaders restHeaders;
    private CampaignConfig campaignConfig;
    private ObjectMapper objectMapper;
    private ArrayList arrayList;
    private CreateCampaignEntity createNewCampaignEntity;
    private CampaignTrafficSourceParam campaignTrafficSourceParam;
    private CreateAffiliatesPartnerEntity createAffiliatesPartnerEntity;
    private AffiliatesPartnerCountryPayout affiliatesPartnerCountryPayout;
    private State state;

    public CreateNewCampaignSteps(State state) {
        this.state = state;
        restHeaders = new RestHeaders();
        campaignConfig = new CampaignConfig();
        objectMapper = new ObjectMapper();
        affiliatesPartnerCountryPayout = new AffiliatesPartnerCountryPayout();
        createAffiliatesPartnerEntity = new CreateAffiliatesPartnerEntity();
        campaignTrafficSourceParam = new CampaignTrafficSourceParam();
        createNewCampaignEntity = new CreateCampaignEntity();
    }


    @Given("User create new affiliates partner for new campaign with valid credential")
    public void user_create_new_affiliates_partner_for_new_campaign_with_valid_credential() {
        restRequest = new RestRequest(URLs.BASE_URL_HAS_PORT_8091, URLs.CREATE_NEW_AFFILIATES_PARTNER, RestMethod.POST);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        createAffiliatesPartnerEntity.setName("Thuan create new affiliates SE at: " + Helper.date());
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

    @Given("User create new campaign for country SE with valid")
    public void user_create_new_campaign_for_country_se_with_valid() throws JsonProcessingException {
        restRequest = new RestRequest(URLs.BASE_URL_HAS_PORT_8091, URLs.CREATE_NEW_CAMPAIGN, RestMethod.POST);
        restHeaders.add(restHeaders.defalutHeaders());
        restRequest.setHeader(restHeaders);
        createNewCampaignEntity.setName("Thuan create campaign at: " + Helper.date());
        createNewCampaignEntity.setPartnerID(state.getId());
        createNewCampaignEntity.setStatus(Status.ACTIVE);
        createNewCampaignEntity.setCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0)); //SE
        createNewCampaignEntity.setPaymentGateway(Gateways.findGatewayBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0))); //SE
        createNewCampaignEntity.setMerchant(Merchants.findMerchantBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0))); // SE
        createNewCampaignEntity.setServiceModel(ServiceModels.findServiceModelBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0))); //SE
        createNewCampaignEntity.setService(ServiceNames.findServicenameBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0))); //SE
        createNewCampaignEntity.setChannel(Randoms.randomStringInList(Channels.CHANNEL));
        createNewCampaignEntity.setRevenue(100f);
        createNewCampaignEntity.setIsConnectionTypeDetection(false);
        createNewCampaignEntity.setIsCountryDetection(false);
        createNewCampaignEntity.setIsDeviceTypeDetection(false);
        createNewCampaignEntity.setTimezone("Europe/Berlin");
        createNewCampaignEntity.setCreatedBy(63);
        createNewCampaignEntity.setUpdatedBy(63);
        createNewCampaignEntity.setStartDate(Helper.date());
        createNewCampaignEntity.setEndDate(Helper.date());
        createNewCampaignEntity.setConfig(campaignConfig);
        campaignConfig.setFirePostbackOnSale(true);
        campaignConfig.set5MinutesPostbackCancel(true);
        restRequest.writeValueAsString(createNewCampaignEntity);
        createNewCampaignEntity.setTsp(arrayList = new ArrayList());
        campaignTrafficSourceParam.setName("Test Lps AT ContentdownloadBlack");
        campaignTrafficSourceParam.setLandingId(651);
        campaignTrafficSourceParam.setStatus(Status.ACTIVE);
        campaignTrafficSourceParam.setDomain("3rdparty");
        campaignTrafficSourceParam.setCountry(Countries.AT);
        campaignTrafficSourceParam.setClub("MHUB");
        campaignTrafficSourceParam.setType("mobile");
        campaignTrafficSourceParam.setUrl("https://lp.adstart.dev/lp/at/mobilehub4u/contentDownloadBlack/?token=true");
        campaignTrafficSourceParam.setWeight(10);
        campaignTrafficSourceParam.setPixelRatioCounter(0);
        campaignTrafficSourceParam.setPixelRatio(100);
        campaignTrafficSourceParam.setFromMinute(0);
        campaignTrafficSourceParam.setToMinute(1440);
        arrayList.add(campaignTrafficSourceParam);

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        restRequest.setBody(new RestBody(objectMapper.writeValueAsString(createNewCampaignEntity)));
        restResponse = restRequest.sendWithLog();
        restResponse.printPrettyPrint();
    }

    @Then("Response status code create new campaign for country SE valid equals {int}")
    public void response_status_code_create_new_campaign_for_country_se_valid_equals(int statusCode) {
        Assert.assertEquals(statusCode, restResponse.extract().statusCode());
    }

    @Then("Response body create new campaign for country SE valid has param Id is not null")
    public void response_body_create_new_campaign_for_country_se_valid_has_param_id_is_not_null() {
        Assert.assertNotNull(RestResponse.findJsonPath(restResponse.extract()).getString("id"));
    }
}