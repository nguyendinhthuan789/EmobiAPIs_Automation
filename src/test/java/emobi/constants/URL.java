package emobi.constants;

public class URL {
    public static final String BASE_URL = "http://lp.dev.emobi-sys.com";
    public static final String BASE_URL_HAS_PORT_8091 = "http://dev.api.emobi-sys.com:8091/v1";
    public static final String LOGIN = "/session/login";
    public static final String CREATE_NEW_CAMPAIGN ="/affiliates/campaign";
    public static final String CREATE_NEW_AFFILIATES_PARTNER ="/affiliates/partner";

    /**
     * @Path: TEST is name of apitoken affiliates partner in database
     */
    public static final String AFFILIATES_PARTNER_C2S ="/affiliates/tf/TEST/";
    public static final String AFFILIATES_PARTNER_MSISDN_PIN_REQUEST ="/affiliates/tf/pin_request/TEST/";
    public static final String AFFILIATES_PARTNER_MSISDN_PIN_VERIFY ="/affiliates/tf/pin_verify/TEST/";
}
