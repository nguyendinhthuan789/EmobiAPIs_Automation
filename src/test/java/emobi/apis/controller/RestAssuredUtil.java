package emobi.apis.controller;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredUtil {

    //Sets Base URI
    public static void setBaseURI() {
        RestAssured.baseURI = "";
    }

    //Sets base path
    public static void setBasePath(String basePathTerm) {
        RestAssured.basePath = basePathTerm;
    }

    //Reset Base URI (after test)
    public static void resetBaseURI() {
        RestAssured.baseURI = null;
    }

    //Reset base path
    public static void resetBasePath() {
        RestAssured.basePath = null;
    }

    //Sets ContentType
    public static void setContentType(ContentType Type) {
        given().contentType(Type);
    }

    //Returns response by given path
    public static Response getResponse(String path) {
        return given().get(path);
    }

    //Returns response
    public static Response getResponse() {
        return given().get();
    }

    //Returns response by given response
    public static JsonPath findJsonPath(Response response) {
        JsonPath js = new JsonPath(response.body().asString());
        return js;
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response response) {
        String json = response.asString();
        return new JsonPath(json);
    }

    public static String getJsonPathHasKey(Response response, String key) {
        String complete = response.asString();
        JsonPath js = new JsonPath(complete);
        return js.get(key).toString();
    }

    public static boolean checkStatusCode(Response res, int status) {
        if (res.getStatusCode() == status) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(final Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNullOrEmpty(final Map<?, ?> m) {
        return m == null || m.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        // else
        return false;
    }

    public static String mapped(DataTable dataTable, Object object) {
        List<Map<String, String>> data =  dataTable.asMaps();
        String key= data.get(0).get(object);
        return key;
    }
}
