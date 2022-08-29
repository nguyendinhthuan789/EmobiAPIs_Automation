package emobi.apis.constants;

import java.util.ArrayList;
import java.util.List;

public class Gateways {
    public static final String NTH = "nth";
    public static final String PURETECH = "puretech";
    public static final String INFOMEDIA = "infomedia";
    public static final List<String> NTH_PURETECH_INFOMEDIA = new ArrayList<>(List.of("nth","puretech","infomedia"));

    public static String findGatewayBaseOnCountry(String country) {
        if (Countries.COUNTRIES_GATEWAY_OF_NTH.contains(country)) {
            return NTH;
        } else if (Countries.COUNTRIES_GATEWAY_OF_PURETECH.contains(country)) {
            return PURETECH;
        } else if (Countries.COUNTRIES_GATEWAY_OF_INFOMEDIA.contains(country)) {
            return INFOMEDIA;
        }else if(Countries.COUNTRIES_GATEWAY_OF_NTH_PURETECH_INFOMEDIA.contains(country)){
            return NTH_PURETECH_INFOMEDIA.toString();
        }
        return ("Not found country to find gateway");
    }
    public static void main(String[] args) {
        System.out.println("getGatewayBaseOnCountry: "+ findGatewayBaseOnCountry("CA"));
    }
}
