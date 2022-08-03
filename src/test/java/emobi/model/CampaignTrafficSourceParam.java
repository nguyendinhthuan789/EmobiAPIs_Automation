package emobi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampaignTrafficSourceParam {
    @JsonProperty("name")
    private String name;

    @JsonProperty("landing_id")
    private int landingId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("country")
    private String country;

    @JsonProperty("club")
    private String club;

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("pixel_ratio_counter")
    private int pixelRatioCounter;

    @JsonProperty("to_minute")
    private int toMinute;

    @JsonProperty("from_minute")
    private int fromMinute;

    @JsonProperty("pixel_ratio")
    private int pixelRatio;
}
