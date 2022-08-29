package emobi.apis.rest.filter;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSender;

/**
 * Provides the functionality to set properties, sending requests and continue the filter chain.
 */
public interface FilterContext {

    /**
     * Add a value that may be used be subsequent filters.
     *
     * @param name  The name of the value
     * @param value The value itself
     */
    void setValue(String name, Object value);

    /**
     * Get a value
     *
     * @param name The name of the value
     * @param <T>  The type of the value
     * @return The value itself or <code>null</code> if no value was found for the supplied name.
     */
    <T> T getValue(String name);

    /**
     * See if this filter context contain a value with the given name
     *
     * @param name The name of the value
     * @return <code>true</code> if the value exists in this filter context, <code>false</code> otherwise.
     */
    boolean hasValue(String name);

    /**
     * Send a request to the same request path and with the same request method as the original request.
     *
     * @param requestSender The response or request specification.
     * @return The response.
     */
    Response send(RequestSender requestSender);

    /**
     * Continue to the next filter in the chain.
     *
     * @param request  The request specification
     * @param response The response specification
     * @return The response of the request
     */
    Response next(FilterableRequestSpecification request, FilterableResponseSpecification response);
}