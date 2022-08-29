package emobi.apis.controller;

import emobi.apis.base.Base;
import emobi.apis.constants.URLs;
import emobi.apis.rest.*;
import emobi.apis.utilities.Helper;
import emobi.apis.utilities.Randoms;
import io.cucumber.datatable.DataTable;
import io.restassured.path.json.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MoForAtController extends Base {
    Logger log = LoggerFactory.getLogger(MoForAtController.class);
    private RestRequest restRequest;
    private RestParams restParams;
    private RestHeaders restHeaders;
    private RestResponse restResponse;

    public MoForAtController() {
        restParams = new RestParams();
        restHeaders = new RestHeaders();
    }

    public void moviplusRequestMoTracking(DataTable dataTable) {
        restRequest = new RestRequest(Helper.getDomainBaseOnEnv(), URLs.AFFILIATES_PARTNER_MO_REQUEST + mapped(dataTable, "campaignID"), RestMethod.GET);
        restHeaders.add(restHeaders.defaultApikey());
        restParams.addParam("tpClickId", Randoms.randomString());
        restParams.addParam("msisdn", mapped(dataTable, "msisdn"));
        restParams.addParam("userAgent", mapped(dataTable, "userAgent"));
        restParams.addParam("ip", mapped(dataTable, "ip"));
        restParams.addParam("portalDomain", mapped(dataTable, "portalDomain"));
        restRequest.setParams(restParams);
        restRequest.setHeader(restHeaders);
        restResponse = restRequest.send();
        log.info("Request header is: \n" + restRequest.toString());
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
