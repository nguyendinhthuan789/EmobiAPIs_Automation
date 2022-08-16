package emobi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CampaignConfig {

    @JsonProperty("isFirePostbackOnSale")
    private boolean isFirePostbackOnSale;

    @JsonProperty("is5MinutesPostbackCancel")
    private boolean is5MinutesPostbackCancel;
}
