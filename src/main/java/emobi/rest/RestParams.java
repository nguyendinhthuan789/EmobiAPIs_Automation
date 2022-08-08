package emobi.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * RestParams is to create request parameters
 */
public class RestParams {

    private Map<String, Object> params;

    /**
     * Init map
     */
    public RestParams() {
        this.params = new HashMap<>();
    }

    /**
     * Add new param
     *
     * @param key   key
     * @param value value
     */
    public void addParam(String key, Object value) {
        this.params.put(key, value);
    }

    public Map<String, Object> formParam(String key, Object value) {
        params.put(key, value);
        return this.params;
    }

    public void remove(String key) {
        this.params.remove(key);
    }

    public void removeAll() {
        this.params.clear();
    }

    /**
     * Get map
     *
     * @return
     */
    public Map<String, Object> getParams() {
        return this.params;
    }
}