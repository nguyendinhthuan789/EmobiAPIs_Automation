package emobi.filter;

import io.restassured.http.Header;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RebrandFilterImpl extends RequestFilter{

    private String result = "";
    private static final String BODY = "body";

    private boolean verifyResponseHeader() {
        List<Header> headers = response.getHeaders().asList();
        for(Header h : headers){
            if(h.getName().contains(BODY) || h.getValue().toLowerCase().contains(BODY)){
                result += "RESPONSE HEADER, ";
                return false;
            }
        }
        return true;
    }

    private boolean verifyResponseBody() {
        String responseBody = response.getBody().asString();
        if(responseBody.toLowerCase().contains(BODY)){
            result += "RESPONSE BODY, ";
            return false;
        }
        return true;
    }

    private boolean verifyFormParam() {
        Map<String, String> formParams = requestSpec.getFormParams();
        Set<String> keys = formParams.keySet();

        for (String k : keys) {
            if (k.toLowerCase().contains(BODY) || formParams.get(k).toLowerCase().contains(BODY)) {
                result += "FORM PARAMS, ";
                return false;
            }
        }
        return true;
    }

    private boolean verifyHeader() {
        List<Header> headers = requestSpec.getHeaders().asList();
        for (Header h : headers) {
            if (h.getName().toLowerCase().contains(BODY) || h.getValue().toLowerCase().contains(BODY)) {
                result += "REQUEST HEADER, ";
                return false;
            }
        }
        return true;
    }

    private boolean verifyParameter() {

        Map<String, String> requestParams = requestSpec.getRequestParams();
        Set<String> keys = requestParams.keySet();
        for (String k : keys) {
            if (k.toLowerCase().contains(BODY) || requestParams.get(k).toLowerCase().contains(BODY)) {
                result += "PARAMETERS, ";
                return false;
            }
        }
        return true;
    }

    private boolean verifyBaseUri() {
        String baseUri = requestSpec.getBaseUri();
        if (baseUri.toLowerCase().contains(BODY)) {
            result += "REQUEST URI, ";
            return false;
        }
        return true;
    }


    @Override
    public boolean condition() {
        return false;
    }

    @Override
    public void action() {
    }
}