package emobi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AffiliatesPartnerCountryPayout {
    @JsonProperty("payout_amount")
    private int payoutAmount;

    @JsonProperty("iso_country_code")
    private String isoCountryCode;

    @JsonProperty("payout_currency")
    private String payoutCurrency;
}
