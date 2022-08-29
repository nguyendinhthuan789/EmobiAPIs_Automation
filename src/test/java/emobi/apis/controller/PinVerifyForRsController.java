package emobi.apis.controller;

import emobi.apis.base.Base;
import emobi.apis.constants.URLs;
import emobi.apis.rest.*;
import emobi.apis.utilities.Helper;
import io.cucumber.datatable.DataTable;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PinVerifyForRsController extends Base {
    Logger log = LoggerFactory.getLogger(PinVerifyForRsController.class);
    private RestRequest restRequest;
    private final RestParams restParams;
    private final RestHeaders restHeaders;
    private List<String> result;
    private RestResponse restResponse;

    public PinVerifyForRsController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void requestPinVerifyTracking(DataTable dataTable) {
        restRequest = new RestRequest(Helper.getDomainBaseOnEnv(), URLs.AFFILIATES_PARTNER_PIN_VERIFY + mapped(dataTable, "campaignID"), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam("tpClickId", mapped(dataTable, "tpClickId"));
        restParams.addParam("pinId", mapped(dataTable, "pinId"));
        restParams.addParam("pinValue", mapped(dataTable, "pinValue"));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        log.info("Request header is: \n" + restRequest.toString());
        restResponse = restRequest.send();
        log.info("Response is: \n" + restResponse.printPrettyPrint());
    }

    public boolean verifyStatus(int status) {
        log.info("status code is: " + restResponse.extract().getStatusCode());
        return checkStatusCode(restResponse.extract(), status);
    }

    public String findJsonPathHasKey(String key) {
        return RestAssuredUtil.getJsonPathHasKey(restResponse.extract(), key);
    }

    public boolean checkMapIsEmpty(String key) {
        Map map = new JsonPath(findJsonPathHasKey(key)).getMap(key);
        return RestAssuredUtil.isNullOrEmpty(map);
    }

    public String extractTable(DataTable dataTable, String key) {
        return mapped(dataTable, key);
    }
}
