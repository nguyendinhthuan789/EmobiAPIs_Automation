package emobi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateAffiliatesPartnerCountryPayout {

    @JsonProperty("payout_amount")
    private float payoutAmount;

    @JsonProperty("iso_country_code")
    private String isoCountryCode;

    @JsonProperty("payout_currency")
    private String payoutCurrency;
}
