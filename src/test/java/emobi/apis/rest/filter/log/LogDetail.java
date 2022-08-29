package emobi.apis.rest.filter.log;

public enum LogDetail {
    /**
     * Logs everything
     */
    ALL,
    /**
     * Log only headers
     */
    HEADERS,
    /**
     * Log only cookies
     */
    COOKIES,
    /**
     * Log on the body
     */
    BODY,
    /**
     * Log only the status line (works only for responses).
     */
    STATUS,
    /**
     * Logs only the request parameters (only works for requests)
     */
    PARAMS,
    /**
     * Logs only the request method (only works for requests)
     */
    METHOD,
    /**
     * Logs only the request uri (only works for requests)
     */
    URI
}