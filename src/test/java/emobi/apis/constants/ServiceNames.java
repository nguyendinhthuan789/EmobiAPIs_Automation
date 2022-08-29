package emobi.apis.constants;

import java.util.Arrays;
import java.util.List;

public class ServiceNames {
    public static final String MOBILEHUB4U = "mobilehub4u";
    public static final String LOGONHUB = "logonhub";
    public static final String BRINGBOOST = "bringboost";
    public static final List<String> ALL_SERVICE_NAME = Arrays.asList("default_service_name", "mobilehub4u", "logonhub", "myvivo", "bringboost", "playzone", "mobilezonehub");

    public static String findServicenameBaseOnCountry(String country) {
        switch (country) {
            case "SE":
                if (ServiceModels.findServiceModelBaseOnCountry(country).equalsIgnoreCase(ServiceModels.ONE_OFF_C2S)) {
                    return MOBILEHUB4U;
                } else if (ServiceModels.findServiceModelBaseOnCountry(country).equalsIgnoreCase(ServiceModels.MSISDN_MO)) {
                    return LOGONHUB;
                } else
                    return BRINGBOOST;
            case "CZ":
                break;
        }
        return "Not found service name of country "+country;
    }

    public static void main(String[] args) {
        System.out.println(findServicenameBaseOnCountry(Countries.COUNTRIES_GATEWAY_OF_NTH.get(0)));
    }
}
