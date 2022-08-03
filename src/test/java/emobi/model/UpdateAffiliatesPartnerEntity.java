package emobi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;


@Getter
@Setter
public class UpdateAffiliatesPartnerEntity {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("pixel_ratio")
    private int pixelRatio;

    @JsonProperty("pixel_ratio_counter")
    private int pixelRatioCounter;

    @JsonProperty("description")
    private String description;

    @JsonProperty("params")
    private ArrayList params;

    @JsonProperty("pixel_url")
    private Set<String> pixelUrl;

    @JsonProperty("countries")
    private Set<String> countries;

    @JsonProperty("country_payout")
    private ArrayList<AffiliatesPartnerCountryPayout> countryPayout;

    @JsonProperty("config")
    private String config;

    @JsonProperty("created_by")
    private int createdBy;

    @JsonProperty("updated_by")
    private int updatedBy;
}