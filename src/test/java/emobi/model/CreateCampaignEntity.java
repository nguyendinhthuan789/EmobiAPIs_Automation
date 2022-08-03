package emobi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;


@Getter
@Setter
public class CreateCampaignEntity {
    @JsonProperty("partner_id")
    private String partnerID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("campaign_type")
    private String campaignType;

    @JsonProperty("offer_type")
    private String offerType;

    @JsonProperty("description")
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonProperty("start_date")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonProperty("end_date")
    private Date endDate;
    @JsonProperty("status")
    private String status;

    @JsonProperty("channel")
    private String channel;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("updated_by")
    private int updatedBy;

    @JsonProperty("country")
    private String country;

    @JsonProperty("payment_gateway")
    private String paymentGateway;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("revenue")
    private Float revenue;

    @JsonProperty("service")
    private String service;

    @JsonProperty("merchant")
    private String merchant;

    @JsonProperty("service_model")
    private String serviceModel;

    @JsonProperty("billing_type")
    private String billingType;

    @JsonProperty("is_connection_type_detection")
    private Boolean isConnectionTypeDetection;

    @JsonProperty("is_country_detection")
    private Boolean isCountryDetection;

    @JsonProperty("is_device_type_detection")
    private Boolean isDeviceTypeDetection;

    @JsonProperty("config")
    private CampaignConfig config;

    @JsonProperty("tsp")
    private ArrayList<CampaignTrafficSourceParam> tsp;
}