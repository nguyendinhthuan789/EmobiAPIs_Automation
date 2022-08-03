package emobi.constants;

import emobi.utilities.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Countries {
    /**
     * This is list country go to get gateway
     * @COUNTRIES_OF_NTH
     * @COUNTRIES_OF_PURETECH
     * @COUNTRIES_OF_NTH_PURETECH_INFOMEDIA
     */

    public static final List<String> COUNTRIES_GATEWAY_OF_NTH = new ArrayList<>(List.of("SE","CZ"));
    public static final List<String> COUNTRIES_GATEWAY_OF_PURETECH = new ArrayList<>(List.of("AE"));
    public static final List<String> COUNTRIES_GATEWAY_OF_INFOMEDIA = new ArrayList<>(List.of("CA"));
    public static final List<String> COUNTRIES_GATEWAY_OF_NTH_PURETECH_INFOMEDIA = Stream.of("XYZ").collect(Collectors.toList());

    public static void main(String[] args) {
        System.out.println(Randoms.randomStringInList(COUNTRIES_GATEWAY_OF_NTH));
    }

    /**
     * NTH gateway
     */
    public static final String AT = "AT";
    /**
     * puretech gateway
     */
    public static final String AE = "AE";
    /**
     * infomedia gateway
     */
    public static final String CA = "CA";
}
