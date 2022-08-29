package emobi.apis.rest;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class RestBody {
    private JsonElement jsonElement;

    /**
     * Constructor without parameter to init JsonObject
     */
    public RestBody() {
        jsonElement = new JsonObject();
    }

    /**
     * Init body with provided JsonElement
     *
     * @param jsonElement json element
     */
    public RestBody(JsonObject jsonElement) {
        this.jsonElement = jsonElement;
    }

    /**
     * Init body with json string
     *
     * @param body String
     */
    public RestBody(String body) {
        this.jsonElement = new GsonBuilder().serializeNulls().create().fromJson(body, JsonElement.class);
    }

    public RestBody(Object body){
        this.jsonElement = new GsonBuilder().serializeNulls().create().toJsonTree(body);
    }

    /**
     * print the body
     *
     * @return String
     */
    public String print() {
        return new GsonBuilder().serializeNulls().create().toJson(jsonElement);
    }

    /**
     * print the json-format body
     *
     * @return String
     */
    public String prettyPrint() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(jsonElement);
    }
}
