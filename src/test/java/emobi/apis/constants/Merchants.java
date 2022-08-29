package emobi.apis.constants;

import emobi.apis.utilities.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Merchants {
    public static final String EMOBI = "EM";
    public static final String GOMOBEE = "GM";
    public static final List<String> EMOBI_GOMOBEE = new ArrayList<>(List.of("EM", "GM"));

    public static String findMerchantBaseOnCountry(String country) {
        switch (country){
            case "SE":
                return Randoms.randomStringInList(EMOBI_GOMOBEE);
            case "CZ":
                return EMOBI;
            case "HR":
                return GOMOBEE;
        }
        return "Not found country to find merchant";
    }

    public static void main(String[] args) {
        System.out.println(findMerchantBaseOnCountry("SE"));
    }
}
