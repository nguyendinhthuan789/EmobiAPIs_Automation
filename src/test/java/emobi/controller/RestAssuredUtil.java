package emobi.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
}
