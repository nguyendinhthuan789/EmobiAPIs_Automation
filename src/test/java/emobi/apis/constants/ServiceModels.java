package emobi.apis.constants;

import emobi.apis.utilities.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ServiceModels {
    public static final String MSISDN_PIN = "SUB MSISDN + PIN";
    public static final String MSISDN_MO = "SUB MSISDN + MO";
    public static final String PSMS = "PSMS";
    public static final String PSMS_CLICK2SMS = "PSMS_CLICK2SMS";
    public static final String SUB_C2S = "SUB C2S";
    public static final String ONE_OFF_C2S = "ONE-OFF C2S";
    public static final List<String> MSISDN_MO_MSISDN_PIN = new ArrayList<>(List.of("SUB MSISDN + MO", "SUB MSISDN + PIN"));

    public static String findServiceModelBaseOnCountry(String country) {
        switch (country) {
            case "SE":
                if (Merchants.findMerchantBaseOnCountry(country).equalsIgnoreCase(Merchants.EMOBI)) {
                    return ONE_OFF_C2S; //EM
                } else {
                    return Randoms.randomStringInList(MSISDN_MO_MSISDN_PIN); //GM
                }
            case "CZ":
                if (Merchants.findMerchantBaseOnCountry(country).equalsIgnoreCase(Merchants.EMOBI)) {
                    return ONE_OFF_C2S;
                }
            default:
                throw new IllegalStateException("Unexpected value: " + country);
        }
    }

    public static void main(String[] args) {
        System.out.println(findServiceModelBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0)));
    }
}
