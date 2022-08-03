package emobi.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import emobi.model.CampaignConfig;
import emobi.model.CampaignTrafficSourceParam;
import emobi.model.CreateCampaignEntity;
import emobi.utilities.Utils;

import java.util.ArrayList;
import java.util.Date;

public class CreateNewCampaignMap {
    CreateCampaignEntity createNewCampaignEntity;
    CampaignTrafficSourceParam campaignTrafficSourceParam;
    CampaignConfig campaignConfig;
    ObjectMapper objectMapper;
    ArrayList arrayList;

    public CreateNewCampaignMap() {
        createNewCampaignEntity = new CreateCampaignEntity();
        campaignTrafficSourceParam = new CampaignTrafficSourceParam();
        campaignConfig = new CampaignConfig();
        objectMapper = new ObjectMapper();
        arrayList = new ArrayList();
    }

    private String nameCamp(String name) {
        return name + Utils.date();
    }

    public void requestBodyNewCampaign(String name, String partnerId,
                                              String status, String country,
                                              String gateway, String merchant,
                                              String serviceModel, String service,
                                              String channel, float revenue,
                                              boolean isConnectionTypeDetection, boolean isCountryDetection, boolean isDeviceTypeDetection,
                                              String timezone, int createBy, int updateBy, Date startDate, Date endDate,
                                              boolean firePostbackOnSale, boolean _5MinutesPostbackCancel,
                                              String nameLp, int landingId, String statusLp, String domain, String countryLp,
                                              String club, String type, String url, int weight, int pixelRatioCounter, int pixelRatio,
                                              int fomrMinute, int toMinute) {
        try {
            createNewCampaignEntity.setName(nameCamp(name));
            createNewCampaignEntity.setPartnerID(partnerId);
            createNewCampaignEntity.setStatus(status);
            createNewCampaignEntity.setCountry(country);
            createNewCampaignEntity.setPaymentGateway(gateway);
            createNewCampaignEntity.setMerchant(merchant);
            createNewCampaignEntity.setServiceModel(serviceModel);
            createNewCampaignEntity.setService(service);
            createNewCampaignEntity.setChannel(channel);
            createNewCampaignEntity.setRevenue(revenue);
            createNewCampaignEntity.setIsConnectionTypeDetection(isConnectionTypeDetection);
            createNewCampaignEntity.setIsCountryDetection(isCountryDetection);
            createNewCampaignEntity.setIsDeviceTypeDetection(isDeviceTypeDetection);
            createNewCampaignEntity.setTimezone(timezone);
            createNewCampaignEntity.setCreatedBy(createBy);
            createNewCampaignEntity.setUpdatedBy(updateBy);
            createNewCampaignEntity.setStartDate(startDate);
            createNewCampaignEntity.setEndDate(endDate);

            campaignConfig.setFirePostbackOnSale(firePostbackOnSale);
            campaignConfig.set5MinutesPostbackCancel(_5MinutesPostbackCancel);
            createNewCampaignEntity.setConfig(campaignConfig);
            objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createNewCampaignEntity);

            campaignTrafficSourceParam.setName(nameLp);
            campaignTrafficSourceParam.setLandingId(landingId);
            campaignTrafficSourceParam.setStatus(statusLp);
            campaignTrafficSourceParam.setDomain(domain);
            campaignTrafficSourceParam.setCountry(countryLp);
            campaignTrafficSourceParam.setClub(club);
            campaignTrafficSourceParam.setType(type);
            campaignTrafficSourceParam.setUrl(url);
            campaignTrafficSourceParam.setWeight(weight);
            campaignTrafficSourceParam.setPixelRatioCounter(pixelRatioCounter);
            campaignTrafficSourceParam.setPixelRatio(pixelRatio);
            campaignTrafficSourceParam.setFromMinute(fomrMinute);
            campaignTrafficSourceParam.setToMinute(toMinute);

            createNewCampaignEntity.setTsp(arrayList);
            arrayList.add(campaignTrafficSourceParam);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return;
    }

    public static void main(String[] args) {
//        CreateNewCampaignMap createNewCampaignMap= new CreateNewCampaignMap();
//                createNewCampaignMap.requestBodyNewCampaign("Thuan Test At: ",
//                "11d8a4e6-041d-47b5-afa4-6a95c421d3c2",
//                Status.ACTIVE, Countries.AT, Gateways.NTH, Merchants.EMOBI, ServiceModels.MSISDN_PIN, ServiceNames.DOWNLOADHUB, Channels.WEB,
//                100f, false, false, false, "Europe/Berlin",
//                63, 63, Utils.date(), Utils.date(), true, true,
//                "Test Lps AT ContentdownloadBlack",651,
//                Status.ACTIVE, "3rdparty", Countries.AT, "MHUB", "mobile",
//                "https://lp.adstart.dev/lp/at/mobilehub4u/contentDownloadBlack/?token=true",
//                10, 0, 100, 0, 1440
//                );
//                System.out.println("JSON: "+createNewCampaignMap);
    }
}
